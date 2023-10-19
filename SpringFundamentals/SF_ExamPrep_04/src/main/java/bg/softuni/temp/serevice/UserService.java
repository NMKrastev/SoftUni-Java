package bg.softuni.temp.serevice;

import bg.softuni.temp.model.dto.SongDTO;
import bg.softuni.temp.model.dto.UserLoginDTO;
import bg.softuni.temp.model.dto.UserRegistrationDTO;
import bg.softuni.temp.model.entity.Song;
import bg.softuni.temp.model.entity.User;
import bg.softuni.temp.model.mapper.SongMapper;
import bg.softuni.temp.model.mapper.UserMapper;
import bg.softuni.temp.repository.UserRepository;
import bg.softuni.temp.user.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final SongService songService;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final SongMapper songMapper;
    private final CurrentUser currentUser;

    public UserService(UserRepository userRepository, SongService songService,
                       PasswordEncoder passwordEncoder, UserMapper userMapper,
                       SongMapper songMapper, CurrentUser currentUser) {

        this.userRepository = userRepository;
        this.songService = songService;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.songMapper = songMapper;
        this.currentUser = currentUser;
    }

    public boolean registerUser(UserRegistrationDTO userRegistrationDTO) {

        //Reassurance!
        if (this.userRepository.findByUsername(userRegistrationDTO.getUsername()).isPresent()
                || this.userRepository.findByEmail(userRegistrationDTO.getEmail()).isPresent()) {

            this.logoutUser();

            return false;
        }

        final User user = this.userMapper.userRegistrationDtoToUser(userRegistrationDTO);

        this.userRepository.save(user);

        return true;
    }

    public boolean loginUser(UserLoginDTO userLoginDTO) {

        final Optional<User> optionalUser = this.userRepository
                .findByUsername(userLoginDTO.getUsername());

        if (optionalUser.isEmpty()) {

            return false;
        }

        final String rawPassword = userLoginDTO.getPassword();
        final String encodedPassword = optionalUser.get().getPassword();

        final boolean success = this.passwordEncoder
                .matches(rawPassword, encodedPassword);

        if (success) {

            this.login(optionalUser.get());

        } else {

            this.logoutUser();
        }

        return success;
    }

    public void logoutUser() {

        this.currentUser.clear();
    }

    private void login(User user) {

        this.currentUser.setId(user.getId());
        this.currentUser.setLoggedIn(true);
        this.currentUser.setEmail(user.getEmail());
        this.currentUser.setUsername(user.getUsername());
    }

    public List<SongDTO> findUserPlaylist() {

        return this.userRepository
                .findById(this.currentUser.getId())
                .get()
                .getPlaylist()
                .stream()
                .map(this.songMapper::songToSongDto)
                .toList();
    }

    public boolean addSongToPlaylist(Long songId) {

        final User user =
                this.userRepository.findByUsername(this.currentUser.getUsername()).get();

        if (user.getPlaylist().stream().anyMatch(e -> Objects.equals(e.getId(), songId))) {
            return false;
        }

        final Song song = this.songService.findSongById(songId);

        user.getPlaylist().add(song);

        this.userRepository.save(user);

        return true;
    }

    public void removeAllSongsFromPlaylist() {

        final User user =
                this.userRepository.findByUsername(this.currentUser.getUsername()).get();

        user.setPlaylist(new ArrayList<>());

        this.userRepository.save(user);
    }
}
