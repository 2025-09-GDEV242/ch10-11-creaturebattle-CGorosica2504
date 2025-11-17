

/**
 * The Balrog class implements a wrapper for the base Creature class with the following additions
 * Implements a maximum/minimum strength for the creature type [100/50]
 * Implements a maximum/minimum hitpoint total for the creature type [200/80]
 * Implements an overriding attack method which gives the creature type the ability to attack twice per round
 * 
 * @author Bill Crosbie
 * @author Christian Gorosica
 * @version 2025.11.16
 */
public class Balrog extends Demon
{
    private static final int MAX_BALROG_HP = 200;
    private static final int MIN_BALROG_HP = 80;
    private static final int MAX_BALROG_STR = 100;
    private static final int MIN_BALROG_STR = 50;

    /**
     * Constructor for objects of class Balrog -
     * Note that the calling class does not need to know anything about the 
     * requirements of cyberdemon minimum and maximum values
     * 
     * The instantiating class asks for a Balrog and the balrog class is responsible for
     * return a Balrog object with values in the appropriate range
     * 
     */
    public Balrog()
    {
        // note how the class uses the static randomizer class to
        // generate the values. This localizes the need to know 
        // max and min values to this class only
        // max-min is range of values
        // range + min ensures that the values don't start at one.
        super(
            Randomizer.nextInt(MAX_BALROG_STR-MIN_BALROG_STR)+MIN_BALROG_STR,
            Randomizer.nextInt(MAX_BALROG_HP-MIN_BALROG_HP)+MIN_BALROG_HP        
        );
    }
    
    /**
     * Allows a Balrog to determine how much damage it is causing in this round of battle
     * Balrog have a special ability in which they attack twice each round
     * 
     * @return a value between 1 and str to be used to cause damage to another creature
     */
    public int attack(){
        int damageFirstAttack = super.attack();
        int damageSecondAttack = super.attack();
        
        int damageDealt = damageFirstAttack + damageSecondAttack;
        
        return damageDealt;
    }
}
