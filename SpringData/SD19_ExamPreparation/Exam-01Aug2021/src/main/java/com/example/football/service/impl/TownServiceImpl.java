package com.example.football.service.impl;

import com.example.football.models.dto.town.TownImportDTO;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
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
import static com.example.football.constant.Paths.TOWNS_FILE_PATH;

@Service
public class TownServiceImpl implements TownService {

    private final StringBuilder sb;
    private final ModelMapper mapper;
    private final Gson gson;
    private final FileUtil fileUtil;
    private final TownRepository townRepository;

    public TownServiceImpl(ModelMapper mapper, Gson gson, FileUtil fileUtil, TownRepository townRepository) {
        this.mapper = mapper;
        this.gson = gson;
        this.fileUtil = fileUtil;
        this.townRepository = townRepository;
        this.sb = new StringBuilder();
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return this.fileUtil.readFile(TOWNS_FILE_PATH);
    }

    @Override
    public String importTowns() throws FileNotFoundException {

        final JsonReader reader = new JsonReader(new FileReader(TOWNS_FILE_PATH.toFile()));

        final Type type = new TypeToken<List<TownImportDTO>>(){}.getType();

        final List<TownImportDTO> townsImportDTO = this.gson.fromJson(reader, type);

        townsImportDTO
                .forEach(townDTO -> {

                    final Town town = this.mapper.map(townDTO, Town.class);

                    try {

                        this.townRepository.saveAndFlush(town);

                        this.sb.append(String.format(SUCCESSFUL_JSON_IMPORT,
                                        town.getClass().getSimpleName(), town.getName(), town.getPopulation()))
                                .append(System.lineSeparator());

                    } catch (Exception e) {

                        this.sb.append(String.format(INVALID_ENTITY, town.getClass().getSimpleName()))
                                .append(System.lineSeparator());
                    }
                });

        return this.sb.toString().trim();
    }
}
