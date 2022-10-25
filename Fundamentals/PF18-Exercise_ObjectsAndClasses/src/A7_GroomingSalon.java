//package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class A7_GroomingSalon {

    private List<A7_Pet> data = new ArrayList<>();
    private int capacity;

    public A7_GroomingSalon(int capacity) {
        this.capacity = capacity;
    }

    public void add(A7_Pet pet) {

        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().equals(name)) {
                data.remove(i);
                return true;
            }
        }
        return false;
    }

    public int getCount() {

        return data.size();
    }

    public A7_Pet getPet(String name, String owner) {

        for (int i = 0; i < data.size(); i++) {
            if (name.equals(data.get(i).getName()) && owner.equals(data.get(i).getOwner())) {
                return data.get(i);
            }
        }
        return null;
    }

    public String getStatistics() {

        StringBuilder sb = new StringBuilder("The grooming salon has the following clients:"  + System.lineSeparator());

        for (A7_Pet pet : data) {
            sb.append(pet.getName().toString());
            sb.append(" ");
            sb.append(pet.getOwner().toString());
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }
}
