package com.example.A1_ProductShop.services.category;

import com.example.A1_ProductShop.entities.Category;
import com.example.A1_ProductShop.entities.dto.category.CategoryByProductsSummaryDTO;
import com.example.A1_ProductShop.repositories.CategoryRepository;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

import static com.example.A1_ProductShop.constants.Constants.CATEGORY_TABLE_IS_EMPTY;
import static com.example.A1_ProductShop.constants.Paths.CATEGORIES_BY_PRODUCT_COUNT_FILE_PATH;
import static com.example.A1_ProductShop.utils.Utils.writeJsonIntoFile;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final Gson gson;
    private final ModelMapper mapper;
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(Gson gson, ModelMapper mapper, CategoryRepository categoryRepository) {
        this.gson = gson;
        this.mapper = mapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public String getCategoriesByProductSummary() throws IOException {

        final List<CategoryByProductsSummaryDTO> categoriesByProductSummary =
                this.categoryRepository.getCategoriesByProductSummary()
                        .orElseThrow(NoSuchElementException::new)
                        .stream()
                        .map(category -> this.mapper.map(category, CategoryByProductsSummaryDTO.class))
                        .toList();

        writeJsonIntoFile(categoriesByProductSummary, CATEGORIES_BY_PRODUCT_COUNT_FILE_PATH);

        System.out.println();

        return null;
    }
}
