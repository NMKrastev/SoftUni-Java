package JavaOOPExam_12December2020.bankSafe;

import JavaOOPExam_12December2020.bankSafe.BankVault;
import JavaOOPExam_12December2020.bankSafe.Item;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

import static org.junit.Assert.*;

public class BankVaultTest {

    private static final String CELL_DOES_NOT_EXIST = "Cell doesn't exist!";
    private static final String CELL_ALREADY_TAKEN = "Cell is already taken!";
    private static final String ITEM_ALREADY_IN_CELL = "Item is already in cell";
    private static final String ITEM_IN_CELL_DOES_NOT_EXIST = "Item in that cell doesn't exists!";
    private static final String ITEM_SAVED = "Item:%s saved successfully!";
    private static final String ITEM_REMOVED = "Remove item:%s successfully!";

    private Item itemOne = new Item("Ivan", "1");
    private Item itemTwo = new Item("Peter", "2");
    private static final String CELL = "A1";
    private static final String NON_EXISTENT_CELL = "G1";
    private BankVault bankVault;
    private Map<String, Item> vaultCells;

    @Before
    public void setUp() {
        this.bankVault = new BankVault();
        this.vaultCells = this.bankVault.getVaultCells();
    }

    @Test
    public void testGetVaultCellsShouldReturnMap() {
        assertEquals(this.vaultCells.get(CELL), this.bankVault.getVaultCells().get(CELL));
        assertEquals(this.vaultCells, this.bankVault.getVaultCells());
        assertEquals(this.vaultCells.size(), this.bankVault.getVaultCells().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemShouldThrowIfCellDoesNotExist() throws OperationNotSupportedException, IllegalArgumentException {
        try {
            this.bankVault.addItem(NON_EXISTENT_CELL, itemOne);
        } catch (IllegalArgumentException e) {
            assertEquals(CELL_DOES_NOT_EXIST, e.getMessage());
            throw e;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemShouldThrowIfCellIsAlreadyTaken() throws OperationNotSupportedException, IllegalArgumentException {
        this.bankVault.addItem(CELL, itemOne);
        try {
            this.bankVault.addItem(CELL, itemTwo);
        } catch (IllegalArgumentException e) {
            assertEquals(CELL_ALREADY_TAKEN, e.getMessage());
            throw e;
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddItemShouldThrowIfItemAlreadyExist() throws OperationNotSupportedException, IllegalArgumentException {
        this.bankVault.addItem(CELL, itemOne);
        try {
            this.bankVault.addItem("A2", itemOne);
        } catch (OperationNotSupportedException e) {
            assertEquals(ITEM_ALREADY_IN_CELL, e.getMessage());
            throw e;
        }
    }

    @Test
    public void testAddItemShouldPutItemToCell() throws OperationNotSupportedException, IllegalArgumentException {
        assertEquals(String.format(ITEM_SAVED, itemOne.getItemId()), this.bankVault.addItem(CELL, itemOne));
        String expectedOwner = this.bankVault.getVaultCells().get(CELL).getOwner();
        assertEquals(expectedOwner, this.bankVault.getVaultCells().get(CELL).getOwner());
        Item expected = this.bankVault.getVaultCells().get(CELL);
        assertEquals(expected, this.bankVault.getVaultCells().get(CELL));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemShouldThrowIfCellDoesntExist() {
        try {
            this.bankVault.removeItem(NON_EXISTENT_CELL, itemOne);
        } catch (IllegalArgumentException e) {
            assertEquals("Cell doesn't exists!", e.getMessage());
            throw e;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemShouldThrowIfItemInCellDoesNotExist() {
        try {
            this.bankVault.removeItem(CELL, itemOne);
        } catch (IllegalArgumentException e) {
            assertEquals(ITEM_IN_CELL_DOES_NOT_EXIST, e.getMessage());
            throw e;
        }
    }

    @Test
    public void testRemoveItemShouldWork() throws OperationNotSupportedException, IllegalArgumentException {
        this.bankVault.addItem(CELL, itemOne);
        assertEquals(String.format(ITEM_REMOVED, itemOne.getItemId()), this.bankVault.removeItem(CELL, itemOne));
        assertNull(this.bankVault.getVaultCells().get(CELL));
    }
}