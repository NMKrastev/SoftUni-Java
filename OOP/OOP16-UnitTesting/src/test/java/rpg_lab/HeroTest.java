package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class HeroTest {

    private static final int TARGET_XP = 10;
    private static final String HERO_NAME = "Ivan";
    private static final int ATTACK = 10;
    private static final int DURABILITY = 10;
    Hero hero;
    Weapon weapon;

    @Before
    public void setUp() throws Exception {
        weapon = new Axe(ATTACK, DURABILITY);
        hero = new Hero(HERO_NAME, weapon);
    }

    @Test
    public void testDemo() {

        Weapon weapon = new Weapon() {
            @Override
            public int getAttackPoints() {
                return 10;
            }

            @Override
            public int getDurabilityPoints() {
                return 0;
            }

            @Override
            public void attack(Target target) {

            }
        };

        Target target = new Target() {
            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int giveExperience() {
                return TARGET_XP;
            }

            @Override
            public boolean isDead() {
                return true;
            }
        };

        Hero hero = new Hero(HERO_NAME, weapon);
        hero.attack(target);
        assertEquals(TARGET_XP, hero.getExperience());

    }

    @Test
    public void testAttackWhenTargetDiesHeroGetsExp() {

        int exp = 10;

        Target target = mock(Target.class);
        when(target.isDead()).thenReturn(true);
        when(target.giveExperience()).thenReturn(exp);

        Weapon weapon = mock(Weapon.class);

        Hero hero = new Hero("Ivan", weapon);

        hero.attack(target);

        assertEquals(exp, hero.getExperience());
    }

    @Test
    public void testGetHeroName(){

        assertEquals("Ivan", hero.getName());

    }

    @Test
    public void testGetHeroWeapon() {

        assertEquals(weapon, hero.getWeapon());
    }

    @Test
    public void testGetHeroExp() {

        hero = mock(Hero.class);
        when(hero.getExperience()).thenReturn(10);

        int expectedExp = 10;

        assertEquals(expectedExp, hero.getExperience());
    }
}