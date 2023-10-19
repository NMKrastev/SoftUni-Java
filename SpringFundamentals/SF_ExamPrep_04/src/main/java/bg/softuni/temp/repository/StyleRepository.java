package bg.softuni.temp.repository;

import bg.softuni.temp.model.entity.Style;
import bg.softuni.temp.model.entity.enums.StyleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleRepository extends JpaRepository<Style, Long> {

    Style findByName(StyleEnum style);
}
