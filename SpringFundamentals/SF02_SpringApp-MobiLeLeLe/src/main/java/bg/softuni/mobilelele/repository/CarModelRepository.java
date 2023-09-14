package bg.softuni.mobilelele.repository;

import bg.softuni.mobilelele.model.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarModelRepository extends JpaRepository<ModelEntity, Long> {
}
