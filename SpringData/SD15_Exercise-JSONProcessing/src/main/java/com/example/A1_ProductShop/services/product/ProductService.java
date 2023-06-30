package com.example.A1_ProductShop.services.product;

import com.example.A1_ProductShop.entities.Product;
import com.example.A1_ProductShop.entities.User;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    String findAllProductsInPriceRange(BigDecimal minRange, BigDecimal maxRange) throws IOException;
}
