/**
 * ---------------------------------------------------------------------------
 * File name: Participant.java
 * Project name: Project 5 - The Zork Game
 * ---------------------------------------------------------------------------
 * Creator's name and email: Leandro Nascimento, nascimento@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 03, 2017
 * ---------------------------------------------------------------------------
 */

package zork;


/**
 * Abstract Class that will server as a superclass of Monster and Player
 *
 * <hr>
 * Date created: Nov 03, 2017
 * <hr>
 * @author Leandro Nascimento
 */

public abstract class Participant 
{
    private String name;	// hold participant's name
    private double health;	// hold participant's health
    private double damage;	// hold participant's damage

    /**
	 * Default Constructor        
	 *
	 * <hr>
	 * Date created: Nov 03, 2017 
	 *
	 */
    public Participant()
    {
    	
    }
    
    /**
	 * Parameterized Constructor        
	 *
	 * <hr>
	 * Date created: Nov 01, 2017 
	 * 
	 * @param name - Participant's name
	 * @param health - Participant's health
	 * @param damage - Participant's damage
	 */
    public Participant(String name, double health, double damage) 
    {
        this.name 	= name;
        this.health = health;
        this.damage = damage;
    }

    /**
     * @return String
     */
    public String getName() 
    {
        return name;
    }

    /**
     * @param name Participant`s name
     */
    public void setName(String name) 
    {
        this.name = name;
    }

    /**
     * @return double
     */
    public double getHealth() 
    {
        return health;
    }

    /**
     *  Set Participant's health points
     *  
     * @param health Participant`s health points
     */
    public void setHealth(double health) 
    {
        this.health = health;
    }

    /**
     *
     * @return double
     */
    public double getDamage() 
    {
        return damage;
    }

    /**
     *
     * @param damage Participant`s damage points
     */
    public void setDamage(double damage) 
    {
        this.damage = damage;
    }

    /**
     * Calculate the participant health points during
     * the combat
     *
     * @return double
     */
    public abstract double calculateHealth(double damage);

} // End of Class Participant
