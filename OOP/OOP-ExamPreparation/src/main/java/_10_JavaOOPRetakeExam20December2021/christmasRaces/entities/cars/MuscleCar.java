package _10_JavaOOPRetakeExam20December2021.christmasRaces.entities.cars;

import static _10_JavaOOPRetakeExam20December2021.christmasRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class MuscleCar extends BaseCar {

    private static final double CUBIC_CENTIMETERS = 5000;

    public MuscleCar(String model, int horsePower) {
        super(model, setHorsePower(horsePower), CUBIC_CENTIMETERS);
    }

    private static int setHorsePower(int horsePower) {
        if (horsePower < 400 || horsePower > 600) {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }

        return horsePower;
    }
}
