package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.team.TeamImportDTO;
import softuni.exam.domain.dtos.team.TeamImportWrapperDTO;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.PictureRepository;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.FileUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static softuni.exam.constant.FilePath.TEAMS_FILE_PATH;
import static softuni.exam.constant.Message.INVALID_TEAM;
import static softuni.exam.constant.Message.SUCCESSFULLY_ADDED_TEAM;

@Service
public class TeamServiceImpl implements TeamService {

    private final StringBuilder sb = new StringBuilder();
    private final ModelMapper mapper;
    private final FileUtil fileUtil;
    private final TeamRepository teamRepository;
    private final PictureRepository pictureRepository;

    public TeamServiceImpl(ModelMapper mapper, FileUtil fileUtil, TeamRepository teamRepository, PictureRepository pictureRepository) {
        this.mapper = mapper;
        this.fileUtil = fileUtil;
        this.teamRepository = teamRepository;
        this.pictureRepository = pictureRepository;
    }

    @Override
    public String importTeams() throws FileNotFoundException, JAXBException {

        final FileReader reader = new FileReader(TEAMS_FILE_PATH);

        final JAXBContext context = JAXBContext.newInstance(TeamImportWrapperDTO.class);

        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final TeamImportWrapperDTO teamImportWrapperDTO = (TeamImportWrapperDTO) unmarshaller.unmarshal(reader);

        final List<TeamImportDTO> teamsDTO = teamImportWrapperDTO.getTeams();

        for (TeamImportDTO teamDTO : teamsDTO) {

            final Picture pictureByUrl = this.pictureRepository.findByUrl(teamDTO.getPicture().getUrl());

            final Team team = this.mapper.map(teamDTO, Team.class);

            team.setPicture(pictureByUrl);

            try {

                this.teamRepository.saveAndFlush(team);

                this.sb.append(String.format(SUCCESSFULLY_ADDED_TEAM, team.getName()))
                        .append(System.lineSeparator());

            } catch (Exception e) {

                this.sb.append(INVALID_TEAM).append(System.lineSeparator());
            }
        }

        return this.sb.toString().trim();
    }

    @Override
    public boolean areImported() {

        return this.teamRepository.count() > 0;
    }

    @Override
    public String readTeamsXmlFile() throws IOException {

        return this.fileUtil.readFile(TEAMS_FILE_PATH);
    }
}
