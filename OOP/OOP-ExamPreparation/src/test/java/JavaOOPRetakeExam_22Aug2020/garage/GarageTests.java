package JavaOOPRetakeExam_22Aug2020.garage;

import JavaOOPRetakeExam_22Aug2020.garage.Car;
import JavaOOPRetakeExam_22Aug2020.garage.Garage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

public class GarageTests {

    public Garage garage;
    private Car carOne = new Car("Nissan", 300, 2000000.00);
    private Car carTwo = new Car("Ferrari", 320, 4000000.00);
    private Car carThree = new Car("Mercedes", 310, 3000000.00);
    private Car carFour = new Car("BMW", 310, 250000.00);
    private Car carFive = new Car("Mercedes", 28, 200000.00);
    private static final String BRAND = "Mercedes";

    @Before
    public void setUp() {
        garage = new Garage();
        garage.addCar(carOne);
        garage.addCar(carTwo);
        garage.addCar(carThree);
    }

    @Test
    public void testGetCarsShouldReturnListWithCars() {
        List<Car> carList = List.of(carOne, carTwo, carThree);
        assertEquals(carList, garage.getCars());
    }

    @Test
    public void testGetCountShouldReturnAsExpected() {
        int oldCount = garage.getCount();
        garage.addCar(carFour);
        assertEquals(oldCount + 1, garage.getCount());
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAboveShouldReturnListOfCars() {
        List<Car> carWithSpeedAbove300 = List.of(carTwo, carThree);
        assertEquals(carWithSpeedAbove300, garage.findAllCarsWithMaxSpeedAbove(300));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarShouldThrowIfCarIsNull() {
        garage.addCar(null);
    }

    @Test
    public void testAddCarShouldWork() {
        int oldCount = garage.getCount();
        garage.addCar(carFour);
        assertEquals(carFour, garage.getCars().get(3));
        assertEquals(oldCount + 1, garage.getCount());
    }

    @Test
    public void testGetMostExpensiveCarShouldReturnCar() {
        assertEquals(carTwo, garage.getTheMostExpensiveCar());
    }

    @Test
    public void testFindAllCarsByBrandShouldReturnListOfCarsByBrand() {
        garage.addCar(carFive);
        List<Car> carsByBrand = List.of(carThree, carFive);
        assertEquals(carsByBrand, garage.findAllCarsByBrand(BRAND));
    }
}
























