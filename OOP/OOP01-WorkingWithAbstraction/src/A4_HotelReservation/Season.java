package A4_HotelReservation;

public enum Season {
    SPRING("Spring", 2),
    SUMMER("Summer", 4),
    AUTUMN("Autumn", 1),
    WINTER("Winter", 3);

    private String name;
    private int multiplyCoefficient;

    Season(String name, int multiplyCoefficient) {
        this.name = name;
        this.multiplyCoefficient = multiplyCoefficient;
    }

    public String getName() {
        return name;
    }

    public int getMultiplyCoefficient() {
        return multiplyCoefficient;
    }
}
