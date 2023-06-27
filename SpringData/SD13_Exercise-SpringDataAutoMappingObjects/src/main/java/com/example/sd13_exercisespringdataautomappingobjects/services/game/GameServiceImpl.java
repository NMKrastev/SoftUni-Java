package com.example.sd13_exercisespringdataautomappingobjects.services.game;

import com.example.sd13_exercisespringdataautomappingobjects.entities.Game;
import com.example.sd13_exercisespringdataautomappingobjects.entities.User;
import com.example.sd13_exercisespringdataautomappingobjects.entities.dtos.game.GameDTO;
import com.example.sd13_exercisespringdataautomappingobjects.entities.dtos.game.GameDetailedInfoDTO;
import com.example.sd13_exercisespringdataautomappingobjects.entities.dtos.game.GameTitlePriceDTO;
import com.example.sd13_exercisespringdataautomappingobjects.repositories.GameRepository;
import com.example.sd13_exercisespringdataautomappingobjects.services.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.example.sd13_exercisespringdataautomappingobjects.constants.Messages.*;
import static com.example.sd13_exercisespringdataautomappingobjects.constants.Validations.*;

@Service
public class GameServiceImpl implements GameService {

    private final ModelMapper mapper;
    private final GameRepository gameRepository;
    private final UserService userService;

    @Autowired
    public GameServiceImpl(ModelMapper mapper, GameRepository gameRepository, UserService userService) {
        this.mapper = mapper;
        this.gameRepository = gameRepository;
        this.userService = userService;
    }

    @Override
    public String addGame(String[] gameData) {

        if (!isUserLoggedInAdministrator()) {
            return USER_MUST_BE_LOGGED_OR_ADMIN_TO_ADD_OR_EDIT_GAME;
        }

        final String title = gameData[0];

        final Optional<Game> doesGameExist = this.gameRepository.findFirstByTitle(title);

        if (doesGameExist.isPresent()) {
            return GAME_ALREADY_EXISTS;
        }

        final BigDecimal price = BigDecimal.valueOf(Double.parseDouble(gameData[1]));
        final Double size = Double.parseDouble(gameData[2]);
        final String trailerId = gameData[3];
        final String thumbnailUrl = gameData[4];
        final String description = gameData[5];
        final LocalDate releaseDate = LocalDate.parse(gameData[6], DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        final GameDTO gameDTO;

        try {
            gameDTO = new GameDTO(title, trailerId, thumbnailUrl, size, price, description, releaseDate);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        final Game gameToSave = this.mapper.map(gameDTO, Game.class);

        this.gameRepository.save(gameToSave);

        return String.format(GAME_ADDED_SUCCESSFULLY, title);
    }

    @Override
    @Transactional
    public String editGame(String[] gameData) {

        if (!isUserLoggedInAdministrator()) {
            return USER_MUST_BE_LOGGED_OR_ADMIN_TO_ADD_OR_EDIT_GAME;
        }

        final Long id = Long.valueOf(gameData[0]);

        final Optional<Game> doesGameExist = this.gameRepository.findById(id);

        if (doesGameExist.isEmpty()) {
            return String.format(GAME_DOES_NOT_EXISTS, id);
        }

        final Game game = doesGameExist.get();

        final Field[] declaredFields = game.getClass().getDeclaredFields();

        updateFieldsValue(gameData, game, declaredFields);

        this.gameRepository.save(game);

        return String.format(GAME_EDITED_SUCCESSFULLY, game.getTitle());
    }

    @Override
    @Transactional
    public String deleteGame(String[] gameData) {

        if (!isUserLoggedInAdministrator()) {
            return USER_MUST_BE_LOGGED_OR_ADMIN_TO_ADD_OR_EDIT_GAME;
        }

        final Long id = Long.valueOf(gameData[0]);

        final Optional<Game> doesGameExist = this.gameRepository.findById(id);

        if (doesGameExist.isEmpty()) {
            return String.format(GAME_DOES_NOT_EXISTS, id);
        }

        deleteDetachedEntries(id);

        this.gameRepository.deleteById(id);

        return String.format(GAME_DELETED_SUCCESSFULLY, doesGameExist.get().getTitle());
    }

    @Override
    public String getAllGames() {

        final List<Game> allGames = this.gameRepository.findAll();

        final List<GameTitlePriceDTO> gameTitlePriceDTOS = new ArrayList<>();

        allGames.forEach(e -> gameTitlePriceDTOS.add(mapper.map(e, GameTitlePriceDTO.class)));

        final StringBuilder sb = new StringBuilder();

        gameTitlePriceDTOS
                .forEach(e -> sb.append(String.format("%s %.2f", e.getTitle(), e.getPrice()))
                        .append(System.lineSeparator()));

        return sb.toString().trim();
    }

    @Override
    public String getInfoAboutAGame(String[] data) {

        final String title = data[0];

        final Optional<Game> gameByTitle = this.gameRepository.findFirstByTitle(title);

        if (gameByTitle.isEmpty()) {
            return String.format(GAME_TITLE_DOES_NOT_EXISTS, title);
        }

        final Game game = gameByTitle.get();

        final GameDetailedInfoDTO gameDetailedInfoDTO = mapper.map(game, GameDetailedInfoDTO.class);

        return gameDetailedInfoDTO.toString();
    }

    private static void updateFieldsValue(String[] gameData, Game game, Field[] declaredFields) {

        for (String data : Arrays.stream(gameData).skip(1).toArray(String[]::new)) {

            final String column = data.split("=")[0];
            final String value = data.split("=")[1];

            label:
            for (Field declaredField : declaredFields) {

                if (declaredField.getName().equals(column) && declaredField.getType().equals(String.class)) {

                    switch (column) {
                        case "title":
                            game.setTitle(value);
                            break label;
                        case "trailerId":
                            game.setTrailerId(value);
                            break label;
                        case "thumbnailUrl":
                            game.setThumbnailUrl(value);
                            break label;
                        case "description":
                            game.setDescription(value);
                            break label;
                    }                                                //maybe an extra condition
                } else if (declaredField.getName().equals(column) && column.equals("price")
                        && declaredField.getType().equals(BigDecimal.class)) {

                    game.setPrice(BigDecimal.valueOf(Double.parseDouble(value)));
                    break;
                } else if (declaredField.getName().equals(column) && column.equals("size")
                        && declaredField.getType().equals(Double.class)) {

                    game.setSize(Double.parseDouble(value));
                    break;
                } else if (declaredField.getName().equals(column) && column.equals("releaseDate")
                        && declaredField.getType().equals(LocalDate.class)) {

                    game.setReleaseDate(LocalDate.parse(value, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                    break;
                }
            }
        }
    }

    private void deleteDetachedEntries(Long id) {

        this.gameRepository.deleteGameInOrdersById(id);
        this.gameRepository.deleteGameInUsersById(id);
        this.gameRepository.deleteGameInCartsById(id);
    }

    private boolean isUserLoggedInAdministrator() {

        final User loggedInUser = this.userService.getLoggedInUser();

        if (loggedInUser == null) {
            return false;
        }

        return loggedInUser.getAdministrator();
    }
}
