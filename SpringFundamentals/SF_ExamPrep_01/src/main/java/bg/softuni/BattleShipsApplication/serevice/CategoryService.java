package bg.softuni.BattleShipsApplication.serevice;

import bg.softuni.BattleShipsApplication.model.dto.CategoryDTO;
import bg.softuni.BattleShipsApplication.model.mapper.CategoryMapper;
import bg.softuni.BattleShipsApplication.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }


    public List<CategoryDTO> findAllCategories() {

        return this.categoryRepository
                .findAll()
                .stream()
                .map(this.categoryMapper::categoryToCategoryDto)
                .toList();
    }
}
