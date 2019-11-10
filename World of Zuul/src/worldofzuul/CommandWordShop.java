package worldofzuul;
//blueprint for the commandWords the user can use in the shop "room".

public enum CommandWordShop
{
    BREATH("upgradebreath"), INVENTORY("upgradeinventory"), HELP("help"), UNKNOWN("?"), NEXTLEVEL("nextlevel");
    
    private String commandString;
    
    CommandWordShop(String commandString)
    {
        this.commandString = commandString;
    }
    
    public String toString()
    {
        return commandString;
    }
}
