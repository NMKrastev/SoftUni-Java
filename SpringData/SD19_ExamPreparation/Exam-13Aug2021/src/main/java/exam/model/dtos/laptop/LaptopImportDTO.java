package exam.model.dtos.laptop;

import exam.model.dtos.shop.ShopNameDTO;
import exam.model.entity.WarrantyType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LaptopImportDTO {

    private String macAddress;

    private Double cpuSpeed;

    private int ram;

    private int storage;

    private String description;

    private BigDecimal price;

    private WarrantyType warrantyType;

    private ShopNameDTO shop;
}
