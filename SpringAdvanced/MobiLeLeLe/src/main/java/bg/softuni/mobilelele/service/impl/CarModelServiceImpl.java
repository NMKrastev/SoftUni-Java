package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.entity.ModelEntity;
import bg.softuni.mobilelele.repository.CarModelRepository;
import bg.softuni.mobilelele.service.CarModelService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class CarModelServiceImpl implements CarModelService {

    private final CarModelRepository carModelRepository;
    private final DataSource dataSource;

    public CarModelServiceImpl(CarModelRepository carModelRepository, DataSource dataSource) {

        this.carModelRepository = carModelRepository;
        this.dataSource = dataSource;
    }

    @Override
    public boolean isPopulated() {

        return this.carModelRepository.count() > 0;
    }

    @Override
    public void populate() {

        final ResourceDatabasePopulator resourceDatabasePopulator =
                new ResourceDatabasePopulator(new ClassPathResource("sql/car_models_data.sql"));

        resourceDatabasePopulator.setSeparator(";;");
        resourceDatabasePopulator.execute(dataSource);
    }

    @Override
    public ModelEntity findById(Long modelId) {

        return this.carModelRepository
                .findById(modelId)
                .get();
    }
}
