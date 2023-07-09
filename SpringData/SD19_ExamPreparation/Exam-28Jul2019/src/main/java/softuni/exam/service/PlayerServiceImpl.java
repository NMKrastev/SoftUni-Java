package softuni.exam.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.player.PlayerImportDTO;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Player;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.PictureRepository;
import softuni.exam.repository.PlayerRepository;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.FileUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import static softuni.exam.constant.FilePath.PLAYERS_FILE_PATH;
import static softuni.exam.constant.Message.*;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final StringBuilder sb = new StringBuilder();
    private final ModelMapper mapper;
    private final Gson gson;
    private final FileUtil fileUtil;
    private final PlayerRepository playerRepository;
    private final PictureRepository pictureRepository;
    private final TeamRepository teamRepository;

    public PlayerServiceImpl(ModelMapper mapper, Gson gson, FileUtil fileUtil,
                             PlayerRepository playerRepository, PictureRepository pictureRepository, TeamRepository teamRepository) {
        this.mapper = mapper;
        this.gson = gson;
        this.fileUtil = fileUtil;
        this.playerRepository = playerRepository;
        this.pictureRepository = pictureRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public String importPlayers() throws FileNotFoundException {

        final Type type = new TypeToken<List<PlayerImportDTO>>(){}.getType();

        final JsonReader reader = new JsonReader(new FileReader(PLAYERS_FILE_PATH));

        final List<PlayerImportDTO> playersImportDTO = this.gson.fromJson(reader, type);

        for (PlayerImportDTO playerDTO : playersImportDTO) {

            final Player player = this.mapper.map(playerDTO, Player.class);

            final Picture pictureByUrl = this.pictureRepository.findByUrl(playerDTO.getPicture().getUrl());

            final Team teamByName = this.teamRepository.findByName(player.getTeam().getName());

            player.setPicture(pictureByUrl);
            player.setTeam(teamByName);

            try {

                this.playerRepository.saveAndFlush(player);

                this.sb.append(String.format(SUCCESSFULLY_ADDED_PLAYER, player.getFirstName(), player.getLastname()))
                        .append(System.lineSeparator());

            } catch (Exception e) {
                System.out.println(e.getMessage());
                this.sb.append(INVALID_PLAYER).append(System.lineSeparator());
            }
        }

        return this.sb.toString().trim();
    }

    @Override
    public boolean areImported() {

        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersJsonFile() throws IOException {

        return this.fileUtil.readFile(PLAYERS_FILE_PATH);
    }

    @Override
    public String exportPlayersWhereSalaryBiggerThan() {

        final List<Player> players = this.playerRepository.findAllBySalaryGreaterThanOrderBySalaryDesc(SALARY);

        for (Player player : players) {

            this.sb.append(String.format(PLAYER_INFO_FORMAT, player.getFullName(),
                    player.getNumber(), player.getSalary(), player.getTeam().getName()))
                    .append(System.lineSeparator());
        }

        return this.sb.toString().trim();
    }

    @Override
    public String exportPlayersInATeam() {

        final List<Player> players = this.playerRepository.findAllByTeamNameOrderById(TEAM_NAME);

        this.sb.append(String.format(TEAM_NAME_FORMAT, TEAM_NAME))
                .append(System.lineSeparator());

        for (Player player : players) {
            this.sb.append(String.format(PLAYER_FROM_TEAM_FORMAT, player.getFirstName(), player.getLastname(),
                    player.getPosition(), player.getNumber()))
                    .append(System.lineSeparator());
        }

        return this.sb.toString().trim();
    }
}
