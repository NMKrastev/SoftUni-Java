package A7_Google;

public class Car {

    private String car;
    private String speed;

    public Car(String car, String speed) {
        this.car = car;
        this.speed = speed;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format("%s %s", car, speed);
    }
}
