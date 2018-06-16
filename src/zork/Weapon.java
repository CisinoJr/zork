/**
 * ---------------------------------------------------------------------------
 * File name: Weapon.java
 * Project name: Project 5 - The Zork Game
 * ---------------------------------------------------------------------------
 * Creator's name and email: Leandro Nascimento, nascimento@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 10, 2017
 * ---------------------------------------------------------------------------
 */

package zork;

/**
 * Class Weapon is a superclass that will be used by more specific 
 * types of weapon, which will extend this class
 *
 * <hr>
 * Date created: Nov 10, 2017
 * <hr>
 * @author Leandro Nascimento
 */
public class Weapon 
{
    private String name;
    private double damage;

    /**
	 * Default Constructor        
	 *
	 * <hr>
	 * Date created: Nov 10, 2017 
	 *
	 */
    public Weapon() 
    {
    	
    }

    /**
	 * Parameterized Constructor        
	 *
	 * <hr>
	 * Date created: Nov 10, 2017 
	 *
	 * 
	 * @param name Weapon's name
	 * @param damage Weapon's damage
	 */
    public Weapon(String name, double damage) 
    {
        this.name = name;
        this.damage = damage;
    }

    /**
     * @return name as String
     */
    public String getName() 
    {
        return name;
    }

    /**
     * @param name Weapon's name
     */
    public void setName(String name) 
    {
        this.name = name;
    }

    /**
     * @return damage as double
     */
    public double getDamage() 
    {
        return damage;
    }

    /**
     * @param damage Weapon's damage points
     */
    public void setDamage(double damage) 
    {
        this.damage = damage;
    }

} // End of Weapon class
