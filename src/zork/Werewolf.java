/**
 * ---------------------------------------------------------------------------
 * File name: Werewolf.java
 * Project name: Project 5 - The Zork Game
 * ---------------------------------------------------------------------------
 * Creator's name and email: Leandro Nascimento, nascimento@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 10, 2017
 * ---------------------------------------------------------------------------
 */

package zork;

/**
 * It models a Werewolf as a Monster
 * This is a subclass from Monster superclass
 * 
 * Also known as Lycanthropes, they are one of the most ancient and feared 
 * of all curses, Werewolves can transform the most civilized humanoid into a ravening 
 * beast. In its natural humanoid form, a creature cursed by lycanthropy appears as its 
 * normal self. Over time, however, many lycanthropes acquire features suggestive of 
 * their animal form. IN that animal form, a lycanthrope resembles a powerful 
 * version of a normal animal. On close inspection, its eyes show a faint spark of 
 * unnatural intelligence and might glow red in the dark. Evil lycanthropes hide among normal 
 * folk, emerging in animal form at night to spread terror and bloodshed, especially under a 
 * full moon.
 *
 * <hr>
 * Date created: Nov 10, 2017
 * <hr>
 * @author Leandro Nascimento
 */
public class Werewolf extends Monster 
{
    public Werewolf() 
    {
    	// Werewolf's health is 23 and his damage per hit is 4 points
        super("Werewolf", 23, 4);
    }
} // End of Werewolf class