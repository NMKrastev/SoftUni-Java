package _14_JavaOOPRetakeExam_22August2022.goldDigger.models.operation;

import _14_JavaOOPRetakeExam_22August2022.goldDigger.models.discoverer.Discoverer;
import _14_JavaOOPRetakeExam_22August2022.goldDigger.models.spot.Spot;

import java.util.Collection;

public interface Operation {
    void startOperation(Spot spot, Collection<Discoverer> discoverers);

}
