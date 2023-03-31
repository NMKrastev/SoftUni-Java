package _13_JavaOOPExam_14August2022.footballUnitTest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FootballTeamTests {

    private static final String INVALID_NAME = "Invalid name.";
    private static final String INVALID_POSITION = "Invalid vacant position.";
    private static final String TEAM_IS_FULL = "Football team is full.";
    private static final String PLAYER_NOT_IN_TEAM = "A footballer named %s is not on the soccer team.";
    private static final String PLAYER_IS_IN_TEAM = "The footballer %s is in the team %s.";

    private FootballTeam footballTeamOne;
    private Footballer footballerOne;
    private Footballer footballerTwo;
    private Footballer footballerThree;

    @Before
    public void setUp() {
        this.footballTeamOne = new FootballTeam("TeamOne", 2);
        this.footballerOne = new Footballer("Ivan");
        this.footballerTwo = new Footballer("Peter");
        this.footballerThree = new Footballer("Alex");
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorShouldThrowIfNameIsNull() {
        try {
            FootballTeam footballTeamTwo = new FootballTeam(null, 2);
        } catch (NullPointerException e) {
            assertEquals(INVALID_NAME, e.getMessage());
            throw e;
        }
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorShouldThrowIfNameIsEmpty() {
        try {
            FootballTeam footballTeamTwo = new FootballTeam("  ", 2);
        } catch (NullPointerException e) {
            assertEquals(INVALID_NAME, e.getMessage());
            throw e;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorShouldThrowIfVacantPositionIsBelowZero() {
        try {
            FootballTeam footballTeamTwo = new FootballTeam("name", -1);
        } catch (IllegalArgumentException e) {
            assertEquals(INVALID_POSITION, e.getMessage());
            throw e;
        }
    }

    @Test
    public void testAddFootballerShouldWork() {
        assertEquals(0, this.footballTeamOne.getCount());
        assertEquals(2, this.footballTeamOne.getVacantPositions());
        assertEquals("TeamOne", this.footballTeamOne.getName());
        this.footballTeamOne.addFootballer(this.footballerOne);
        assertEquals(1, this.footballTeamOne.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFootballerShouldThrowIfThereIsNotEnoughCapacity() {
        this.footballTeamOne.addFootballer(this.footballerOne);
        this.footballTeamOne.addFootballer(this.footballerTwo);
        try {
            this.footballTeamOne.addFootballer(this.footballerThree);
        } catch (IllegalArgumentException e) {
            assertEquals(TEAM_IS_FULL, e.getMessage());
            throw e;
        }
    }

    @Test
    public void testRemovePlayerShouldWork() {
        this.footballTeamOne.addFootballer(this.footballerOne);
        this.footballTeamOne.addFootballer(this.footballerTwo);
        assertEquals(2, this.footballTeamOne.getCount());
        this.footballTeamOne.removeFootballer(this.footballerTwo.getName());
        assertEquals(1, this.footballTeamOne.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovePlayerShouldThrowIfPlayerNameDoesNotExist() {
        this.footballTeamOne.addFootballer(this.footballerOne);
        this.footballTeamOne.addFootballer(this.footballerTwo);
        assertEquals(2, this.footballTeamOne.getCount());
        try {
            this.footballTeamOne.removeFootballer("Petkan");
        } catch (IllegalArgumentException e) {
            assertEquals(String.format(PLAYER_NOT_IN_TEAM, "Petkan"), e.getMessage());
            throw e;
        }
    }

    @Test
    public void testFootballerForSaleShouldWork() {
        this.footballTeamOne.addFootballer(this.footballerOne);
        this.footballTeamOne.footballerForSale("Ivan");
        assertFalse(this.footballerOne.isActive());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFootballerForSaleShouldThrowIfPlayerNameDoesNotExist() {
        this.footballTeamOne.addFootballer(this.footballerOne);
        try {
            this.footballTeamOne.footballerForSale("Foncho");
        } catch (IllegalArgumentException e) {
            assertEquals(String.format(PLAYER_NOT_IN_TEAM, "Foncho"), e.getMessage());
            throw e;
        }
    }

    @Test
    public void testGetStatisticsShouldReturnAllPlayers() {
        this.footballTeamOne.addFootballer(this.footballerOne);
        this.footballTeamOne.addFootballer(this.footballerTwo);
        String names = "Ivan, Peter";
        String expected = String.format(PLAYER_IS_IN_TEAM, names, "TeamOne");
        String actual = this.footballTeamOne.getStatistics();
        assertEquals(expected, actual);
    }
}
