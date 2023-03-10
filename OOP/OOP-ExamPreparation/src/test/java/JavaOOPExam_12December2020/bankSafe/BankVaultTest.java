package JavaOOPExam_12December2020.bankSafe;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

import static org.junit.Assert.*;

public class BankVaultTest {

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
        this.bankVault.addItem(NON_EXISTENT_CELL, itemOne);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemShouldThrowIfCellIsAlreadyTaken() throws OperationNotSupportedException, IllegalArgumentException {
        this.bankVault.addItem(CELL, itemOne);
        this.bankVault.addItem(CELL, itemTwo);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddItemShouldThrowIfItemAlreadyExist() throws OperationNotSupportedException, IllegalArgumentException {
        this.bankVault.addItem(CELL, itemOne);
        this.bankVault.addItem("A2", itemOne);
    }

    @Test
    public void testAddItemShouldPutItemToCell() throws OperationNotSupportedException, IllegalArgumentException {
        this.bankVault.addItem(CELL, itemOne);
        Item expected = this.bankVault.getVaultCells().get(CELL);
        assertEquals(expected, this.bankVault.getVaultCells().get(CELL));
    }

    @Test
    public void testAddItemShouldReturnCorrectOwner() throws OperationNotSupportedException, IllegalArgumentException {
        this.bankVault.addItem(CELL, itemOne);
        String expectedOwner = this.bankVault.getVaultCells().get(CELL).getOwner();
        assertEquals(expectedOwner, this.bankVault.getVaultCells().get(CELL).getOwner());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemShouldThrowIfCellDoesntExist() {
        this.bankVault.removeItem(NON_EXISTENT_CELL, itemOne);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemShouldThrowIfItemInCellDoesNotExist() {
        this.bankVault.removeItem(CELL, itemOne);
    }

    @Test
    public void testRemoveItemShouldWork() throws OperationNotSupportedException, IllegalArgumentException {
        this.bankVault.addItem(CELL, itemOne);
        this.bankVault.removeItem(CELL, itemOne);
        assertNull(this.bankVault.getVaultCells().get(CELL));
    }
}