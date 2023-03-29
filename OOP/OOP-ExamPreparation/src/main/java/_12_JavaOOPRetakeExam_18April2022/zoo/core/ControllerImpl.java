package _12_JavaOOPRetakeExam_18April2022.zoo.core;

import _12_JavaOOPRetakeExam_18April2022.zoo.entities.animals.Animal;
import _12_JavaOOPRetakeExam_18April2022.zoo.entities.animals.TerrestrialAnimal;
import _12_JavaOOPRetakeExam_18April2022.zoo.entities.areas.Area;
import _12_JavaOOPRetakeExam_18April2022.zoo.entities.foods.Food;
import _12_JavaOOPRetakeExam_18April2022.zoo.entities.animals.AquaticAnimal;
import _12_JavaOOPRetakeExam_18April2022.zoo.entities.areas.LandArea;
import _12_JavaOOPRetakeExam_18April2022.zoo.entities.areas.WaterArea;
import _12_JavaOOPRetakeExam_18April2022.zoo.entities.foods.Meat;
import _12_JavaOOPRetakeExam_18April2022.zoo.entities.foods.Vegetable;
import _12_JavaOOPRetakeExam_18April2022.zoo.repositories.FoodRepository;
import _12_JavaOOPRetakeExam_18April2022.zoo.repositories.FoodRepositoryImpl;

import java.util.Collections;
import java.util.HashMap;

import static _12_JavaOOPRetakeExam_18April2022.zoo.common.ConstantMessages.*;
import static _12_JavaOOPRetakeExam_18April2022.zoo.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private FoodRepository foodRepository;
    private HashMap<String, Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new HashMap<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {

        switch (areaType) {
            case "WaterArea":
                this.areas.put(areaName, new WaterArea(areaName));
                break;
            case "LandArea":
                this.areas.put(areaName, new LandArea(areaName));
                break;
            default:
                throw new NullPointerException(INVALID_AREA_TYPE);
        }

        return String.format(SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {

        switch (foodType) {
            case "Vegetable":
                this.foodRepository.add(new Vegetable());
                break;
            case "Meat":
                this.foodRepository.add(new Meat());
                break;
            default:
                throw new IllegalArgumentException(INVALID_FOOD_TYPE);
        }

        return String.format(SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {

        Food food = this.foodRepository.findByType(foodType);

        if (food == null) {
            throw new IllegalArgumentException(String.format(NO_FOOD_FOUND, foodType));
        }

        this.areas.get(areaName).addFood(food);

        this.foodRepository.remove(food);

        return String.format(SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {

        Area area = this.areas.get(areaName);

        Animal animal;

        switch (animalType) {
            case "AquaticAnimal":
                animal = new AquaticAnimal(animalName, kind, price);
                break;
            case "TerrestrialAnimal":
                animal = new TerrestrialAnimal(animalName, kind, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_ANIMAL_TYPE);
        }

        area.addAnimal(animal);

        return String.format(SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
    }

    @Override
    public String feedAnimal(String areaName) {

        Area area = this.areas.get(areaName);

        area.feed();

        return String.format(ANIMALS_FED, area.getAnimals().size());
    }

    @Override
    public String calculateKg(String areaName) {

        Area area = this.areas.get(areaName);

        double totalKg = area.getAnimals()
                .stream()
                .mapToDouble(Animal::getKg)
                .sum();

        return String.format(KILOGRAMS_AREA, areaName, totalKg);
    }

    @Override
    public String getStatistics() {

        StringBuilder sb = new StringBuilder();

        this.areas.values()
                .forEach(e -> sb.append(e.getInfo()).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
