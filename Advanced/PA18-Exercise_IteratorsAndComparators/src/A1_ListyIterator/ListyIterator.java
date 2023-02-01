package A1_ListyIterator;

import java.util.List;

public class ListyIterator {

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
}
