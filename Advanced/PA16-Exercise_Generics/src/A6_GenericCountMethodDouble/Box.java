package A6_GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {

    private List<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public void add(T input) {
        list.add(input);
    }

    public int countOfGreaterItems(T element) {
        return (int) list.stream()
                .filter(e -> e.compareTo(element) > 0)
                .count();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        list.forEach(e -> output.append(String.format("%s: %s", e.getClass().getName(), e))
                .append(System.lineSeparator()));

        return output.toString();
    }
}
