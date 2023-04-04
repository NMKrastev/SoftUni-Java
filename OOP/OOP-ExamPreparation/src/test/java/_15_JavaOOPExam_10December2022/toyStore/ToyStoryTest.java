package _15_JavaOOPExam_10December2022.toyStore;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ToyStoryTest {

    private static final String SHELF_DOES_NOT_EXIST = "Shelf doesn't exist!";
    private static final String SHELF_DOES_NOT_EXISTS = "Shelf doesn't exists!";
    private static final String SHELF_ALREADY_TAKEN = "Shelf is already taken!";
    private static final String TOY_ALREADY_IN_SHELF = "Toy is already in shelf!";
    private static final String TOY_ADDED = "Toy:%s placed successfully!";
    private static final String TOY_REMOVED = "Remove toy:%s successfully!";
    private static final String TOY_DOES_NOT_EXIST = "Toy in that shelf doesn't exists!";

    private ToyStore toyStore;
    private Map<String, Toy> toyShelf;
    private Toy toyOne;
    private Toy toyTwo;

    @Before
    public void setUp() {
        this.toyStore = new ToyStore();
        this.toyOne = new Toy("One", "1");
        this.toyTwo = new Toy("Two", "2");
        this.toyShelf = new LinkedHashMap<>();
        this.toyShelf.put("A", null);
        this.toyShelf.put("B", null);
        this.toyShelf.put("C", null);
        this.toyShelf.put("D", null);
        this.toyShelf.put("E", null);
        this.toyShelf.put("F", null);
        this.toyShelf.put("G", null);
    }

    @Test
    public void testConstructorShouldInitializeStore() {
        assertEquals(this.toyShelf.get("A"), this.toyStore.getToyShelf().get("A"));
        assertEquals(toyShelf, this.toyStore.getToyShelf());
        assertEquals(this.toyShelf.size(), this.toyStore.getToyShelf().size());
    }

    @Test
    public void testAddToyShouldPlaceToyInShelf() throws OperationNotSupportedException {
        assertEquals(String.format(TOY_ADDED, this.toyOne.getToyId()), this.toyStore.addToy("A", this.toyOne));
        String actualManufacturer = this.toyStore.getToyShelf().get("A").getManufacturer();
        String actualId = this.toyStore.getToyShelf().get("A").getToyId();
        assertEquals("One", actualManufacturer);
        assertEquals("1", actualId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToyShouldThrowIfShelfDoesNotExist() throws OperationNotSupportedException, IllegalArgumentException {
        try {
            this.toyStore.addToy("Z", this.toyOne);
        } catch (IllegalArgumentException e) {
            assertEquals(SHELF_DOES_NOT_EXIST, e.getMessage());
            throw e;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToyShouldThrowIfShelfIsAlreadyTaken() throws OperationNotSupportedException, IllegalArgumentException {
        this.toyStore.addToy("A", this.toyOne);
        try {
            this.toyStore.addToy("A", this.toyTwo);
        } catch (IllegalArgumentException e) {
            assertEquals(SHELF_ALREADY_TAKEN, e.getMessage());
            throw e;
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddToyShouldThrowIfToyIsAlreadyInTheShelf() throws OperationNotSupportedException, IllegalArgumentException {
        this.toyStore.addToy("A", this.toyOne);
        try {
            this.toyStore.addToy("B", this.toyOne);
        } catch (OperationNotSupportedException e) {
            assertEquals(TOY_ALREADY_IN_SHELF, e.getMessage());
            throw e;
        }
    }

    @Test
    public void testRemoveToyShouldRemoveToyFromShelf() throws OperationNotSupportedException {
        this.toyStore.addToy("A", this.toyOne);
        String actual = this.toyStore.removeToy("A", this.toyOne);
        assertEquals(String.format(TOY_REMOVED, this.toyOne.getToyId()), actual);
        assertNull(this.toyStore.getToyShelf().get("A"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyShouldThrowIfShelfDoesNotExist() throws OperationNotSupportedException {
        try {
            this.toyStore.removeToy("Z", this.toyOne);
        } catch (IllegalArgumentException e) {
            assertEquals(SHELF_DOES_NOT_EXISTS, e.getMessage());
            throw e;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyShouldThrowIfToyInShelfDoesNotExist() throws OperationNotSupportedException {
        try {
            this.toyStore.removeToy("A", this.toyTwo);
        } catch (IllegalArgumentException e) {
            assertEquals(TOY_DOES_NOT_EXIST, e.getMessage());
            throw e;
        }
    }
}