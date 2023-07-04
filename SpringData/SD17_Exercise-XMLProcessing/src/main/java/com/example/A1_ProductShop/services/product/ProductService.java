package com.example.A1_ProductShop.services.product;

import jakarta.xml.bind.JAXBException;

import java.math.BigDecimal;

public interface ProductService {

    String findAllProductsInPriceRange(BigDecimal minRange, BigDecimal maxRange) throws JAXBException;
}
