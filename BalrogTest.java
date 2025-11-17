

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class BalrogTest.
 *
 * @author  Christian Gorosica
 * @version 2025.11.16
 */
public class BalrogTest
{
    private Balrog balrog1;

    /**
     * Default constructor for test class BalrogTest
     */
    public BalrogTest()
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
        balrog1 = new Balrog();
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
    public void testBalrogIsConscious()
    {
        assertEquals(true, balrog1.isAlive());
        assertEquals(false, balrog1.isKnockedOut());
    }

    /**
     * Tests that the creature is considered knocked out when health points are depleted
     */
    @Test
    public void testBalrogIsKnockedOut()
    {
        balrog1.takeDamage(balrog1.getHp());
        assertEquals(false, balrog1.isAlive());
        assertEquals(true, balrog1.isKnockedOut());
    }

    /**
     * Tests that the creature HP is properly affected by taken damage
     */
    @Test
    public void testBalrogTakesDamage()
    {
        int startHp = balrog1.getHp();
        balrog1.takeDamage(1);
        int endHp = balrog1.getHp();
        assertEquals(startHp - 1, endHp);
    }
}