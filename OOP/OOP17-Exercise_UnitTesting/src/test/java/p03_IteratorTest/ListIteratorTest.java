package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

    private ListIterator listIterator;
    private static final String[] NAMES  = {"Ivan", "Peter", "Alex"};

    @Before
    public void setUp() throws OperationNotSupportedException {
        listIterator = new ListIterator(NAMES);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWithNull() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testConstructorShouldCreate() throws OperationNotSupportedException {
        new ListIterator(NAMES);
        assertEquals(NAMES[0], listIterator.print());
        listIterator.move();
        assertEquals(NAMES[1], listIterator.print());
        listIterator.move();
        assertEquals(NAMES[2], listIterator.print());
    }

    @Test
    public void testHasNext() {
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertFalse(listIterator.hasNext());
    }

    @Test
    public void testMove() {
        listIterator.move();
        assertTrue(listIterator.move());
        assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintShouldThrowIfListIsEmpty() throws OperationNotSupportedException {
        ListIterator emptyIterator = new ListIterator();
        emptyIterator.print();
    }

    @Test
    public void testPrintShouldWork() {
        assertEquals(NAMES[0], listIterator.print());
        listIterator.move();
        assertEquals(NAMES[1], listIterator.print());
    }
}