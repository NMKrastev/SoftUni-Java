package A3_RandomArrayList;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArrayList<T> extends ArrayList<T> {

    public Object getRandomElement() {
        return get(ThreadLocalRandom.current().nextInt(0, size()));
    }
}
