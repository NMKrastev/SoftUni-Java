package _14_JavaOOPRetakeExam_22August2022.archeologicalExcavations;

import _14_JavaOOPRetakeExam_22August2022.archeologicalExcavations.Archaeologist;
import _14_JavaOOPRetakeExam_22August2022.archeologicalExcavations.Excavation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExcavationTests {

    private static final String INVALID_EXCAVATION_NAME = "Invalid excavation name!";
    private static final String INVALID_CAPACITY = "Invalid capacity!";
    private static final String NO_MORE_EXCAVATION = "No more excavation!";
    private static final String ARCHAEOLOGIST_EXIST = "The archaeologist is already in the excavation!";

    private Excavation excavation;
    private Archaeologist one;
    private Archaeologist two;
    private Archaeologist three;

    @Before
    public void setUp() {
        this.excavation = new Excavation("Test", 2);
        this.one = new Archaeologist("Ivan", 90);
        this.two = new Archaeologist("Peter", 100);
        this.three = new Archaeologist("Alex", 80);
    }

    @Test
    public void testAddArchaeologistShouldAddArchaeologistToTheExcavation() {
        assertEquals(0, this.excavation.getCount());
        assertEquals("Test", this.excavation.getName());
        assertEquals(2, this.excavation.getCapacity());
        this.excavation.addArchaeologist(this.one);
        assertEquals(1, this.excavation.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistShouldThrowIfThereIsNotEnoughCapacity() {
        this.excavation.addArchaeologist(this.one);
        this.excavation.addArchaeologist(this.two);
        try {
            this.excavation.addArchaeologist(this.three);
        } catch (IllegalArgumentException e) {
            assertEquals(NO_MORE_EXCAVATION, e.getMessage());
            throw e;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistShouldThrowIfArchaeologistExists() {
        this.excavation.addArchaeologist(this.one);
        try {
            this.excavation.addArchaeologist(this.one);
        } catch (IllegalArgumentException e) {
            assertEquals(ARCHAEOLOGIST_EXIST, e.getMessage());
            throw e;
        }
    }

    @Test
    public void testRemoveArchaeologistShouldRemoveArchaeologistFromExcavation() {
        assertEquals(0, this.excavation.getCount());
        this.excavation.addArchaeologist(this.one);
        assertEquals(1, this.excavation.getCount());
        this.excavation.removeArchaeologist(this.one.getName());
        assertEquals(0, this.excavation.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowIfNameIsNull() {
        try {
            Excavation ex = new Excavation(null, 2);
        } catch (NullPointerException e) {
            assertEquals(INVALID_EXCAVATION_NAME, e.getMessage());
            throw e;
        }
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowIfNameIsEmpty() {
        try {
            Excavation ex = new Excavation("  ", 2);
        } catch (NullPointerException e) {
            assertEquals(INVALID_EXCAVATION_NAME, e.getMessage());
            throw e;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldThrowIfCapacityIsNegative() {
        try {
            Excavation ex = new Excavation("One", -1);
        } catch (IllegalArgumentException e) {
            assertEquals(INVALID_CAPACITY, e.getMessage());
            throw e;
        }
    }
}
