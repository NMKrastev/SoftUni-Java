package EP13_JavaAdvancedRetakeExam13April2022.A3_EasterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Basket {

    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (data.size() < capacity) {
            data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        return data.removeIf(e -> e.getColor().equals(color));
    }

    public Egg getStrongestEgg() {
        return data.stream()
                .max(Comparator.comparing(Egg::getStrength))
                .orElse(null);
    }

    public Egg getEgg(String color) {
        return data.stream()
                .filter(e -> e.getColor().equals(color))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String report() {
        return String.format("%s basket contains:\n%s", material, data.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
