package A7_CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable <T>> {
    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        list.add(element);
    }

    public T remove(int index) {
        return list.remove(index);
    }

    public boolean contains(T element) {
        return list.contains(element);
    }

    public void swapPlace(int indexOne, int indexTwo) {
        Collections.swap(list, indexOne, indexTwo);
    }

    public int countGreaterThan(T element) {
        return (int) list.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax() {
        return list.stream().max(Comparable::compareTo).get();
    }

    public T getMin() {
        return list.stream().min(Comparable::compareTo).get();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        list.forEach(e -> output.append(e.toString()).append(System.lineSeparator()));
        return output.toString().trim();
    }
}
