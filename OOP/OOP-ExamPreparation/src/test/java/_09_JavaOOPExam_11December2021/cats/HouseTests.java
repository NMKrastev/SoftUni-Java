package _09_JavaOOPExam_11December2021.cats;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HouseTests {

    private static final String INVALID_NAME = "Invalid name!";
    private static final String INVALID_CAPACITY = "Invalid capacity!";
    private static final String FULL_HOUSE = "House is full!";
    private static final String CAT_DOES_NOT_EXIST = "Cat with name %s doesn't exist!";
    private static final String CAT_STATISTICS = "The cat %s is in the house %s!";

    private String name;
    private int capacity;
    private House houseOne;
    private Cat catOne;
    private Cat catTwo;
    private Cat catThree;

    @Before
    public void setUp() {
        this.name = "CatHouse";
        this.capacity = 2;
        this.houseOne = new House(name, capacity);
        this.catOne = new Cat("CatOne");
        this.catTwo = new Cat("CatTwo");
        this.catThree = new Cat("CatThree");
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowIfNameIsNull() {
        try {
            House house = new House(null, 3);
        } catch (NullPointerException e) {
            assertEquals(INVALID_NAME, e.getMessage());
            throw e;
        }
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowIfNameIsEmpty() {
        try {
            House house = new House("  ", 3);
        } catch (NullPointerException e) {
            assertEquals(INVALID_NAME, e.getMessage());
            throw e;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldThrowIfCapacityIsBelowZero() {
        try {
            House house = new House("CatLand", -1);
        } catch (NullPointerException e) {
            assertEquals(INVALID_CAPACITY, e.getMessage());
            throw e;
        }
    }

    @Test
    public void testAddCatShouldWork() {
        assertEquals(0, this.houseOne.getCount());
        assertEquals(2, this.houseOne.getCapacity());
        this.houseOne.addCat(this.catOne);
        assertEquals(this.name, this.houseOne.getName());
        assertEquals(1, this.houseOne.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatShouldThrowIfThereIsNoMoreCapacityForNewCatInHouse() {
        this.houseOne.addCat(this.catOne);
        this.houseOne.addCat(this.catTwo);
        try {
            this.houseOne.addCat(this.catThree);
        } catch (IllegalArgumentException e) {
            assertEquals(FULL_HOUSE, e.getMessage());
            throw e;
        }
    }

    @Test
    public void testRemoveCatShouldWork() {
        this.houseOne.addCat(this.catOne);
        this.houseOne.addCat(this.catTwo);
        assertEquals(2, this.houseOne.getCount());
        this.houseOne.removeCat(this.catTwo.getName());
        assertEquals(1, this.houseOne.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatShouldThrowIfCatWithNameDoesNotExist() {
        this.houseOne.addCat(this.catOne);
        this.houseOne.addCat(this.catTwo);
        assertEquals(2, this.houseOne.getCount());
        try {
            this.houseOne.removeCat(this.catThree.getName());
        } catch (IllegalArgumentException e) {
            assertEquals(String.format(CAT_DOES_NOT_EXIST, this.catThree.getName()), e.getMessage());
            throw e;
        }
    }

    @Test
    public void testCatForSaleShouldWork() {
        this.houseOne.addCat(this.catOne);
        this.houseOne.addCat(this.catTwo);
        this.houseOne.catForSale(this.catTwo.getName());
        assertFalse(this.catTwo.isHungry());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleShouldThrowIfCatWithNameDoesNotExist() {
        this.houseOne.addCat(this.catOne);
        this.houseOne.addCat(this.catTwo);
        try {
            this.houseOne.catForSale(this.catThree.getName());
        } catch (IllegalArgumentException e) {
            assertEquals(String.format(CAT_DOES_NOT_EXIST, this.catThree.getName()), e.getMessage());
            throw e;
        }
    }

    @Test
    public void testStatisticsShouldReturnCorrectResult() {
        this.houseOne.addCat(this.catOne);
        this.houseOne.addCat(this.catTwo);
        String expectedNames = "CatOne, CatTwo";
        assertEquals(String.format(CAT_STATISTICS, expectedNames, this.name),
                this.houseOne.statistics());
    }
}
