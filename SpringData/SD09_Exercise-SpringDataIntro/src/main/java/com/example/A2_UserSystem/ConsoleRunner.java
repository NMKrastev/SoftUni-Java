package com.example.A2_UserSystem;

import com.example.A2_UserSystem.entities.User;
import com.example.A2_UserSystem.services.seed.SeedService;
import com.example.A2_UserSystem.services.town.TownService;
import com.example.A2_UserSystem.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import static com.example.A2_UserSystem.constants.Constants.*;

@Service
public class ConsoleRunner implements CommandLineRunner {

    private static final Scanner scanner = new Scanner(System.in);
    private SeedService seedService;
    private TownService townService;
    private UserService userService;

    @Autowired
    public ConsoleRunner(SeedService seedService, TownService townService, UserService userService) {
        this.seedService = seedService;
        this.townService = townService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        this.seedService.seedAll();

        //Get users by email provider
        this.getAllUsersByEmailProvider();

        //Remove Inactive Users
        this.removeInactiveUsers();
    }

    private void removeInactiveUsers() {

        System.out.println(SEPARATOR);
        System.out.println(TASK_TWO_TITLE);
        System.out.print(ENTER_DATE_IN_FORMAT);
        final String date = scanner.nextLine();

        //Setting users for deletion
        final List<User> usersNotLoggedInAfterGivenDate = setUsersForDeletion(date);

        //Deleting the users
        deleteUsers(usersNotLoggedInAfterGivenDate);
    }

    private void deleteUsers(List<User> usersNotLoggedInAfterGivenDate) {

        usersNotLoggedInAfterGivenDate
                .forEach(e -> this.userService.deleteById(e.getId()));

        System.out.println(USERS_DELETED);
    }

    private List<User> setUsersForDeletion(String date) {

        final LocalDate givenDate = LocalDate.of(Integer.parseInt(date.split("-")[2]),
                Integer.parseInt(date.split("-")[1]), Integer.parseInt(date.split("-")[0]));

        final List<User> usersNotLoggedInAfterGivenDate = this.userService.findAllByLastTimeLoggedInBefore(givenDate);

        usersNotLoggedInAfterGivenDate.forEach(e -> e.setIsDeleted(true));

        System.out.printf(USERS_SET_AS_DELETED, usersNotLoggedInAfterGivenDate.size());

        return usersNotLoggedInAfterGivenDate;
    }

    private void getAllUsersByEmailProvider() {

        System.out.println(SEPARATOR);
        System.out.println(TASK_ONE_TITLE);
        System.out.print(ENTER_EMAIL_PROVIDER);
        final String emailProvider = scanner.nextLine();

        final List<User> allByEmailLike = this.userService.findAllByEmailLike(emailProvider);

        allByEmailLike
                .forEach(e -> System.out.printf(PRINT_USER_EMAIL_FORMAT, e.getUsername(), e.getEmail()));
    }
}
