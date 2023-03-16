package _05_JavaOOPExam_10April2021.aquariumUnitTestTask;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AquariumTests {

    private static final String INVALID_AQUARIUM_NAME = "Invalid aquarium name!";
    private static final String INVALID_AQUARIUM_CAPACITY = "Invalid aquarium capacity!";
    private static final String AQUARIUM_FULL = "Aquarium is full!";
    private static final String FISH_NAME_DOES_NOT_EXIST = "Fish with name %s doesn't exist";
    private static final String AVAILABLE_FISH = "Fish available at %s: %s";

    private static final String FISH_NAME_ONE = "Nemo";
    private static final String FISH_NAME_TWO = "SpongeBob";
    Aquarium aquarium;
    Fish fishOne;
    Fish fishTwo;


    @Before
    public void setUp() {
        this.aquarium = new Aquarium("Water", 2);
        this.fishOne = new Fish(FISH_NAME_ONE);
        this.fishTwo = new Fish(FISH_NAME_TWO);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorShouldThrowIfNameIsNull() {
        try {
            this.aquarium = new Aquarium(null, 2);
        } catch (NullPointerException e) {
            assertEquals(INVALID_AQUARIUM_NAME, e.getMessage());
            throw e;
        }
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorShouldThrowIfNameIsEmpty() {
        try {
            this.aquarium = new Aquarium("", 2);
        } catch (NullPointerException e) {
            assertEquals(INVALID_AQUARIUM_NAME, e.getMessage());
            throw e;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorShouldThrowIfCapacityIsBelowZero() {
        try {
            this.aquarium = new Aquarium("DeepBlue", -1);
        } catch (IllegalArgumentException e) {
            assertEquals(INVALID_AQUARIUM_CAPACITY, e.getMessage());
            throw e;
        }
    }

    @Test
    public void testAddShouldWork() {
        assertEquals(2, this.aquarium.getCapacity());
        assertEquals(0, this.aquarium.getCount());
        this.aquarium.add(this.fishOne);
        assertEquals(1, this.aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowIfThereIsNotEnoughCapacity() {
        assertEquals(0, this.aquarium.getCount());
        this.aquarium.add(this.fishOne);
        this.aquarium.add(this.fishTwo);
        assertEquals(2, this.aquarium.getCount());
        try {
            this.aquarium.add(new Fish("Dodo"));
        } catch (IllegalArgumentException e) {
            assertEquals(AQUARIUM_FULL, e.getMessage());
            throw e;
        }
    }

    @Test
    public void testRemoveShouldWork() {
        this.aquarium.add(this.fishOne);
        this.aquarium.add(this.fishTwo);
        this.aquarium.remove(FISH_NAME_TWO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldThrowIfNameOfTheFishDoesNotExist() {
        this.aquarium.add(this.fishOne);
        try {
            this.aquarium.remove("Dodo");
        } catch (IllegalArgumentException e) {
            assertEquals(String.format(FISH_NAME_DOES_NOT_EXIST, "Dodo"), e.getMessage());
            throw e;
        }
    }

    @Test
    public void testSellFishShouldWork() {
        this.aquarium.add(this.fishOne);
        this.aquarium.add(this.fishTwo);
        this.aquarium.sellFish(FISH_NAME_TWO);
        assertFalse(this.fishTwo.isAvailable());
        assertEquals(2, this.aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellFishShouldThrowIfNameOfTheFishDoesNotExist() {
        this.aquarium.add(this.fishOne);
        this.aquarium.add(this.fishTwo);
        try {
            this.aquarium.sellFish("Dodo");
        } catch (IllegalArgumentException e) {
            assertEquals(String.format(FISH_NAME_DOES_NOT_EXIST, "Dodo"), e.getMessage());
            throw e;
        }
    }

    @Test
    public void testReportShouldDisplayCorrectInfo() {
        this.aquarium.add(this.fishOne);
        this.aquarium.add(this.fishTwo);
        String names = String.format("%s, %s", FISH_NAME_ONE, FISH_NAME_TWO);
        assertEquals(String.format(AVAILABLE_FISH, this.aquarium.getName(), names), this.aquarium.report());
    }
}

