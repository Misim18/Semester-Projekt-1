package worldofzuul;
import java.util.HashMap;


public class CommandWordsShop
{
    private HashMap<String, CommandWordShop> validCommandsShop;

    public CommandWordsShop()
    {
        validCommandsShop = new HashMap<String, CommandWordShop>();
        for(CommandWordShop command : CommandWordShop.values()) {
            if(command != CommandWordShop.UNKNOWN) {
                validCommandsShop.put(command.toString(), command);
            }
        }
    }

    public CommandWordShop getCommandWordShop(String commandWordShop)
    {
        CommandWordShop command = validCommandsShop.get(commandWordShop);
        if(command != null) {
            return command;
        }
        else {
            return CommandWordShop.UNKNOWN;
        }
    }
    
    public boolean isCommand(String aString)
    {
        return validCommandsShop.containsKey(aString);
    }

    public void showAll() 
    {
        for(String command : validCommandsShop.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
