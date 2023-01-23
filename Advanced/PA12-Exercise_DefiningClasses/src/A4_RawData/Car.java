package A4_RawData;

public class Car {

    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tires tireOne;
    private Tires tireTwo;
    private Tires tireThree;
    private Tires tireFour;

    public Car(String model, Engine engine, Cargo cargo, Tires tyreOne, Tires tyreTwo, Tires tyreThree, Tires tyreFour) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tireOne = tyreOne;
        this.tireTwo = tyreTwo;
        this.tireThree = tyreThree;
        this.tireFour = tyreFour;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tires[] getTires() {
        return new Tires[]{tireOne, tireTwo, tireThree, tireFour};
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public void setTyreOne(Tires tyreOne) {
        this.tireOne = tyreOne;
    }

    public void setTyreTwo(Tires tyreTwo) {
        this.tireTwo = tyreTwo;
    }

    public void setTyreThree(Tires tyreThree) {
        this.tireThree = tyreThree;
    }

    public void setTyreFour(Tires tyreFour) {
        this.tireFour = tyreFour;
    }

    @Override
    public String toString() {
        return String.format("%s", model);
    }
}
