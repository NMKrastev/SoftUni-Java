package exam.model.dtos.shop;

import exam.model.dtos.town.TownNameDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "shop")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShopImportDTO {

    @XmlElement
    private String address;

    @XmlElement(name = "employee-count")
    private int employeeCount;

    @XmlElement
    private BigDecimal income;

    @XmlElement
    private String name;

    @XmlElement(name = "shop-area")
    private int shopArea;

    @XmlElement(name = "town")
    private TownNameDTO town;
}
