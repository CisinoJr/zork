/**
 * ---------------------------------------------------------------------------
 * File name: Sword.java
 * Project name: Project 5 - The Zork Game
 * ---------------------------------------------------------------------------
 * Creator's name and email: Leandro Nascimento, nascimento@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 10, 2017
 * ---------------------------------------------------------------------------
 */

package zork;

public class Sword extends Weapon 
{

	/**
	 * Models a Sword as a Weapon.
	 * This class is a subclass of Weapon class
	 *
	 * <hr>
	 * Date created: Nov 10, 2017
	 * <hr>
	 * @author Leandro Nascimento
	 */
    public Sword() 
    {
    	
    }

    /**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Nov 10, 2017 
	 *
	 * @param name Sword's name
	 * @param damage Sword's damage
	 */
    public Sword(String name, double damage) 
    {
        super(name, damage);
    }

} // End of Sword class
