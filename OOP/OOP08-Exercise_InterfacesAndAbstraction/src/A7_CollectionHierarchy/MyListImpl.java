package A7_CollectionHierarchy;

public class MyListImpl extends Collection implements MyList {


    @Override
    public int add(String item) {
        super.items.add(0, item);
        return 0;
    }

    @Override
    public String remove() {
        return super.items.remove(0);
    }

    @Override
    public int getUsed() {
        return super.items.size();
    }
}
