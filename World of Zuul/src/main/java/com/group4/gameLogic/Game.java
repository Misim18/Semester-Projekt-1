package com.group4.gameLogic;

import com.group4.gui.App;
import com.group4.myData.Load;
import com.group4.myData.Save;
import java.util.ArrayList;
import java.util.Scanner;

public class Game //attributes
{

    private Parser parser;
    private Room currentRoom;
    private static int limitY;
    private static int limitX;
	private int option;
    private Room boat;
    private Room[][] grid;
    private Save save;
    private Load load;
    public Character player1;
    public Shopping shop;

    public Game(int option) //Constructor
    {
		// option: 1=text 2=gui
		this.option = option;
		if(option == 1){
        Scanner s = new Scanner(System.in);                                         //Initializes new scanner object
        Text.introLine();                                                          //calls the introLine method in Text
        String name = s.nextLine();                                                 //Takes the first input line and saves it as name (String)
        name = Text.uppercaseName(name);                                                 //Makes the first letter uppercase and the rest lowercase, and accounts for several names
        player1 = new Character(name, (getLimitX() / 2), 1);                      //Makes a new character, feeding the name, X, Y & Breath to the contructor
		} else if(option == 2){
			player1 = new Character((getLimitX() / 2), 1);
		}
        parser = new Parser();                                                      //Part of original world of zuul, but creates a new Parser
        load = new Load();
        save = new Save();
        boat = new Boat(2, 0, "now in the boat room, with the coordinates: x:" + 2 + " y:" + 0);
        shop = new Shopping(player1);
        Collectables.initializeItemNames();                                                      //Calls the initializeItemNames method
        nextLevel();                                                                //Calls the nextLevel method
    }

    public void nextLevel() {                                               //Java said it might be a good idea to make this final, as to never be overwritten.
        setLimitX(5 + 2 * player1.getLevelReached());                         //Sets the new limitX
        setLimitY(7 + 2 * player1.getLevelReached());                         //Sets the new limitX
        Room.clearHostilesActive();                                         //Resets the ArrayList containing HostilesActive
        createRooms();
        createInitialCollectables((5 + 2 * player1.getLevelReached()) - player1.getRecyclingUpgrade());//-*-*-*-RecyclingUpgrade         //Creates the amount of Collectables fed into the method
        createInitialHostiles(3 + 1 * player1.getLevelReached());             //Creates the amount of Hostiles fed into the method
        player1.setLevelReached(player1.getLevelReached() + 1);           //Increments levelReached
        player1.setRewards(player1.getRewards() + 2);                 //gives rewards to character for upgrades
        //Creates the playable grid System.out.println(boat);
    }

    public Room[][] getGrid(){
        return grid;
    }
    
    public static int getLimitY() {
        return limitY;
    }

    public static int getLimitX() {
        return limitX;
    }

    public void setLimitY(int limitY) {
        this.limitY = limitY;
    }

    public void setLimitX(int limitX) {
        this.limitX = limitX;
    }

    //Creates and int number of hostiles and loads them into the activeHostiles ArrayList in Room
    private void createInitialHostiles(int amountOfActiveHostiles) {
        for (int x = 0; x < amountOfActiveHostiles; x++) {
            Room.addToHostilesActive(new Shark());
        }
    }

    //Creates an int number of Collectables and loads them into the Room(grid).
    private void createInitialCollectables(int amountOfCollectables) {
        // count is used to prevent an infinite loop
        int count = 0;
        for (int x = 0; x < amountOfCollectables; x++) {
            Collectables temp = new Collectables();
            // check it the Room is empty and then put the item in
            // else it count one less and tries again. it can do that 10 times.
            if (grid[temp.getCoordinateY()][temp.getCoordinateX()].getCollectable() == null) {
                grid[temp.getCoordinateY()][temp.getCoordinateX()].addCollectable(temp);
            } else {
                x--;
                count++;
                if (count >= 1000) {
                    x = amountOfCollectables + 1;
                }
            }
        }
    }

    private void createRooms() //Sets up the rooms in the game
    {
        //Creates a new two-dimensional room array, with limitY "slots" of limitX elements
        grid = new Room[getLimitY()][getLimitX()];

        //Creates the grid and places the boat in the top row and in the middle.
        for (int y = 0; y < getLimitY(); y++) {
            for (int x = 0; x < getLimitX(); x++) {
                if (x == getLimitX() / 2 && y == 0) {
                    grid[y][x] = boat;
                    boat.setCoordinate_X_Y(getLimitX() / 2, 0);
                } else if (y == 0) {
                    grid[y][x] = new Room(x, y, "now above the surface, in the room with the coordinates: x:" + x + " y:" + y);
                } else {
                    grid[y][x] = new Room(x, y, "now beneath the surface, in the room with the coordinates: x:" + x + " y:" + y);
                }
            }
        }

        //Sets right exits
        for (int y = 0; y < getLimitY(); y++) {
            for (int x = 0; x < getLimitX() - 1; x++) {
                grid[y][x].setExit("right", grid[y][x + 1]);
            }
        }

        //Sets left exits
        for (int y = 0; y < getLimitY(); y++) {
            for (int x = 1; x < getLimitX(); x++) //x starts at 1, as to not
            {
                grid[y][x].setExit("left", grid[y][x - 1]);
            }
        }

        //Sets down exits
        for (int y = 0; y < getLimitY() - 1; y++) //y goes to max limit - 1, as to not give bottom row down exit
        {
            for (int x = 0; x < getLimitX(); x++) {
                grid[y][x].setExit("down", grid[y + 1][x]);
            }
        }

        //Sets up exits
        for (int y = 1; y < getLimitY(); y++) // y starts at one, as to not give up exit on top row
        {
            for (int x = 0; x < getLimitX(); x++) {
                grid[y][x].setExit("up", grid[y - 1][x]);
            }
        }

        ////Can be used for printing info about rooms (Troubleshooting)
        //
        //        for (int y = 0; y < getLimitY(); y++) {
        //            for (int x = 0; x < getLimitX(); x++) {
        //                System.out.println(grid[y][x].getShortDescription());
        //                System.out.println(grid[y][x].getCoordinateX());
        //                System.out.println(grid[y][x].getCoordinateY());
        //            }
        //        }
        currentRoom = grid[1][getLimitX() / 2];
    }

    public void play() {
        Text.printWelcome(player1);
        Text.printInfo(player1, grid, currentRoom);

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }

        Text.printInfo(player1, grid, currentRoom);
        System.out.println("");
        System.out.println(Text.causeOfDeath(player1));
        System.out.println("");
        System.out.println("Thank you for playing.  Good bye.");
    }

    public boolean processCommand(Command command) {
        boolean wantToQuit = false;
        Text.clearScreen();

        CommandWord commandWord = command.getCommandWord();
        System.out.println();

        if (commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");  //Whenever the commandWord is set to .UNKNOWN prints this message, used to communicate to the player that the input wasn't understood.
            return false;
        }

        if (commandWord == CommandWord.HELP) { //If CommandWord is set to help, printHelp (See below)
            printHelp();
        } else if (commandWord == CommandWord.GO) {
            wantToQuit = goRoom(command);
        } else if (commandWord == CommandWord.CHEAT) {
            cheat(command);
        } else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        } else if (commandWord == CommandWord.SAVE) {
            save.SaveGame(player1);
            System.out.println("Saved game");
			System.out.println("Player Name: "+player1.getName());
			System.out.println("Player Rewards: "+player1.getRewards());
			System.out.println("Player LevelReached: "+player1.getLevelReached());
        } else if (commandWord == CommandWord.LOAD) {
            load.LoadGame(player1);
            System.out.println("Loaded game");
			System.out.println("Player Name: "+player1.getName());
			System.out.println("Player Rewards: "+player1.getRewards());
			System.out.println("Player LevelReached: "+player1.getLevelReached());
        }
        return wantToQuit;
    }

    private void cheat(Command command) {
        if (!command.hasSecondWord()) { //if the command does not have second word
            System.out.println("What kind of cheat?, it taks one arg?");
            return;
        }
        String cheat = command.getSecondWord();
        switch (cheat) {
            case "list":
                System.out.println("cheat motherload");
                System.out.println("cheat getAllItem");
                System.out.println("cheat nextlevel");
                break;
            case "motherload":
                System.out.println("Here are 999,999 thousend of dollars to sims xD ");
                update();
                break;
            case "getAllItem":
                cheatAddItems();
                break;
            case "nextLevel":
                nextLevel();
                break;
            default:
                System.out.println("This: " + cheat + "is not implementet yet");
        }
    }

    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    public boolean goRoom(Command command) {
        if (!command.hasSecondWord()) { //if the command does not have second word
            System.out.println("Go where?");
            return false;
        }

        String direction = command.getSecondWord();  //Otherwise create string 'dicrection' equal to second word

        Room nextRoom = currentRoom.getExit(direction); //Goes the direction specified by second word, unless that exit doesn't exist (Lowercase / Uppercase isn't accounted for)

        if (nextRoom == null) {
            System.out.println("There is no door!");
            Text.printInfo(player1, grid, currentRoom);
        } else {
            currentRoom = nextRoom;
            return update();

        }
        return false;
    }

    public boolean quit(Command command) //quit command, med fejl på quit + second word
    {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }

    // return true to end game.
    private boolean update() {
        Room.updateHostiles();
        int itemsLeft = itemLeft();
        // Set the player coordinates
        player1.setCoordinate_X_Y(currentRoom.getCoordinateX(), currentRoom.getCoordinateY());

        // Check it player is on boat:
        // it returns true if there is no more items.
        if (currentRoom.playerOnBoat(player1, itemsLeft)) {
            currentRoom.countCollectableTypes(player1);
            currentRoom.printCollectablesData(player1);
			if(option == 1){
            	shop.goToShop(player1);
			} else if(option == 2){
				//shop.injectPlayer(player1);
				App.toggleUI();

			}
            nextLevel();
        }

        // Check if player is on item, then player pickup
        player1.OnItem(grid);

        // Updates player breath and if it return true you are dead.
        if (player1.UpdateBreath()) {
            return true;
        }

        // Check if the hostiles hits the player.
        if (player1.hitHostile(Room.getHostilesActive())) {
            // return true if player is dead
            return true;
        }

        // print where player, collectables, and hostiles
        Text.printInfo(player1, grid, currentRoom);

        return false;
    }

    private int itemLeft() {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].getCollectable() != null) {
                    count++;
                }
            }
        }
        return count;
    }

    private void cheatAddItems() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].getCollectable() != null) {
                    player1.addToInventoryCheat(grid[i][j].getCollectable());
                    grid[i][j].addCollectable(null);
                }
            }
        }
    }
}
