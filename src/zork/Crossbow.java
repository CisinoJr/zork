/**
 * ---------------------------------------------------------------------------
 * File name: Crossbow.java
 * Project name: Project 5 - The Zork Game
 * ---------------------------------------------------------------------------
 * Creator's name and email: Leandro Nascimento, nascimento@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 10, 2017
 * ---------------------------------------------------------------------------
 */

package zork;

/**
 * It models a crossbow as a weapon
 * This is a subclass from Weapon superclass
 *
 * <hr>
 * Date created: Nov 10, 2017
 * <hr>
 * @author Leandro Nascimento
 */
public class Crossbow extends Weapon 
{
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Nov 10, 2017 
	 *
	 * 
	 * @param name Weapon's Name
	 * @param damage Weapon's Damage
	 */
    public Crossbow() 
    {
    	
    }

    public Crossbow(String name, double damage) 
    {
        super(name, damage);
    }
    
} // End of Crossbow Class
