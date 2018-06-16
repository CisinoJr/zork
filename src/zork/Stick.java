/**
 * ---------------------------------------------------------------------------
 * File name: Stick.java
 * Project name: Project 5 - The Zork Game
 * ---------------------------------------------------------------------------
 * Creator's name and email: Leandro Nascimento, nascimento@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 10, 2017
 * ---------------------------------------------------------------------------
 */

package zork;

public class Stick extends Weapon 
{

	/**
	 * Models a Stick as a Weapon.
	 * This class is a subclass of Weapon class
	 *
	 * <hr>
	 * Date created: Nov 10, 2017
	 * <hr>
	 * @author Leandro Nascimento
	 */
    public Stick() 
    {
    	
    }

    /**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Nov 10, 2017 
	 *
	 * @param name Stick's name
	 * @param damage Stick's damage
	 */
    public Stick(String name, double damage) 
    {
        super(name, damage);
    }

} // End of Stick class
