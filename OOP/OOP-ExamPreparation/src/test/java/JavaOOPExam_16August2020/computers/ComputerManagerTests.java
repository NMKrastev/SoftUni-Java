package JavaOOPExam_16August2020.computers;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ComputerManagerTests {

    private ComputerManager computerManager;
    private Computer computerOne;
    private Computer computerTwo;

    @Before
    public void setUp(){
        computerManager = new ComputerManager();
        computerOne = new Computer("Razer", "X500", 1000);
        computerTwo = new Computer("Razer", "Z300", 500);
        computerManager.addComputer(computerOne);
        computerManager.addComputer(computerTwo);
    }

    @Test
    public void testCountShouldWork() {
        int expectedCount = 2;
        assertEquals(expectedCount, computerManager.getCount());
    }

    @Test
    public void testGetComputersAsAListShouldWork(){
        List<Computer> expected = List.of(computerOne, computerTwo);
        assertEquals(expected, computerManager.getComputers());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testComputerThatAlreadyExist() {
        computerManager.addComputer(computerOne);
    }

    @Test
    public void testRemoveComputerShouldWork() {
        assertEquals(computerOne, computerManager.removeComputer("Razer", "X500"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveComputerShouldNotWork() {
        assertEquals(computerOne, computerManager.removeComputer("Test", "Test"));
    }

    @Test
    public void testGetComputersByManufacturerShouldWork(){
        List<Computer> expectedList = List.of(computerOne, computerTwo);
        assertEquals(expectedList, computerManager.getComputersByManufacturer("Razer"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateNullValueShouldWork() {
        List<Computer> expectedList = List.of(computerOne, computerTwo);
        assertEquals(expectedList, computerManager.getComputersByManufacturer(null));
    }
}