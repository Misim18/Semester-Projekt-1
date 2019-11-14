package worldofzuul;

import java.util.ArrayList;
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
        //Shopping.goToShop();                                                      //for when we wish to call the shop.

        Scanner s = new Scanner(System.in);                                         //Initializes new scanner object
        Text.introLine();                                                          //calls the introLine method in Text
        String name = s.nextLine();                                                 //Takes the first input line and saves it as name (String)
        name = uppercaseName(name);                                                 //Makes the first letter uppercase and the rest lowercase, and accounts for several names
	player1 = new Character(name, (getLimitX()/2), 1, 14);                      //Makes a new character, feeding the name, X, Y & Breath to the contructor
        parser = new Parser();                                                      //Part of original world of zuul, but creates a new Parser
        boat = new Boat();                                                          //Creates a new boat
        initializeItemNames();                                                      //Calls the initializeItemNames method
        nextLevel();                                                                //Calls the nextLevel method
    }

    public final void initializeItemNames () {
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

    public String uppercaseName (String name) {
    name = name.trim();        //Trim to get rid of white space (both in before and after the string)

    ArrayList<String> nameArray = new ArrayList<>();


    //While the name contains a space, fetch all the segments in between the spaces
    while (name.contains(" ")){
        int cutAt = name.indexOf(" ");                  //indexOf(" ") gives an int correcsponding to where the first space is in the string
        nameArray.add(name.substring(0,cutAt));         //So the first "name" must be from 0 to where the space occurs
        name = name.substring(cutAt+1);                 //Now we cut at this point + 1, because we dont want to include the space
    }
    //Since the name was trimmed originally, the last "name" can't be found by looking for the space character
    nameArray.add(name);
    //Reset name, as we are going to have it contain the uppercased version instead
    name = "";


    //For the entire nameArray, set name to the i'th arrayElement with first letter uppercased and rest lowercased
        for (int i = 0; i<nameArray.size(); i++){
        name += nameArray.get(i).substring(0,1).toUpperCase() + nameArray.get(i).substring(1).toLowerCase() + " ";
    }

    //The above method, adds an additional space at the end, we remove this here.
    name = name.trim();


    return name;
    }

	public Boat getBoat(){
		return boat;
	}

    public void nextLevel() {                                               //Java said it might be a good idea to make this final, as to never be overwritten.
        setLimitX(5+2*player1.getLevelReached());                         //Sets the new limitX
        setLimitY(7+2*player1.getLevelReached());                         //Sets the new limitX
        createRooms();                                                      //Creates the playable grid
        boat.placeBoat((getLimitX()/2), 0);                       //Places the boat at y = 0, x = middle
        boat.setLevelTrashCollected(0);                                     //Resets levelTrashCollected attribute in Boat
        Room.clearCollectablesLeft();                                       //Resets the ArrayList containing CollectablesLeft, this isn't really needed is it?
        Room.clearHostilesActive();                                         //Resets the ArrayList containing HostilesActive
        createInitialCollectables((5+2*player1.getLevelReached())-player1.getRecyclingUpgrade());//-*-*-*-RecyclingUpgrade         //Creates the amount of Collectables fed into the method
        createInitialHostiles(3+1*player1.getLevelReached());             //Creates the amount of Hostiles fed into the method
        player1.setLevelReached(player1.getLevelReached()+1);           //Increments levelReached
        player1.setRewards(player1.getRewards()+2);                 //gives rewards to character for upgrades
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
			Room.addToHostilesActive(new Shark());
		}
    }

    private void createInitialCollectables(int amountOfCollectables) //Creates an int number of Collectables and loads them into the collectablesLeft ArrayList in Room
    {

        Collectables[] gameCollectables = new Collectables[amountOfCollectables];

        for (int x = 0; x < gameCollectables.length; x++)
    {
        gameCollectables[x] = new Collectables();
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
        grid[y][x] = new Room(x, y, "x"+x+"y"+y);
    }
}

//Sets right exits
    for (int y = 0; y < getLimitY(); y++)
{
    for (int x = 0; x < getLimitX()-1; x++)
    {
        grid[y][x].setExit("right", grid[y][x+1]);
    }
}

//Sets left exits
    for (int y = 0; y < getLimitY(); y++)
{
    for (int x = 1; x < getLimitX(); x++) //x starts at 1, as to not
    {
        grid[y][x].setExit("left", grid[y][x-1]);
    }
}

//Sets down exits
    for (int y = 0; y < getLimitY()-1; y++) //y goes to max limit - 1, as to not give bottom row down exit
{
    for (int x = 0; x < getLimitX(); x++)
    {
        grid[y][x].setExit("down", grid[y+1][x]);
    }
}

//Sets up exits
    for (int y = 1; y < getLimitY(); y++) // y starts at one, as to not give up exit on top row
{
    for (int x = 0; x < getLimitX(); x++)
    {
        grid[y][x].setExit("up", grid[y-1][x]);
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

        currentRoom = grid[1][getLimitX()/2]; 
    }

    public void play()
    {
        Text.printWelcome(player1);
        Text.printInfo(player1, currentRoom);
        
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }

        Text.printInfo(player1, currentRoom);
        System.out.println("Thank you for playing.  Good bye.");
    }


    private boolean processCommand(Command command)
    {
        boolean wantToQuit = false;
		Text.clearScreen();

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
		else if(commandWord == CommandWord.CHEAT) {
			cheat(command);
		}
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }

	private void cheat(Command command){
        if(!command.hasSecondWord()) { //if the command does not have second word
            System.out.println("What kind of cheat?, it taks one arg?");
            return;
        }
		String cheat = command.getSecondWord();
		switch(cheat){
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
				for(Collectables item : currentRoom.getCollectablesLeft()){
					player1.addToInventory(item);
				}
				currentRoom.clearCollectablesLeft();
				update();
				break;
			case "nextLevel":
				nextLevel();
				break;
			default:
				System.out.println("This: " + cheat + "is not implementet yet");
      }
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
            Text.printInfo(player1, currentRoom);
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
				for(Collectables item : player1.getInventory()){
					boat.addToBoatInventory(item);
				}
                                player1.clearInventory();
				if(currentRoom.getNumberOfCollectablesLeft() <= 0){
					System.out.println("There are no more items left");
					Shopping.goToShop(player1);
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
				// Checks if the player has room in inventory and then add it to players inventory.
				// Else Print don't have room
				if(player1.addToInventory(currentRoom.getCollectablesLeft().get(i))){
				System.out.println("You Picked up: " + currentRoom.getCollectablesLeft().get(i).getName());
				currentRoom.removeFromCollectablesLeft(i);
				--i;
				} else {
					System.out.println("You dont have any more room.");
					System.out.println("Your inventory size: " + player1.getCarryCapacity() + "/" + player1.getCarryCapacity());
				}
			}
		}

		// Updates player breath and if it return true you are dead.
		if(player1.UpdateBreath()){
			return true;
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
        Text.printInfo(player1, currentRoom);
		return false;
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
