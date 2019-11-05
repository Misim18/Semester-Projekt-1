package worldofzuul;

public class Game //attributes
{
    private Parser parser;
    private Room currentRoom;
    private int limitY = 0; //Character.levelReached times x_1 + x_2
    private int limitX = 0; //Same as above     

    public Game() //Constructor
    {
        createRooms();
        parser = new Parser();
    }

    public int getLimitY() {
        return limitY;
    }

    public int getLimitX() {
        return limitX;
    }

     
    public void setLimitY(int limitY) {
        this.limitY = limitY;
    }

    public void setLimitX(int limitX) {
        this.limitX = limitX;
    }

    
    private void createRooms() //Sets up the rooms in the game
    {
    setLimitX(5);
    setLimitY(3);
    
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
    for (int x = 1; x < getLimitX(); x++) 
    {
        grid[y][x].setExit("south", grid[y+1][x]);
    }
}

//Sets north exits
    for (int y = 1; y < getLimitY(); y++) // y starts at one, as to not give north exit on top row
{
    for (int x = 1; x < getLimitX(); x++) 
    {
        grid[y][x].setExit("north", grid[y-1][x]);
    }
}    

        for (int y = 0; y < getLimitY(); y++) {
            for (int x = 0; x < getLimitX(); x++) {
                System.out.println(grid[y][x].getShortDescription());
                System.out.println(grid[y][x].getCoordinateX());
                System.out.println(grid[y][x].getCoordinateY());
            }
        }
    
        currentRoom = grid[0][Math.round(getLimitX()/2)]; //Change to grid[0][limitX/2] something something ceil...
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
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");  //Whenever the commandWord is set to .UNKNOWN prints this message, used to communicate to the player that the input wasn't understood.
            return false;
        }

        if (commandWord == CommandWord.HELP) { //If CommandWord is set to help, printHelp (See below)
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
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

    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) { //if the command does not have second word
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();  //Otherwise create string 'dicrection' equal to second word

        Room nextRoom = currentRoom.getExit(direction); //Goes the direction specified by second word, unless that exit doesn't exist (Lowercase / Uppercase isn't accounted for)

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
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
