package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.agent.AgentImportDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static softuni.exam.constant.Message.*;

@Service
public class AgentServiceImpl implements AgentService {

    private final StringBuilder sb;
    private final Gson gson;
    private final ModelMapper mapper;
    private final ValidationUtils validationUtils;
    private final AgentRepository agentRepository;
    private final TownRepository townRepository;

    public AgentServiceImpl(Gson gson, ModelMapper mapper, ValidationUtils validationUtils,
                            AgentRepository agentRepository, TownRepository townRepository) {
        this.sb = new StringBuilder();
        this.gson = gson;
        this.mapper = mapper;
        this.validationUtils = validationUtils;
        this.agentRepository = agentRepository;
        this.townRepository = townRepository;
    }

    @Override
    public boolean areImported() {
        return this.agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(Path.of(AGENTS_FILE));
    }

    @Override
    public String importAgents() throws IOException {

        final List<AgentImportDTO> agentsImportDTO =
                Arrays.stream(this.gson.fromJson(this.readAgentsFromFile(), AgentImportDTO[].class))
                        .toList();

        for (AgentImportDTO agentDTO : agentsImportDTO) {

            final Optional<Town> optionalTown = this.townRepository.findFirstByTownName(agentDTO.getTown());

            if (!this.validationUtils.isValid(agentDTO)
                    || this.agentRepository.findFirstByFirstName(agentDTO.getFirstName()).isPresent()
                    || this.agentRepository.findFirstByEmail(agentDTO.getEmail()).isPresent()
                    || optionalTown.isEmpty()) {

                this.sb.append(String.format(INVALID_ENTITY, AGENT))
                        .append(System.lineSeparator());
                continue;
            }

            final Agent agent = this.mapper.map(agentDTO, Agent.class);

            agent.setTown(optionalTown.get());

            this.agentRepository.saveAndFlush(agent);

            this.sb.append(String.format(SUCCESSFUL_AGENT_IMPORT, agent.getFullName()))
                    .append(System.lineSeparator());
        }

        return this.sb.toString().trim();
    }
}
