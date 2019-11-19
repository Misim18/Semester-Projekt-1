package worldofzuul;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator; //unused import?

public class Room extends Coordinate {

    private String description;
    private HashMap<String, Room> exits;
    private static ArrayList<Hostiles> hostilesActive = new ArrayList<>();
    private static ArrayList<Collectables> collectablesLeft = new ArrayList<>();

    public Room (int x, int y, String description) //Sets up the room, and assigns the description to be equal to the string given to the contructor
    {
        super(x,y);
        this.description = description;
        exits = new HashMap<String, Room>();
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public String getShortDescription() //Returns the desciption, which is already a string so an accessor method, although at the same time also a .toString method
    {
        return description;
    }

    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString();
    }

    private String getExitString() {
        String returnString = "Exits:";     //First word of the 'returnString'
        Set<String> keys = exits.keySet();  //Creates a set of Strings called keys, and is equal to the entire key-set for exits (HashMap)
        for (String exit : keys) {           //Adds all the exits for the room to the 'returnString'
            returnString += " " + exit;
        }
        return returnString;                //Returns the entire 'returnString'
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public static ArrayList<Hostiles> getHostilesActive() {
        return hostilesActive;
    }

    public static void addToHostilesActive(Hostiles hostile) {
        hostilesActive.add(hostile);
    }

    public static void overwriteActiveHostile(int number) { //Adds a new hostile at the given index, and removes the old one
        Hostiles tmpHostile = new Shark();
        hostilesActive.add(number, tmpHostile);
        hostilesActive.remove(number + 1);
    }

    public static void clearHostilesActive() {
        hostilesActive.clear();
    }

    public static void updateHostiles() { //U N - T E S T E D
        for (int i = 0; i < hostilesActive.size(); i++) { //Goes through all the active hostiles and...
            if (hostilesActive.get(i).getCoordinateX() == 0 && hostilesActive.get(i).getDirectionX() == -1) { //if they're at the left side AND are moving left, overwrite hostile
                Room.overwriteActiveHostile(i);
            } else if (hostilesActive.get(i).getCoordinateX() == Game.getLimitX() && hostilesActive.get(i).getDirectionX() == 1) { //if they're at the right side AND are moving right, overwrite hostile
                Room.overwriteActiveHostile(i);
            } else {
                hostilesActive.get(i).setCoordinateX(hostilesActive.get(i).getCoordinateX() + hostilesActive.get(i).getDirectionX()); //Just update their position
            }
        }
    }

    public static ArrayList<Collectables> getCollectablesLeft() {
        return collectablesLeft;
    }

    public static int getNumberOfCollectablesLeft() {
        return collectablesLeft.size();
    }

    public static void addToCollectablesLeft(Collectables collectable) {
        collectablesLeft.add(collectable);
    }

    public static void removeFromCollectablesLeft(int index) {
        collectablesLeft.remove(index);
    }

    public static void clearCollectablesLeft() {
        collectablesLeft.clear();
    }

        @Override
    public String toString(){
        return "Should this be implemented?";
    }

}
