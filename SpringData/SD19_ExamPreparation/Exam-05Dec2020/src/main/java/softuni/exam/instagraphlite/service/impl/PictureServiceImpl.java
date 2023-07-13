package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dtos.picture.PictureImportDTO;
import softuni.exam.instagraphlite.models.entities.Picture;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.FileUtil;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import static softuni.exam.instagraphlite.constants.Message.*;
import static softuni.exam.instagraphlite.constants.Paths.PICTURES_FILE_PATH;

@Service
public class PictureServiceImpl implements PictureService {

    private final StringBuilder sb;
    private final ModelMapper mapper;
    private final Gson gson;
    private final FileUtil fileUtil;
    private final PictureRepository pictureRepository;

    @Autowired
    public PictureServiceImpl(ModelMapper mapper, Gson gson, FileUtil fileUtil, PictureRepository pictureRepository) {
        this.sb = new StringBuilder();
        this.mapper = mapper;
        this.gson = gson;
        this.fileUtil = fileUtil;
        this.pictureRepository = pictureRepository;
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return this.fileUtil.readFile(PICTURES_FILE_PATH);
    }

    @Override
    public String importPictures() throws IOException {

        final Type type = new TypeToken<List<PictureImportDTO>>(){}.getType();

        final JsonReader reader = new JsonReader(new FileReader(PICTURES_FILE_PATH.toFile()));

        final List<PictureImportDTO> picturesImportDTO = this.gson.fromJson(reader, type);

        picturesImportDTO
                .stream()
                .map(pictureDTO -> this.mapper.map(pictureDTO, Picture.class))
                .toList()
                .forEach(picture -> {

                    try {

                        this.pictureRepository.saveAndFlush(picture);

                        this.sb.append(String.format(SUCCESSFULLY_IMPORTED_PICTURE,
                                        picture.getClass().getSimpleName(), picture.getSize()))
                                .append(System.lineSeparator());

                    } catch (Exception e) {

                        this.sb.append(String.format(INVALID_ENTITY, picture.getClass().getSimpleName()))
                                .append(System.lineSeparator());
                    }
                });

        return this.sb.toString().trim();
    }

    @Override
    public String exportPictures() {

        final List<Picture> pictures = this.pictureRepository.findAllBySizeGreaterThanOrderBySize(PICTURE_SIZE);

        pictures
                .forEach(p -> this.sb.append(String.format(PICTURE_FORMAT, p.getSize(), p.getPath()))
                        .append(System.lineSeparator()));

        return this.sb.toString().trim();
    }
}
