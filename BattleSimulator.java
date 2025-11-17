import java.util.ArrayList;
/**
 * BattleSimulator simulates a battle between two armies of creatures.
 * 
 * Army One is composed of a larger number of Humans and Elves. Army Two is composed of a smaller
 * number of Humans, Cyberdemons, and Balrog. Each creature attacks simultaneously in one-on-one combat
 * until one or both creatures are knocked out. 
 * 
 * When a creature falls, the next creature in its army steps forward and continues the skirmish.
 * The battle continues until one army is entirely defeated.
 * 
 * After the battle finishes, the simulator will report which army has won, if either, and the number
 * of creatures remaining in each army.
 * 
 * @author Christian Gorosica
 * @version 2025.11.16
 */
public class BattleSimulator {
    public static void main(String[] args) {
    
    ArrayList<Creature> armyOne = new ArrayList<>();
    ArrayList<Creature> armyTwo = new ArrayList<>();
    
    //Populating Army One of 100-150 Creatures (Humans and Elves)
    int armyOneSize = Randomizer.nextInt(50) + 100;
    
    for (int i = 0; i < armyOneSize; i++) {
        int choice = Randomizer.nextInt(10);
        
        if (choice <= 7) {
            armyOne.add(new Human());
        } else {
            armyOne.add(new Elf());
        }
    }

    //Populating Army Two of 30-50 Creatures (Humans, Cyberdemons, Balrog)
    int armyTwoSize = Randomizer.nextInt(20) + 30;
    
    for (int i = 0; i < armyTwoSize; i++) {
        int choice = Randomizer.nextInt(25);
        
        if (choice <= 18) {
            armyTwo.add(new Human());
        } else if (choice <= 24) {
            armyTwo.add(new Cyberdemon());
        } else {
            armyTwo.add(new Balrog());
        }
    }
    
    int index1 = 0;
    int index2 = 0;
    
    //Main battle loop
    while (index1 < armyOne.size() && index2 < armyTwo.size()) {
        Creature c1 = armyOne.get(index1);
        Creature c2 = armyTwo.get(index2);
        
        //Individual combat loop per round
        while (c1.isAlive() && c2.isAlive()) {
            int damageToC2 = c1.attack();
            int damageToC1 = c2.attack();
            
            c1.takeDamage(damageToC1);
            c2.takeDamage(damageToC2);
        }
        
        //To determine which army has lost a creature and needs to rotate combatant
        if (c1.isKnockedOut()) {
            index1++;
        }
        
        if (c2.isKnockedOut()) {
            index2++;
        }
      }
  
    //After-action battle report
    System.out.println("[RESULT OF BATTLE]\n");
    
    if (index1 == armyOne.size() && index2 == armyTwo.size()) {
        System.out.println("Both armies have fallen! No survivors remaining. War is brutal.");
    } else if (index1 == armyOne.size()) {
        System.out.println("Army Two has won the battle! They were fewer but stronger.");
    } else {
        System.out.println("Army One has won the battle! They were weaker but more numerous.");
    }
    
    System.out.println("\n[ARMY STANDINGS]\n");

    System.out.println("Army One remaining creatures: " + (armyOne.size() - index1));
    System.out.println("Army Two remaining creatures: " + (armyTwo.size() - index2));
 }
}