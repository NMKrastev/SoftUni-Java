package com.example.A1_ProductShop.services.product;

import com.example.A1_ProductShop.entities.Product;
import com.example.A1_ProductShop.entities.dto.product.ProductDTO;
import com.example.A1_ProductShop.entities.dto.product.ProductInRangeWithNoBuyerDTO;
import com.example.A1_ProductShop.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

import static com.example.A1_ProductShop.constants.Constants.*;
import static com.example.A1_ProductShop.constants.Paths.PRODUCTS_IN_RANGE_FILE_PATH;
import static com.example.A1_ProductShop.utils.Utils.writeJsonIntoFile;

@Service
public class ProductServiceImpl implements ProductService {

    private final ModelMapper mapper;
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ModelMapper mapper, ProductRepository productRepository) {
        this.mapper = mapper;
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public String findAllProductsInPriceRange(BigDecimal minRange, BigDecimal maxRange) throws IOException {

        final Optional<List<Product>> productsInRange =
                this.productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPrice(minRange, maxRange);

        final List<Product> products = productsInRange.get();

        if (products.isEmpty()) {
            return NO_PRODUCTS_FOR_GIVEN_CRITERIA;
        }

        final List<ProductInRangeWithNoBuyerDTO> productsInRangeDTO = products
                .stream()
                .map(product -> this.mapper.map(product, ProductDTO.class))
                .map(ProductDTO::toProductInRangeWithBuyerDTO)
                .toList();

        writeJsonIntoFile(productsInRangeDTO, PRODUCTS_IN_RANGE_FILE_PATH);

        return PRODUCTS_IN_RANGE_SAVED_SUCCESSFULLY;
    }
}
