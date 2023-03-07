package p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {

    private static final int NEGATIVE_INDEX = -2;
    private static final int INDEX_BIGGER_THAN_SIZE = 5;
    private static final int VALID_INDEX = 1;
    private static final int NEGATIVE_RETURN = -1;
    private static final String NAME = "Kiro";
    private static final String EXPECTED_NAME = "Peter";
    private CustomLinkedList<String> linkedList;

    @Before
    public void setUp() {
        linkedList = new CustomLinkedList<>();
        linkedList.add("Ivan");
        linkedList.add("Peter");
        linkedList.add("Alex");
    }


    @Test
    public void testAddShouldWork() {
        int previousSize = linkedList.getCount();
        linkedList.add(NAME);
        int currentSize = linkedList.getCount();
        assertEquals(previousSize + 1, currentSize);
        assertEquals(linkedList.getCount() - 1, linkedList.indexOf("Kiro"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetShouldThrowWithNegativeIndex() {
        linkedList.get(NEGATIVE_INDEX);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetShouldThrowWithBiggerThanSizeIndex() {
        linkedList.get(INDEX_BIGGER_THAN_SIZE);
    }

    @Test
    public void testGetShouldReturnElementOnIndex() {
        assertEquals(EXPECTED_NAME, linkedList.get(VALID_INDEX));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetShouldThrowWithNegativeIndex() {
        linkedList.set(NEGATIVE_INDEX, NAME);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetShouldThrowWithWithBiggerThanSizeIndex() {
        linkedList.set(INDEX_BIGGER_THAN_SIZE, NAME);
    }

    @Test
    public void testSetShouldSetElementOnIndex() {
        linkedList.set(VALID_INDEX, NAME);
        int expectedIndex = 1;
        assertEquals(NAME, linkedList.get(VALID_INDEX));
        assertEquals(expectedIndex, linkedList.indexOf(NAME));
    }

    @Test
    public void testRemoveShouldReturnNegativeNumberIfItemNotFound() {
        assertEquals(NEGATIVE_RETURN, linkedList.remove(NAME));
    }

    @Test
    public void testRemoveShouldReturnCurrentIndexIfItemIsFound() {
        assertEquals(VALID_INDEX, linkedList.remove(EXPECTED_NAME));
    }

    @Test
    public void testIndexOfShouldReturnNegativeNumberIfItemIsNotFound() {
        assertEquals(NEGATIVE_RETURN, linkedList.indexOf(NAME));
    }

    @Test
    public void testContainsItemShouldWork() {
        assertTrue(linkedList.contains(EXPECTED_NAME));
        assertFalse(linkedList.contains(NAME));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtShouldThrowNegativeIndex() {
        linkedList.removeAt(NEGATIVE_INDEX);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtShouldThrowBiggerThanSizeIndex() {
        linkedList.removeAt(INDEX_BIGGER_THAN_SIZE);
    }

    @Test
    public void testRemoveAtShouldRemoveItem() {
        assertEquals(EXPECTED_NAME, linkedList.removeAt(VALID_INDEX));
    }

    @Test
    public void testRemoveListNodeShouldBeNullIfListIsEmpty() {

    }
}