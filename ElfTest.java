

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ElfTest.
 *
 * @author  Christian Gorosica
 * @version 2025.11.16
 */
public class ElfTest
{
    private Elf elf1;

    /**
     * Default constructor for test class ElfTest
     */
    public ElfTest()
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
        elf1 = new Elf();
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
    public void testElfIsConscious()
    {
        assertEquals(true, elf1.isAlive());
        assertEquals(false, elf1.isKnockedOut());
    }

    /**
     * Tests that the creature is considered knocked out when health points are depleted
     */
    @Test
    public void testElfIsKnockedOut()
    {
        elf1.takeDamage(elf1.getHp());
        assertEquals(false, elf1.isAlive());
        assertEquals(true, elf1.isKnockedOut());
    }

    /**
     * Tests that the creature HP is properly affected by taken damage
     */
    @Test
    public void testElfTakesDamage()
    {
        int startHp = elf1.getHp();
        elf1.takeDamage(1);
        int endHp = elf1.getHp();
        assertEquals(startHp - 1, endHp);
    }
}