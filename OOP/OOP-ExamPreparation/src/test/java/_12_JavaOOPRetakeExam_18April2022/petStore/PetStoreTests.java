package _12_JavaOOPRetakeExam_18April2022.petStore;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PetStoreTests {

    private static final String ANIMAL_CANNOT_BE_NULL = "Animal can't be null";

    private PetStore petStore;
    private Animal animalOne;
    private Animal animalTwo;
    private Animal animalThree;

    @Before
    public void setUp() {
        this.petStore = new PetStore();
        this.animalOne = new Animal("Cat", 10, 100);
        this.animalTwo = new Animal("Dog", 60, 200);
        this.animalThree = new Animal("Bird", 2, 300);
    }

    @Test
    public void testAddAnimalShouldWork() {
        assertEquals(0, this.petStore.getCount());
        this.petStore.addAnimal(this.animalOne);
        assertEquals(1, this.petStore.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalShouldThrowIfAnimalIsNull() {
        try {
            this.petStore.addAnimal(null);
        } catch (IllegalStateException e) {
            assertEquals(ANIMAL_CANNOT_BE_NULL, e.getMessage());
            throw e;
        }
    }

    @Test
    public void testFindAllAnimalsWithMaxKilogramsShouldReturnAnimalsWithMaxKg() {
        addAnimalsToPetStore();
        List<Animal> maxKgExpected = List.of(this.animalTwo);
        assertEquals(maxKgExpected, this.petStore.findAllAnimalsWithMaxKilograms(10));
    }

    @Test
    public void testGetTheMostExpensiveAnimalShouldReturnMostExpensiveAnimal() {
        addAnimalsToPetStore();
        assertEquals(this.animalThree, this.petStore.getTheMostExpensiveAnimal());
    }

    @Test
    public void testFindAllAnimalBySpecieShouldReturnAllAnimalsFromSpecie() {
        addAnimalsToPetStore();
        List<Animal> animalsBySpecieExpected = List.of(this.animalTwo);
        assertEquals(animalsBySpecieExpected, this.petStore.findAllAnimalBySpecie("Dog"));
    }

    @Test
    public void testGetListShouldReturnAllAnimals() {
        addAnimalsToPetStore();
        List<Animal> expected = List.of(this.animalOne, this.animalTwo, this.animalThree);
        assertEquals(expected, this.petStore.getAnimals());
    }

    private void addAnimalsToPetStore() {
        this.petStore.addAnimal(this.animalOne);
        this.petStore.addAnimal(this.animalTwo);
        this.petStore.addAnimal(this.animalThree);
    }
}

