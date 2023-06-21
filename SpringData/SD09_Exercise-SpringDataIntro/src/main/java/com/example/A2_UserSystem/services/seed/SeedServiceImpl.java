package com.example.A2_UserSystem.services.seed;

import com.example.A2_UserSystem.models.Town;
import com.example.A2_UserSystem.models.User;
import com.example.A2_UserSystem.services.town.TownService;
import com.example.A2_UserSystem.services.user.UserService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.stream.Collectors;

import static com.example.A2_UserSystem.constants.FilePath.*;

@Service
public class SeedServiceImpl implements SeedService {

    private TownService townService;
    private UserService userService;

    public SeedServiceImpl(TownService townService, UserService userService) {
        this.townService = townService;
        this.userService = userService;
    }

    @Override
    public void seedTowns() throws IOException {

        if (!this.townService.isDataSeeded()) {

            final String regex = ",\\s+";

            this.townService
                    .seedTowns(Files.readAllLines
                                    (Path.of
                                            (SPECIFIC_PATH + RESOURCE_PATH + TOWN_FILE_NAME))
                            .stream()
                            .filter(e -> !e.isBlank())
                            .map(row -> Town.builder()
                                    .name(row.split(regex)[0])
                                    .country(row.split(regex)[1])
                                    .build())
                            .collect(Collectors.toList()));
        }
    }

    @Override
    public void seedUsers() throws IOException {

        if (!this.userService.isDataSeeded()) {

            final String regex = "\\s+";

            this.userService
                    .seedUsers(Files.readAllLines
                                    (Path.of
                                            (SPECIFIC_PATH + RESOURCE_PATH + USER_FILE_NAME))
                            .stream()
                            .filter(e -> !e.isBlank())
                            .map(row -> User.builder()
                                    .username(row.split(regex)[0])
                                    .password(row.split(regex)[1])
                                    .email(row.split(regex)[2])
                                    .registeredOn(LocalDate.now())
                                    .lastTimeLoggedIn(LocalDate.now())
                                    .age(Integer.parseInt(row.split(regex)[3]))
                                    .isDeleted(false)
                                    .bornInTown(this.townService.getRandomTown())
                                    .currentlyLivingInTown(this.townService.getRandomTown())
                                    .build())
                            .collect(Collectors.toList()));
        }
    }
}