package com.example.football.service.impl;

import com.example.football.models.dto.team.TeamImportDTO;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.TeamService;
import com.example.football.util.FileUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import static com.example.football.constant.Messages.INVALID_ENTITY;
import static com.example.football.constant.Messages.SUCCESSFUL_JSON_IMPORT;
import static com.example.football.constant.Paths.TEAMS_FILE_PATH;

@Service
public class TeamServiceImpl implements TeamService {

    private final StringBuilder sb;
    private final ModelMapper mapper;
    private final Gson gson;
    private final FileUtil fileUtil;
    private final TeamRepository teamRepository;
    private final TownRepository townRepository;

    public TeamServiceImpl(ModelMapper mapper, Gson gson, FileUtil fileUtil,
                           TeamRepository teamRepository, TownRepository townRepository) {
        this.mapper = mapper;
        this.gson = gson;
        this.fileUtil = fileUtil;
        this.teamRepository = teamRepository;
        this.townRepository = townRepository;
        this.sb = new StringBuilder();
    }


    @Override
    public boolean areImported() {
        return this.teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return this.fileUtil.readFile(TEAMS_FILE_PATH);
    }

    @Override
    public String importTeams() throws FileNotFoundException {

        final JsonReader reader = new JsonReader(new FileReader(TEAMS_FILE_PATH.toFile()));

        final Type type = new TypeToken<List<TeamImportDTO>>(){}.getType();

        final List<TeamImportDTO> teamsImportDTO = this.gson.fromJson(reader, type);

        teamsImportDTO
                .forEach(teamDTO -> {

                    final Town town = this.townRepository.findByName(teamDTO.getTownName());

                    final Team team = this.mapper.map(teamDTO, Team.class);

                    team.setTown(town);

                    try {

                        this.teamRepository.saveAndFlush(team);

                        this.sb.append(String.format(SUCCESSFUL_JSON_IMPORT,
                                        team.getClass().getSimpleName(), team.getName(), team.getFanBase()))
                                .append(System.lineSeparator());

                    } catch (Exception e) {

                        this.sb.append(String.format(INVALID_ENTITY, team.getClass().getSimpleName()))
                                .append(System.lineSeparator());
                    }
                });

        return this.sb.toString().trim();
    }
}
