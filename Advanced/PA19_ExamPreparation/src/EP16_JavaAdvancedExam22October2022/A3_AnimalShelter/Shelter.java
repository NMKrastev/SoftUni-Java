package EP16_JavaAdvancedExam22October2022.A3_AnimalShelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {

    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (data.size() < capacity) {
            data.add(animal);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(e -> e.getName().equals(name));
    }

    public Animal getAnimal(String name, String caretaker) {
        return data.stream()
                .filter(e -> e.getName().equals(name) && e.getCaretaker().equals(caretaker))
                .findFirst()
                .orElse(null);
    }

    public Animal getOldestAnimal() {
        return data.stream()
                .max(Comparator.comparing(Animal::getAge))
                .orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The shelter has the following animals:").append(System.lineSeparator());
        data.forEach(e -> sb.append(String.format("%s %s", e.getName(), e.getCaretaker())).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
