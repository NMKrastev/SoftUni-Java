package _04_JavaOOPRetakeExam_19December2020.blueOrigin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class SpaceshipTests {

    private static final String INVALID_SPACESHIP_NAME = "Invalid spaceship name!";
    private static final String INVALID_CAPACITY = "Invalid capacity!";
    private static final String SPACESHIP_FULL = "Spaceship is full!";
    private static final String ASTRONAUT_EXIST = "Astronaut %s is already in!";

    private Spaceship spaceship;
    private Astronaut astronautOne;
    private Astronaut astronautTwo;
    private Astronaut astronautThree;

    @Before
    public void setUp() {
        this.spaceship = new Spaceship("SSV Normandy", 2);
        this.astronautOne = new Astronaut("Ivan", 95.2);
        this.astronautTwo = new Astronaut("Peter", 97.8);
        this.astronautThree = new Astronaut("Alex", 99.9);
    }

    @Test
    public void testGetNameShouldWork() {
        String expectedName = "SSV Normandy";
        assertEquals(0, spaceship.getCount());
        assertEquals(expectedName, this.spaceship.getName());
    }

    @Test
    public void testAddShouldAddAstronautSuccessfully() {
        assertEquals(0, this.spaceship.getCount());
        this.spaceship.add(this.astronautOne);
        assertEquals(1, this.spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowIfThereIsNoMoreCapacityForAstronaut() {
        this.spaceship.add(this.astronautOne);
        this.spaceship.add(this.astronautTwo);
        try {
            this.spaceship.add(this.astronautThree);
        } catch (IllegalArgumentException e) {
            assertEquals(SPACESHIP_FULL, e.getMessage());
            throw e;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowIfAstronautAlreadyExist() {
        this.spaceship.add(this.astronautOne);
        try {
            this.spaceship.add(this.astronautOne);
        } catch (IllegalArgumentException e) {
            assertEquals(String.format(ASTRONAUT_EXIST, astronautOne.getName()), e.getMessage());
            throw e;
        }
    }

    @Test
    public void testRemoveShouldWork() {
        this.spaceship.add(this.astronautOne);
        assertTrue(this.spaceship.remove(this.astronautOne.getName()));
        assertFalse(this.spaceship.remove(this.astronautOne.getName()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldThrowIfCapacityIsBelowZero() {
        try {
            Spaceship spaceshipNegativeCapacity = new Spaceship("Normandy 2.0", -1);
        } catch (IllegalArgumentException e) {
            assertEquals(INVALID_CAPACITY, e.getMessage());
            throw e;
        }
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowIfNameIsNull() {
        try {
            Spaceship spaceshipNameIsNull = new Spaceship(null, 5);
        } catch (NumberFormatException e) {
            assertEquals(INVALID_SPACESHIP_NAME, e.getMessage());
            throw e;
        }
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowIfNameIsEmpty() {
        try {
            Spaceship spaceshipNameIsNull = new Spaceship("", 5);
        } catch (NullPointerException e) {
            assertEquals(INVALID_SPACESHIP_NAME, e.getMessage());
            throw e;
        }
    }
}
