package bg.softuni.mobilelele;

import bg.softuni.mobilelele.service.CarBrandService;
import bg.softuni.mobilelele.service.CarModelService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CarBrandService carBrandService;
    private final CarModelService carModelService;

    public DataInitializer(CarBrandService carBrandService, CarModelService carModelService) {
        this.carBrandService = carBrandService;
        this.carModelService = carModelService;
    }

    @Override
    public void run(String... args) throws Exception {

        if (!this.carBrandService.isPopulated()) {
            this.carBrandService.populate();
        }

        if (!this.carModelService.isPopulated()) {
            this.carModelService.populate();
        }
    }
}
