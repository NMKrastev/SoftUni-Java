package bg.softuni.BattleShipsApplication.model.mapper;

import bg.softuni.BattleShipsApplication.model.dto.CategoryDTO;
import bg.softuni.BattleShipsApplication.model.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO categoryToCategoryDto(Category category);

}
