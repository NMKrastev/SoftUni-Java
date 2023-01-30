package A4_GenericSwapMethodInteger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T> {

    private List<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public void add(T input) {
        list.add(input);
    }

    public void swapPlace(int indexOne, int indexTwo) {
        /*T one = list.get(indexOne);
        T two = list.get(indexTwo);
        list.set(indexOne, (T) two);
        list.set(indexTwo, (T) one);*/
        Collections.swap(list, indexOne, indexTwo);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        list.forEach(e -> output.append(String.format("%s: %s", e.getClass().getName(), e))
                .append(System.lineSeparator()));
        return output.toString();
    }
}
