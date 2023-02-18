package A3_SoftUniKindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarten {

    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        if (registry.size() < capacity) {
            registry.add(child);
            return true;
        }
        return false;
    }

    public boolean removeChild(String firstName) {
        return registry.removeIf(e -> e.getFirstName().equals(firstName));
    }

    public int getChildrenCount() {
        return registry.size();
    }

    public Child getChild(String firstName) {
        return registry.stream()
                .filter(e -> e.getFirstName().equals(firstName))
                .findFirst()
                .orElse(null);
    }

    public String registryReport() {
        List<Child> sorted = registry.stream()
                .sorted(Comparator.comparing(Child::getAge)
                        .thenComparing(Child::getFirstName)
                        .thenComparing(Child::getLastName))
                .collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Registered children in %s:", name)).append(System.lineSeparator());
        sorted.forEach(child -> sb.append("--").append(System.lineSeparator()).append(child).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
