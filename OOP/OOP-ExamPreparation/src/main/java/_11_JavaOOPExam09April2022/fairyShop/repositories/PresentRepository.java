package _11_JavaOOPExam09April2022.fairyShop.repositories;

import _11_JavaOOPExam09April2022.fairyShop.models.Present;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PresentRepository implements Repository<Present> {

    private Collection<Present> presents;

    public PresentRepository() {
        this.presents = new ArrayList<>();
    }

    @Override
    public Collection<Present> getModels() {
        return Collections.unmodifiableCollection(this.presents);
    }

    @Override
    public void add(Present present) {
        this.presents.add(present);
    }

    @Override
    public boolean remove(Present present) {
        return this.presents.remove(present);
    }

    @Override
    public Present findByName(String name) {

        return this.presents
                .stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
