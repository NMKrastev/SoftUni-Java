package JavaOOPRetakeExam_18April2021.spaceStation.models.planets;

import java.util.*;

import static JavaOOPRetakeExam_18April2021.spaceStation.common.ExceptionMessages.PLANET_NAME_NULL_OR_EMPTY;

public class PlanetImpl implements Planet {

    private String name;
    private Collection<String> items;

    public PlanetImpl(String name, String... items) {
        this.setName(name);
        this.setItems(items);
    }

    private void setItems(String[] items) {
        this.items = new ArrayList<>();
        this.items.addAll(Arrays.asList(items));
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(PLANET_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getItems() {
        return this.items;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
