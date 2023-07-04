package com.example.A2_CarDealer.entities.dto.customer;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
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
@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerWithTotalSalesDTO {

    @XmlAttribute
    private String name;

    @XmlAttribute(name = "bought-cars")
    private Long boughtCars;

    @XmlAttribute(name = "spent-money")
    private BigDecimal totalMoneySpent;
}
