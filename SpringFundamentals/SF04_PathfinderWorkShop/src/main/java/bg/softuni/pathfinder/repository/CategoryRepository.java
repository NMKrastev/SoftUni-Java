package bg.softuni.pathfinder.repository;

import bg.softuni.pathfinder.model.entity.Category;
import bg.softuni.pathfinder.model.enums.CategoryEnumType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(CategoryEnumType name);
}
