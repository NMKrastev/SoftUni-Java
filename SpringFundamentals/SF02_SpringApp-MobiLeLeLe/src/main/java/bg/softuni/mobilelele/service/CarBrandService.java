package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.entity.BrandEntity;

import java.util.List;

public interface CarBrandService {

    boolean isPopulated();

    void populate();

    List<BrandEntity> getAllBrands();
}
