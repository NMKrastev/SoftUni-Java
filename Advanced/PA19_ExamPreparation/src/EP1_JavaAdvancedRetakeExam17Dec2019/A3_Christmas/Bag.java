package EP1_JavaAdvancedRetakeExam17Dec2019.A3_Christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bag {

    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Present present) {
        if (data.size() < capacity) {
            data.add(present);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(e -> e.getName().equals(name));
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public Present heaviestPresent() {
        return data.stream().max(Comparator.comparing(Present::getWeight)).orElse(null);
    }

    public Present getPresent(String name) {
        for (Present present : data) {
            if (present.getName().equals(name)) {
                return present;
            }
        }
        return null;
    }

    public int count() {
        return data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s bag contains:", getColor())).append(System.lineSeparator());
        data.forEach(e -> sb.append(e).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
