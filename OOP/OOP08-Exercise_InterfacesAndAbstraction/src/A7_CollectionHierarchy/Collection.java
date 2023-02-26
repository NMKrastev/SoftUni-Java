package A7_CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {

    private int maxSize;
    protected List<String> items;

    public Collection() {
        maxSize = 100;
        this.items = new ArrayList<>();
    }
}
