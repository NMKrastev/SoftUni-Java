package _06_JavaOOPRetakeExam_18April2021.heroRepository;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.*;

public class HeroRepositoryTests {

    private static final String HERO_NULL = "Hero is null";
    private static final String HERO_WITH_NAME_EXIST = "Hero with name %s already exists";
    private static final String HERO_ADDED_SUCCESSFULLY = "Successfully added hero %s with level %d";
    private static final String HERO_NAME_CANNOT_BE_NULL = "Name cannot be null";

    private HeroRepository heroRepository;
    private Hero heroOne;
    private Hero heroTwo;
    private Collection<Hero> collection;

    @Before
    public void setUp() {
        this.heroRepository = new HeroRepository();
        this.heroOne = new Hero("Ivan", 99);
        this.heroTwo = new Hero("Peter", 90);
        this.collection = new ArrayList<>();
    }

    @Test
    public void testCreateShouldAddHeroToCollection() {
        assertEquals(0, this.heroRepository.getCount());
        assertEquals(String.format(HERO_ADDED_SUCCESSFULLY, this.heroOne.getName(), this.heroOne.getLevel())
                , this.heroRepository.create(this.heroOne));
        assertEquals(1, this.heroRepository.getCount());
        assertEquals(this.heroOne.getName(), this.heroRepository.getHero("Ivan").getName());
    }

    @Test
    public void testGetHeroShouldReturnNullIfHeroDoesNotExist() {
        this.heroRepository.create(this.heroOne);
        assertNull(this.heroRepository.getHero("Alex"));
    }

    @Test(expected = NullPointerException.class)
    public void testCreateShouldThrowIfHeroIsNull() {
        try {
            this.heroRepository.create(null);
        } catch (NullPointerException e) {
            assertEquals(HERO_NULL, e.getMessage());
            throw e;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateShouldThrowIfHeroWithThatNameExists() {
        this.heroRepository.create(this.heroOne);
        try {
            this.heroRepository.create(this.heroOne);
        } catch (IllegalArgumentException e) {
            assertEquals(HERO_WITH_NAME_EXIST, e.getMessage());
            throw e;
        }
    }

    @Test
    public void testRemoveShouldRemoveHeroFromCollection() {
        assertEquals(0, this.heroRepository.getCount());
        this.heroRepository.create(this.heroOne);
        assertEquals(1, this.heroRepository.getCount());
        this.heroRepository.remove(this.heroOne.getName());
        assertEquals(0, this.heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveShouldThrowIfHeroNameIsNull() {
        assertEquals(0, this.heroRepository.getCount());
        this.heroRepository.create(this.heroOne);
        assertEquals(1, this.heroRepository.getCount());
        try {
            this.heroRepository.remove(null);
        } catch (NullPointerException e) {
            assertEquals(HERO_NAME_CANNOT_BE_NULL, e.getMessage());
            assertEquals(1, this.heroRepository.getCount());
            throw e;
        }
    }

    @Test
    public void testGetHeroWithHighestLevelShouldReturnHeroWithHighestLevel() {
        this.heroRepository.create(this.heroOne);
        this.heroRepository.create(this.heroTwo);
        assertEquals(this.heroOne, this.heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHeroWithHighestLevelShouldReturnNullIfThereAreNoHeroes() {
        assertNull(this.heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHeroesShouldReturnCollectionOfHeroes() {
        this.collection.add(this.heroOne);
        this.collection.add(this.heroTwo);
        this.heroRepository.create(this.heroOne);
        this.heroRepository.create(this.heroTwo);
        Collection<Hero> unmodifiable = Collections.unmodifiableCollection(this.collection);
        assertArrayEquals(unmodifiable.toArray(), this.heroRepository.getHeroes().toArray());
    }
}
