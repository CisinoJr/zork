/**
 * ---------------------------------------------------------------------------
 * File name: GameDriver.java
 * Project name: Project 5 - The Zork Game
 * ---------------------------------------------------------------------------
 * Creator's name and email: Leandro Nascimento, nascimento@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 01, 2017
 * ---------------------------------------------------------------------------
 */

package zork;

import java.util.Scanner;


/**
 * The driver of Zork Game
 *
 * <hr>
 * Date created: Nov 01, 2017
 * <hr>
 * @author Leandro Nascimento
 */
public class GameDriver 
{

	/**
	 * Main method of Zork's game         
	 *
	 * <hr>
	 * Date created: Nov 01, 2017
	 *
	 * <hr>
	 * @param args
	 */
    public static void main(String[] args) 
    {
        Player player 		= new Player();
        Scanner kb	 		= new Scanner(System.in);
        String direction 	= "";

        try 
        {
        	// Get player character's name and it will use his name's inital to identify the player in the dungeon
            System.out.println("Enter Warrior's name or hit Enter to default name: 'Player'.");
            player.setName(kb.nextLine());

          //  player.setDamage(5);		// Player's damage to creature without weapon is 5
            player.setHealth(100.00);	// Player's initial health

            Dungeon dungeon = new Dungeon(player);	// instantiate a dungeon object to set the Dungeon to the game

            if (player.getName().trim().isEmpty()) 
            {
                player.setName("Player");			// If user doesn't inform the 'Warrior's' name, it set's to be 'Player'
            }

            GameManager gameManager = new GameManager(player, dungeon);
            
            // Show welcome screen to player
            System.out.println("\t\t\t╦ ╦╔═╗╦  ╔═╗╔═╗╔╦╗╔═╗  ╔╦╗╔═╗	");
           	System.out.println("\t\t\t║║║║╣ ║  ║  ║ ║║║║║╣    ║ ║ ║	");
           	System.out.println("\t\t\t╚╩╝╚═╝╩═╝╚═╝╚═╝╩ ╩╚═╝   ╩ ╚═╝	");

            System.out.println("\n");
            
            System.out.println ("ZZZZZZZZZZZZZZZZZZZ      OOOOOOOOO      RRRRRRRRRRRRRRRRR    KKKKKKKKK    KKKKKKK	");
            System.out.println ("Z:::::::::::::::::Z    OO:::::::::OO    R::::::::::::::::R   K:::::::K    K:::::K	");
            System.out.println ("Z:::::::::::::::::Z  OO:::::::::::::OO  R::::::RRRRRR:::::R  K:::::::K    K:::::K	");
            System.out.println ("Z:::ZZZZZZZZ:::::Z  O:::::::OOO:::::::O RR:::::R     R:::::R K:::::::K   K::::::K	");
            System.out.println ("ZZZZZ     Z:::::Z   O::::::O   O::::::O   R::::R     R:::::R KK::::::K  K:::::KKK	");
            System.out.println ("        Z:::::Z     O:::::O     O:::::O   R::::R     R:::::R   K:::::K K:::::K   	");
            System.out.println ("       Z:::::Z      O:::::O     O:::::O   R::::RRRRRR:::::R    K::::::K:::::K      ");
            System.out.println ("      Z:::::Z       O:::::O     O:::::O   R:::::::::::::RR     K:::::::::::K       ");
            System.out.println ("     Z:::::Z        O:::::O     O:::::O   R::::RRRRRR:::::R    K:::::::::::K       ");
            System.out.println ("    Z:::::Z         O:::::O     O:::::O   R::::R     R:::::R   K::::::K:::::K      ");
            System.out.println ("   Z:::::Z          O:::::O     O:::::O   R::::R     R:::::R   K:::::K K:::::K     ");
            System.out.println ("ZZZ:::::Z     ZZZZZ O::::::O   O::::::O   R::::R     R:::::R KK::::::K  K:::::KKK	");
            System.out.println ("Z::::::ZZZZZZZZ:::Z O:::::::OOO:::::::O RR:::::R     R:::::R K:::::::K   K::::::K	");
            System.out.println ("Z:::::::::::::::::Z  OO:::::::::::::OO  R::::::R     R:::::R K:::::::K    K:::::K	");
            System.out.println ("Z:::::::::::::::::Z    OO:::::::::OO    R::::::R     R:::::R K:::::::K    K:::::K	");
            System.out.println ("ZZZZZZZZZZZZZZZZZZZ      OOOOOOOOO      RRRRRRRR     RRRRRRR KKKKKKKKK    KKKKKKK	");
            System.out.println("\n");

            System.out.println("\t\t\t  ╔╦╗╦ ╦╔╗╔╔═╗╔═╗╔═╗╔╗╔	");
           	System.out.println("\t\t\t   ║║║ ║║║║║ ╦║╣ ║ ║║║║	");
           	System.out.println("\t\t\t  ═╩╝╚═╝╝╚╝╚═╝╚═╝╚═╝╝╚╝	");
            System.out.println("\n");
            
            System.out.println("********************************************************************************************");
            System.out.println("* Shades of a past not so far to forget...the rise of the demons from their bloody hell!   *");
            System.out.println("* Come mighty warrior! Come to the darkness of the ZORK dungeon. You are the chosen one,   *");
            System.out.println("* and the last hope for the Rhapsody kingdom! Only you can defeat the creatures that inha- *");
            System.out.println("* bit this cave and for centuries have been attacking, looting and killing innocent people *");
            System.out.println("* who once lived in peace in Rhapsody...                                                   *");
            System.out.println("********************************************************************************************");
            // End of welcome screen
          
            // Display Player warrior's name and health
            System.out.println("\nWarrior's Name: " + gameManager.getDungeon().getPlayer().getName() +
                    "\t | \tWarrior's Health: " + gameManager.getDungeon().getPlayer().getHealth() + "\n");
            
            // Set the dungeon
            System.out.println(gameManager.getDungeon().toString() + "\n");
            System.out.println(gameManager.describeRoom(dungeon.getCurrentRoom()) + "\n");

            do 
            {
                try
                {
                    //System.out.println(gameManager.describeRoom(dungeon.getCurrentRoom()) + "\n");

                    System.out.println("What direction would you like to go? ");

                    direction = kb.nextLine().toUpperCase(); // get user's input and do the validation

                    // Validation on user's input
                    if (!gameManager.checkDirection(direction) || direction.trim().isEmpty()) 
                    {
                        System.out.println("\nI do not know what you mean.");
                        
                        continue;
                    } // End of if statement

                /*
                    if (gameManager.getDungeon().hasExitOnRightMost(dungeon.getRooms()))
                     {
                        System.out.println("You have beaten the dungeon");
                        System.exit(0);
                        break;
                    }*/
                    // Check if an exit is in the cell
                    if (gameManager.getDungeon().getCurrentRoom().hasExit(Direction.valueOf(direction))) 
                    {
                        // Move player to chosen direction
                        gameManager.getDungeon().movePlayer(Direction.valueOf(direction));
                        
                        // Every time a player enters a cell, his health is displayed
                        System.out.println("\nPlayer's health: " + gameManager.getDungeon().getPlayer().getHealth());
                        
                    } // End of if statement
                    else 
                    {
                        System.out.println("\nSorry, but you can’t go in this direction.");
                    } // End of else statement

                    System.out.println(gameManager.start());
                    System.out.println(gameManager.getDungeon().toString());

                    // Check player's health and stop the loop if health is less or equal tan zero - he is dead :(
                    if (gameManager.getDungeon().getPlayer().getHealth() <= 0) 
                    {
                        //Display a game over message
                        System.out.println ("     ██████╗  █████╗ ███╗   ███╗███████╗	");
                        System.out.println ("    ██╔════╝ ██╔══██╗████╗ ████║██╔════╝	");
                       	System.out.println ("    ██║  ███╗███████║██╔████╔██║█████╗  	");
                     	System.out.println ("    ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝  	");
                     	System.out.println ("    ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗	");
                     	System.out.println ("     ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝	");
                        System.out.println (" "); 
                        System.out.println ("                     ██████╗ ██╗   ██╗███████╗██████╗ 	");
                       	System.out.println ("                    ██╔═══██╗██║   ██║██╔════╝██╔══██╗	");
                   		System.out.println ("                    ██║   ██║██║   ██║█████╗  ██████╔╝	");
                   		System.out.println ("                    ██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗	");
                   		System.out.println ("                    ╚██████╔╝ ╚████╔╝ ███████╗██║  ██║	");
                   		System.out.println ("                     ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝	");
                        
                        System.exit(0);
                    } // End of if statement
                } // End of try statement
                catch (IndexOutOfBoundsException e)
                {
                    // Moving the player out of the array means the Warrior left the dungeon alive.
                	// Display message to congratulate the player.
                	System.out.println("\nCONGRATULATIONS!\n");
                    
                    System.out.println("Y88b   d88P  .d88888b.  888     888      888    888        d8888 888     888 8888888888 ");
                    System.out.println(" Y88b d88P  d88P   Y88b 888     888      888    888       d88888 888     888 888        ");
                    System.out.println("  Y88o88P   888     888 888     888      888    888      d88P888 888     888 888        ");
                    System.out.println("   Y888P    888     888 888     888      8888888888     d88P 888 Y88b   d88P 8888888    ");
                    System.out.println("    888     888     888 888     888      888    888    d88P  888  Y88b d88P  888        ");
                    System.out.println("    888     888     888 888     888      888    888   d88P   888   Y88o88P   888        ");
                    System.out.println("    888     Y88b. .d88P Y88b. .d88P      888    888  d8888888888    Y888P    888        ");
                    System.out.println("    888       Y88888P     Y88888P        888    888 d88P     888     Y8P     8888888888 ");
                    System.out.println("\n");                                                                   
                    System.out.println("\t888888b.   8888888888        d8888 88888888888 8888888888 888b    888      88888888888 888    888 8888888888  ");    
                   	System.out.println("\t888   88b  888              d88888     888     888        8888b   888          888     888    888 888         ");   
                    System.out.println("\t888  .88P  888             d88P888     888     888        88888b  888          888     888    888 888         ");   
                    System.out.println("\t8888888K.  8888888        d88P 888     888     8888888    888Y88b 888          888     8888888888 8888888     ");   
                    System.out.println("\t888   Y88b 888           d88P  888     888     888        888 Y88b888          888     888    888 888         ");   
                    System.out.println("\t888    888 888          d88P   888     888     888        888  Y88888          888     888    888 888         ");    
                    System.out.println("\t888   d88P 888         d8888888888     888     888        888   Y8888          888     888    888 888         ");    
                    System.out.println("\t8888888P   8888888888 d88P     888     888     8888888888 888    Y888          888     888    888 8888888888  "); 
                    System.out.println("\n");                                                            
                    System.out.println("8888888b.  888     888 888b    888  .d8888b.  8888888888 .d88888b.  888b    888 	");
                    System.out.println("888   Y88b 888     888 8888b   888 d88P  Y88b 888       d88P   Y88b 8888b   888 	");
                    System.out.println("888    888 888     888 88888b  888 888    888 888       888     888 88888b  888 	");
                    System.out.println("888    888 888     888 888Y88b 888 888        8888888   888     888 888Y88b 888 	");
                    System.out.println("888    888 888     888 888 Y88b888 888  88888 888       888     888 888 Y88b888 	");
                    System.out.println("888    888 888     888 888  Y88888 888    888 888       888     888 888  Y88888 	");
                    System.out.println("888  .d88P Y88b. .d88P 888   Y8888 Y88b  d88P 888       Y88b. .d88P 888   Y8888 	");
                    System.out.println("8888888P     Y88888P   888    Y888  Y8888P88  8888888888  Y88888P   888    Y888		");
                    
                    kb.close ( );
                    System.exit(0);
                    break;
                }

            }
            while (gameManager.getDungeon().getPlayer().getHealth() != 0);

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } // End of general catch

    } // End of main method
} // End of GameDriver class