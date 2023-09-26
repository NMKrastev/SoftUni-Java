package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.entity.ModelEntity;

public interface CarModelService {

    boolean isPopulated();

    void populate();

    ModelEntity findById(Long modelId);
}
