package _14_JavaOOPRetakeExam_22August2022.goldDigger.core;

import _14_JavaOOPRetakeExam_22August2022.goldDigger.models.operation.Operation;
import _14_JavaOOPRetakeExam_22August2022.goldDigger.models.discoverer.Anthropologist;
import _14_JavaOOPRetakeExam_22August2022.goldDigger.models.discoverer.Archaeologist;
import _14_JavaOOPRetakeExam_22August2022.goldDigger.models.discoverer.Discoverer;
import _14_JavaOOPRetakeExam_22August2022.goldDigger.models.discoverer.Geologist;
import _14_JavaOOPRetakeExam_22August2022.goldDigger.models.operation.OperationImpl;
import _14_JavaOOPRetakeExam_22August2022.goldDigger.models.spot.Spot;
import _14_JavaOOPRetakeExam_22August2022.goldDigger.models.spot.SpotImpl;
import _14_JavaOOPRetakeExam_22August2022.goldDigger.repositories.DiscovererRepository;
import _14_JavaOOPRetakeExam_22August2022.goldDigger.repositories.SpotRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static _14_JavaOOPRetakeExam_22August2022.goldDigger.common.ConstantMessages.*;
import static _14_JavaOOPRetakeExam_22August2022.goldDigger.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private DiscovererRepository discovererRepository;
    private SpotRepository spotRepository;
    private Operation operation;
    private int totalInspectedSpots;

    public ControllerImpl() {
        this.discovererRepository = new DiscovererRepository();
        this.spotRepository = new SpotRepository();
        this.operation = new OperationImpl();
        this.totalInspectedSpots = 0;
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {

        switch (kind) {
            case "Anthropologist":
                this.discovererRepository.add(new Anthropologist(discovererName));
                break;
            case "Archaeologist":
                this.discovererRepository.add(new Archaeologist(discovererName));
                break;
            case "Geologist":
                this.discovererRepository.add(new Geologist(discovererName));
                break;
            default:
                throw new IllegalArgumentException(DISCOVERER_INVALID_KIND);
        }

        return String.format(DISCOVERER_ADDED, kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {

        Spot spot = new SpotImpl(spotName);

        Arrays.stream(exhibits).forEach(spot.getExhibits()::add);

        this.spotRepository.add(spot);

        return String.format(SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {

        Discoverer discoverer = this.discovererRepository.byName(discovererName);

        if (discoverer == null) {
            throw new IllegalArgumentException(String.format(DISCOVERER_DOES_NOT_EXIST, discovererName));
        }

        this.discovererRepository.remove(discoverer);

        return String.format(DISCOVERER_EXCLUDE, discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {

        List<Discoverer> suitableDiscoverers = this.discovererRepository.getCollection()
                .stream()
                .filter(e -> e.getEnergy() > 45)
                .collect(Collectors.toList());

        if (suitableDiscoverers.isEmpty()) {
            throw new IllegalArgumentException(SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }

        Spot spot = this.spotRepository.byName(spotName);

        int initialDiscoverers = suitableDiscoverers.size();

        operation.startOperation(spot, suitableDiscoverers);

        int excludedDiscoverers = suitableDiscoverers
                .stream()
                .filter(e -> e.getEnergy() == 0)
                .collect(Collectors.toList())
                .size();

        this.totalInspectedSpots++;

        return String.format(INSPECT_SPOT, spotName, excludedDiscoverers);
    }

    @Override
    public String getStatistics() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format(FINAL_SPOT_INSPECT, this.totalInspectedSpots)).append(System.lineSeparator());
        sb.append(FINAL_DISCOVERER_INFO).append(System.lineSeparator());
        for (Discoverer discoverer : this.discovererRepository.getCollection()) {
            sb.append(String.format(FINAL_DISCOVERER_NAME, discoverer.getName())).append(System.lineSeparator());
            sb.append(String.format(FINAL_DISCOVERER_ENERGY, discoverer.getEnergy())).append(System.lineSeparator());
            sb.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS,
                            String.format(discoverer.getMuseum().getExhibits().isEmpty()
                                    ? "None"
                                    : discoverer.getMuseum().getExhibits()
                                    .stream()
                                    .map(String::valueOf)
                                    .collect(Collectors.joining(FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER)))))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
