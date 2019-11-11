/*
 * 
 * 
 * 
 */
package worldofzuul;

public class Shark extends Hostiles {
    private static int lastSharkMovespeed; //Used for keeping track of the order in whitch movespeed is giving pr. created object.

    public Shark() {
        super();
        super.setDamage(100); //Initializes the damage attribute from the Hostiles super class.
        setSharkDirectionX(); //Initializes the directionX attribute from the Hostiles super class.
        setSharkDirectionY(); //Initializes the directionY attribute from the Hostiles super class.
        //setSharkMovespeedX(); //Initializes the movespeed attribute from the Hostiles super class, but is currently not in use, since Direction attribute is used instead.
        setSharkMovespeedY(); //Initializes the movespeedY attribute from the Hostiles super class, but is currently not really usefull, since the movespeed this direction is 0.
        setSharkStartPositionX(); //Initializes a starting position on the x-axis of the grid.
        setSharkStartPositionY(); //Initializes a starting position on the y-axis of the grid.
    }


    public void setSharkDirectionX() {
        if (super.getCoordinateX() == 0) {
            super.setDirectionX(1);
        } else if (super.getCoordinateX() == Game.getLimitX()) {
            super.setDirectionX(-1);
        } else {
            System.out.println("Something went wrong with adding the direction");
        }
    }
    
    public void setSharkDirectionY() {
        super.setDirectionY(0);
    }

//    public void setSharkMovespeedX() {
//        switch (Character.getLevelReached()) {
//            case 0:
//                lastSharkMovespeed = 1;
//                break;
//            case 1:
//                if (lastSharkMovespeed == 2) {
//                    lastSharkMovespeed = 1;
//                } else if (lastSharkMovespeed == 1) {
//                    lastSharkMovespeed = 2;
//                }   super.setMoveSpeedX(lastSharkMovespeed);
//                super.setMoveSpeedX(1);
//                break;
//            default:
//                super.setMoveSpeedX((int) Math.ceil(Math.random() * 3));
//                break;
//        }
//    }
    
    public void setSharkMovespeedY() {
        super.setMoveSpeedY(0);
    }
    
    public void setSharkStartPositionX(){
        super.setStartPositionX();
        
        
    }
    
    public void setSharkStartPositionY(){
        super.setStartPositionY();
    }
    
    public int checkSharkCoordinateX(){
        return super.getCoordinateX();
    }
    
    public int checkSharkCoordinateY(){
        return super.getCoordinateY();
    }
    
    public void updateSharkCoordinateX(int currentCoordinateX){
        int newCoordinateX = currentCoordinateX + super.getMoveSpeedX();
        super.setCoordinateX(newCoordinateX);
    }
    
    public void updateSharkCoordinateY(int currentCoordinateY){
        int newCoordinateY = currentCoordinateY + super.getMoveSpeedY();
        super.setCoordinateY(newCoordinateY);
    }
}
