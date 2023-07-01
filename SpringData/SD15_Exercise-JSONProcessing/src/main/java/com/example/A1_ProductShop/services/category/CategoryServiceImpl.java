package com.example.A1_ProductShop.services.category;

import com.example.A1_ProductShop.entities.dto.category.CategoryByProductsSummaryDTO;
import com.example.A1_ProductShop.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

import static com.example.A1_ProductShop.constants.Constants.CATEGORIES_WITH_PRODUCTS_SAVED_SUCCESSFULLY;
import static com.example.A1_ProductShop.constants.Constants.NO_DATA_IN_CATEGORY_OR_PRODUCTS;
import static com.example.A1_ProductShop.constants.Paths.CATEGORIES_BY_PRODUCT_COUNT_FILE_PATH;
import static com.example.A1_ProductShop.utils.Utils.writeJsonIntoFile;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final ModelMapper mapper;
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(ModelMapper mapper, CategoryRepository categoryRepository) {
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

        if (categoriesByProductSummary.isEmpty()) {
            return NO_DATA_IN_CATEGORY_OR_PRODUCTS;
        }

        writeJsonIntoFile(categoriesByProductSummary, CATEGORIES_BY_PRODUCT_COUNT_FILE_PATH);

        return CATEGORIES_WITH_PRODUCTS_SAVED_SUCCESSFULLY;
    }
}
