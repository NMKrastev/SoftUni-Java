package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dtos.user.UserByPostCountDTO;
import softuni.exam.instagraphlite.models.dtos.user.UserImportDTO;
import softuni.exam.instagraphlite.models.entities.Picture;
import softuni.exam.instagraphlite.models.entities.Post;
import softuni.exam.instagraphlite.models.entities.User;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.FileUtil;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.List;

import static softuni.exam.instagraphlite.constants.Message.*;
import static softuni.exam.instagraphlite.constants.Paths.USERS_FILE_PATH;

@Service
public class UserServiceImpl implements UserService {

    private final StringBuilder sb;
    private final ModelMapper mapper;
    private final Gson gson;
    private final FileUtil fileUtil;
    private final UserRepository userRepository;
    private final PictureRepository pictureRepository;

    public UserServiceImpl(ModelMapper mapper, Gson gson, FileUtil fileUtil,
                           UserRepository userRepository, PictureRepository pictureRepository) {
        this.sb = new StringBuilder();
        this.mapper = mapper;
        this.gson = gson;
        this.fileUtil = fileUtil;
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;
    }

    @Override
    public boolean areImported() {
        return this.userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return this.fileUtil.readFile(USERS_FILE_PATH);
    }

    @Override
    public String importUsers() throws IOException {

        final Type type = new TypeToken<List<UserImportDTO>>(){}.getType();

        final JsonReader reader = new JsonReader(new FileReader(USERS_FILE_PATH.toFile()));

        final List<UserImportDTO> usersImportDTO = this.gson.fromJson(reader, type);

        for (UserImportDTO userDTO : usersImportDTO) {

            final Picture picture = this.pictureRepository.findByPath(userDTO.getPath());

            final User user = this.mapper.map(userDTO, User.class);

            user.setProfilePicture(picture);

            try {

                this.userRepository.saveAndFlush(user);

                this.sb.append(String.format(SUCCESSFULLY_IMPORTED_USER,
                                user.getClass().getSimpleName(), user.getUsername()))
                        .append(System.lineSeparator());

            } catch (Exception e) {

                this.sb.append(String.format(INVALID_ENTITY, user.getClass().getSimpleName()))
                        .append(System.lineSeparator());
            }
        }

        return this.sb.toString().trim();
    }

    @Override
    public String exportUsersWithTheirPosts() {

        final List<UserByPostCountDTO> usersDTO = this.userRepository.findUsersByCountOfPosts();

        for (UserByPostCountDTO userDTO : usersDTO) {

            this.sb.append(String.format(USER_POST_COUNT_FORMAT, userDTO.getUser().getUsername(), userDTO.getPostCount()))
                    .append(System.lineSeparator());

            final List<Post> posts = userDTO.getUser().getPosts();
            posts.sort(Comparator.comparing(post -> post.getPicture().getSize()));

            for (Post post : posts) {
                this.sb.append(String.format(USER_INFO_FORMAT, post.getCaption(), post.getPicture().getSize()))
                        .append(System.lineSeparator());
            }
        }

        return this.sb.toString().trim();
    }
}
