package _11_JavaOOPExam09April2022.gifts;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GiftFactoryTests {

    private static final String GIFT_EXISTS = "gifts. Gift with name %s already exists.";
    private static final String GIFT_ADDED = "Successfully added gift %s with magic %.2f.";
    private static final String NAME_CANNOT_BE_NULL = "Name cannot be null.";

    private GiftFactory giftFactory;
    private Gift giftOne;
    private Gift giftTwo;
    private Gift giftThree;

    @Before
    public void setUp() {
        giftFactory = new GiftFactory();
        this.giftOne = new Gift("TypeOne", 10.0);
        this.giftTwo = new Gift("TypeTwo", 20.0);
        this.giftThree = new Gift("TypeThree", 30.0);
    }

    @Test
    public void testCreateGiftShouldWork() {
        assertEquals(0, this.giftFactory.getCount());
        assertEquals(String.format(GIFT_ADDED, this.giftOne.getType(), this.giftOne.getMagic()),
                this.giftFactory.createGift(this.giftOne));
        assertEquals(1, this.giftFactory.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateGiftShouldThrowIfGiftWithNameAlreadyExist() {
        this.giftFactory.createGift(this.giftOne);
        try {
            this.giftFactory.createGift(this.giftOne);
        } catch (IllegalArgumentException e) {
            assertEquals(String.format(GIFT_EXISTS, this.giftOne.getType()), e.getMessage());
            throw e;
        }
    }

    @Test
    public void testRemoveGiftShouldWork() {
        this.giftFactory.createGift(this.giftOne);
        assertTrue(this.giftFactory.removeGift(this.giftOne.getType()));
        assertEquals(0, this.giftFactory.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveGiftShouldThrowIfNameIsNull() {
        this.giftFactory.createGift(this.giftOne);
        try {
            this.giftFactory.removeGift(null);
        } catch (NullPointerException e) {
            assertEquals(NAME_CANNOT_BE_NULL, e.getMessage());
            throw e;
        }
    }

    @Test
    public void testGetPresentWithLeastMagicShouldReturnPresentWithSmallestAmountOfMagic() {
        this.giftFactory.createGift(this.giftOne);
        this.giftFactory.createGift(this.giftTwo);
        this.giftFactory.createGift(this.giftThree);
        Gift actualGift = this.giftFactory.getPresentWithLeastMagic();
        assertEquals(this.giftOne, actualGift);
    }

    @Test
    public void testGetPresentShouldReturnPresentByName() {
        this.giftFactory.createGift(this.giftOne);
        this.giftFactory.createGift(this.giftTwo);
        this.giftFactory.createGift(this.giftThree);
        Gift actualGift = this.giftFactory.getPresent(this.giftTwo.getType());
        assertEquals(this.giftTwo, actualGift);
    }

    @Test
    public void testGetPresentsShouldReturnCollectionOfPresents() {
        this.giftFactory.createGift(this.giftOne);
        this.giftFactory.createGift(this.giftTwo);
        this.giftFactory.createGift(this.giftThree);
        List<Gift> expected = List.of(this.giftOne, this.giftTwo, this.giftThree);
        List<Gift> actual = new ArrayList<>(this.giftFactory.getPresents());
        assertEquals(expected, actual);
    }
}
