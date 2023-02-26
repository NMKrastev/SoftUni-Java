package A7_CollectionHierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable {

    @Override
    public int add(String item) {

        super.items.add(0, item);

        return 0;
    }

    @Override
    public String remove() {

        return super.items.remove(items.size() - 1);
    }
}
