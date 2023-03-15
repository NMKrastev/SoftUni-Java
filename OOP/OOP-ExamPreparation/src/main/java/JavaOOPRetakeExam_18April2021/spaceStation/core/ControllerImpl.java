package JavaOOPRetakeExam_18April2021.spaceStation.core;

import JavaOOPRetakeExam_18April2021.spaceStation.common.ConstantMessages;
import JavaOOPRetakeExam_18April2021.spaceStation.common.ExceptionMessages;
import JavaOOPRetakeExam_18April2021.spaceStation.models.astronauts.Biologist;
import JavaOOPRetakeExam_18April2021.spaceStation.models.astronauts.Meteorologist;
import JavaOOPRetakeExam_18April2021.spaceStation.models.mission.MissionImpl;
import JavaOOPRetakeExam_18April2021.spaceStation.models.planets.PlanetImpl;
import JavaOOPRetakeExam_18April2021.spaceStation.repositories.AstronautRepository;
import JavaOOPRetakeExam_18April2021.spaceStation.repositories.PlanetRepository;
import JavaOOPRetakeExam_18April2021.spaceStation.models.astronauts.Astronaut;
import JavaOOPRetakeExam_18April2021.spaceStation.models.astronauts.Geodesist;
import JavaOOPRetakeExam_18April2021.spaceStation.models.mission.Mission;
import JavaOOPRetakeExam_18April2021.spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;
    private Mission mission;
    private int planetsExploredCount;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
        this.mission = new MissionImpl();
        this.planetsExploredCount = 0;
    }

    @Override
    public String addAstronaut(String type, String astronautName) {

        switch (type) {
            case "Biologist":
                this.astronautRepository.add(new Biologist(astronautName));
                break;
            case "Geodesist":
                this.astronautRepository.add(new Geodesist(astronautName));
                break;
            case "Meteorologist":
                this.astronautRepository.add(new Meteorologist(astronautName));
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }

        return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {

        this.planetRepository.add(new PlanetImpl(planetName, items));

        return String.format(ConstantMessages.PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {

        Astronaut astronaut = this.astronautRepository.findByName(astronautName);

        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }

        this.astronautRepository.remove(astronaut);

        return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {

        Planet planet = this.planetRepository.findByName(planetName);

        Collection<Astronaut> suitableAstronauts = this.astronautRepository.getModels()
                .stream()
                .filter(e -> e.getOxygen() > 60)
                .collect(Collectors.toList());

        if (suitableAstronauts.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        mission.explore(planet, suitableAstronauts);

        List<Astronaut> deadAstronauts = suitableAstronauts.stream()
                .filter(e -> !e.canBreath())
                .collect(Collectors.toList());

        this.planetsExploredCount++;

        return String.format(ConstantMessages.PLANET_EXPLORED, planetName, deadAstronauts.size());
    }

    @Override
    public String report() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format(ConstantMessages.REPORT_PLANET_EXPLORED, planetsExploredCount)).append(System.lineSeparator());
        sb.append(ConstantMessages.REPORT_ASTRONAUT_INFO).append(System.lineSeparator());
        this.astronautRepository.getModels()
                .forEach(e -> {
                    sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_NAME, e.getName())).append(System.lineSeparator());
                    sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN, e.getOxygen())).append(System.lineSeparator());
                    sb.append(String.format(e.getBag().getItems().isEmpty()
                            ? String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, "none")
                            : ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, e.getBag().getItems().stream().map(String::valueOf).collect(Collectors.joining(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER))));
                    sb.append(System.lineSeparator());
                });

        return sb.toString().trim();
    }
}
