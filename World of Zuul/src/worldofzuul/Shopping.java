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
    private static int rewards = 2; //ændre dette til at hænge sammen med de rewards vi rent faktisk får
    private static int fakeCarryCapacity = 3; //bruges kun til test, slet efter da den findes i Character
    //disse mutator og accessor bruges kun til test da de allerede findes i Character
    	public static int getFakeCarryCapacity(){
		return fakeCarryCapacity;
	}
	public static void setFakeCarryCapacity(int fakeCarryCapacityIn){
		fakeCarryCapacity = fakeCarryCapacityIn;
	}
    
    public static void goToShop() {
        
 //       RYK CARACTER TIL SHOP RUM FØRST EFTER 1 ITERATION       
//        SHOW COMMANDWORDSFORSHOP MED PARSER
//        
//        GET INPUT OF UPGRADE
//                UPGRADE THE SELECTED UPGRADE
//        
//        WRITE NEXT TO NEW LEVEL
        

        System.out.println("Welcome to the Shop. We are happy you are here. Let's get you upgraded.");
        System.out.println("Du har " + rewards + " rewards at gøre godt med");
        parser = new ParserShop();
        
        parser.showShopCommands();
        
        boolean finished = false;
        while (! finished) {
            CommandShop command = parser.getCommand();
            finished = processShopCommand(command);
        }
        
    }
    
    private static boolean processShopCommand(CommandShop command) 
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
            if (rewards > 0) {
                Shopping.setFakeCarryCapacity(Shopping.getFakeCarryCapacity()+1); //erstat denne med breathupgrade metode istedet
                System.out.println("Your breath has been upgraded to" + Shopping.getFakeCarryCapacity()); //erstat denne med breathupgrade metode istedet
                rewards = rewards - 1;
                System.out.println("You now have " + rewards + " rewards left");
            }
            else if (rewards == 0){ 
                System.out.println("You have spent all of your rewards");
                System.out.println("You better nextlevel it");
            }
        } 
        else if (commandWord == CommandWordShop.INVENTORY) {
            if (rewards > 0) {
                Shopping.setFakeCarryCapacity(Shopping.getFakeCarryCapacity()+1);
                System.out.println("Your inventory capacity has been upgraded to " + Shopping.getFakeCarryCapacity()); 
                rewards = rewards - 1;
                System.out.println("You now have " + rewards + " rewards left");
            }
            else if (rewards == 0){ 
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
