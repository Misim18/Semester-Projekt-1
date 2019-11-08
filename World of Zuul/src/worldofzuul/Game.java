package worldofzuul;

import java.util.Scanner;

public class Game //attributes
{
    private Parser parser;
    private Room currentRoom;
    private static int limitY;
    private static int limitX;
    private static Boat boat;
	private Character player1;
    private static String[] itemNames;

    public Game() //Constructor
    {
        //Shopping.goToShop(); Når vi vil kalde shoppen

        Scanner s = new Scanner(System.in);                                         //Initialises new scanner object
        Story.introLine();                                                          //calls the introLine method in Story
        String name = s.nextLine();                                                 //Takes the first input line and saves it as name (String)
        name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase(); //Makes the first letter uppercase and the rest lowercase (just flair)
	player1 = new Character(name, (getLimitX()/2), 1);                                    //Makes a new character, feeding the name to the contructor
        parser = new Parser();                                                      //Part of original world of zuul, but creates a new Parser
        boat = new Boat();                                                          //Creates a new boat
        initializeItemNames();                                                      //Calls the initializeItemNames method
        nextLevel();                                                                //Calls the nextLevel method
    }

    public void initializeItemNames () {
        itemNames = new String[7];
        itemNames[0] = "Food Wrapper";
        itemNames[1] = "Plastic Bottle";
        itemNames[2] = "Plastic Bottle Cap";
        itemNames[3] = "Plastic Bag";
        itemNames[4] = "Straw";
        itemNames[5] = "Plastic Take Away Container";
        itemNames[6] = "Plastic Lid";

//        //used for verifying content of itemNames
//        for (int x = 0; x < getItemNames().length; x++)
//    {
//        System.out.println(getItemNames()[x]);
//    }
    }

	public static Boat getBoat(){
		return boat;
	}

    public void nextLevel() {                                               //Java said it might be a good idea to make this final, as to never be overwritten.
        setLimitX(5+Character.getLevelReached()*2);                         //Sets the new limitX
        setLimitY(3+Character.getLevelReached()*2);                         //Sets the new limitX
        createRooms();                                                      //Creates the playable grid
        boat.placeBoat((getLimitX()/2), 0);                       //Places the boat at y = 0, x = middle
        boat.setLevelTrashCollected(0);                                     //Resets levelTrashCollected attribute in Boat
        Room.clearCollectablesLeft();                                       //Resets the ArrayList containing CollectablesLeft, this isn't really needed is it?
        Room.clearHostilesActive();                                         //Resets the ArrayList containing HostilesActive
        createInitialCollectables(0+0*Character.getLevelReached());         //Creates the amount of Collectables fed into the method
        createInitialHostiles(3+3*Character.getLevelReached());             //Creates the amount of Hostiles fed into the method
        Character.setLevelReached(Character.getLevelReached()+1);           //Increments levelReached
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

    public static String[] getItemNames() { //Returns the entire array
    return itemNames;
    }

    public static String getItemNamesElement(int x) { //Returns the x'th array element
    return itemNames[x];
    }

    private void createInitialHostiles(int amountOfActiveHostiles) //Creates and int number of hostiles and loads them into the activeHostiles ArrayList in Room
    {
		for (int x = 0; x < amountOfActiveHostiles; x++)
    	{
			Room.addToHostilesActive(new Hostiles(40));
		}
    }

    private void createInitialCollectables(int amountOfCollectables) //Creates and int number of Collectables and loads them into the collectablesLeft ArrayList in Room
    {

        Collectables[] gameCollectables = new Collectables[amountOfCollectables];

        for (int x = 0; x < gameCollectables.length; x++)
    {
        gameCollectables[x] = new Collectables();
    }

        for (int x = 0; x < gameCollectables.length; x++)
    {
        Room.addToCollectablesLeft(gameCollectables[x]);
    }

//            //Troubleshooting
//             for (int x = 0; x < gameCollectables.length; x++)
//    {
//        System.out.println("Collectables #" + x);
//        System.out.println(gameCollectables[x].getCoordinateX());
//        System.out.println(gameCollectables[x].getCoordinateY());
//        System.out.println(gameCollectables[x].getName());
//    }
//
    }

    private void createRooms() //Sets up the rooms in the game
    {
    //Creates a new two-dimensional room array, with limitY "slots" of limitX elements
    Room[][] grid = new Room[getLimitY()][getLimitX()];


//Creates the grid
    for (int y = 0; y < getLimitY(); y++)
{
    for (int x = 0; x < getLimitX(); x++)
    {
        grid[y][x] = new Room("x"+x+"y"+y);
        grid[y][x].setCoordinateX(x); //Can we delete these
        grid[y][x].setCoordinateY(y); //- by adding all the relevant information to current room, we only have to check that.
    }
}

//Sets east exits
    for (int y = 0; y < getLimitY(); y++)
{
    for (int x = 0; x < getLimitX()-1; x++)
    {
        grid[y][x].setExit("east", grid[y][x+1]);
    }
}

//Sets west exits
    for (int y = 0; y < getLimitY(); y++)
{
    for (int x = 1; x < getLimitX(); x++) //x starts at 1, as to not
    {
        grid[y][x].setExit("west", grid[y][x-1]);
    }
}

//Sets south exits
    for (int y = 0; y < getLimitY()-1; y++) //y goes to max limit - 1, as to not give bottom row south exit
{
    for (int x = 0; x < getLimitX(); x++)
    {
        grid[y][x].setExit("south", grid[y+1][x]);
    }
}

//Sets north exits
    for (int y = 1; y < getLimitY(); y++) // y starts at one, as to not give north exit on top row
{
    for (int x = 0; x < getLimitX(); x++)
    {
        grid[y][x].setExit("north", grid[y-1][x]);
    }
}

//Can be used for printing info about rooms (Troubleshooting)
//
//        for (int y = 0; y < getLimitY(); y++) {
//            for (int x = 0; x < getLimitX(); x++) {
//                System.out.println(grid[y][x].getShortDescription());
//                System.out.println(grid[y][x].getCoordinateX());
//                System.out.println(grid[y][x].getCoordinateY());
//            }
//        }

        currentRoom = grid[1][getLimitX()/2]; //Change to grid[0][limitX/2]
    }

    public void play()
    {
        printWelcome();

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to OceanClear " + Character.getName() + ". We are happy you are here. Let's get started.");
        System.out.println("OceanClear is a game about cleaning the ocean.");
        System.out.println();

        Story.tutorial();

        System.out.println();
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        Story.printInfo(currentRoom.getHostilesActive(), currentRoom.getCollectablesLeft(), player1.getLife(), currentRoom);
    }

    private boolean processCommand(Command command)
    {
        boolean wantToQuit = false;
		clearScreen();

        CommandWord commandWord = command.getCommandWord();
        System.out.println();
        
        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");  //Whenever the commandWord is set to .UNKNOWN prints this message, used to communicate to the player that the input wasn't understood.
            return false;
        }

        if (commandWord == CommandWord.HELP) { //If CommandWord is set to help, printHelp (See below)
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            wantToQuit = goRoom(command);
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }

    private void printHelp()
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private boolean goRoom(Command command)
    {
        if(!command.hasSecondWord()) { //if the command does not have second word
            System.out.println("Go where?");
            return false;
        }

        String direction = command.getSecondWord();  //Otherwise create string 'dicrection' equal to second word

        Room nextRoom = currentRoom.getExit(direction); //Goes the direction specified by second word, unless that exit doesn't exist (Lowercase / Uppercase isn't accounted for)

        if (nextRoom == null) {
            System.out.println("There is no door!");
            System.out.println(currentRoom.getHostilesActive());
            System.out.println(currentRoom.getCollectablesLeft());
			//return update(); tilføj senere spørg kevin
        }
        else {
            currentRoom = nextRoom;
			return update();
                        
        }
		return false;
    }

	private boolean update(){ 
		currentRoom.updateHostiles();
		
		// Set the player coordinates
		player1.setCoordinate_X_Y(currentRoom.getCoordinateX(), currentRoom.getCoordinateY());

		// Check it player is on boat:
		if(boat.getCoordinateY() == player1.getCoordinateY()){
				for(Collectables item : player1.dumpInventory()){
					boat.addToBoatInventory(item);
				}
                                player1.clearInventory();
				if(currentRoom.getNumberOfCollectablesLeft() <= 0){
					System.out.println("There are no more items left");
					Shopping.goToShop();
					nextLevel();
				} else{
				System.out.println("There are still more items left: " +
						currentRoom.getNumberOfCollectablesLeft());
				}
		}

		// Check if player is on item, then player pickup
		for(int i=0; i <currentRoom.getCollectablesLeft().size(); i++){
			if(currentRoom.getCollectablesLeft().get(i).getCoordinateX() == player1.getCoordinateX() &&
					currentRoom.getCollectablesLeft().get(i).getCoordinateY() == player1.getCoordinateY())
			{
				player1.addToInventory(currentRoom.getCollectablesLeft().get(i));
				System.out.println("You Picked up: " + currentRoom.getCollectablesLeft().get(i).getName());
				currentRoom.removeFromCollectablesLeft(i);
				--i;
			}
		}
                
		// Check if the hostiles hits the player.
		for(Hostiles hostile : currentRoom.getHostilesActive()){
			if(hostile.getCoordinateX() == player1.getCoordinateX() &&
					hostile.getCoordinateY() == player1.getCoordinateY())
			{
				// Damage the player
				player1.setLife(player1.getLife() - hostile.getDamage());
				// Checks if the player is dead
				if(player1.getLife()<=0){
					System.out.println("Player Health: " + player1.getLife());
					System.out.println("You are dead");
					return true;
				}
			}
		}
                Story.printInfo(currentRoom.getHostilesActive(), currentRoom.getCollectablesLeft(), player1.getLife(), currentRoom);
		return false;
	}

	// got it from https://stackoverflow.com/questions/2979383/java-clear-the-console 08-11-19
	public static void clearScreen() {
    	System.out.print("\033[H\033[2J");
    	System.out.flush();
	}

    private boolean quit(Command command) //quit command, med fejl på quit + second word
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }
}
