package bg.softuni.BattleShipsApplication.repository;

import bg.softuni.BattleShipsApplication.model.entity.Category;
import bg.softuni.BattleShipsApplication.model.entity.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(CategoryEnum category);
}
