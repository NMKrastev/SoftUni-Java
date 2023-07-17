package exam.service.impl;

import exam.model.dtos.town.TownImportDTO;
import exam.model.dtos.town.TownImportWrapperDTO;
import exam.model.entity.Town;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.util.FileUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static exam.constant.FilePath.TOWNS_FILE_PATH;
import static exam.constant.Message.INVALID_ENTITY;
import static exam.constant.Message.SUCCESSFUL_TOWN_IMPORT;

@Service
public class TownServiceImpl implements TownService {

    private final StringBuilder sb;
    private final FileUtil fileUtil;
    private final ModelMapper mapper;
    private final TownRepository townRepository;

    @Autowired
    public TownServiceImpl(FileUtil fileUtil, ModelMapper mapper, TownRepository townRepository) {
        this.fileUtil = fileUtil;
        this.mapper = mapper;
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
    public String importTowns() throws JAXBException, FileNotFoundException {

        final FileReader reader = new FileReader(TOWNS_FILE_PATH.toFile());

        final JAXBContext context = JAXBContext.newInstance(TownImportWrapperDTO.class);

        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final TownImportWrapperDTO townImportWrapperDTOS = (TownImportWrapperDTO) unmarshaller.unmarshal(reader);

        final List<TownImportDTO> townsImportDTO = townImportWrapperDTOS.getTowns();

        townsImportDTO
                .forEach(townDTO -> {

                    final Town town = this.mapper.map(townDTO, Town.class);

                    try {

                        this.townRepository.saveAndFlush(town);

                        this.sb.append(String.format(SUCCESSFUL_TOWN_IMPORT,
                                        town.getClass().getSimpleName(), town.getName()))
                                .append(System.lineSeparator());

                    } catch (Exception e) {
                        this.sb.append(String.format(INVALID_ENTITY, town.getClass().getSimpleName().toLowerCase()))
                                .append(System.lineSeparator());
                    }
                });

        return this.sb.toString().trim();
    }
}
