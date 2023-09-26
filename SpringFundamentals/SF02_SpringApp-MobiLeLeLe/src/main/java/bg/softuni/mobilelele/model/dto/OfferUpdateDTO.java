package bg.softuni.mobilelele.model.dto;

import bg.softuni.mobilelele.model.entity.ModelEntity;
import bg.softuni.mobilelele.model.enums.EngineEnum;
import bg.softuni.mobilelele.model.enums.TransmissionEnum;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OfferUpdateDTO {

    private Long id;

    private Long modelId;

    private ModelEntity model;

    private BigDecimal price;

    private EngineEnum engine;

    private TransmissionEnum transmission;

    private Integer year;

    private Double mileage;

    private String description;

    private String imageUrl;
}
