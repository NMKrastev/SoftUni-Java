package bg.softuni.mobilelele;

import bg.softuni.mobilelele.service.CarBrandService;
import bg.softuni.mobilelele.service.CarModelService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CarBrandService carBrandService;
    private final CarModelService carModelService;

    private final PasswordEncoder encoder;

    public DataInitializer(CarBrandService carBrandService, CarModelService carModelService, PasswordEncoder encoder) {
        this.carBrandService = carBrandService;
        this.carModelService = carModelService;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) throws Exception {

        //Use the data initializer in the application.properties
        // or use the code below

        /*if (!this.carBrandService.isPopulated()) {
            this.carBrandService.populate();
        }

        if (!this.carModelService.isPopulated()) {
            this.carModelService.populate();
        }*/

        //System.out.println(this.encoder.encode("password"));
    }
}
