package com.example.A1_BookshopSystem.services.category;

import com.example.A1_BookshopSystem.models.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {

    void seedCategories(List<Category> categories);

    boolean isDataSeeded();

    Set<Category> getRandomCategories();
}
