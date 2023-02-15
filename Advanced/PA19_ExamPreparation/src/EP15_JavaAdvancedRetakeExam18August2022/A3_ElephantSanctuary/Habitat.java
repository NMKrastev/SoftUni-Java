package EP15_JavaAdvancedRetakeExam18August2022.A3_ElephantSanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Habitat {

    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant) {
        if (data.size() < capacity) {
            data.add(elephant);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(e -> e.getName().equals(name));
    }

    public Elephant getOldestElephant() {
        return data.stream()
                .max(Comparator.comparing(Elephant::getAge))
                .orElse(null);
    }

    public Elephant getElephant(String retiredFrom) {
        return data.stream()
                .filter(e -> e.getRetiredFrom().equals(retiredFrom))
                .findFirst()
                .orElse(null);
    }

    public int getAllElephants() {
        return data.size();
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Saved elephants in the park:").append(System.lineSeparator());
        data.forEach(e -> sb.append(String.format("%s came from: %s", e.getName(), e.getRetiredFrom())).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
