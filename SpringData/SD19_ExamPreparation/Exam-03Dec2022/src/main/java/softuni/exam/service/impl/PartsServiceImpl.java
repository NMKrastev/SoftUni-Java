package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.part.PartImportDTO;
import softuni.exam.models.entity.Part;
import softuni.exam.repository.PartsRepository;
import softuni.exam.service.PartsService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static softuni.exam.constant.Message.*;

@Service
public class PartsServiceImpl implements PartsService {

    private static final String PARTS_FILE_PATH = "src/main/resources/files/json/parts.json";
    private final StringBuilder sb;
    private final Gson gson;
    private final ModelMapper mapper;
    private final ValidationUtils validationUtils;
    private final PartsRepository partsRepository;

    @Autowired
    public PartsServiceImpl(Gson gson, ModelMapper mapper,
                            ValidationUtils validationUtils, PartsRepository partsRepository) {
        this.sb = new StringBuilder();
        this.gson = gson;
        this.mapper = mapper;
        this.validationUtils = validationUtils;
        this.partsRepository = partsRepository;
    }

    @Override
    public boolean areImported() {
        return this.partsRepository.count() > 0;
    }

    @Override
    public String readPartsFileContent() throws IOException {
        return Files.readString(Path.of(PARTS_FILE_PATH));
    }

    @Override
    public String importParts() throws IOException {

        final List<PartImportDTO> partsImportDTO =
                Arrays.stream(this.gson.fromJson(this.readPartsFileContent(), PartImportDTO[].class))
                        .collect(Collectors.toList());

        partsImportDTO
                .forEach(partDTO -> {

                    if (this.partsRepository.findFirstByPartName(partDTO.getPartName()).isPresent() ||
                            !this.validationUtils.isValid(partDTO)) {

                        this.sb.append(String.format(INVALID_ENTITY, PART))
                                .append(System.lineSeparator());

                    } else {

                        final Part part = this.mapper.map(partDTO, Part.class);

                        this.partsRepository.saveAndFlush(part);

                        this.sb.append(String.format(SUCCESSFUL_PART_IMPORT, PART,
                                        part.getPartName(), part.getPrice()))
                                .append(System.lineSeparator());
                    }
                });

        return this.sb.toString().trim();
    }
}
