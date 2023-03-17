package _07_JavaOOPExam_15August2021.restaurant.repositories;

import _07_JavaOOPExam_15August2021.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import _07_JavaOOPExam_15August2021.restaurant.repositories.interfaces.HealthFoodRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class HealthFoodRepositoryImpl implements HealthFoodRepository<HealthyFood> {

    private Collection<HealthyFood> foods = new ArrayList<>();

    @Override
    public HealthyFood foodByName(String name) {

        return this.foods
                .stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return Collections.unmodifiableCollection(this.foods);
    }

    @Override
    public void add(HealthyFood food) {
        this.foods.add(food);
    }
}
