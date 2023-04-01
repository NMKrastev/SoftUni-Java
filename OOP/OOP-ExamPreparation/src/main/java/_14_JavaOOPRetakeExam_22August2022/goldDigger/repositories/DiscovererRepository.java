package _14_JavaOOPRetakeExam_22August2022.goldDigger.repositories;

import _14_JavaOOPRetakeExam_22August2022.goldDigger.models.discoverer.Discoverer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DiscovererRepository implements Repository<Discoverer> {

    private Collection<Discoverer> discoverers;

    public DiscovererRepository() {
        this.discoverers = new ArrayList<>();
    }

    @Override
    public void add(Discoverer discoverer) {
        this.discoverers.add(discoverer);
    }

    @Override
    public boolean remove(Discoverer discoverer) {
        return this.discoverers.remove(discoverer);
    }

    @Override
    public Discoverer byName(String name) {
        return this.discoverers
                .stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Discoverer> getCollection() {
        return Collections.unmodifiableCollection(this.discoverers);
    }
}
