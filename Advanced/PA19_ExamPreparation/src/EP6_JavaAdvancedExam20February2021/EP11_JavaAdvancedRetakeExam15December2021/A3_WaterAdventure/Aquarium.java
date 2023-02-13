package EP6_JavaAdvancedExam20February2021.EP11_JavaAdvancedRetakeExam15December2021.A3_WaterAdventure;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Aquarium {

    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public void add(Fish fish) {
        if (fishInPool.isEmpty()) {
            fishInPool.add(fish);
        } else {
            for (Fish current : fishInPool) {
                if (!current.getName().equals(fish.getName()) && fishInPool.size() < capacity) {
                    fishInPool.add(fish);
                    break;
                }
            }
        }
    }

    public boolean remove(String name) {
        return fishInPool.removeIf(e -> e.getName().equals(name));
    }

    public Fish findFish(String name) {
        return fishInPool.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public String report() {
        return String.format("Aquarium: %s ^ Size: %d\n%s", name, size, fishInPool.stream().map(String::valueOf).collect(Collectors.joining(System.lineSeparator()))).trim();
    }
}
