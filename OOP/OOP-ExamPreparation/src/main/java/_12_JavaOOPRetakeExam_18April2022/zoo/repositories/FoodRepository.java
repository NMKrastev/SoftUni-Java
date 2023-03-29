package _12_JavaOOPRetakeExam_18April2022.zoo.repositories;

import _12_JavaOOPRetakeExam_18April2022.zoo.entities.foods.Food;

public interface FoodRepository {
    void add(Food food);

    boolean remove(Food food);

    Food findByType(String type);
}
