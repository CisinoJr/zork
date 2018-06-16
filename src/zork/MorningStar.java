/**
 * ---------------------------------------------------------------------------
 * File name: MorningStar.java
 * Project name: Project 5 - The Zork Game
 * ---------------------------------------------------------------------------
 * Creator's name and email: Leandro Nascimento, nascimento@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 10, 2017
 * ---------------------------------------------------------------------------
 */

package zork;

/**
 * It models a morningStar as a weapon. This is a subclass from Weapon superclass
 * A morning star is any of several medieval club-like weapons consisting of a shaft with 
 * an attached ball adorned with one or more spikes. Each used, to varying degrees, a combination of 
 * blunt-force and puncture attack to kill or wound the enemy.
 *
 * <hr>
 * Date created: Nov 10, 2017
 * <hr>
 * @author Leandro Nascimento
 */
public class MorningStar extends Weapon 
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
    public MorningStar() 
    {
    	
    }

    public MorningStar(String name, double damage) 
    {
        super(name, damage);
    }
    
} // End of MorningStar Class
