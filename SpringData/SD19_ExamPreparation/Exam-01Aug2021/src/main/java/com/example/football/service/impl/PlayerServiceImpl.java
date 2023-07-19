package com.example.football.service.impl;

import com.example.football.models.dto.player.PlayerImportDTO;
import com.example.football.models.dto.player.PlayerImportWrapperDTO;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.PlayerRepository;
import com.example.football.repository.StatRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.PlayerService;
import com.example.football.util.FileUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static com.example.football.constant.Messages.*;
import static com.example.football.constant.Paths.PLAYERS_FILE_PATH;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final StringBuilder sb;
    private final ModelMapper mapper;
    private final FileUtil fileUtil;
    private final PlayerRepository playerRepository;
    private final TownRepository townRepository;
    private final TeamRepository teamRepository;
    private final StatRepository statRepository;

    public PlayerServiceImpl(ModelMapper mapper, FileUtil fileUtil, PlayerRepository playerRepository,
                             TownRepository townRepository, TeamRepository teamRepository, StatRepository statRepository) {
        this.mapper = mapper;
        this.fileUtil = fileUtil;
        this.playerRepository = playerRepository;
        this.townRepository = townRepository;
        this.teamRepository = teamRepository;
        this.statRepository = statRepository;
        this.sb = new StringBuilder();
    }


    @Override
    public boolean areImported() {
        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return this.fileUtil.readFile(PLAYERS_FILE_PATH);
    }

    @Override
    public String importPlayers() throws FileNotFoundException, JAXBException {

        final FileReader reader = new FileReader(PLAYERS_FILE_PATH.toFile());

        final JAXBContext context = JAXBContext.newInstance(PlayerImportWrapperDTO.class);

        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final PlayerImportWrapperDTO playersImportWrapperDTO = (PlayerImportWrapperDTO) unmarshaller.unmarshal(reader);

        final List<PlayerImportDTO> playersImportDTO = playersImportWrapperDTO.getPlayers();

        playersImportDTO
                .forEach(playerDTO -> {

                    final Town town = this.townRepository.findByName(playerDTO.getTown().getName());

                    final Team team = this.teamRepository.findByName(playerDTO.getTeam().getName());

                    final Stat stat = this.statRepository.getById(playerDTO.getStat().getId());

                    final Player player = this.mapper.map(playerDTO, Player.class);

                    player.setTown(town);
                    player.setTeam(team);
                    player.setStat(stat);

                    try {

                        this.playerRepository.saveAndFlush(player);

                        this.sb.append(String.format(SUCCESSFUL_PLAYER_IMPORT,
                                        player.getClass().getSimpleName(), player.getFullName(), player.getPosition()))
                                .append(System.lineSeparator());

                    } catch (Exception e) {

                        this.sb.append(String.format(INVALID_ENTITY, player.getClass().getSimpleName()))
                                .append(System.lineSeparator());
                    }
                });

        return this.sb.toString().trim();
    }

    @Override
    public String exportBestPlayers() {

        final List<Player> players = this.playerRepository.findAllPlayerForGivenPeriod();

        players
                .forEach(p -> this.sb.append(String.format(PRINT_FORMAT,
                                p.getFullName(), p.getPosition(), p.getTeam().getName(), p.getTeam().getStadiumName()))
                        .append(System.lineSeparator()));

        return this.sb.toString().trim();
    }
}
