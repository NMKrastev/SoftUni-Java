package _07_JavaOOPExam_15August2021.restaurant.repositories;

import _07_JavaOOPExam_15August2021.restaurant.entities.drinks.interfaces.Beverages;
import _07_JavaOOPExam_15August2021.restaurant.repositories.interfaces.BeverageRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {

    private Collection<Beverages> beverages = new ArrayList<>();

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {

        return this.beverages
                .stream()
                .filter(e -> e.getName().equals(drinkName) && e.getBrand().equals(drinkBrand))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return Collections.unmodifiableCollection(this.beverages);
    }

    @Override
    public void add(Beverages beverage) {
        this.beverages.add(beverage);
    }
}
