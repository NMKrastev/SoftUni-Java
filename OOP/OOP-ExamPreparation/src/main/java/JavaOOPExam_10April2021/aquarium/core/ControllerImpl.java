package JavaOOPExam_10April2021.aquarium.core;

import JavaOOPExam_10April2021.aquarium.common.ConstantMessages;
import JavaOOPExam_10April2021.aquarium.common.ExceptionMessages;
import JavaOOPExam_10April2021.aquarium.entities.aquariums.Aquarium;
import JavaOOPExam_10April2021.aquarium.entities.decorations.Decoration;
import JavaOOPExam_10April2021.aquarium.entities.decorations.Ornament;
import JavaOOPExam_10April2021.aquarium.entities.decorations.Plant;
import JavaOOPExam_10April2021.aquarium.entities.fish.Fish;
import JavaOOPExam_10April2021.aquarium.entities.fish.FreshwaterFish;
import JavaOOPExam_10April2021.aquarium.entities.fish.SaltwaterFish;
import JavaOOPExam_10April2021.aquarium.entities.aquariums.FreshwaterAquarium;
import JavaOOPExam_10April2021.aquarium.entities.aquariums.SaltwaterAquarium;
import JavaOOPExam_10April2021.aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private DecorationRepository decorationRepository;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorationRepository = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {

        switch (aquariumType) {
            case "FreshwaterAquarium":
                this.aquariums.add(new FreshwaterAquarium(aquariumName));
                break;
            case "SaltwaterAquarium":
                this.aquariums.add(new SaltwaterAquarium(aquariumName));
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_AQUARIUM_TYPE);
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {

        switch (type) {
            case "Ornament":
                this.decorationRepository.add(new Ornament());
                break;
            case "Plant":
                this.decorationRepository.add(new Plant());
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_DECORATION_TYPE);
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {

        Decoration decoration = this.decorationRepository.findByType(decorationType);

        if (decoration == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_DECORATION_FOUND, decorationType));
        }

        this.aquariums
                .stream()
                .filter(e -> e.getName().equals(aquariumName))
                .findFirst()
                .get()
                .addDecoration(decoration);

        this.decorationRepository.remove(decoration);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {

        if (!fishType.equals("FreshwaterFish") && !fishType.equals("SaltwaterFish")) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_FISH_TYPE);
        }

        Aquarium aquarium = this.aquariums.stream()
                .filter(e -> e.getName().equals(aquariumName))
                .findFirst()
                .get();

        switch (fishType) {
            case "FreshwaterFish":
                if (!aquarium.getClass().getSimpleName().contains("Freshwater")) {
                    return String.format(ConstantMessages.WATER_NOT_SUITABLE);
                }
                aquarium.addFish(new FreshwaterFish(fishName, fishSpecies, price));
                break;
            case "SaltwaterFish":
                if (!aquarium.getClass().getSimpleName().contains("Saltwater")) {
                    return String.format(ConstantMessages.WATER_NOT_SUITABLE);
                }
                aquarium.addFish(new SaltwaterFish(fishName, fishSpecies, price));
                break;
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {

        Aquarium aquarium = this.aquariums
                .stream()
                .filter(e -> e.getName().equals(aquariumName))
                .findFirst()
                .get();

        aquarium.feed();

        int fedFish = aquarium.getFish().size();

        return String.format(ConstantMessages.FISH_FED, fedFish);
    }

    @Override
    public String calculateValue(String aquariumName) {

        double fishValue = this.aquariums
                .stream()
                .filter(e -> e.getName().equals(aquariumName))
                .findFirst()
                .get()
                .getFish()
                .stream()
                .mapToDouble(Fish::getPrice)
                .sum();

        double decorationsValue = this.aquariums
                .stream()
                .filter(e -> e.getName().equals(aquariumName))
                .findFirst()
                .get()
                .getDecorations()
                .stream()
                .mapToDouble(Decoration::getPrice)
                .sum();

        double totalValue = fishValue + decorationsValue;

        return String.format(ConstantMessages.VALUE_AQUARIUM, aquariumName, totalValue);
    }

    @Override
    public String report() {

        StringBuilder sb = new StringBuilder();
        aquariums.forEach(e -> sb.append(e.getInfo()).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
