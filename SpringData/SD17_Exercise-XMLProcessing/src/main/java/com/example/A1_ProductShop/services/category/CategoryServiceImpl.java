package com.example.A1_ProductShop.services.category;

import com.example.A1_ProductShop.entities.dto.category.CategoryByProductsSummaryDTO;
import com.example.A1_ProductShop.entities.dto.category.wrapper.CategoriesByProductsSummaryWrapperDTO;
import com.example.A1_ProductShop.repositories.CategoryRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

import static com.example.A1_ProductShop.constants.Constants.CATEGORIES_WITH_PRODUCTS_SAVED_SUCCESSFULLY;
import static com.example.A1_ProductShop.constants.Constants.NO_DATA_IN_CATEGORY_OR_PRODUCTS;
import static com.example.A1_ProductShop.constants.Paths.CATEGORIES_BY_PRODUCT_COUNT_FILE_PATH;

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
    public String getCategoriesByProductSummary() throws JAXBException {

        final List<CategoryByProductsSummaryDTO> categoriesByProductSummary =
                this.categoryRepository.getCategoriesByProductSummary()
                        .orElseThrow(NoSuchElementException::new)
                        .stream()
                        .map(category -> this.mapper.map(category, CategoryByProductsSummaryDTO.class))
                        .toList();

        if (categoriesByProductSummary.isEmpty()) {
            return NO_DATA_IN_CATEGORY_OR_PRODUCTS;
        }

        final CategoriesByProductsSummaryWrapperDTO categoriesByProductsSummaryWrapperDTO =
                new CategoriesByProductsSummaryWrapperDTO(categoriesByProductSummary);

        final JAXBContext context = JAXBContext.newInstance(CategoriesByProductsSummaryWrapperDTO.class);

        final Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(categoriesByProductsSummaryWrapperDTO, CATEGORIES_BY_PRODUCT_COUNT_FILE_PATH.toFile());

        return CATEGORIES_WITH_PRODUCTS_SAVED_SUCCESSFULLY;
    }
}
