package JavaOOPRetakeExam_18April2021.spaceStation.models.mission;

import JavaOOPRetakeExam_18April2021.spaceStation.models.astronauts.Astronaut;
import JavaOOPRetakeExam_18April2021.spaceStation.models.planets.Planet;

import java.util.Collection;

public interface Mission {
    void explore(Planet planet, Collection<Astronaut> astronauts);
}
