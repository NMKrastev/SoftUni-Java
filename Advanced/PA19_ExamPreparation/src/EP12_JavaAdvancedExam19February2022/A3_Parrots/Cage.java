package EP12_JavaAdvancedExam19February2022.A3_Parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {

    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (data.size() < capacity) {
            data.add(parrot);
        }
    }

    public boolean remove(String parrotName) {
        return data.removeIf(e -> e.getName().equals(parrotName));
    }

    public Parrot sellParrot(String name) {
        Parrot parrotForSell = data.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
        if (parrotForSell != null) {
            parrotForSell.setAvailable(false);
        }
        return parrotForSell;
    }

    public List<Parrot> sellParrotBySpecies(String specie) {
        List<Parrot> soldSpecies = data.stream()
                .filter(e -> e.getSpecies().equals(specie))
                .collect(Collectors.toList());
        soldSpecies.forEach(e -> e.setAvailable(false));
        return soldSpecies;
    }

    public int count() {
        return data.size();
    }

    public String report() {
        return String.format("Parrots available at %s:\n%s", name, data.stream()
                .filter(Parrot::isAvailable)
                .map(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator()))).trim();
    }
}
