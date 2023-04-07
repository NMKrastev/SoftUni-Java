package _16_JavaOOPRetakeExam_19December2022.magicGameUnitTests;

import _16_JavaOOPRetakeExam_19December2022.magicGameUnitTests.Magic;
import _16_JavaOOPRetakeExam_19December2022.magicGameUnitTests.Magician;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MagicianTests {

    private static final String NAME_NULL = "Cannot be null!";
    private static final String HEALTH_BELOW_ZERO = "Health cannot be bellow zero!";
    private static final String MAGICIAN_DEAD = "Magician is dead!";
    private static final String MAGIC_NULL = "Magic cannot be null!";

    private Magic magicOne;
    private Magic magicTwo;
    private Magic magicThree;
    private Magician magician;

    @Before
    public void setUp() {
        this.magicOne = new Magic("MagicOne", 50);
        this.magicTwo = new Magic("MagicTwo", 75);
        this.magicThree = new Magic("MagicThree", 100);
        this.magician = new Magician("MagicianOne", 100);
    }

    @Test
    public void testConstructor() {
        assertEquals("MagicianOne", this.magician.getUsername());
        assertEquals(100, this.magician.getHealth());
        assertTrue(this.magician.getMagics().isEmpty());
        assertEquals(50, this.magicOne.getBullets());
    }

    @Test(expected = NullPointerException.class)
    public void testSetUsernameShouldThrowIfNameIsNull() {
        try {
            Magician two = new Magician(null, 100);
        } catch (NullPointerException e) {
            assertEquals(NAME_NULL, e.getMessage());
            throw e;
        }
    }

    @Test(expected = NullPointerException.class)
    public void testSetUsernameShouldThrowIfNameIsEmpty() {
        try {
            Magician two = new Magician("  ", 100);
        } catch (NullPointerException e) {
            assertEquals(NAME_NULL, e.getMessage());
            throw e;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHealthShouldThrowIfHealthIsBelowZero() {
        try {
            Magician two = new Magician("Two", -1);
        } catch (IllegalArgumentException e) {
            assertEquals(HEALTH_BELOW_ZERO, e.getMessage());
            throw e;
        }
    }

    @Test
    public void testTakeDamageShouldTakeHealthPointsFromMagician() {
        assertEquals(100, this.magician.getHealth());
        this.magician.takeDamage(5);
        assertEquals(95, this.magician.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageShouldThrowIfMagicianIsDead() {
        assertEquals(100, this.magician.getHealth());
        this.magician.takeDamage(110);
        assertEquals(0, this.magician.getHealth());
        try {
            this.magician.takeDamage(110);
        } catch (IllegalStateException e) {
            assertEquals(MAGICIAN_DEAD, e.getMessage());
            throw e;
        }
    }

    @Test
    public void testAddMagicShouldWork() {
        this.magician.addMagic(this.magicOne);
        assertEquals(this.magicOne, this.magician.getMagic("MagicOne"));
    }

    @Test(expected = NullPointerException.class)
    public void testAddMagicShouldThrowIfMagicIsNull() {
        try {
            this.magician.addMagic(null);
        } catch (NullPointerException e) {
            assertEquals(MAGIC_NULL, e.getMessage());
            throw e;
        }
    }

    @Test
    public void testRemoveMagicShouldReturnBoolean() {
        this.magician.addMagic(this.magicOne);
        assertFalse(this.magician.removeMagic(this.magicTwo));
        assertTrue(this.magician.removeMagic(this.magicOne));
    }
}
