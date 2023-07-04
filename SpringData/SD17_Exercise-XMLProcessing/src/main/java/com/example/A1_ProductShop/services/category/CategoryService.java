package com.example.A1_ProductShop.services.category;

import jakarta.xml.bind.JAXBException;

import java.io.IOException;

public interface CategoryService {

    String getCategoriesByProductSummary() throws IOException, JAXBException;
}
