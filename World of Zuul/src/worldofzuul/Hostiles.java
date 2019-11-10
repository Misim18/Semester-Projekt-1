package worldofzuul;

public class Hostiles extends Coordinate {
private int DirectionX; //Hostiles moving horizontal
private int DirectionY; //Hostiles moving vertical
private int Damage;
private int MoveSpeedX; //This can be timed with the corresponding direction value.
private int MoveSpeedY; //This can be timed with the corresponding direction value.

public Hostiles()
    {
    super(0,0); //This seems to be nessesary as super wouldn't take a method returning an int, as an argument
    this.setCoordinateX(setStartPositionX()); //sets the coordinates to the returned value of setStartPositionX (method)
    this.setCoordinateY(setStartPositionY()); //sets the coordinates to the returned value of setStartPositionY (method)
    
    }

    public int getDirectionX() {
        return DirectionX;
    }

    public void setDirectionX(int directionX) {
        this.DirectionX = directionX;
    }
    
    public int getDirectionY() {
        return DirectionY;
    }

    public void setDirectionY(int directionY) {
        this.DirectionY = directionY;
    }
    
    public int getMoveSpeedX() {
        return MoveSpeedX;
    }

    public void setMoveSpeedX(int moveSpeedX) {
        this.MoveSpeedX = moveSpeedX;
    }
    
    public int getMoveSpeedY() {
        return MoveSpeedY;
    }

    public void setMoveSpeedY(int movespeedY) {
        this.MoveSpeedY = movespeedY;
    }

    public int getDamage() {
        return Damage;
    }

    public void setDamage(int Damage) {
        this.Damage = Damage;
    }

    //math.round maintains the same chance for all grids, an explicit casting would simply floor
    public int setStartPositionX() {
        
        int temp = (int)Math.round(Math.random()*Game.getLimitX());
        
        int startPositionX;
        if(temp < Game.getLimitX()/2){startPositionX = -1;}
        else {startPositionX = Game.getLimitX();}

        return startPositionX;
    }

    //math.round maintains the same chance for all grids, an explicit casting would simply floor
    public int setStartPositionY() {
        //to keep the upper 2 grid lines shark free, prevent Hostiles from spawning higher than limitY
        int startPositionY = (int)Math.round(Math.random()*(Game.getLimitY()-3))+2;  
        boolean run = true;
        int counter;
        //Makes sure Hostiles are never spawned on the same y position 
        //(Note: Endless loop if number of hostiles > limitY-2)
        do{
            counter = 0;
        for (int i = 0; i<Room.getHostilesActive().size(); i++){
            //checking to see if there is already a Hostile placed in the first rolled startPosition. If so, re-roll a rand startpos.
            if (Room.getHostilesActive().get(i).getCoordinateY() == startPositionY){
                startPositionY = (int)Math.round(Math.random()*(Game.getLimitY()-3))+2;  
                run = true;
                break;
            }
            else{counter++;}
        }
        if (counter == Room.getHostilesActive().size()){
        run = false;    
        }
        
        }while (run);
        
        return startPositionY;
    }
        // for the text based UI.
	@Override
	public String toString(){
		return "Damage: " + Damage + "; Dir:" + DirectionX +
			"; x:" + getCoordinateX() +
			"; y:" + getCoordinateY();
	}
 

}
