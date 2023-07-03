package com.example.A2_CarDealer.services.sale;

import com.example.A2_CarDealer.entities.Part;
import com.example.A2_CarDealer.entities.dto.sale.SaleDiscountDTO;
import com.example.A2_CarDealer.repositories.SaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import static com.example.A2_CarDealer.constants.Messages.SALES_DISCOUNTS_SAVED_SUCCESSFULLY;
import static com.example.A2_CarDealer.constants.Paths.SALES_DISCOUNTS_FILE_PATH;

@Service
public class SaleServiceImpl implements SaleService {

    private final ModelMapper mapper;
    private final SaleRepository saleRepository;

    @Autowired
    public SaleServiceImpl(ModelMapper mapper, SaleRepository saleRepository) {
        this.mapper = mapper;
        this.saleRepository = saleRepository;
    }

    @Override
    public String findAllSalesWithInformationAboutCarAndCustomer() throws IOException {

        final List<SaleDiscountDTO> saleDiscountDTOS = this.saleRepository.findAll()
                .stream()
                .map(sale -> {

                    final String customerName = sale.getCustomer().getName();
                    final Double discount = sale.getDiscount();
                    final Set<Part> parts = sale.getCar().getParts();
                    BigDecimal price = BigDecimal.ZERO;

                    for (Part part : parts) {
                        price = price.add(part.getPrice());
                    }

                    final BigDecimal priceWithDiscount = price.multiply(BigDecimal.valueOf(1 - discount));

                    final SaleDiscountDTO saleDiscountDTO = this.mapper.map(sale, SaleDiscountDTO.class);

                    saleDiscountDTO.setCustomerName(customerName);
                    saleDiscountDTO.setDiscount(discount);
                    saleDiscountDTO.setPrice(price);
                    saleDiscountDTO.setPriceWithDiscount(priceWithDiscount);

                    return saleDiscountDTO;
                })
                .toList();

        //writeJsonIntoFile(saleDiscountDTOS, SALES_DISCOUNTS_FILE_PATH);

        return SALES_DISCOUNTS_SAVED_SUCCESSFULLY;
    }
}
