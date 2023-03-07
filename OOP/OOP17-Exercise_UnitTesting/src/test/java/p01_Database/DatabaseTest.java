package p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private Database database;
    private Integer[] NUMBERS = {1, 2, 3, 4, 5};

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorCreatesValidDatabase() throws OperationNotSupportedException {
        Integer[] dbElements = database.getElements();
        assertArrayEquals(dbElements, NUMBERS);
        /*for (int i = 0; i < dbElements.length; i++) {
            assertEquals(dbElements[i], numbers[i]);
        }*/
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWithMoreThan16Elements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWithNoElements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        new Database(numbers);
    }

    @Test
    public void testAddShouldWork() throws OperationNotSupportedException {
        database.add(6);
        Integer[] dbElements = database.getElements();
        assertEquals(Integer.valueOf(6), dbElements[dbElements.length - 1]);
        assertEquals(NUMBERS.length + 1, dbElements.length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrow() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testRemoveShouldWork() throws OperationNotSupportedException {
        Integer[] elementsBeforeRemove = database.getElements();
        database.remove();
        Integer[] elementsAfterRemove = database.getElements();
        assertEquals(elementsBeforeRemove.length - 1, elementsAfterRemove.length);
        assertEquals(elementsBeforeRemove[elementsBeforeRemove.length - 2], elementsAfterRemove[elementsAfterRemove.length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowWithEmptyDB() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }

}