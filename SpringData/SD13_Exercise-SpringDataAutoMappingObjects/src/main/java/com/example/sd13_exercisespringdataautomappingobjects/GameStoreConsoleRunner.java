package com.example.sd13_exercisespringdataautomappingobjects;

import com.example.sd13_exercisespringdataautomappingobjects.services.game.GameService;
import com.example.sd13_exercisespringdataautomappingobjects.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Scanner;

import static com.example.sd13_exercisespringdataautomappingobjects.constants.Commands.*;
import static com.example.sd13_exercisespringdataautomappingobjects.constants.Messages.COMMAND_NOT_FOUND_MESSAGE;
import static com.example.sd13_exercisespringdataautomappingobjects.constants.Messages.ENTER_COMMAND;

@Component
public class GameStoreConsoleRunner implements CommandLineRunner {

    private final Scanner scanner;
    private final UserService userService;
    private final GameService gameService;

    @Autowired
    public GameStoreConsoleRunner(Scanner scanner, UserService userService, GameService gameService) {
        this.scanner = scanner;
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public void run(String... args) throws Exception {

        //Separated by |
        System.out.print(ENTER_COMMAND);
        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("Close")) {

            final String command = input.split("\\|")[0];

            final String[] data = Arrays.stream(input.split("\\|")).skip(1).toArray(String[]::new);

            final String output = switch (command) {
                case REGISTER_USER -> this.userService.registerUser(data);
                case LOGIN_USER -> this.userService.loginUser(data);
                case LOGOUT_USER -> this.userService.logoutUser();
                case ADD_GAME -> this.gameService.addGame(data);
                case EDIT_GAME -> this.gameService.editGame(data);
                case DELETE_GAME -> this.gameService.deleteGame(data);
                case ALL_GAMES -> this.gameService.getAllGames();
                case DETAIL_GAME -> this.gameService.getInfoAboutAGame(data);
                case OWNED_GAMES -> this.userService.getUserOwnedGames();
                case ADD_ITEM -> this.userService.addItemToShoppingCart(data);
                case REMOVE_ITEM -> this.userService.removeItemFromShoppingCart(data);
                case BUY_ITEM -> this.userService.buyItemsFromShoppingCart();
                default -> COMMAND_NOT_FOUND_MESSAGE;
            };

            System.out.println(output);

            System.out.print(ENTER_COMMAND);
            input = scanner.nextLine();
        }
    }
}
