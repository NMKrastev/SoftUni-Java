package _02_JavaOOPRetakeExam_22Aug2020.easterRaces.entities.cars;

import _02_JavaOOPRetakeExam_22Aug2020.easterRaces.common.ExceptionMessages;

public class MuscleCar extends BaseCar {

    private static final double CUBIC_CENTIMETERS = 5000.00;

    public MuscleCar(String model, int horsePower) {
        super(model, setHorsePower(horsePower), CUBIC_CENTIMETERS);
    }

    private static int setHorsePower(int horsePower) {
        if (horsePower < 400 || horsePower > 600) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER, horsePower));
        }

        return horsePower;
    }
}
