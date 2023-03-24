package _10_JavaOOPRetakeExam20December2021.garage;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GarageTests {

    private static final String CAR_CANNOT_BE_NULL = "Car can't be null";

    private Garage garage;
    private Car carOne;
    private Car carTwo;
    private Car carThree;

    @Before
    public void setUp() {
        this.garage = new Garage();
        this.carOne = new Car("BMW", 300, 150000.0);
        this.carTwo = new Car("Mercedes", 310, 200000.0);
        this.carThree = new Car("Ferrari", 330, 300000.0);
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAboveShouldReturnCorrectCars() {
        this.garage.addCar(this.carOne);
        this.garage.addCar(this.carTwo);
        this.garage.addCar(this.carThree);

        List<Car> actual = this.garage.findAllCarsWithMaxSpeedAbove(305);
        List<Car> expected = List.of(this.carTwo, this.carThree);

        assertEquals(expected, actual);
    }

    @Test
    public void testAddCarShouldWork() {
        assertEquals(0, this.garage.getCount());
        this.garage.addCar(this.carOne);
        assertEquals(1, this.garage.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarShouldThrowIfCarIsNull() {
        try {
            this.garage.addCar(null);
        } catch (IllegalArgumentException e) {
            assertEquals(CAR_CANNOT_BE_NULL, e.getMessage());
            throw e;
        }
    }

    @Test
    public void testGetTheMostExpensiveCarShouldReturnMostExpensiveCar() {
        this.garage.addCar(this.carOne);
        this.garage.addCar(this.carTwo);
        this.garage.addCar(this.carThree);

        Car actualCar = this.garage.getTheMostExpensiveCar();

        assertEquals(this.carThree, actualCar);
    }

    @Test
    public void testGetTheMostExpensiveCarShouldReturnNullIfCarIsNotFound() {

        Car actualCar = this.garage.getTheMostExpensiveCar();

        assertNull(actualCar);
    }

    @Test
    public void testFindAllCarsByBrandShouldReturnList() {
        this.garage.addCar(this.carOne);
        this.garage.addCar(this.carTwo);
        this.garage.addCar(this.carThree);

        List<Car> actual = this.garage.findAllCarsByBrand("Mercedes");
        List<Car> expected = List.of(this.carTwo);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetCarsShouldReturnUnmodifiableList() {
        this.garage.addCar(this.carOne);
        this.garage.addCar(this.carTwo);
        this.garage.addCar(this.carThree);

        List<Car> actual = this.garage.getCars();
        List<Car> expected = List.of(this.carOne, this.carTwo, this.carThree);

        assertEquals(expected, actual);
    }
}