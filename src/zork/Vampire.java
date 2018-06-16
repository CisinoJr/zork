/**
 * ---------------------------------------------------------------------------
 * File name: Vampire.java
 * Project name: Project 5 - The Zork Game
 * ---------------------------------------------------------------------------
 * Creator's name and email: Leandro Nascimento, nascimento@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 10, 2017
 * ---------------------------------------------------------------------------
 */

package zork;

/**
 * It models a Vampire as a Monster
 * This is a subclass from Monster superclass
 * 
 * Vampires appear just as they did in life, although their features are often hardened and 
 * feral, with the predatory look of wolves. Like liches, they often embrace finery 
 * and decadence and may assume the guise of nobility. Despite their human appearance, 
 * vampires can be easily recognized, for they cast no shadows and throw no reflections in mirrors.
 * Vampires speak any languages they knew in life
 *
 * <hr>
 * Date created: Nov 10, 2017
 * <hr>
 * @author Leandro Nascimento
 */
public class Vampire extends Monster 
{

    public Vampire() 
    {
    	// Vampire's health is 30 and his damage per hit is 5 points
        super("Vampire", 30, 5);
    }
} // End of Vampire class