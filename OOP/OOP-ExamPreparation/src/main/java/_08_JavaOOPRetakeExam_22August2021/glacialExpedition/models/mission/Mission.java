package _08_JavaOOPRetakeExam_22August2021.glacialExpedition.models.mission;

import _08_JavaOOPRetakeExam_22August2021.glacialExpedition.models.explorers.Explorer;
import _08_JavaOOPRetakeExam_22August2021.glacialExpedition.models.states.State;


import java.util.Collection;

public interface Mission {
    void explore(State state, Collection<Explorer> explorers);
}
