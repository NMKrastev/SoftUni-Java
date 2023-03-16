package _06_JavaOOPRetakeExam_18April2021.spaceStation.models.mission;

import _06_JavaOOPRetakeExam_18April2021.spaceStation.models.astronauts.Astronaut;
import _06_JavaOOPRetakeExam_18April2021.spaceStation.models.bags.Bag;
import _06_JavaOOPRetakeExam_18April2021.spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.stream.Collectors;

public class MissionImpl implements Mission {

    public MissionImpl() {
    }

    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        for (Astronaut astronaut : astronauts) {
            Bag bag = astronaut.getBag();
            while (astronaut.canBreath() && !planet.getItems().isEmpty()) {
                String item = planet.getItems().stream().collect(Collectors.toList()).get(0);
                astronaut.breath();
                bag.getItems().add(item);
                planet.getItems().remove(item);
            }
        }
    }
}
