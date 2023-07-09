package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.picture.PictureImportWrapperDTO;
import softuni.exam.domain.dtos.picture.PictureImportDTO;
import softuni.exam.domain.entities.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.util.FileUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static softuni.exam.constant.FilePath.PICTURES_FILE_PATH;
import static softuni.exam.constant.Message.INVALID_PICTURE;
import static softuni.exam.constant.Message.SUCCESSFULLY_ADDED_PICTURE;

@Service
public class PictureServiceImpl implements PictureService {

    private final StringBuilder sb = new StringBuilder();
    private final ModelMapper mapper;
    private final FileUtil fileUtil;
    private final PictureRepository pictureRepository;

    @Autowired
    public PictureServiceImpl(ModelMapper mapper, FileUtil fileUtil, PictureRepository pictureRepository) {
        this.mapper = mapper;
        this.fileUtil = fileUtil;
        this.pictureRepository = pictureRepository;
    }

    @Override
    public String importPictures() throws JAXBException, FileNotFoundException {

        final FileReader reader = new FileReader(PICTURES_FILE_PATH);

        final JAXBContext context = JAXBContext.newInstance(PictureImportWrapperDTO.class);

        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final PictureImportWrapperDTO pictureImportWrapperDTO = (PictureImportWrapperDTO) unmarshaller.unmarshal(reader);

        final List<PictureImportDTO> picturesImportDTO = pictureImportWrapperDTO.getPictures();

        for (PictureImportDTO pictureDTO : picturesImportDTO) {

            final Picture picture = this.mapper.map(pictureDTO, Picture.class);

            try {

                this.pictureRepository.saveAndFlush(picture);
                this.sb.append(String.format(SUCCESSFULLY_ADDED_PICTURE, picture.getUrl()))
                        .append(System.lineSeparator());

            } catch (Exception e) {
                this.sb.append(INVALID_PICTURE).append(System.lineSeparator());
            }
        }

        return this.sb.toString().trim();
    }

    @Override
    public boolean areImported() {

        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesXmlFile() throws IOException {

        return fileUtil.readFile(PICTURES_FILE_PATH);
    }

}
