package JavaOOPRetakeExam_18April2021.spaceStation.models.mission;

import JavaOOPRetakeExam_18April2021.spaceStation.repositories.AstronautRepository;
import JavaOOPRetakeExam_18April2021.spaceStation.models.astronauts.Astronaut;
import JavaOOPRetakeExam_18April2021.spaceStation.models.bags.Bag;
import JavaOOPRetakeExam_18April2021.spaceStation.models.planets.Planet;
import JavaOOPRetakeExam_18April2021.spaceStation.repositories.PlanetRepository;

import java.util.Collection;
import java.util.stream.Collectors;

public class MissionImpl implements Mission {

    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;

    public MissionImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
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
