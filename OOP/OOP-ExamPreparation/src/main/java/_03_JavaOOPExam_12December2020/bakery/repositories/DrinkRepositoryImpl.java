package JavaOOPExam_12December2020.bakery.repositories;

import JavaOOPExam_12December2020.bakery.entities.drinks.interfaces.Drink;
import JavaOOPExam_12December2020.bakery.repositories.interfaces.DrinkRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DrinkRepositoryImpl implements DrinkRepository<Drink> {

    private Collection<Drink> models;

    public DrinkRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public void add(Drink drink) {
        this.models.add(drink);
    }

    @Override
    public Collection<Drink> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
        return this.models.stream()
                .filter(drink -> drink.getName().equals(drinkName) && drink.getBrand().equals(drinkBrand))
                .findFirst()
                .orElse(null);
    }
}
