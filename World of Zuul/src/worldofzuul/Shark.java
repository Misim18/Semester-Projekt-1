/*
 * 
 * 
 * 
 */
package worldofzuul;

public class Shark extends Hostiles {
    //private static int lastSharkMovespeed; //Used for keeping track of the order in whitch movespeed is giving pr. created object.

    public Shark() {
        super();
        super.setDamage(100); //Initializes the damage attribute from the Hostiles super class.
        this.setStartPositionX(); //Initializes a starting position on the x-axis of the grid.
        this.setStartPositionY(); //Initializes a starting position on the y-axis of the grid.
        this.setDirectionX(); //Initializes the directionX attribute from the Hostiles super class.
        this.setDirectionY(); //Initializes the directionY attribute from the Hostiles super class.
    }

    @Override
    //math.round keeps the same chance for all outcomes.
    public void setStartPositionX(){
        int startPositionX;
        int temp = (int)Math.round(Math.random()*Game.getLimitX());
        
        if(temp < (double)Game.getLimitX()/2){
            startPositionX = -1;
                    }
        else {startPositionX = Game.getLimitX()+1;} 
        
        super.setCoordinateX(startPositionX);
        
    }
    
    @Override
    //math.round keeps the same chance for all outcomes.
    public void setStartPositionY() {
        //to keep the upper 2 grid lines shark free, prevent Hostiles from spawning higher than limitY
        int startPositionY = (int)Math.round(Math.random()*(Game.getLimitY()-2))+2;  
        boolean run = true;
        int counter;
        //Makes sure Hostiles are never spawned on the same y position 
        //(Note: Endless loop if number of hostiles > limitY-2)
        do{
            counter = 0;
        for (int i = 0; i<Room.getHostilesActive().size(); i++){
            //checking to see if there is already a Hostile placed in the first rolled startPosition. If so, re-roll a rand startpos.
            if (Room.getHostilesActive().get(i).getCoordinateY() == startPositionY){
                startPositionY = (int)Math.round(Math.random()*(Game.getLimitY()-2))+2;  
                run = true;
                break;
            }
            else{counter++;}
        }
        if (counter == Room.getHostilesActive().size()){
        run = false;    
        }
        
        }while (run);
        
        super.setCoordinateY(startPositionY);
    }
    
    public void setDirectionX() {
        if (super.getCoordinateX() == 0) {
            super.setDirectionX(1);
        } else if (super.getCoordinateX() == Game.getLimitX()) {
            super.setDirectionX(-1);
        } else {
            System.out.println("Something went wrong with adding the direction");
        }
    }
    
    public void setDirectionY() {
        super.setDirectionY(0);
    }
    
    public void setMovespeedX(){
        super.setMoveSpeedX(1);
    }
    
    public void setSharkMovespeedY() {
        super.setMoveSpeedY(0);
    }
    
    @Override
    public void moveX(){
        int currentCoordinateX = super.getCoordinateX();
        int newCoordinateX = currentCoordinateX + super.getDirectionX()*super.getMoveSpeedX();
        super.setCoordinateX(newCoordinateX);
    }
    
    @Override
    public void moveY(){
        int currentCoordinateY = super.getCoordinateY();
        int newCoordinateY = currentCoordinateY + super.getDirectionY()*super.getMoveSpeedY();
        super.setCoordinateY(newCoordinateY);
    }
    
    
}
