package bg.softuni.mobilelele.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class OfferDetailsDTO {

    private Long id;

    private ModelDetailsDTO model;

    private LocalDateTime created;

    private LocalDateTime modified;

    private String description;

    private String imageUrl;

    private int year;

    private BigDecimal price;

    private double mileage;

    private String engine;

    private String transmission;

    private UserFullNameDTO seller;

}
