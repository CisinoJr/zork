/**
 * ---------------------------------------------------------------------------
 * File name: Room.java
 * Project name: Project 5 - The Zork Game
 * ---------------------------------------------------------------------------
 * Creator's name and email: Leandro Nascimento, nascimento@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 01, 2017
 * ---------------------------------------------------------------------------
 */

package zork;


import java.util.ArrayList;
import java.util.Random;

/**
 * This class is representing a room in a dungeon.
 * Each room will have 50/50 chance of containing a weapon, a monster and exits
 * <p>
 * 
 * <hr>
 * Date created: Nov 01, 2017
 * <hr>
 *
 */
public class Room 
{
    ArrayList<Direction> exits;  	// An ArrayList of exits
    Monster monster;                // A monster
    Weapon weapon;                	// A weapon

    /**
     * Default constructor.
     * 
     * <p>
     * 
     * <hr>
     * Date created: Nov 01, 2017
     */
    public Room() 
    {
        Random rand = new Random();

        // Use the 50/50 random check to decide if a monster will be in the room
        if (rand.nextInt(100) >= 50)
        {
            // Room has an monster, determine monster type with a random roll.
            switch (rand.nextInt(3)) 
            {
                case 0: // Create a Monster: Werewolf - See their classes to a definition of what a werewolf is
                    setMonster(new Werewolf());
                    break;
                case 1: // Create a Monster: Vampire - See their classes to a definition of what a vampire is
                    setMonster(new Vampire());
                    break;
                case 2: // Create a Monster: Troll - See their classes to a definition of what a troll is
                    setMonster(new Troll());
                    break;
            } // End of switch statement
        } // End of if statement

        // Create ArrayList to hold the exits
        exits = new ArrayList<Direction>();

        // Set all the exits as open
        for (Direction d : Direction.values()) 
        {
            addExit(d);
        }
        // Set weapon to null
        setWeapon(null);
    } // End of Room constructor


    /**
     * Parameterized constructor.
     * 
     * <p>
     * 
     * <hr>
     * Date created: Nov 01, 2017
     *
     * @param exits Exits of the room.
     */
    public Room(ArrayList<Direction> exits) 
    {
        Random rand = new Random();

        // Determine if the room will have a monster.
        if (rand.nextInt(100) >= 50) // 50% chance
        {
            // If room contains a monster, determine what monster will be
            switch (rand.nextInt(3)) 
            {
                case 0: // Create a Werewolf
                    setMonster(new Werewolf());
                    break;
                case 1: // Create a Vampire
                    setMonster(new Vampire());
                    break;
                case 2: // Create a Troll
                    setMonster(new Troll());
                    break;
            } // End of switch statement
        } // End of if statement

        // Set the exits of the room
        setExits(exits);

        // Set weapon to null
        setWeapon(null);
        
    } // End of room constructor


	/**
	 * @return exits
	 */
    public ArrayList<Direction> getExits() 
    {
        return exits;
    }


    /**
	 * @param exits
	 */
    public void setExits(ArrayList<Direction> exits) 
    {
        this.exits = exits;
    }


	/**
	 * @return monster
	 */
    public Monster getMonster() 
    {
        return monster;
    }


    /**
	 * @param monster
	 */
    public void setMonster(Monster monster) 
    {
        this.monster = monster;
    }


	/**
	 * @return weapon
	 */
    public Weapon getWeapon() 
    {
        return weapon;
    }


    /**
	 * @param weapon
	 */
    public void setWeapon(Weapon weapon) 
    {
        this.weapon = weapon;
    }

    /**
     * This method will add an exit to the list of exits and if an 
     * exit already exist, then nothing will be done
     * 
     * <hr>
     * Date created: Nov 01, 2017
     * 
     * @param exit
     */
    public void addExit(Direction exit) 
    {
        if (!exits.contains(exit))
            exits.add(exit);
    } // End of addExit method

    /**
     * This method will remove an exit from the list of exits and if an 
     * exit doesn't exist, then nothing will be done
     * 
     * <hr>
     * Date created: Nov 01, 2017
     * 
     * <hr>
     *
     * @param exit 
     */
    public void removeExit(Direction exit) 
    {
        if (exits.contains(exit))
            exits.remove(exit);
    } // End of removeExit method

    /**
     * Inform to player if the room contains the exit
     * 
     * <hr>
     * Date created: Nov 01, 2017
     * 
     * <hr>
     *
     * @param exit 
     * @return boolean
     */
    public boolean hasExit(Direction exit) 
    {
        // if the exit is in the room, return true, otherwise false
        return exits.contains(exit);
    } // End of hasExit method

} // End of Room class
