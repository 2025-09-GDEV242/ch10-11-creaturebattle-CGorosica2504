

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CyberdemonTest.
 *
 * @author  Christian Gorosica
 * @version 2025.11.16
 */
public class CyberdemonTest
{
    private Cyberdemon cyberdem1;

    /**
     * Default constructor for test class CyberdemonTest
     */
    public CyberdemonTest()
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
        cyberdem1 = new Cyberdemon();
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
    public void testCyberdemonIsConscious()
    {
        assertEquals(true,cyberdem1.isAlive());
        assertEquals(false, cyberdem1.isKnockedOut());
    }

    /**
     * Tests that the creature is considered knocked out when health points are depleted
     */
    @Test
    public void testCyberdemonIsKnockedOut()
    {
        cyberdem1.takeDamage(cyberdem1.getHp());
        assertEquals(false, cyberdem1.isAlive());
        assertEquals(true, cyberdem1.isKnockedOut());
    }

    /**
     * Tests that the creature HP is properly affected by taken damage
     */
    @Test
    public void testCyberdemonTakesDamage()
    {
        int startHp = cyberdem1.getHp();
        cyberdem1.takeDamage(1);
        int endHp = cyberdem1.getHp();
        assertEquals(startHp - 1, endHp);
    }
}