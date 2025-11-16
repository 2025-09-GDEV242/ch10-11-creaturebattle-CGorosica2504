

/**
 * The Elf class implements a wrapper for the base Creature class with the following additions
 * Implements a maximum/minimum strength for the creature type [18/5]
 * Implements a maximum/minimum hitpoint total for the creature type [25/8]
 * Implements an overriding attack method which gives the creature type a 10% chance to deal double damage
 * 
 * @author Bill Crosbie
 * @author Christian Gorosica
 * @version 2025.11.16
 */
public class Elf extends Creature
{
    private static final int MAX_ELF_HP = 25;
    private static final int MIN_ELF_HP = 8;
    private static final int MAX_ELF_STR = 18;
    private static final int MIN_ELF_STR = 5;

    /**
     * Constructor for objects of class Elf -
     * Note that the calling class does not need to know anything about the 
     * requirements of elf minimum and maximum values
     * 
     * The instantiating class asks for an Elf and the elf class is responsible for
     * return a Elf object with values in the appropriate range
     * 
     */
    public Elf()
    {
        // note how the class uses the static randomizer class to
        // generate the values. This localizes the need to know 
        // max and min values to this class only
        // max-min is range of values
        // range + min ensures that the values don't start at one.
        super(
            Randomizer.nextInt(MAX_ELF_STR-MIN_ELF_STR)+MIN_ELF_STR,
            Randomizer.nextInt(MAX_ELF_HP-MIN_ELF_HP)+MIN_ELF_HP        
        );
    }
    
    /**
     * Allows an Elf to determine how much damage it is causing in this round of battle
     * Elves have a special ability in which they have a 10% chance to deal double damage
     * 
     * @return a value between 1 and str to be used to cause damage to another creature
     */
    public int attack(){
        int damageDealt = super.attack();
        
        if (Randomizer.nextInt(10) == 1) {
            damageDealt = damageDealt * 2;
        }
        
        return damageDealt;
    }
}
