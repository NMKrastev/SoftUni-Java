package bg.softuni.BattleShipsApplication.model.dto;

import bg.softuni.BattleShipsApplication.model.entity.enums.CategoryEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {

    private Long id;

    private CategoryEnum name;

    private String description;
}
