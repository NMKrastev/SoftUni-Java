package com.example.sd11_exercisespringdataadvancedquerying.services.category;


import com.example.sd11_exercisespringdataadvancedquerying.models.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {

    void seedCategories(List<Category> categories);

    boolean isDataSeeded();

    Set<Category> getRandomCategories();
}
