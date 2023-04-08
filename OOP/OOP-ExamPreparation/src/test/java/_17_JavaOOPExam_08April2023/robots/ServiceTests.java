package _17_JavaOOPExam_08April2023.robots;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceTests {

    private static final String INVALID_NAME = "Invalid name!";
    private static final String INVALID_CAPACITY = "Invalid capacity!";
    private static final String FULL_SERVICE = "Full service!";
    private static final String ROBOT_NAME_DOES_NOT_EXIST = "Robot with name %s doesn't exist!";
    private static final String ROBOT_IN_SERVICE = "The robot %s is in the service %s!";

    private Service service;
    private Robot one;
    private Robot two;
    private Robot three;

    private String names;

    @Before
    public void setUp() {
        this.service = new Service("Service One", 2);
        this.one = new Robot("One");
        this.two = new Robot("Two");
        this.three = new Robot("Three");
        this.names = "One, Two";
    }


    @Test
    public void testConstructorShouldInitializeService() {
        assertEquals("Service One", this.service.getName());
        assertEquals(2, this.service.getCapacity());
        assertEquals(0, this.service.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameOfServiceShouldThrowIfNameIsNull() {
        try {
            Service test = new Service(null, 2);
        } catch (NullPointerException e) {
            assertEquals(INVALID_NAME, e.getMessage());
            throw e;
        }
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameOfServiceShouldThrowIfNameIsEmpty() {
        try {
            Service test = new Service("  ", 2);
        } catch (NullPointerException e) {
            assertEquals(INVALID_NAME, e.getMessage());
            throw e;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityOfServiceShouldThrowIfCapacityIsBelowZero() {
        try {
            Service test = new Service("test", -1);
        } catch (IllegalArgumentException e) {
            assertEquals(INVALID_CAPACITY, e.getMessage());
            throw e;
        }
    }

    @Test
    public void testAddRobotShouldWork() {
        assertEquals(0, this.service.getCount());
        this.service.add(this.one);
        assertEquals(1, this.service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRobotShouldThrowIfThereIsNoCapacityForMoreRobots() {
        assertEquals(0, this.service.getCount());
        this.service.add(this.one);
        this.service.add(this.two);
        assertEquals(2, this.service.getCount());
        try {
            this.service.add(this.three);
        } catch (IllegalArgumentException e) {
            assertEquals(2, this.service.getCount());
            assertEquals(FULL_SERVICE, e.getMessage());
            throw e;
        }
    }

    @Test
    public void testRemoveShouldRemoveRobotFormService() {
        this.service.add(this.one);
        assertEquals(1, this.service.getCount());
        this.service.remove(this.one.getName());
        assertEquals(0, this.service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldThrowIfRobotWithNameDoesNotExist() {
        this.service.add(this.one);
        assertEquals(1, this.service.getCount());
        try {
            this.service.remove(this.two.getName());
        } catch (IllegalArgumentException e) {
            assertEquals(1, this.service.getCount());
            assertEquals(String.format(ROBOT_NAME_DOES_NOT_EXIST, this.two.getName()), e.getMessage());
            throw e;
        }
    }

    @Test
    public void testForSaleShouldWork() {
        this.service.add(this.one);
        assertTrue(this.one.isReadyForSale());
        this.service.forSale(this.one.getName());
        assertFalse(this.one.isReadyForSale());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForSaleShouldThrowIfRobotWithNameDoesNotExist() {
        this.service.add(this.one);
        assertTrue(this.one.isReadyForSale());
        try {
            this.service.forSale(this.two.getName());
        } catch (IllegalArgumentException e) {
            assertEquals(String.format(ROBOT_NAME_DOES_NOT_EXIST, this.two.getName()), e.getMessage());
            throw e;
        }
    }

    @Test
    public void testReportShouldReturnRobotsNames() {
        this.service.add(this.one);
        this.service.add(this.two);
        assertEquals(String.format(ROBOT_IN_SERVICE, names, "Service One"), this.service.report());
    }

}
