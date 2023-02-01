package A2_Collection;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String>{

    private List<String> data;
    private int index = 0;

    public ListyIterator(String... element) {
        this.data = List.of(element);
        this.index = 0;
    }

    public boolean move() {
        if (hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return index < data.size() - 1;
    }

    public void print() {
        if (data.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        } else {
            System.out.println(data.get(index));
        }
    }

    public void printAll() {
        System.out.println(String.join(" ", data));
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int internalIndex;
            @Override
            public boolean hasNext() {
                return internalIndex < data.size() - 1;
            }

            @Override
            public String next() {
                String element = data.get(internalIndex);
                internalIndex++;
                return element;
            }
        };
    }
}
