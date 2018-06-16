/**
 * ---------------------------------------------------------------------------
 * File name: Monster.java
 * Project name: Project 5 - The Zork Game
 * ---------------------------------------------------------------------------
 * Creator's name and email: Leandro Nascimento, nascimento@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 03, 2017
 * ---------------------------------------------------------------------------
 */
package zork;

/**
 * It is a subclass of Participant, but also it is a superclass for
 * Monsters: Warewolf, Vampire, Troll
 *
 * <hr>
 * Date created: Nov 03, 2017
 * <hr>
 * @author Leandro Nascimento
 */
public class Monster extends Participant 
{

	/**
	 * Default Constructor        
	 *
	 * <hr>
	 * Date created: Nov 03, 2017 
	 *
	 * 
	 */
    public Monster() 
    {
    	
    }

    /**
	 * Parameterized Constructor        
	 *
	 * <hr>
	 * Date created: Nov 03, 2017 
	 * 
	 * @param name   Monster's name
     * @param health Monster's health
     * @param damage Monster's damage
	 */
    public Monster(String name, double health, double damage) 
    {
        super(name, health, damage);
    }

    /**
	 * Calculates Monster's health         
	 *
	 * <hr>
	 * Date created: Nov 03, 2017 
	 *
	 * <hr>
	 * @param damage
	 * @return
	 * @see zork.Participant#calculateHealth(double)
	 */
    @Override
    public double calculateHealth(double damage) 
    {
        return this.getHealth() - damage;
    } // End of calculateHealth method
  
} // End of Monster Class
