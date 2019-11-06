package worldofzuul;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;


public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private int CoordinateX;
    private int CoordinateY;
    private static ArrayList<Hostiles> hostilesActive = new ArrayList<>();
    private static ArrayList<Collectables> collectablesLeft = new ArrayList<>();

    public Room(String description)  //Sets up the room, and assigns the description to be equal to the string given to the contructor
    {
        //super(x,y)
        this.description = description;
        exits = new HashMap<String, Room>();
    }

    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription() //Returns the desciption, which is already a string so an accessor method, although at the same time also a .toString method
    {
        return description;
    }

    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    private String getExitString()
    {
        String returnString = "Exits:";     //First word of the 'returnString'
        Set<String> keys = exits.keySet();  //Creates a set of strings called keys, and is equal to Set is a collection that can't contain dublicates
        for(String exit : keys) {           //Adds all the exits for the room to the 'returnString'
            returnString += " " + exit;     
        }
        return returnString;                //Returns the entire 'returnString'
    }

    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    
    public int getCoordinateX() { //Can potentially be removed
        return CoordinateX;
    }

    
    public void setCoordinateX(int CoordinateX) { //Can potentially be removed
        this.CoordinateX = CoordinateX;
    }

    
    public int getCoordinateY() { //Can potentially be removed
        return CoordinateY;
    }

    
    public void setCoordinateY(int CoordinateY) { //Can potentially be removed
        this.CoordinateY = CoordinateY;
    }
    
    public static ArrayList<Hostiles> getHostilesActive(){
        return hostilesActive; 
    }
    
      public static void addToHostilesActive(Hostiles hostile){
        hostilesActive.add(hostile);
    }
    
        public static void overwriteActiveHostile(int number, Hostiles hostile){ //Adds the hostile at the given index, and removes the previous one
        hostilesActive.add(number, hostile);
        hostilesActive.remove(number+1);
    }
    
    public static ArrayList<Collectables> getCollectablesLeft(){
        return collectablesLeft; 
    } 
    
     public static void addToCollectablesLeft(Collectables collectable){
        collectablesLeft.add(collectable);
    }
    
        public static void removeFromCollectablesLeft(int number){
        collectablesLeft.remove(number);
    } 
}

