package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dtos.post.PostImportDTO;
import softuni.exam.instagraphlite.models.dtos.post.PostImportWrapperDTO;
import softuni.exam.instagraphlite.models.entities.Picture;
import softuni.exam.instagraphlite.models.entities.Post;
import softuni.exam.instagraphlite.models.entities.User;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.util.FileUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static softuni.exam.instagraphlite.constants.Message.INVALID_ENTITY;
import static softuni.exam.instagraphlite.constants.Message.SUCCESSFULLY_IMPORTED_POST;
import static softuni.exam.instagraphlite.constants.Paths.POSTS_FILE_PATH;

@Service
public class PostServiceImpl implements PostService {

    private final StringBuilder sb;
    private final ModelMapper mapper;
    private final FileUtil fileUtil;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PictureRepository pictureRepository;

    public PostServiceImpl(ModelMapper mapper, FileUtil fileUtil, PostRepository postRepository,
                           UserRepository userRepository, PictureRepository pictureRepository) {
        this.mapper = mapper;
        this.fileUtil = fileUtil;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;
        this.sb = new StringBuilder();
    }

    @Override
    public boolean areImported() {
        return this.postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return this.fileUtil.readFile(POSTS_FILE_PATH);
    }

    @Override
    public String importPosts() throws IOException, JAXBException {

        final FileReader reader = new FileReader(POSTS_FILE_PATH.toFile());

        final JAXBContext context = JAXBContext.newInstance(PostImportWrapperDTO.class);

        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final PostImportWrapperDTO postImportWrapperDTO = (PostImportWrapperDTO) unmarshaller.unmarshal(reader);

        final List<PostImportDTO> postsImportDTO = postImportWrapperDTO.getPosts();

        for (PostImportDTO postDTO : postsImportDTO) {

            final User user = this.userRepository.findByUsername(postDTO.getUser().getUsername());

            final Picture picture = this.pictureRepository.findByPath(postDTO.getPicture().getPath());

            final Post post = this.mapper.map(postDTO, Post.class);
            post.setUser(user);
            post.setPicture(picture);

            try {

                this.postRepository.saveAndFlush(post);

                this.sb.append(String.format(SUCCESSFULLY_IMPORTED_POST,
                                post.getClass().getSimpleName(), post.getUser().getUsername()))
                        .append(System.lineSeparator());

            } catch (Exception e) {

                this.sb.append(String.format(INVALID_ENTITY, post.getClass().getSimpleName()))
                        .append(System.lineSeparator());
            }
        }

        return this.sb.toString().trim();
    }
}
