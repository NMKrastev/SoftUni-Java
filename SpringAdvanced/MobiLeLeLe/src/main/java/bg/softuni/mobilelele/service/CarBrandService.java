package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.dto.BrandDTO;

import java.util.List;

public interface CarBrandService {

    boolean isPopulated();

    void populate();

    List<BrandDTO> getAllBrands();
}
