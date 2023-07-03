package com.example.A1_ProductShop.services.product;

import com.example.A1_ProductShop.entities.dto.product.ProductDTO;
import com.example.A1_ProductShop.entities.dto.product.ProductInRangeWithNoBuyerDTO;
import com.example.A1_ProductShop.entities.dto.product.wrapper.ProductsInRangeWithNoBuyerWrapperDTO;
import com.example.A1_ProductShop.repositories.ProductRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import static com.example.A1_ProductShop.constants.Constants.NO_PRODUCTS_FOR_GIVEN_CRITERIA;
import static com.example.A1_ProductShop.constants.Constants.PRODUCTS_IN_RANGE_SAVED_SUCCESSFULLY;
import static com.example.A1_ProductShop.constants.Paths.PRODUCTS_IN_RANGE_FILE_PATH;

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
    public String findAllProductsInPriceRange(BigDecimal minRange, BigDecimal maxRange) throws JAXBException {

        final List<ProductInRangeWithNoBuyerDTO> productsInRangeWithNoBuyerDTO =
                this.productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPrice(minRange, maxRange)
                        .orElseThrow(NoSuchElementException::new)
                        .stream()
                        .map(product -> this.mapper.map(product, ProductDTO.class))
                        .map(ProductDTO::toProductInRangeWithBuyerDTO)
                        .toList();

        if (productsInRangeWithNoBuyerDTO.isEmpty()) {
            return NO_PRODUCTS_FOR_GIVEN_CRITERIA;
        }

        final ProductsInRangeWithNoBuyerWrapperDTO productsInRangeWithNoBuyerWrapperDTO =
                new ProductsInRangeWithNoBuyerWrapperDTO(productsInRangeWithNoBuyerDTO);

        final JAXBContext context = JAXBContext.newInstance(ProductsInRangeWithNoBuyerWrapperDTO.class);

        final Marshaller addressMarshal = context.createMarshaller();

        addressMarshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        addressMarshal.marshal(productsInRangeWithNoBuyerWrapperDTO, PRODUCTS_IN_RANGE_FILE_PATH.toFile());

        return PRODUCTS_IN_RANGE_SAVED_SUCCESSFULLY;
    }
}
