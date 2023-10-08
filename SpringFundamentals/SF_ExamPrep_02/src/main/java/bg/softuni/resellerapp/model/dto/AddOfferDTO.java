package bg.softuni.resellerapp.model.dto;

import bg.softuni.resellerapp.model.enums.ConditionTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class AddOfferDTO {

    @NotBlank(message = "Description must not be empty!")
    @Size(min = 2, max = 50, message = "Description must be between 2 and 50 characters!")
    private String description;

    @NotNull(message = "Price must not be empty!")
    @Positive(message = "Price must be positive number!")
    private BigDecimal price;

    @NotNull(message = "Condition must be selected!")
    private ConditionTypeEnum condition;
}
