package A2_Constructors;

public class Car {

    private String brand;
    private String model;
    private int horsePower;

    public Car(String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.horsePower = -1;
    }

    public Car(String brand, String model, int horsePower) {
        this(brand);
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    void carInfo() {
        System.out.printf("The car is: %s %s - %d HP.\n", getBrand()/*brand*/, getModel()/*model*/, getHorsePower()/*horsePower*/);
    }
}
