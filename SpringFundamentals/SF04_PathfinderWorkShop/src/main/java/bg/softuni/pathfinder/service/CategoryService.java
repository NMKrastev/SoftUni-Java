package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.entity.Category;
import bg.softuni.pathfinder.model.enums.CategoryEnumType;

public interface CategoryService {

    Category findCategoryByName(CategoryEnumType name);
}
