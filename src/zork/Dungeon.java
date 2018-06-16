/**
 * ---------------------------------------------------------------------------
 * File name: Dungeon.java
 * Project name: Project 5 - The Zork Game
 * ---------------------------------------------------------------------------
 * Creator's name and email: Leandro Nascimento, nascimento@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Nov 10, 2017
 * ---------------------------------------------------------------------------
 */
package zork;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

/**
 * Model for the Zork's Dungeon based on a bi-dimensional ArrayList of rooms.
 * The dungeon's exit is selected randomly using the east-most cell in any row
 * <p>
 * <hr>
 * Date created: Nov 10, 2017
 * <hr>
 *
 * @author Leandro Nascimento
 */
public class Dungeon {
    private ArrayList<ArrayList<Room>> rooms;                        // A bi-dimensional array of rooms for Zork's dungeon
    private Player player;                            // The Zork Game's Player
    private int[] playerPosition;                // Represents the player's position in the dungeon
    private Random random = new Random();    // Random object of Random class

    /**
     * Parameterized Constructor
     * <p>
     * <hr>
     * Date created: Nov 10, 2017
     *
     * @param player
     */
    public Dungeon(Player player) {
        this.player = player;
        this.setPlayerPosition(new int[2]);
        this.setPlayerPosition(0, 0);
        this.generateRooms();
    }

    /**
     * @return rooms ArrayList
     */
    public ArrayList<ArrayList<Room>> getRooms() {
        return rooms;
    }

    /**
     * @param rooms Room
     */
    public void setRooms(ArrayList<ArrayList<Room>> rooms) {
        this.rooms = rooms;
    }

    /**
     * @return Player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @param player Player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * @return int
     */
    public int[] getPlayerPosition() {
        return playerPosition;
    }

    /**
     * @param playerPosition int
     */
    public void setPlayerPosition(int[] playerPosition) {
        this.playerPosition = playerPosition;
    }

    /**
     * @param row    int
     * @param column int
     */
    public void setPlayerPosition(int row, int column) {
        // Place the player in a giving room using this method
        this.playerPosition[0] = row;
        this.playerPosition[1] = column;
    }

    /**
     * @return Room
     */
    public Room getCurrentRoom() {
        // Return the room where the player is
        return rooms.get(playerPosition[0]).get(playerPosition[1]);
    }

    /**
     * Generate all the rooms to the Zork Dungeon,
     * Set the room attributes and weapons to the rooms
     * <p>
     * <hr>
     * Date created: Nov 01, 2017
     * <p>
     * <hr>
     */
    private void generateRooms() {
        ArrayList<ArrayList<Room>> newRooms = new ArrayList<ArrayList<Room>>();

        createDungeon(newRooms);                // Columns and rows for the Dungeon
        closeExits(newRooms);                    // Close external exits
        placeWeapons(newRooms);                    // Place the weapons in the rooms
        setRooms(newRooms);                        // Set the rooms to complete the dungeon
    }

    /**
     * @param dungeon ArrayList
     */
    public void createDungeon(ArrayList<ArrayList<Room>> dungeon) {
        int rows = random.nextInt(5) + 1;                    // Min 1 rows, max 5
        int columns = random.nextInt(6) + 5;                // Min 5 columns, max 10
        ArrayList<Room> tempRoomRow;                        // Temporary container for each row that is going to be created

        for (int i = 0; i < rows; i++)                        // To create the random rows of the dungeon
        {
            tempRoomRow = new ArrayList<Room>(columns);

            for (int aux = 0; aux <= columns; aux++) {
                tempRoomRow.add(new Room());                // Move from temporary container of rows to the new ArrayList
            }

            dungeon.add(tempRoomRow);                        // Add the row to the Dungeon
        }

        // Removes monster from the first position (first room) if it exists
        if (dungeon.get(0).get(0).getMonster() != null) {
            dungeon.get(0).get(0).setMonster(null);
        }
    }    // End of createDungeon method

    /**
     * Removes the external exits of the ZORK dungeon.
     * <p>
     * <hr>
     * Date created: Nov 01, 2017
     * <p>
     * <hr>
     *
     * @param dungeon ArrayList
     */
    private void closeExits(ArrayList<ArrayList<Room>> dungeon) {
        Random rand = new Random();                    // Random number generator
        final int ROW_NUM = dungeon.size(),                // Number of rows
                COLUMN_NUM = dungeon.get(0).size();    // Number of columns

        // Removing NORTH, SOUTH, WEST and EAST exit from rooms on the extreme direction
        for (Room r : dungeon.get(0)) {
            r.removeExit(Direction.NORTH);
        }

        for (Room r : dungeon.get(ROW_NUM - 1)) {
            r.removeExit(Direction.SOUTH);
        }

        for (ArrayList<Room> row : dungeon) {
            row.get(0).removeExit(Direction.WEST);
        }

        for (ArrayList<Room> row : dungeon) {
            row.get(COLUMN_NUM - 1).removeExit(Direction.EAST);
        }

        // The exit is always on the EAST, but it may be on any row.  
        // Set the exit row randomly with equal probability to be in any row.
        dungeon.get(rand.nextInt(ROW_NUM)).get(COLUMN_NUM - 1).addExit(Direction.EAST);
    } // End of closeExits

    /**
     * @param dungeon ArrayList
     */
    private void placeWeapons(ArrayList<ArrayList<Room>> dungeon) {
        int rowsNum = dungeon.size(),                            // # of rows
                columnsNum = dungeon.get(0).size(),                // # of columns
                i;                                                    // loop counter
        final int NUM_WEAPONS = ((rowsNum * columnsNum) / 15) + 1;    // # of weapons to place in the dungeon
        int[] weaponRoom = {0, 0};                                    // The room where  weapon will be placed
        Random rand = new Random();
        Stack<Weapon> weapons = new Stack<Weapon>();                // Inventory of the possible weapons

        // Populate the inventory of possible weapons.
        weapons.add(new Stick("Stick", 1.0));
        weapons.add(new Crossbow("Crossbow", 2.0));
        weapons.add(new Sword("Sword", 3.0));
        weapons.add(new Axe("Axe", 5.0));
        weapons.add(new MorningStar("MorningStar", 6.0));


        // Shuffle the weapons inventory.
        Collections.shuffle(weapons);

        // Place single weapons until the number of required weapons has been reached
        for (i = 0; i < NUM_WEAPONS; i++) {
            // Choose a room, to place a weapon (except the starting room (0, 0)) 
            while (weaponRoom[0] == 0 && weaponRoom[1] == 0) {
                weaponRoom[0] = rand.nextInt(rowsNum);
                weaponRoom[1] = rand.nextInt(columnsNum);

                // If the room already has a weapon places, keep searching for a room available
                if (dungeon.get(weaponRoom[0]).get(weaponRoom[1]).getWeapon() != null) {
                    weaponRoom[0] = 0;
                    weaponRoom[1] = 0;
                }
            } // End of while loop

            // Fill the room selected with a weapon from the inventory
            dungeon.get(weaponRoom[0]).get(weaponRoom[1]).setWeapon(weapons.pop());

            // Reset the weaponRoom index
            weaponRoom[0] = 0;
            weaponRoom[1] = 0;

        } // End of for loop
    } // End of placeWeapons method


    /**
     * movePlayer is the method that will move the player to a direction selected via input
     * If moving the player confirms to be successful, it returns true, otherwise false
     * <p>
     * <hr>
     * Date created: Nov 01, 2017
     * <p>
     * <hr>
     *
     * @param direction Direction where player will move to
     * @return boolean to confirm if the operation was successful (true) or not successful (false)
     */
    public boolean movePlayer(Direction direction) {
        boolean confirm = false;  // start the boolean as false

        // If the room where the player is has the correct exit, move the player to that position
        // and set the confirm variable to true, otherwise false
        if (rooms.get(playerPosition[0]).get(playerPosition[1]).getExits().contains(direction)) {
            confirm = true;        //Set boolean to true if moving the player is successful

            // Adjust player's position based on the direction he moves according to user's input
            switch (direction) {
                // Moving to next column
                case EAST:
                    playerPosition[1]++;
                    break;
                // Moving to previous column
                case WEST:
                    playerPosition[1]--;
                    break;
                // Moving to upper row
                case NORTH:
                    playerPosition[0]--;
                    break;
                // Moving to lower row
                case SOUTH:
                    playerPosition[0]++;
                    break;
            } // End of switch statement
        }// End of if statement

        return confirm;
    } // End of movePlayer method


    /**
     * To check if the right-most column has an exist on in and return a boolean
     * <p>
     * <hr>
     * Date created: Nov 01, 2017
     * <p>
     * <hr>
     *
     * @return boolean
     */
    public boolean hasExitOnRightMost(ArrayList<ArrayList<Room>> dungeon) {

        int rowsNum = dungeon.size() - 1;                            // # of rows
        int columnsNum = dungeon.get(0).size() - 1;                // # of columns

        for (int i = 0; i < rowsNum; i++) {
            for (int j = 0; j < columnsNum; j++) {
                if (dungeon.get(i).get(j).hasExit(Direction.EAST)) {
                    return false;
                }
            }
        }

      /*   if (this.getPlayerPosition().length > this.rooms.size())
         {
            return true;
         } // End of if Statement*/

        return true;
    } // End of hasExitOnRightMost method

    /**
     * Generates a String to represent the Dungeon
     * It contains all the elements to draw the dungeon and indicate
     * monsters and weapons in it
     * <p>
     * <hr>
     * Date created: Nov 01, 2017
     * <p>
     * <hr>
     *
     * @return the formatted string
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String dungeonString = "";
        // Variables a and b are used to track player's location in the dungeon
        int a = 0;                // Current row indicator
        int b = 0;            // Current column indicator

        try            // Begin of try
        {
            // Loop in each row
            for (ArrayList<Room> row : rooms) {
                // At each row's start, set b to 0
                b = 0;

                // Loop into each room in the row
                for (Room r : row) {
                    dungeonString += "|_";    // Every room begins with "|_"

                    // If a given row/column matches with player's position, set player's first Letter of his name
                    if (playerPosition[0] == a && playerPosition[1] == b)
                        dungeonString += player.getName().substring(0, 1);
                    else
                        dungeonString += "_";

                    // If a given room has a Monster in it, set monster's initial to the room, otherwise set the floor 
                    if (r.getMonster() != null) {
                        switch (r.getMonster().getClass().getSimpleName()) {
                            case "Vampire":
                                dungeonString += "V";
                                break;
                            case "Werewolf":
                                dungeonString += "W";
                                break;
                            case "Troll":
                                dungeonString += "T";
                                break;
                        } // End of switch statement
                    } // End of if statement
                    else {
                        // If no monster or player is in the room, then set the floor "_"
                        dungeonString += "_";
                    }

                    // If a given room has a Weapon in it, set the weapon's initial to the room, otherwise set the floor
                    if (r.getWeapon() != null) {
                        switch (r.getWeapon().getClass().getSimpleName()) {
                            case "Stick":
                                dungeonString += "K";
                                break;
                            case "Sword":
                                dungeonString += "S";
                                break;
                            case "Crossbow":
                                dungeonString += "C";
                                break;
                            case "Axe":
                                dungeonString += "A";
                                break;
                            case "MorningStar":
                                dungeonString += "M";
                                break;
                        } // End of switch statement
                    } // End of if statement
                    else {
                        // If no weapon or player is in the room, then set the floor "_"
                        dungeonString += "_";
                    }

                    dungeonString += "_|";    // Every room ends with "_|"

                    b++;        // column counter increment

                } // End of for loop - columns

                dungeonString += "\n";

                a++; // row counter increment

            } // End of for loop - rows

        } // End of try
        catch (Exception e) // Begin of catch
        {
            System.out.println(e.getMessage());
        }
        return dungeonString; // End of catch
    } // End of toString method
} // End of Dungeon class
