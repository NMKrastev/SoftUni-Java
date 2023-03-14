package JavaOOPExam_10April2021.aquarium.entities.aquariums;

import JavaOOPExam_10April2021.aquarium.common.ConstantMessages;
import JavaOOPExam_10April2021.aquarium.common.ExceptionMessages;
import JavaOOPExam_10April2021.aquarium.entities.decorations.Decoration;
import JavaOOPExam_10April2021.aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public abstract class BaseAquarium implements Aquarium {

    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    protected BaseAquarium(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int calculateComfort() {
        return this.decorations
                .stream()
                .mapToInt(Decoration::getComfort)
                .sum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
        if (fish.getSize() >= this.capacity) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY);
        }
        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        this.fish.forEach(Fish::eat);
    }

    @Override
    public String getInfo() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s):", this.name, getClass().getSimpleName()));
        sb.append(System.lineSeparator());
        sb.append(String.format(fish.isEmpty() ? "Fish: none" : "Fish: %s", this.fish.stream().map(Fish::getName).collect(Collectors.joining(" "))));
        sb.append(System.lineSeparator());
        sb.append(String.format("Decorations: %d", this.decorations.size()));
        sb.append(System.lineSeparator());
        sb.append(String.format("Comfort: %d", calculateComfort()));

        return sb.toString().trim();
    }

    @Override
    public Collection<Fish> getFish() {
        return Collections.unmodifiableCollection(this.fish);
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return Collections.unmodifiableCollection(this.decorations);
    }
}
