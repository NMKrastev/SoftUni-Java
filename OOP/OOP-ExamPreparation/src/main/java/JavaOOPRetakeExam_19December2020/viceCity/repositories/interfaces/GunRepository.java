package JavaOOPRetakeExam_19December2020.viceCity.repositories.interfaces;

import JavaOOPRetakeExam_19December2020.viceCity.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GunRepository implements Repository<Gun> {

    private Collection<Gun> models;

    public GunRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Gun model) {

        Gun gun = models.stream()
                .filter(e -> e.equals(model))
                .findFirst()
                .orElse(null);

        if (gun == null) {
            models.add(model);
        }
    }

    @Override
    public boolean remove(Gun model) {
        return models.removeIf(e -> e.equals(model));
    }

    @Override
    public Gun find(String name) {
        return models
                .stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
