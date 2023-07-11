package softuni.exam.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.town.TownImportDTO;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.FileUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

import static softuni.exam.constant.Message.INVALID_IMPORT;
import static softuni.exam.constant.Message.SUCCESSFUL_IMPORT;
import static softuni.exam.constant.Paths.TOWNS_FILE_PATH;

@Service
public class TownServiceImpl implements TownService {

    private final StringBuilder sb = new StringBuilder();
    private final ModelMapper mapper;
    private final Gson gson;
    private final FileUtil fileUtil;
    private final TownRepository townRepository;

    @Autowired
    public TownServiceImpl(ModelMapper mapper, Gson gson, FileUtil fileUtil, TownRepository townRepository) {
        this.mapper = mapper;
        this.gson = gson;
        this.fileUtil = fileUtil;
        this.townRepository = townRepository;
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
                .stream()
                .map(townDTO -> this.mapper.map(townDTO, Town.class))
                .collect(Collectors.toList())
                .forEach(town -> {
                    try {

                        this.townRepository.saveAndFlush(town);

                        this.sb.append(String.format(SUCCESSFUL_IMPORT, town.getClass().getSimpleName(),
                                        town.getName(), town.getPopulation()))
                                .append(System.lineSeparator());

                    } catch (Exception e) {

                        this.sb.append(String.format(INVALID_IMPORT, town.getClass().getSimpleName()))
                                .append(System.lineSeparator());
                    }
                });

        return this.sb.toString().trim();
    }
}
