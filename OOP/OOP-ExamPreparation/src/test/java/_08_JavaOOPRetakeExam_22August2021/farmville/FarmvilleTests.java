package _08_JavaOOPRetakeExam_22August2021.farmville;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FarmvilleTests {
    private static final String INVALID_FARM_NAME = "Invalid farm name!";
    private static final String INVALID_CAPACITY = "Invalid capacity!";
    private static final String FARM_IS_FULL = "Farm is full!";
    private static final String ANIMAL_EXIST = "Animal %s is already in!";
    private static final int ZERO_CAPACITY = 0;


    private String name;
    private int capacity;
    private Farm farm;
    private Animal cat;
    private Animal dog;
    private Animal cow;
    private Animal chicken;

    @Before
    public void setUp() {
        this.name = "Clarkson";
        this.capacity = 3;
        this.farm = new Farm(this.name, this.capacity);
        this.cat = new Animal("Cat", 100.00);
        this.dog = new Animal("Dog", 95);
        this.cow = new Animal("Cow", 60.00);
        this.chicken = new Animal("Chicken", 40.00);
    }

    @Test
    public void testAddShouldWork() {
        assertEquals(0, this.farm.getCount());
        this.farm.add(cat);
        assertEquals(this.name, this.farm.getName());
        assertEquals(1, this.farm.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddShouldThrowIfThereIsNotEnoughCapacity() {
        assertEquals(0, this.farm.getCount());
        this.farm.add(cat);
        this.farm.add(dog);
        this.farm.add(cow);
        try {
            this.farm.add(chicken);
        } catch (IllegalArgumentException e) {
            assertEquals(FARM_IS_FULL, e.getMessage());
            throw e;
        }
        assertEquals(3, this.farm.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddShouldThrowIfAnimalAlreadyExist() {
        assertEquals(0, this.farm.getCount());
        this.farm.add(cat);
        try {
            this.farm.add(cat);
        } catch (IllegalArgumentException e) {
            assertEquals(String.format(ANIMAL_EXIST, cat.getType()), e.getMessage());
            throw e;
        }
        assertEquals(0, this.farm.getCount());
    }

    @Test
    public void testRemoveShouldWork() {
        this.farm.add(cat);
        this.farm.add(cow);
        assertEquals(2, this.farm.getCount());
        this.farm.remove(cow.getType());
        assertEquals(1, this.farm.getCount());
    }

    @Test
    public void testRemoveShouldNotRemoveIfAnimalTypeIsNotFound() {
        this.farm.add(cat);
        this.farm.add(cow);
        assertEquals(2, this.farm.getCount());
        this.farm.remove(dog.getType());
        assertEquals(2, this.farm.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldThrowIfCapacityIsBelowZero() {
        this.capacity = ZERO_CAPACITY;
        try {
            Farm farmTwo = new Farm("FarmTwo", -1);
        } catch (IllegalArgumentException e) {
            assertEquals(INVALID_CAPACITY, e.getMessage());
            throw e;
        }
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowIfNameOfFarmIsNull() {
        try {
            Farm farmTwo = new Farm(null, 5);
        } catch (NullPointerException e) {
            assertEquals(INVALID_FARM_NAME, e.getMessage());
            throw e;
        }
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowIfNameOfFarmIsEmpty() {
        try {
            Farm farmTwo = new Farm("  ", 5);
        } catch (NullPointerException e) {
            assertEquals(INVALID_FARM_NAME, e.getMessage());
            throw e;
        }
    }
}
