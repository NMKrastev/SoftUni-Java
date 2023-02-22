package A3_RandomArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {

    List<T> list;

    public RandomArrayList () {
        this.list = new ArrayList<>();
    }
    public Object getRandomElement() {
        Random random = new Random();

        return list.get(random.nextInt(list.size()));
    }

    public boolean add(T element) {
        return list.add(element);
    }
}
