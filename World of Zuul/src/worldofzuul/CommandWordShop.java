package worldofzuul;

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
