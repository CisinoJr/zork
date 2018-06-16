/**
 * ---------------------------------------------------------------------------
 * File name: GameManager.java
 * Project name: Project 5 - The Zork Game
 * ---------------------------------------------------------------------------
 * Creator's name and email: Leandro Nascimento, nascimento@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 03, 2017
 * ---------------------------------------------------------------------------
 */
package zork;

import java.util.ArrayList;
import java.util.Random;

/**
* Control the action elements of the Zork Game
*
* <hr>
* Date created: Nov 03, 2017
* <hr>
* @author Leandro Nascimento
*/
public class GameManager 
{
    private Dungeon dungeon;
    private Player 	player;

    /**
     * Parameterized Constructor
     *
     * <hr>
     * Date created: Nov 01, 2017
     * <hr>
     * @author Leandro Nascimento
     */
    public GameManager(Player player, Dungeon dungeon) 
    {
        setDungeon(dungeon);
        setPlayer(player);
    }

    /**
	 * @return player
	 */
    public Player getPlayer() 
    {
        return player;
    }

    /**
	 * @param player the player to set
	 */
    public void setPlayer(Player player) 
    {
        this.player = player;
    }

    /**
	 * @return dungeon
	 */
    public Dungeon getDungeon() 
    {
        return dungeon;
    }

    /**
	 * @param dungeon the dungeon to set
	 */
    public void setDungeon(Dungeon dungeon) 
    {
        this.dungeon = dungeon;
    }

	/**
	 * Move player to the direction selected by the user        
	 *
	 * <hr>
	 * Date created: Nov 01, 2017
	 *
	 * <hr>
	 * @param direction 
	 * @return True for success, false for not success
	 */
    public boolean movePlayer(Direction direction) 
    {
        return dungeon.movePlayer(direction);
    }

    /**
	 * Actions performed when user enters in a new room     
	 *
	 * <hr>
	 * Date created: Nov 01, 2017
	 *
	 * <hr>
	 * @param 
	 * @return 
	 */
    public String start() 
    {
    	// The room where the player is now
    	Room currentRoom = dungeon.getCurrentRoom(); 
    	
    	// Describe the actions of the player when entering in a room
        String encounter = ""; 

        // If a weapon is places in the room, examine the weapon to identify it and check if the damage that the weapon adds is better to the one he carries
        if (currentRoom.getWeapon() != null)
            encounter += examineWeapon(currentRoom);

        // If an monster is in the room, a fight will start
        if (currentRoom.getMonster() != null)
            encounter += battle(currentRoom);

        // Display the room and the directions the player can move
        encounter += describeRoom(currentRoom);


        // Return the encounter details
        return encounter;
    } // End of start method

    /**
	 * ASet the introduction and description of the room    
	 *
	 * <hr>
	 * Date created: Nov 01, 2017
	 *
	 * <hr>
	 * @param currentRoom
	 * @return description
	 */
    public String describeRoom(Room currentRoom) 
    {
        String description = ""; // Room's details
        Random rand = new Random();

        // Generate a random room introduction
        switch (rand.nextInt(4)) 
        {
            case 0:
                description += "\n\nThose walls… there is something about them that scares you." 
                				+ "\nThe air doesn’t get any better here… you must continue walking.";
                break;
            case 1:
                description += "\n\nNow is a good time to find a way to escape from the dungeon." 
                				+ " \nYou hear water running far away but the air here is heavy and hard to breath!" 
                				+ " \nBetter to find a way out fast and beat the challenges that the destiny saved for you!";
                break;
            case 2:
                description += "\n\nThis heat, combined with the humidity and the blood’s smell, is so suffocating\n " 
                				+ "and disorienting that you can barely walk, but you must stay strong. \n" 
                				+ "Luckily there is a flame on the wall and it is not all dark.\n";
                				
                break;
            case 3:
                description += "\n\nAs you walk to the next room, mutilated bodies are carved in stone,"
                				+ " \nrevealing a tragic decoration of a carnage fight! But, what creature"
                				+ " would do \nsuch damage to a warrior? Blood is everywhere and looks fresh!"
                				+ "\nSomething has been here recently!\n";
        } // End of switch statement

        description += "\n\tExits: ";

        // loop over the rooms' exits and add them to the description that will be displayed to the player
        for (Direction exit : currentRoom.getExits())
            description += " " + exit.toString().toLowerCase();

        description += ".\n\n";

        return description;
    } // End of DescribeRoom method
    

    /**
     * @param currentRoom Room
     * @return description as String
     */
    public String examineWeapon(Room currentRoom) 
    {
        String description = ""; 
        Weapon weapon = currentRoom.getWeapon(); // The weapon that is in the room

        // Inform the player that he found a weapon
        description += "You did step in something! It is an engraved " + weapon.getClass().getSimpleName()
                + " laying on the ground.\n";

        // If the player has no weapon yet, equip him with the new weapon
        if (player.getWeapon() == null) 
        {
            description += "Having a weapon to help you to defend yourself is encouraging. You picked it on the ground\n"
                    + "and try it on an old statue made of wood that is in the room.\n\n" +
                    "Weapon damage: " + weapon.getDamage() +"\n"; // Show weapon damage

            // Assign the weapon to the player and the room to null as the weapon was collected
            player.setWeapon(weapon);
            currentRoom.setWeapon(null);
        } // End of if statement
        
        // If player is equipped with a weapon, check and compare the damage that each weapon adds to the player to decide if replacing the weapon is a good idea
        else if (weapon.getDamage() > player.getWeapon().getDamage()) 
        {
            description += "It is definetly better than the weapon you are equiped. You drop\n"
                    + "\tthe " + player.getWeapon().getClass().getSimpleName()
                    + "  you were carrying and pick the new weapon. \nYou feel stronger already!\n\n";

         // Assign the weapon to the player and the room to null as the weapon was collected
            player.setWeapon(weapon);
            currentRoom.setWeapon(null);
        } // End of else if statement
        
        // if the weapon player is carrying is better the one he found
        else 
        {
            description += "\tIt looks useless compared to the "
                    + player.getWeapon().getClass().getSimpleName() + ", and you left it there, in the same place\n"
                    + "\tin case another brave warrior decides to adventure himself in this dungeon.\n\n";
        } // End of else statement

        return description;
    } // End of examineWeapon method

    /**
	 * It is the combat between the player and the creature/monster
	 * Combat runs round by round until player or creature is defeated
	 *
	 * <hr>
	 * Date created: Nov 01, 2017
	 *
	 * <hr>
	 * @param currentRoom 
	 * @return String
	 */
    public String battle(Room currentRoom) 
    {
        String description = "";
        
        // The monster to the fight
        Monster monster = currentRoom.getMonster(); 
        
        Weapon weapon = getDungeon().getPlayer().getWeapon();
        
        Random rand = new Random();

        player.setDamage(5); // set player health here
        
        double monsterHealth;
        // Display to the player the monster that approaches him
        description += "You heard a noise, like a stick cracking and suddenly an evil " + monster.getClass().getSimpleName()
                + " coming from a crack on the wall, appears in the room. \nThe creature is angryly screaming and it's ready to attack you.\n"
                + "You think on everyone that is relying on your victory and find some courage to fight!\n";

        // Add the weapon's damage bonus to player's damage
        if (weapon != null && weapon.getName().equals("Sword")) 
        {
            player.setDamage(player.getDamage() + weapon.getDamage());
        } 
        else if (weapon != null && weapon.getName().equals("Stick")) 
        {
            player.setDamage(player.getDamage() + weapon.getDamage());
        } 
        else if (weapon != null && weapon.getName().equals("Crossbow")) 
        {
            player.setDamage(player.getDamage() + weapon.getDamage());
        }
        else if (weapon != null && weapon.getName().equals("Axe")) 
        {
            player.setDamage(player.getDamage() + weapon.getDamage());
        }
        else if (weapon != null && weapon.getName().equals("MorningStar")) 
        {
            player.setDamage(player.getDamage() + weapon.getDamage());
        }

        // The combat runs turn by turn until player or creature's health reaches 0 or below
        while (getDungeon().getPlayer().getHealth() > 0 && monster.getHealth() > 0) {

            // Check if player was able to hit the creature 
        	// He has 10% of missing the hit
            if (rand.nextInt(10000) > 1000 && monster.getHealth() > 0 && getDungeon().getPlayer().getHealth() > 0) 
            {
             
                if (weapon != null && weapon.getName().equals("Sword")) 
                {
                    monsterHealth = monster.calculateHealth(player.getDamage());
                    monster.setHealth(monsterHealth);
                } 
                else if (weapon != null && weapon.getName().equals("Stick")) 
                {
                    monsterHealth = monster.calculateHealth(player.getDamage());
                    monster.setHealth(monsterHealth);
                } 
                else if (weapon != null && weapon.getName().equals("Crossbow")) 
                {
                    monsterHealth = monster.calculateHealth(player.getDamage());
                    monster.setHealth(monsterHealth);
                } 
                
                else if (weapon != null && weapon.getName().equals("Axe")) 
                {
                    monsterHealth = monster.calculateHealth(player.getDamage());
                    monster.setHealth(monsterHealth);
                } 
                
                else if (weapon != null && weapon.getName().equals("MorningStar")) 
                {
                    monsterHealth = monster.calculateHealth(player.getDamage());
                    monster.setHealth(monsterHealth);
                } 
                
                else 
                {
                    monsterHealth = monster.calculateHealth(player.getDamage());
                    monster.setHealth(monsterHealth);
                }

                description += "\n\tYou have hit the " + monster.getClass().getSimpleName() + "\n";
                description += "\tPlayer Damage: " + player.getDamage() + "\n";
                description += "\tPlayer Health: " + player.getHealth() + "\n";
                description += "\tMonster Health: " + monster.getHealth() + "\n";

            } 
            else if (player.getHealth() > 0) 
            {
                // If missed the monster
                description += "\n\tYou strike at the " + monster.getClass().getSimpleName() + ", but you missed it!\n";
            }

            // Check if the creature was able to hit the player
            // The creature has 20% of chances of missing the attack
            if (rand.nextInt(10000) > 2000 && monster.getHealth() > 0 && getDungeon().getPlayer().getHealth() > 0) 
            {
                double playerHealth = player.calculateHealth(monster.getDamage());
                player.setHealth(playerHealth);
                description += "\n\tThe " + monster.getClass().getSimpleName() + " hits you!\n";
                description += "\tPlayer Health: " + player.getHealth() + "\n";
                description += "\tMonster Health: " + monster.getHealth() + "\n";
                description += "\tMonster damage: " + monster.getDamage() + "\n";
            } 
            else if (monster.getHealth() > 0) 
            {
                // If creature misses the attack
                description += "\n\tThe creature is not very smart and looks stunned. \n\tIt tries to attack awkwardly, but it does not hit you!\n";
            }

            if (monster.getHealth() <= 0) 
            {
                dungeon.getCurrentRoom().setMonster(null); // Once creature is dead, it doesn't not return the creature to this room
                break;
            }
        } // End of while loop

        // Inform if player or creature is dead
        if (player.getHealth() <= 0) {
            description += "\nSlowly all becomes dark, you were defeated! \nPerhaps the profecy was wrong and you were not the chosen one...";
        } else {
            description += "\nThe terrible, stinky and ugly " + monster.getClass().getSimpleName() + " is dead! His corpse is laying in the dungeon’s floor." 
                    + "\nHe smells worse than before, but you defeat him and you must move on.\n";
        }

        return description;
    } // End of battle method

    
    /**
     * Validation on directions entered
     *
     * <hr>
     * Date created: Nov 01, 2017
     * <hr>
     * @param input 
     * @param input 
     */
    public boolean checkDirection(String input) 
    {
    	//The ArrayList of directions from enum Direction class
        ArrayList<Direction> directionList = new ArrayList<>();

        directionList.add(Direction.EAST);
        directionList.add(Direction.WEST);
        directionList.add(Direction.SOUTH);
        directionList.add(Direction.NORTH);

        for (Direction direction : directionList) 
        {
            if (direction.toString().equals(input)) 
            {
                return true;
            } // End of if statement
        } // End of for statement
        return false;
    } // End of checkDirection method
} // End of GameManger class