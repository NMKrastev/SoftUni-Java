package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.dto.BrandDTO;
import bg.softuni.mobilelele.model.dto.ModelDTO;
import bg.softuni.mobilelele.model.entity.BrandEntity;
import bg.softuni.mobilelele.model.entity.ModelEntity;
import bg.softuni.mobilelele.model.mapper.BrandMapper;
import bg.softuni.mobilelele.model.mapper.ModelMapper;
import bg.softuni.mobilelele.repository.CarBrandRepository;
import bg.softuni.mobilelele.service.CarBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarBrandServiceImpl implements CarBrandService {

    private final CarBrandRepository carBrandRepository;
    private final BrandMapper brandMapper;
    private final ModelMapper modelMapper;
    private final DataSource dataSource;

    public CarBrandServiceImpl(CarBrandRepository carBrandRepository, BrandMapper brandMapper,
                               ModelMapper modelMapper, DataSource dataSource) {
        this.carBrandRepository = carBrandRepository;
        this.brandMapper = brandMapper;
        this.modelMapper = modelMapper;
        this.dataSource = dataSource;
    }

    @Override
    public boolean isPopulated() {
        return carBrandRepository.count() > 0;
    }

    @Override
    public void populate() {

        final ResourceDatabasePopulator resourceDatabasePopulator =
                new ResourceDatabasePopulator(new ClassPathResource("sql/car_brands_data.sql"));

        resourceDatabasePopulator.execute(dataSource);
    }

    @Override
    public List<BrandDTO> getAllBrands() {

        return this.carBrandRepository
                .findAll()
                .stream()
                .map(this::mapBrand)
                .collect(Collectors.toList());
    }

    private BrandDTO mapBrand(BrandEntity brandEntity) {

        /*final List<ModelDTO> modelsDTO = brandEntity
                .getModels()
                .stream()
                .map(this::mapModel)
                .collect(Collectors.toList());


        final BrandDTO result = new BrandDTO().builder()
                .models(modelsDTO)
                .name(brandEntity.getName())
                .build();*/

        return this.brandMapper.brandEntitytoBrandDto(brandEntity);
    }

/*    private ModelDTO mapModel(ModelEntity modelEntity) {

        return this.modelMapper.modelEntityToModelDto(modelEntity);

        *//*return new ModelDTO()
                .builder()
                .id(modelEntity.getId())
                .name(modelEntity.getName())
                .category(modelEntity.getCategory().toString())
                .imageUrl(modelEntity.getImageUrl())
                .startYear(modelEntity.getStartYear())
                .endYear(modelEntity.getEndYear())
                .build();*//*
    }*/
}
