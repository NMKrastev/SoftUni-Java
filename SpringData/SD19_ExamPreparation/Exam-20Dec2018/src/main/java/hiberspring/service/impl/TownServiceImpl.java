package hiberspring.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import hiberspring.domain.dtos.TownImportDTO;
import hiberspring.domain.entities.Town;
import hiberspring.repository.TownRepository;
import hiberspring.service.TownService;
import hiberspring.util.FileUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

import static hiberspring.common.Constants.*;

@Service
public class TownServiceImpl implements TownService {

    private final Gson gson;
    private final ModelMapper mapper;
    private final StringBuilder sb;
    private final FileUtil fileUtil;
    private final TownRepository townRepository;

    @Autowired
    public TownServiceImpl(Gson gson, ModelMapper mapper, StringBuilder sb, FileUtil fileUtil, TownRepository townRepository) {
        this.gson = gson;
        this.mapper = mapper;
        this.sb = sb;
        this.fileUtil = fileUtil;
        this.townRepository = townRepository;
    }

    @Override
    public Boolean townsAreImported() {
        return this.townRepository.count() != 0;
    }

    @Override
    public String readTownsJsonFile() throws IOException {
        return this.fileUtil.readFile(PATH_TO_FILES + TOWNS_FILE);
    }

    @Override
    public String importTowns(String townsFileContent) throws FileNotFoundException {

        final Type type = new TypeToken<List<TownImportDTO>>(){}.getType();

        final String filePath = PATH_TO_FILES + TOWNS_FILE;

        final JsonReader reader = new JsonReader(new FileReader(filePath));

        final List<TownImportDTO> townsImportDTO = this.gson.fromJson(reader, type);

        final List<Town> towns = townsImportDTO
                .stream()
                .map(townDTO -> this.mapper.map(townDTO, Town.class))
                .collect(Collectors.toList());

        for (Town town : towns) {

            try {

                this.townRepository.saveAndFlush(town);

                this.sb.append(String.format(SUCCESSFUL_IMPORT_MESSAGE, town.getClass().getSimpleName(), town.getName()))
                        .append(System.lineSeparator());

            } catch (Exception e) {
                this.sb.append(INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
            }
        }

        return this.sb.toString().trim();
    }
}
