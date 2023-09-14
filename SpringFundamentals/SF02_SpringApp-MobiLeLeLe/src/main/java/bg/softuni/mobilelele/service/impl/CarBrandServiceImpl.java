package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.repository.CarBrandRepository;
import bg.softuni.mobilelele.service.CarBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class CarBrandServiceImpl implements CarBrandService {

    private final CarBrandRepository carBrandRepository;

    @Autowired
    private final DataSource dataSource;

    public CarBrandServiceImpl(CarBrandRepository carBrandRepository, DataSource dataSource, DataSource dataSource1) {
        this.carBrandRepository = carBrandRepository;
        this.dataSource = dataSource1;
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
}
