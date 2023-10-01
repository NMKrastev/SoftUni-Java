package bg.softuni.BattleShipsApplication.model.dto;

import bg.softuni.BattleShipsApplication.model.entity.Category;
import bg.softuni.BattleShipsApplication.model.entity.enums.CategoryEnum;
import bg.softuni.BattleShipsApplication.validation.FutureDate;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class AddShipDTO {

    @NotNull
    @NotBlank
    @Size(min = 2, max = 10)
    private String name;

    @Positive
    private long power;

    @Positive
    private long health;

    @NotNull
    @NotEmpty
    @FutureDate
    private String created;

    @NotNull
    private CategoryEnum category;
}
