package com.group4.gameLogic;

import java.util.ArrayList;
import java.util.Scanner;

public class Text {

    private String Line;
    private String[] randLineArray = new String[10];

    public Text() {
    }

    public void fillArray() { //is to be filled with catching phrases involving the facts about plastic items from our poster.
        randLineArray[0] = "2,412,151";
        randLineArray[1] = "1,739,743";
        randLineArray[2] = "1,569,135";
        randLineArray[3] = "1,091,107";
        randLineArray[4] = "757,523";
        randLineArray[5] = "746,211";
        randLineArray[6] = "643,562";
        randLineArray[7] = "632,874";
        randLineArray[8] = "624,878";
        randLineArray[9] = "580,570";
    }

    public String getLine() {
        return Line;
    }

    public static String causeOfDeath(Character player) {
        if (player.getLife() == 0 && player.getBreath() == 0) {
            return "You ran out of breath and drowned! \n   Game Over!";
        } else if (player.getLife() == 0 && player.getBreath() != 0) {
            return "You ran head first into a shark and died! \n   Game Over!";
        } else {
            return "";
        }
    }

    public static String RandomFact() {
        return "Math random missing to made. \n Edit me in Text.javai. Package gameLogic \n Maks 52 character per line";
    }

    public void getRandLine() { //currently un-used. Is to be used for printing out facts about plastic polution in the oceans.
        fillArray();
        int temp = (int) Math.round(Math.random() * 9);
        System.out.println(randLineArray[temp]);

    }

    public static void introLine() {
        System.out.println("Hello, you are about to begin the game.");
        System.out.println("Please begin by entering your name, followed by hitting Enter. ");
        System.out.print("> ");
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

    public static void printAfterMoved(Boat boat, int itemCount, Room[][] room) {
        ArrayList<Coordinate> listOfElements = new ArrayList<>();

        for (Room[] room1 : room) {
            for (Room room11 : room1) {
                if (room11.getCollectable() != null) {
                    listOfElements.add(room11.getCollectable());
                }
            }
        }

        for (int i = 0; i < Room.getHostilesActive().size(); i++) {
            listOfElements.add(Room.getHostilesActive().get(i));
        }

        for (Coordinate Element : listOfElements) {
            int xCoordinate = Element.getCoordinateX();
            int yCoordinate = Element.getCoordinateY();
            String type;
            if (Element instanceof Hostiles) {
                type = "hostile";
            } else if (Element instanceof Collectables) {
                type = "collectable";
            } else {
                type = "";
            }

            System.out.println("a " + type + " is at the coordinates: x" + xCoordinate + " Y" + yCoordinate);
        }

        System.out.println("Collectables left: " + itemCount);
        System.out.println("Trash collected in this level: " + boat.getLevelTrashCollected());
        System.out.println("Total trash collected: " + boat.getTotalTrashCollected());
        System.out.println("");
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
