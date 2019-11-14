/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import java.util.Scanner;

/**
 *
 * @author mikai
 */
public class Shopping {
    
    private static ParserShop parser;
    
    public static void goToShop(Character player1) {
        
//       RYK CARACTER TIL SHOP RUM FØRST EFTER 1 ITERATION       
//        SHOW COMMANDWORDSFORSHOP MED PARSER
//        
//        GET INPUT OF UPGRADE
//                UPGRADE THE SELECTED UPGRADE
//        
//        WRITE NEXT TO NEW LEVEL
        

        System.out.println("Welcome to the Shop. We are happy you are here. Let's get you upgraded.");
        System.out.println("Du har " + player1.getRewards() + " rewards at gøre godt med");
        parser = new ParserShop();
        
        parser.showShopCommands();
        
        boolean finished = false;
        while (! finished) {
            CommandShop command = parser.getCommand();
            finished = processShopCommand(player1, command);
        }
        
    }
    
    private static boolean processShopCommand(Character player1, CommandShop command) 
    {
        boolean wantToNextLevel = false;

        CommandWordShop commandWord = command.getCommandWord();

        if(commandWord == CommandWordShop.UNKNOWN) {
            System.out.println("I don't know what you mean...");  //Whenever the commandWord is set to .UNKNOWN prints this message, used to communicate to the player that the input wasn't understood.
            return false;
        }

        if (commandWord == CommandWordShop.HELP) { //If CommandWord is set to help, printHelp (See below)
            printShopHelp();
        }
        else if (commandWord == CommandWordShop.BREATH) {
            if (player1.getRewards() > 0) {
                player1.setBreath(player1.getBreath()+1); 
                System.out.println("Your breath has been upgraded to " + player1.getBreath()); 
                player1.setRewards(player1.getRewards()-1);
                System.out.println("You now have " + player1.getRewards() + " rewards left");
            }
            else if (player1.getRewards() == 0){ 
                System.out.println("You have spent all of your rewards");
                System.out.println("You better nextlevel it");
            }
        } 
        else if (commandWord == CommandWordShop.INVENTORY) {
            if (player1.getRewards() > 0) {
                player1.setCarryCapacity(player1.getCarryCapacity()+1);
                System.out.println("Your inventory capacity has been upgraded to " + player1.getCarryCapacity()); 
                player1.setRewards(player1.getRewards()-1);
                System.out.println("You now have " + player1.getRewards() + " rewards left");
            }
            else if (player1.getRewards() == 0){ 
                System.out.println("You have spent all of your rewards"); 
                System.out.println("You better nextlevel it");
            }
        } else if (commandWord == CommandWordShop.NEXTLEVEL) {
            wantToNextLevel = nextLevel(command);
        }
        return wantToNextLevel;
    }
    
    private static void printShopHelp() 
    {
        System.out.println("Your command words are:");
        parser.showShopCommands();
    }
    
    private static boolean nextLevel(CommandShop command) //ligesom quit command
    {
        if(command.hasSecondWord()) {
            System.out.println("Next what?");
            return false;
        }
        else {
            return true;
        }
    }
    
    
}
