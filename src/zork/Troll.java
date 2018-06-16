/**
 * ---------------------------------------------------------------------------
 * File name: Troll.java
 * Project name: Project 5 - The Zork Game
 * ---------------------------------------------------------------------------
 * Creator's name and email: Leandro Nascimento, nascimento@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 10, 2017
 * ---------------------------------------------------------------------------
 */

package zork;

/**
 * It models a Troll as a Monster
 * This is a subclass from Monster superclass
 * 
 * Trolls re massive, predatory species of giant-kin, they are considered 
 * "stupid bastards" by other species of giants except for ogres, who are 
 * treated the same way. The most distinctive feature of trolls is their 
 * ability to regenerate. If any part of a troll's body is cut off, it will 
 * grow back after a while and the felled limb has a chance to evolve into an 
 * entirely new troll. The only things that can stop this are fire and acid, 
 * both of which trolls fear greatly.
 *
 * <hr>
 * Date created: Nov 10, 2017
 * <hr>
 * @author Leandro Nascimento
 */
public class Troll extends Monster 
{

    public Troll() 
    {
    	// Troll's health is 20 and his damage per hit is 4 points
        super("Troll", 20, 4);
    }
} // End of Troll class