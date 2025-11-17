

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class HumanTest.
 *
 * @author  Christian Gorosica
 * @version 2025.11.16
 */
public class HumanTest
{
    private Human human1;

    /**
     * Default constructor for test class HumanTest
     */
    public HumanTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        human1 = new Human();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    /**
     * Tests that the creature is alive and not unconscious upon creation
     */
    @Test
    public void testHumanIsConscious()
    {
        assertEquals(true, human1.isAlive());
        assertEquals(false, human1.isKnockedOut());
    }

    /**
     * Tests that the creature is considered knocked out when health points are depleted
     */
    @Test
    public void testHumanIsKnockedOut()
    {
        human1.takeDamage(human1.getHp());
        assertEquals(false, human1.isAlive());
        assertEquals(true, human1.isKnockedOut());
    }

    /**
     * Tests that the creature HP is properly affected by taken damage
     */
    @Test
    public void testHumanTakesDamage()
    {
        int startHp = human1.getHp();
        human1.takeDamage(1);
        int endHp = human1.getHp();
        assertEquals(startHp - 1, endHp);
    }
}



