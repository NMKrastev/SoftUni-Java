package softuni.exam.service.impl;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.plane.PlaneImportDTO;
import softuni.exam.models.dtos.plane.PlaneImportWrapperDTO;
import softuni.exam.models.entities.Plane;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.service.PlaneService;
import softuni.exam.util.FileUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static softuni.exam.constant.Message.*;
import static softuni.exam.constant.Paths.PLANES_FILE_PATH;

@Service
public class PlaneServiceImpl implements PlaneService {

    private final StringBuilder sb = new StringBuilder();
    private final ModelMapper mapper;
    private final FileUtil fileUtil;
    private final PlaneRepository planeRepository;

    @Autowired
    public PlaneServiceImpl(ModelMapper mapper, FileUtil fileUtil, PlaneRepository planeRepository) {
        this.mapper = mapper;
        this.fileUtil = fileUtil;
        this.planeRepository = planeRepository;
    }


    @Override
    public boolean areImported() {
        return this.planeRepository.count() > 0;
    }

    @Override
    public String readPlanesFileContent() throws IOException {
        return this.fileUtil.readFile(PLANES_FILE_PATH);
    }

    @Override
    public String importPlanes() throws FileNotFoundException, JAXBException {

        final FileReader reader = new FileReader(PLANES_FILE_PATH.toFile());

        final JAXBContext context = JAXBContext.newInstance(PlaneImportWrapperDTO.class);

        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final PlaneImportWrapperDTO planesImportWrapperDTO = (PlaneImportWrapperDTO) unmarshaller.unmarshal(reader);

        final List<PlaneImportDTO> planesDTO = planesImportWrapperDTO.getPlanes();

        planesDTO
                .stream()
                .map(planeDTO -> this.mapper.map(planeDTO, Plane.class))
                .collect(Collectors.toList())
                .forEach(plane -> {

                    try {

                        this.planeRepository.saveAndFlush(plane);

                        this.sb.append(String.format(PLANE_SUCCESSFUL_IMPORT, plane.getClass().getSimpleName(),
                                plane.getRegisterNumber())).append(System.lineSeparator());

                    } catch (Exception e) {

                        this.sb.append(String.format(INVALID_IMPORT, plane.getClass().getSimpleName()))
                                .append(System.lineSeparator());
                    }
                });

        return this.sb.toString().trim();
    }
}
