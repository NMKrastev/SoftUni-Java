package EP4_JavaAdvancedRetakeExam19August2020.A3_VetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {

    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(e -> e.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        return data.stream()
                .filter(e -> e.getName().equals(name) && e.getOwner().equals(owner))
                .findFirst()
                .orElse(null);
    }

    public Pet getOldestPet() {
        return data.stream()
                .max(Comparator.comparing(Pet::getAge))
                .orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:").append(System.lineSeparator());
        for (Pet pet : data) {
            sb.append(pet.getName()).append(" ").append(pet.getOwner()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
