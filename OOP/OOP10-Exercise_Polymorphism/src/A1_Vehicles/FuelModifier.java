package A1_Vehicles;

public enum FuelModifier {

    CAR(0.9),
    TRUCK(1.6),
    TRUCK_FUEL(0.95);

    private double modifier;

    FuelModifier(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return modifier;
    }
}
