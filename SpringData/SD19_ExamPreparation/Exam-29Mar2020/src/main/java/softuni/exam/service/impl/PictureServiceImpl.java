package softuni.exam.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.picture.PictureImportDTO;
import softuni.exam.models.entities.Car;
import softuni.exam.models.entities.Picture;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.PictureService;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.util.List;

import static softuni.exam.constant.Message.INVALID_PICTURE;
import static softuni.exam.constant.Message.SUCCESSFULLY_ADDED_PICTURE;
import static softuni.exam.constant.Paths.PICTURES_FILE_PATH;

@Service
public class PictureServiceImpl implements PictureService {

    private final StringBuilder sb = new StringBuilder();
    private final Gson gson;
    private final ModelMapper mapper;
    private final PictureRepository pictureRepository;
    private final CarRepository carRepository;

    public PictureServiceImpl(Gson gson, ModelMapper mapper,
                              PictureRepository pictureRepository, CarRepository carRepository) {
        this.gson = gson;
        this.mapper = mapper;
        this.pictureRepository = pictureRepository;
        this.carRepository = carRepository;
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return new String(Files.readAllBytes(PICTURES_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {

        final Type type = new TypeToken<List<PictureImportDTO>>() {
        }.getType();

        final JsonReader reader = new JsonReader(new FileReader(PICTURES_FILE_PATH.toFile()));

        final List<PictureImportDTO> picturesImportDTO = this.gson.fromJson(reader, type);

        for (PictureImportDTO pictureImportDTO : picturesImportDTO) {

            final Picture picture = this.mapper.map(pictureImportDTO, Picture.class);

            final Car car = this.carRepository.findById(pictureImportDTO.getCar()).get();

            picture.setCar(car);

            try {

                this.pictureRepository.saveAndFlush(picture);

                this.sb.append(String.format(SUCCESSFULLY_ADDED_PICTURE, picture.getName()))
                        .append(System.lineSeparator());

            } catch (Exception e) {
                this.sb.append(INVALID_PICTURE).append(System.lineSeparator());
            }
        }

        return this.sb.toString().trim();
    }
}
