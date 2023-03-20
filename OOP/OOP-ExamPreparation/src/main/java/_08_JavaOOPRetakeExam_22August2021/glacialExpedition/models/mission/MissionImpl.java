package _08_JavaOOPRetakeExam_22August2021.glacialExpedition.models.mission;

import _08_JavaOOPRetakeExam_22August2021.glacialExpedition.models.explorers.Explorer;
import _08_JavaOOPRetakeExam_22August2021.glacialExpedition.models.states.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission {

    public MissionImpl() {
    }

    @Override
    public void explore(State state, Collection<Explorer> explorers) {

        List<String> stateExhibits = new ArrayList<>(state.getExhibits());

        for (Explorer explorer : explorers) {

            while (explorer.canSearch() && !stateExhibits.isEmpty()) {

                explorer.getSuitcase().getExhibits().add(stateExhibits.get(0));

                state.getExhibits().remove(stateExhibits.get(0));

                stateExhibits.remove(0);

                explorer.search();
            }
        }
    }
}
