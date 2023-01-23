package A5_CarSalesman;

public class Car {

    private String carModel;
    private String carEngine;
    private String carWeight;
    private String carColor;

    public Car(String model, String engine) {
        this.carModel = model;
        this.carEngine = engine;
        this.carWeight = "n/a";
        this.carColor = "n/a";
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarEngine() {
        return carEngine;
    }

    public void setCarEngine(String carEngine) {
        this.carEngine = carEngine;
    }

    public String getCarWeight() {
        return carWeight;
    }

    public void setCarWeight(String carWeight) {
        this.carWeight = carWeight;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }
}
