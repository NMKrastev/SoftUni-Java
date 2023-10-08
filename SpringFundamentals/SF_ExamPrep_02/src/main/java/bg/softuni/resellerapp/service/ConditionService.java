package bg.softuni.resellerapp.service;

import bg.softuni.resellerapp.model.entity.Condition;
import bg.softuni.resellerapp.model.enums.ConditionTypeEnum;
import bg.softuni.resellerapp.repository.ConditionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConditionService {

    private final ConditionRepository conditionRepository;

    public ConditionService(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }


    public List<Condition> findAllConditions() {

        return this.conditionRepository
                .findAll();
    }

    public Condition findConditionByName(ConditionTypeEnum condition) {

        return this.conditionRepository
                .findByName(condition);
    }
}
