

/**
 * The Demon class is an abstract class. It cannot be instantiated directly. It is meant to be subclassed by specific types of demons.
 * 
 * Implements an overriding attack method that provides the creature type a 5% to deal an additional 50 damage.
 * 
 * @author Bill Crosbie
 * @author Christian Gorosica
 * @version 2025.11.16
 */
public abstract class Demon extends Creature
{
    /**
     * Constructor for objects of class Demon -
     * This class cannot be instantiated directly
     * Subclasses must provide concrete instances
     * 
     */
    public Demon(int str, int hp)
    {
        super(str,hp);
    }
    
    /**
     * Allows a demon to determine how much damage it is causing in this round of battle
     * Demons have a special ability in which they have a 5% chance to deal an additional 50 damage
     * 
     * @return a value between 1 and str to be used to cause damage to another creature
     */
    public int attack(){
        int damageDealt = super.attack();
        
        if (Randomizer.nextInt(20) == 1) {
            damageDealt = damageDealt + 50;
        }
        
        return damageDealt;
    }
}
