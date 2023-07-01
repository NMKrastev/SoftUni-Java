package com.example.A1_ProductShop.services.product;

import java.io.IOException;
import java.math.BigDecimal;

public interface ProductService {

    String findAllProductsInPriceRange(BigDecimal minRange, BigDecimal maxRange) throws IOException;
}
