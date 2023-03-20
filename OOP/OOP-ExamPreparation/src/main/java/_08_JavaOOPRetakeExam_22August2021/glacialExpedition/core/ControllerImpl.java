package _08_JavaOOPRetakeExam_22August2021.glacialExpedition.core;

import _08_JavaOOPRetakeExam_22August2021.glacialExpedition.models.explorers.AnimalExplorer;
import _08_JavaOOPRetakeExam_22August2021.glacialExpedition.models.explorers.Explorer;
import _08_JavaOOPRetakeExam_22August2021.glacialExpedition.models.explorers.GlacierExplorer;
import _08_JavaOOPRetakeExam_22August2021.glacialExpedition.models.explorers.NaturalExplorer;
import _08_JavaOOPRetakeExam_22August2021.glacialExpedition.models.mission.Mission;
import _08_JavaOOPRetakeExam_22August2021.glacialExpedition.models.states.State;
import _08_JavaOOPRetakeExam_22August2021.glacialExpedition.repositories.ExplorerRepository;
import _08_JavaOOPRetakeExam_22August2021.glacialExpedition.repositories.StateRepository;
import _08_JavaOOPRetakeExam_22August2021.glacialExpedition.models.mission.MissionImpl;
import _08_JavaOOPRetakeExam_22August2021.glacialExpedition.models.states.StateImpl;

import java.util.List;
import java.util.stream.Collectors;

import static _08_JavaOOPRetakeExam_22August2021.glacialExpedition.common.ConstantMessages.*;
import static _08_JavaOOPRetakeExam_22August2021.glacialExpedition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private ExplorerRepository explorerRepository;
    private StateRepository stateRepository;
    private int exploredStatesCount;

    public ControllerImpl() {
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
        this.exploredStatesCount = 0;
    }

    @Override
    public String addExplorer(String type, String explorerName) {

        Explorer explorer;

        switch (type) {
            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;
            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            default:
                throw new IllegalArgumentException(EXPLORER_INVALID_TYPE);
        }

        this.explorerRepository.add(explorer);

        return String.format(EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {

        State state = new StateImpl(stateName);

        state.getExhibits().addAll(List.of(exhibits));

        this.stateRepository.add(state);

        return String.format(STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {

        Explorer explorer = this.explorerRepository.byName(explorerName);

        if (explorer == null) {
            throw new IllegalArgumentException(String.format(EXPLORER_DOES_NOT_EXIST, explorerName));
        }

        this.explorerRepository.remove(explorer);

        return String.format(EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {

        List<Explorer> suitableExplorers = this.explorerRepository.getCollection()
                .stream()
                .filter(e -> e.getEnergy() > 50)
                .collect(Collectors.toList());

        int initialExplorersCount = suitableExplorers.size();

        if (suitableExplorers.isEmpty()) {
            throw new IllegalArgumentException(STATE_EXPLORERS_DOES_NOT_EXISTS);
        }

        State state = this.stateRepository.byName(stateName);

        Mission mission = new MissionImpl();
        mission.explore(state, suitableExplorers);

        int leftExplorersCount = suitableExplorers
                .stream()
                .filter(e -> e.getEnergy() > 0)
                .collect(Collectors.toList())
                .size();

        this.exploredStatesCount++;

        return String.format(STATE_EXPLORER, state.getName(), initialExplorersCount - leftExplorersCount);
    }

    @Override
    public String finalResult() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format(FINAL_STATE_EXPLORED, this.exploredStatesCount)).append(System.lineSeparator());
        sb.append(FINAL_EXPLORER_INFO).append(System.lineSeparator());

        for (Explorer explorer : this.explorerRepository.getCollection()) {
            sb.append(String.format(FINAL_EXPLORER_NAME, explorer.getName())).append(System.lineSeparator());
            sb.append(String.format(FINAL_EXPLORER_ENERGY, explorer.getEnergy())).append(System.lineSeparator());
            sb.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS,
                    String.format(explorer.getSuitcase().getExhibits().isEmpty()
                            ? "None"
                            : explorer.getSuitcase().getExhibits()
                            .stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER)))))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
