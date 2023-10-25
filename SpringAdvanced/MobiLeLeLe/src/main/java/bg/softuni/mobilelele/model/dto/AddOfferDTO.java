package bg.softuni.mobilelele.model.dto;

import bg.softuni.mobilelele.model.enums.EngineEnum;
import bg.softuni.mobilelele.model.enums.TransmissionEnum;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class AddOfferDTO {

    @NotNull
    @Min(1)
    private Long modelId;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    private EngineEnum engine;

    @NotNull
    private TransmissionEnum transmission;

    @NotNull
    @Min(1900)
    @Max(2024)
    private Integer year;

    @NotNull
    @Min(0)
    private Double mileage;

    @NotEmpty
    private String description;

    @NotEmpty
    private String imageUrl;
}
