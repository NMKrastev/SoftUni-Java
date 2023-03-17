package _07_JavaOOPExam_15August2021.shopAndGoods;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Collections;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ShopTest {

    private static final String SHELF_DOES_NOT_EXIST = "The shelf doesn't exist!";
    private static final String SHELF_ALREADY_TAKEN = "The shelf is already taken!";
    private static final String GOODS_ALREADY_IN_SHELF = "Goods is already in shelf!";
    private static final String GOODS_PLACED_SUCCESSFULLY = "Goods: %s is placed successfully!";
    private static final String GOODS_IN_SHELF_DOES_NOT_EXIST = "Goods in that shelf doesn't exists!";
    private static final String GOODS_REMOVED_SUCCESSFULLY = "Goods: %s is removed successfully!";

    private Shop shop;
    private Goods goodOne;
    private Goods goodTwo;

    @Before
    public void setUp() {
        this.shop = new Shop();
        this.goodOne = new Goods("Good One", "111");
        this.goodTwo = new Goods("Good Two", "222");
    }

    @Test
    public void testGetShelvesShouldReturnMap() {
        Map<String, Goods> unmodifiable = Collections.unmodifiableMap(this.shop.getShelves());
        assertEquals(unmodifiable.size(), this.shop.getShelves().size());
        assertEquals(unmodifiable, this.shop.getShelves());
        for (Goods value : this.shop.getShelves().values()) {
            assertNull(value);
        }
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetShelvesShouldThrowIfThereIsIllegalAccess() {
        this.shop.getShelves().put("Shelves13", this.goodTwo);
        this.shop.getShelves().remove("Shelves1", this.goodTwo);
    }

    @Test
    public void testAddGoodsShouldWork() throws OperationNotSupportedException {
        assertEquals(12, this.shop.getShelves().size());
        assertEquals(String.format(GOODS_PLACED_SUCCESSFULLY, this.goodOne.getGoodsCode()), this.shop.addGoods("Shelves1", this.goodOne));
        assertEquals(this.goodOne.getName(), this.shop.getShelves().get("Shelves1").getName());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddGoodsShouldThrowIfShelfDoesNotExist() throws OperationNotSupportedException {
        try {
            this.shop.addGoods("Shelves20", this.goodOne);
        } catch (IllegalArgumentException e) {
            assertEquals(SHELF_DOES_NOT_EXIST, e.getMessage());
            throw e;
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddGoodsShouldThrowIfShelfIsAlreadyTaken() throws OperationNotSupportedException {
        this.shop.addGoods("Shelves1", this.goodOne);
        try {
            this.shop.addGoods("Shelves1", this.goodTwo);
        } catch (IllegalArgumentException e) {
            assertEquals(SHELF_ALREADY_TAKEN, e.getMessage());
            throw e;
        }
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddGoodsShouldThrowIfGoodIsAlreadyInShelf() throws OperationNotSupportedException {
        this.shop.addGoods("Shelves1", this.goodOne);
        try {
            this.shop.addGoods("Shelves2", this.goodOne);
        } catch (OperationNotSupportedException e) {
            assertEquals(GOODS_ALREADY_IN_SHELF, e.getMessage());
            throw e;
        }
    }

    @Test
    public void testRemoveGoodsShouldWork() throws OperationNotSupportedException {
        this.shop.addGoods("Shelves1", this.goodOne);
        assertEquals(String.format(GOODS_REMOVED_SUCCESSFULLY, this.goodOne.getGoodsCode()), this.shop.removeGoods("Shelves1", this.goodOne));
        assertNull(this.shop.getShelves().get("Shelves1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsShouldThrowIfShelfDoesNotExist() {
        try {
            this.shop.removeGoods("Shelves20", this.goodOne);
        } catch (IllegalArgumentException e) {
            assertEquals(SHELF_DOES_NOT_EXIST, e.getMessage());
            throw e;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsShouldThrowIfGoodsDoesNotExist() {
        try {
            this.shop.removeGoods("Shelves1", this.goodOne);
        } catch (IllegalArgumentException e) {
            assertEquals(GOODS_IN_SHELF_DOES_NOT_EXIST, e.getMessage());
            throw e;
        }
    }
}