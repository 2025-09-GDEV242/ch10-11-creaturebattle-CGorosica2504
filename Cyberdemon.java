

/**
 * The Cyberdemon class implements a wrapper for the base Creature class with the following additions
 * Implements a maximum/minimum strength for the creature type [40/20]
 * Implements a maximum/minimum hitpoint total for the creature type [100/25]
 * 
 * @author Bill Crosbie
 * @author Christian Gorosica
 * @version 2025.11.16
 */
public class Cyberdemon extends Demon
{
    private static final int MAX_CYBERDEMON_HP = 100;
    private static final int MIN_CYBERDEMON_HP = 25;
    private static final int MAX_CYBERDEMON_STR = 40;
    private static final int MIN_CYBERDEMON_STR = 20;

    /**
     * Constructor for objects of class Cyberdemon -
     * Note that the calling class does not need to know anything about the 
     * requirements of cyberdemon minimum and maximum values
     * 
     * The instantiating class asks for a Cyberdemon and the cyberdemon class is responsible for
     * return a Cyberdemon object with values in the appropriate range
     * 
     */
    public Cyberdemon()
    {
        // note how the class uses the static randomizer class to
        // generate the values. This localizes the need to know 
        // max and min values to this class only
        // max-min is range of values
        // range + min ensures that the values don't start at one.
        super(
            Randomizer.nextInt(MAX_CYBERDEMON_STR-MIN_CYBERDEMON_STR)+MIN_CYBERDEMON_STR,
            Randomizer.nextInt(MAX_CYBERDEMON_HP-MIN_CYBERDEMON_HP)+MIN_CYBERDEMON_HP        
        );
    }
}
