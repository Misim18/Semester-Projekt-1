package worldofzuul;

import java.util.ArrayList;
import java.util.Scanner;

public class Story {

private String Line;    
private String[] randLineArray = new String[10];

public Story(){
}

public void fillArray(){ //facts fra poster billede.
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

public String getLine(){
    return Line;
}

public void getRandLine(){
    fillArray();
    int temp =(int) Math.round(Math.random()*9);
    System.out.println(randLineArray[temp]);
    
}

public static void introLine(){
    System.out.println("Hello, you are about to begin the game."); 
    System.out.println("Please begin by entering your name, followed by hitting Enter. ");
    System.out.print("> "); 
}

public static void tutorial(){
    System.out.println("This is where we'd give you the tutorial."); 
    System.out.println("IF WE HAD/WANTED ONE! 🤔");//nice FOP refrence xD 
}

public static void printAfterMoved(){
    ArrayList<Coordinate> listOfElements = new ArrayList<>();
    
    for(int i = 0; i<Room.getCollectablesLeft().size(); i++){
        listOfElements.add(Room.getCollectablesLeft().get(i));
    }
    for(int i = 0; i<Room.getHostilesActive().size();  i++){
        listOfElements.add(Room.getHostilesActive().get(i));
    }
    
    for (Coordinate Element : listOfElements) {
        int xCoordinate = Element.getCoordinateX(); 
        int yCoordinate = Element.getCoordinateY(); 
        String type; 
        if(Element instanceof Hostiles){
            type = "hostile"; 
        }
        else if(Element instanceof Collectables){
            type = "collectable";
        }
        else{
            type = ""; 
        }
        
        System.out.println("a " + type + " is at the coordinates: x" + xCoordinate + " Y" + yCoordinate);
    }
    
    System.out.println("Collectables left: " + Room.getCollectablesLeft().size());
    System.out.println("Trash collected in this level: " + Game.getBoat().getLevelTrashCollected());
    System.out.println("Total trash collected: " + Game.getBoat().getTotalTrashCollected());
    System.out.println("");
}

public static void printInfo(ArrayList<Hostiles> hostileArray, ArrayList<Collectables> collectablesArray, int health, Room currentRoom){

    System.out.println();
    System.out.println("Collectables: ");
    for (Collectables collectable : collectablesArray) {
        System.out.println(collectable);
    }
    System.out.println();
    System.out.println("Hostiles: ");
    for (Hostiles hostile : hostileArray) {
        System.out.println(hostile);
    }
    
    System.out.println();
    System.out.println("Player Health:" + health);
    System.out.println();
    System.out.println(currentRoom.getLongDescription());
}
}
