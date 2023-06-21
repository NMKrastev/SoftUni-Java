package com.example.A2_UserSystem;

import com.example.A2_UserSystem.models.User;
import com.example.A2_UserSystem.services.seed.SeedService;
import com.example.A2_UserSystem.services.town.TownService;
import com.example.A2_UserSystem.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

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

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("2. Remove Inactive Users");
        System.out.print("Please enter date in format (d-m-yyyy/1-1-1900): ");
        final String date = scanner.nextLine();

        //Setting users for deletion
        final List<User> usersNotLoggedInAfterGivenDate = setUsersForDeletion(date);

        //Deleting the users
        deleteUsers(usersNotLoggedInAfterGivenDate);
    }

    private void deleteUsers(List<User> usersNotLoggedInAfterGivenDate) {

        usersNotLoggedInAfterGivenDate
                .forEach(e -> this.userService.deleteById(e.getId()));

        System.out.println("Users deleted!");
    }

    private List<User> setUsersForDeletion(String date) {

        final LocalDate givenDate = LocalDate.of(Integer.parseInt(date.split("-")[2]),
                Integer.parseInt(date.split("-")[1]), Integer.parseInt(date.split("-")[0]));

        final List<User> usersNotLoggedInAfterGivenDate = this.userService.findAllByLastTimeLoggedInBefore(givenDate);

        usersNotLoggedInAfterGivenDate.forEach(e -> e.setIsDeleted(true));

        System.out.printf("Users set as deleted: %s\n", usersNotLoggedInAfterGivenDate.size());

        return usersNotLoggedInAfterGivenDate;
    }

    private void getAllUsersByEmailProvider() {

        System.out.println("1. Get Users by Email Provider");
        System.out.print("Enter a provider(gmail.com): ");
        final String emailProvider = scanner.nextLine();

        final List<User> allByEmailLike = this.userService.findAllByEmailLike(emailProvider);

        allByEmailLike
                .forEach(e -> System.out.printf("Username: %s, Email: %s\n", e.getUsername(), e.getEmail()));
    }
}
