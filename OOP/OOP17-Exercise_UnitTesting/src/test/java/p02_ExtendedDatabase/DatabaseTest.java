package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private Database database;
    private Person ivan = new Person(1, "Ivan");
    private Person peter = new Person(2, "Peter");
    private Person alex = new Person(3, "Alex");
    private Person nullPerson;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(ivan, peter);
        nullPerson = null;
    }

    @Test
    public void testConstructorShouldCreateValidDB() {
        Person[] dbElements = database.getElements();
        assertArrayEquals(dbElements, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWithMoreThan16Elements() throws OperationNotSupportedException {
        Person[] elements = new Person[17];
        database = new Database(elements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWithNoElements() throws OperationNotSupportedException {
        Person[] elements = new Person[0];
        database = new Database(elements);
    }

    @Test
    public void testAddShouldWork() throws OperationNotSupportedException {
        Person[] dbElementsBeforeAdd = database.getElements();
        database.add(alex);
        Person[] dbElementsAfterAdd = database.getElements();
        assertEquals(dbElementsBeforeAdd.length + 1, dbElementsAfterAdd.length);
        assertEquals(alex, dbElementsAfterAdd[dbElementsAfterAdd.length - 1]);
        assertEquals(dbElementsAfterAdd.length, database.getElements().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowWhenPersonIsNull() throws OperationNotSupportedException {
        database.add(nullPerson);
    }

    @Test
    public void testRemoveShouldWork() throws OperationNotSupportedException {
        Person[] elementsBeforeRemove = database.getElements();
        database.remove();
        Person[] elementsAfterRemove = database.getElements();
        assertEquals(elementsBeforeRemove.length - 1, elementsAfterRemove.length);
        assertEquals(elementsBeforeRemove[elementsBeforeRemove.length - 2], elementsAfterRemove[elementsAfterRemove.length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowWhenElementAreNull() throws OperationNotSupportedException {
        Person[] dbElements = database.getElements();
        for (int i = 0; i < dbElements.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldThrowWithNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldTrowIfMissing() throws OperationNotSupportedException {
        database.findByUsername("Kiko");
    }

    @Test
    public void testFindByUsernameShouldReturnPerson() throws OperationNotSupportedException {
        Person person = database.findByUsername("Ivan");
        assertEquals(person.getId(), ivan.getId());
        assertEquals(person.getUsername(), ivan.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdShouldThrowWhenEmpty() throws OperationNotSupportedException {
        database.findById(5);
    }

    @Test
    public void testFindByIdShouldReturnPerson() throws OperationNotSupportedException {
        Person person = database.findById(1);
        assertEquals(person.getId(), ivan.getId());
        assertEquals(person.getUsername(), ivan.getUsername());
    }
}