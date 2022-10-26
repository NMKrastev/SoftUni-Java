public class A2_Car {

    private String model;
    private A2_Engine engines;
    private A2_Cargo cargos;
    private A2_Tires tireOne;
    private A2_Tires tireTwo;
    private A2_Tires tireThree;
    private A2_Tires tireFour;

    public A2_Car(String model, A2_Engine engines, A2_Cargo cargos, A2_Tires tireOne, A2_Tires tireTwo, A2_Tires tireThree, A2_Tires tireFour) {
        this.model = model;
        this.engines = engines;
        this.cargos = cargos;
        this.tireOne = tireOne;
        this.tireTwo = tireTwo;
        this.tireThree = tireThree;
        this.tireFour = tireFour;
    }

    public String getModel() {
        return model;
    }

    public A2_Engine getEngines() {
        return engines;
    }

    public A2_Cargo getCargos() {
        return cargos;
    }

    public A2_Tires[] getTires() {
        return new A2_Tires[]{tireOne, tireTwo, tireThree, tireFour};
    }
}