package _14_JavaOOPRetakeExam_22August2022.goldDigger.models.operation;

import _14_JavaOOPRetakeExam_22August2022.goldDigger.models.discoverer.Discoverer;
import _14_JavaOOPRetakeExam_22August2022.goldDigger.models.spot.Spot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OperationImpl implements Operation {

    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {

        List<String> exhibits = new ArrayList<>(spot.getExhibits());

        for (Discoverer discoverer : discoverers) {
            while (discoverer.canDig() && !exhibits.isEmpty()) {
                discoverer.dig();
                String exhibit = exhibits.get(0);
                exhibits.remove(0);
                spot.getExhibits().remove(exhibit);
                discoverer.getMuseum().getExhibits().add(exhibit);
            }
        }
    }
}
