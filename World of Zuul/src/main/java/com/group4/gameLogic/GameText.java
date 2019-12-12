package com.group4.gameLogic;

import java.util.ArrayList;
import java.util.Scanner;

public class GameText {

    private static String[] randLineArray;

    public static void fillArray() { //is to be filled with catching phrases involving the facts about plastic items from our poster.
        randLineArray = new String[13];
        randLineArray[0] = "3,728,712 food wrappers\nwere found in the ocean in the 2019 coastal cleanup. ";
        randLineArray[1] = "3,668,871 Straws and Strippers\nwere found in the 2019 coastal cleanup. ";
        randLineArray[2] = "1,968,065 forks spoons and knifes\nwere found in the 2019 coastal cleanup. ";
        randLineArray[3] = "1,754,908 plastic beverage\nbottles were found in the 2019 coastal cleanup. ";
        randLineArray[4] = "1,390,232 plastic bottle caps\nwere found in the 2019 coastal cleanup. ";
        randLineArray[5] = "964,541 plastic grocery bags\nwere found in the 2019 coastal cleanup. ";
        randLineArray[6] = "938,929 other plastic bags\nwere found in the 2019 coastal cleanup. ";
        randLineArray[7] = "728,892 plastic lids\nwere found in the 2019 coastal cleanup";
        randLineArray[8] = "656,276 plastic cups and plates\nwere found in the 2019 coastal cleanup. ";
        randLineArray[9] = "The 2019 coastal cleanup found enough plastic beverage cans\nto make full armor for 308 superheroes! ";
        randLineArray[10] = "Did the 2019 coastal cleanup find any plastic bags?\nThey found enough plastic bags to make plastic bag\ncapes for 1,056,514 superheroes. ";
        randLineArray[11] = "How many baloons did the 2019 coastal cleanup find?\nEnough plastic ballons to make 17,5 superheroes fly! ";
        randLineArray[12] = "A total of 97,457,984 plastic items were\ncollected in the 2019 worldwide coastal cleanup. ";
    }

    public static String getRandLine() { //currently un-used. Is to be used for printing out facts about plastic polution in the oceans.
        int temp = (int) Math.round(Math.random() * randLineArray.length - 1);
        System.out.println(temp);
        return randLineArray[temp];

    }

    public static String causeOfDeath(Character player) {
        if (player.getLife() <= 0 && player.getBreath() <= 0) {
            return "You ran out of breath and drowned! \n   Game Over!";
        } else if (player.getLife() <= 0 && player.getBreath() != 0) {
            return "You ran head first into a shark and died! \n   Game Over!";
        } else {
            return "";
        }
    }

    public static String introLine() {
        return "Hello, you are about to begin the game.\n"+
        		"Please begin by entering your name, followed by hitting Enter.\n"+
				"> ";
    }
    
    public static String introLineUI() {
        return "Welcome to OceanClear \n"+
                "OceanClear is a game about cleaning the ocean \n"+
                "Use the keys 'W' 'A' 'S' 'D' or the buttons to control the character \n"+
                "Your mission is to ollect all the plastic, and bring it to the boat \n"+
                "Once you've collected all the plastic from the ocean, you'll discover bigger oceans\n"+
                "Go safe our oceans!";
    }

    public static void printWelcome(Character player1) {
        System.out.println();
        System.out.println("Welcome to OceanClear " + player1.getName() + ". We are happy you are here. Let's get started.");
        System.out.println("OceanClear is a game about cleaning the ocean.");
        System.out.println();

        System.out.println();
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
    }

    public static void printInfo(Character player1, Room[][] room, Room currentRoom) {

        System.out.println();
        System.out.println("Collectables: ");
        for (Room[] room1 : room) {
            for (Room room11 : room1) {
                if (room11.getCollectable() != null) {
                    System.out.println(room11.getCollectable());
                }
            }
        }
        System.out.println();
        System.out.println("Hostiles: ");
        for (Hostiles hostile : Room.getHostilesActive()) {
            System.out.println(hostile);
        }

        System.out.println();
        System.out.println("Current Inventory: " + player1.getInventory().size() + "/" + player1.getCarryCapacity());
        for (Collectables inv : player1.getInventory()) {
            System.out.println(inv.getName());
        }

        System.out.println();
        System.out.println("Player Health:" + player1.getLife());
        System.out.println("Player Breath:" + player1.getBreath());
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    public static String uppercaseName(String name) {
        name = name.trim();        //Trim to get rid of white space (both in before and after the string)

        ArrayList<String> nameArray = new ArrayList<>();

        //While the name contains a space, fetch all the segments in between the spaces
        while (name.contains(" ")) {
            int cutAt = name.indexOf(" ");                  //indexOf(" ") gives an int correcsponding to where the first space is in the string
            nameArray.add(name.substring(0, cutAt));         //So the first "name" must be from 0 to where the space occurs
            name = name.substring(cutAt + 1);                 //Now we cut at this point + 1, because we dont want to include the space
        }
        //Since the name was trimmed originally, the last "name" can't be found by looking for the space character
        nameArray.add(name);
        //Reset name, as we are going to have it contain the uppercased version instead
        name = "";

        //For the entire nameArray, set name to the i'th arrayElement with first letter uppercased and rest lowercased
        for (int i = 0; i < nameArray.size(); i++) {
            name += nameArray.get(i).substring(0, 1).toUpperCase() + nameArray.get(i).substring(1).toLowerCase() + " ";
        }

        //The above method, adds an additional space at the end, we remove this here.
        name = name.trim();

        return name;
    }

    // got it from https://stackoverflow.com/questions/2979383/java-clear-the-console 08-11-19
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
