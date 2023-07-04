package com.example.A2_CarDealer.entities.dto.sale;

import com.example.A2_CarDealer.entities.dto.car.CarSaleDiscountDTO;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "sale")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleDiscountDTO {

    @XmlElement(name = "car")
    private CarSaleDiscountDTO car;

    @XmlElement(name = "customer-name")
    private String customerName;

    @XmlElement
    private Double discount;

    @XmlElement
    private BigDecimal price;

    @XmlElement(name = "price-with-discount")
    private BigDecimal priceWithDiscount;
}
