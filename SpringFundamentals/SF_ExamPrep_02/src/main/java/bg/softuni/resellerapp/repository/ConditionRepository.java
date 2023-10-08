package bg.softuni.resellerapp.repository;

import bg.softuni.resellerapp.model.entity.Condition;
import bg.softuni.resellerapp.model.enums.ConditionTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConditionRepository extends JpaRepository<Condition, Long> {
    Condition findByName(ConditionTypeEnum condition);
}
