package com.example.football.service.impl;

import com.example.football.models.dto.stat.StatImportDTO;
import com.example.football.models.dto.stat.StatImportWrapperDTO;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.FileUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static com.example.football.constant.Messages.INVALID_ENTITY;
import static com.example.football.constant.Messages.SUCCESSFUL_STAT_IMPORT;
import static com.example.football.constant.Paths.STATS_FILE_PATH;

@Service
public class StatServiceImpl implements StatService {

    private final StringBuilder sb;
    private final ModelMapper mapper;
    private final FileUtil fileUtil;
    private final StatRepository statRepository;

    public StatServiceImpl(ModelMapper mapper, FileUtil fileUtil, StatRepository statRepository) {
        this.mapper = mapper;
        this.fileUtil = fileUtil;
        this.statRepository = statRepository;
        this.sb = new StringBuilder();
    }

    @Override
    public boolean areImported() {
        return this.statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return this.fileUtil.readFile(STATS_FILE_PATH);
    }

    @Override
    public String importStats() throws FileNotFoundException, JAXBException {

        final FileReader reader = new FileReader(STATS_FILE_PATH.toFile());

        final JAXBContext context = JAXBContext.newInstance(StatImportWrapperDTO.class);

        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final StatImportWrapperDTO statsImportWrapperDTO = (StatImportWrapperDTO) unmarshaller.unmarshal(reader);

        final List<StatImportDTO> statsImportDTO = statsImportWrapperDTO.getStats();

        statsImportDTO
                .forEach(statDTO -> {

                    final Stat stat = this.mapper.map(statDTO, Stat.class);

                    try {

                        this.statRepository.saveAndFlush(stat);

                        this.sb.append(String.format(SUCCESSFUL_STAT_IMPORT, stat.getClass().getSimpleName(),
                                        stat.getPassing(), stat.getShooting(), stat.getEndurance()))
                                .append(System.lineSeparator());

                    } catch (Exception e) {

                        this.sb.append(String.format(INVALID_ENTITY, stat.getClass().getSimpleName()))
                                .append(System.lineSeparator());
                    }
                });

        return this.sb.toString().trim();
    }
}
