package _03_JavaOOPExam_12December2020.bakery.repositories;

import _03_JavaOOPExam_12December2020.bakery.entities.bakedFoods.interfaces.BakedFood;
import _03_JavaOOPExam_12December2020.bakery.repositories.interfaces.FoodRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class FoodRepositoryImpl implements FoodRepository<BakedFood> {

    private Collection<BakedFood> models;

    public FoodRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public void add(BakedFood bakedFood) {
        this.models.add(bakedFood);
    }

    @Override
    public Collection<BakedFood> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public BakedFood getByName(String name) {
        return this.models.stream()
                .filter(bakedFood -> bakedFood.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
