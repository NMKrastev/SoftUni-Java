package JavaOOPRetakeExam_22Aug2020.easterRaces.entities.cars;

import JavaOOPRetakeExam_22Aug2020.easterRaces.common.ExceptionMessages;

public class SportsCar extends BaseCar {

    private static final double CUBIC_CENTIMETERS = 3000.00;

    public SportsCar(String model, int horsePower) {
        super(model, setHorsePower(horsePower), CUBIC_CENTIMETERS);
    }

    private static int setHorsePower(int horsePower) {
        if (horsePower < 250 || horsePower > 450) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER, horsePower));
        }

        return horsePower;
    }
}
