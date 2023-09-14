package bg.softuni.mobilelele.repository;

import bg.softuni.mobilelele.model.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarBrandRepository extends JpaRepository<BrandEntity, Long> {
}
