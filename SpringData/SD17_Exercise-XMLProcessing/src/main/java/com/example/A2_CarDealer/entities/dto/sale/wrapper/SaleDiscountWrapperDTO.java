package com.example.A2_CarDealer.entities.dto.sale.wrapper;

import com.example.A2_CarDealer.entities.dto.sale.SaleDiscountDTO;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleDiscountWrapperDTO {

    @XmlElement(name = "sale")
    private List<SaleDiscountDTO> sales;
}
