/**
 * ---------------------------------------------------------------------------
 * File name: Player.java
 * Project name: Project 5 - The Zork Game
 * ---------------------------------------------------------------------------
 * Creator's name and email: Leandro Nascimento, nascimento@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 04, 2017
 * ---------------------------------------------------------------------------
 */
package zork;

/**
 * Creates a player to the "The Zork Game"
 *
 * <hr>
 * Date created: Nov 04, 2017
 * <hr>
 * @author Leandro Nascimento
 */
public class Player extends Participant 
{
    private Weapon weapon;	// Variable weapon of class Weapon to set Player's weapon
    
    /**
	 * Default Constructor        
	 *
	 * <hr>
	 * Date created: Nov 04, 2017 
	 *
	 * 
	 */
    public Player() 
    {
    	
    }

    
    /**
	 * Parameterized Constructor        
	 *
	 * <hr>
	 * Date created: Nov 04, 2017 
	 *
	 * 
	 * @param name Player's name
	 * @param health Player's health
	 * @param damage Player's damage
	 */
    public Player(String name, double health, double damage) 
    {
        super(name, health, damage);
    }

    /**
	 * Calculate Player's health         
	 *
	 * <hr>
	 * Date created: Nov 04, 2017 
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

    /**
	 * @return weapon
	 */
    public Weapon getWeapon() 
    {
        return weapon;
    }

    /**
	 * @param weapon the weapon to set
	 */
    public void setWeapon(Weapon weapon) 
    {
        this.weapon = weapon;
    }
} // End of Player class
