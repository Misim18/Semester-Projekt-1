/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

public class Shark extends Hostiles {
    private static int lastSharkMovespeed; //bruges til at holde styr på rækkefølgen af tildelt movespeed pr oprettet objekt.

    public Shark() {
        super();
        super.setDamage(100); //initialiserer damage fra Hostile klassen
        setSharkDirectionX(); //initialiserer directionX fra Hostile klassen.
        setSharkDirectionY(); //initialiserer directionY fra Hostile klassen.
        setSharkMovespeedX(); //initialiserer moveSpeedX fra Hostile klassen.
        setSharkMovespeedY(); //initialiserer moveSpeedY fra Hostile klassen.
        setSharkSpawnLocationX(); //initialiserer spawnLocationX fra Hostile klassen.
        setSharkSpawnLocationY(); //initialiserer spawnLocationY fra Hostile klassen.
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

    public void setSharkMovespeedX() {
        switch (Character.getLevelReached()) {
            case 0:
                lastSharkMovespeed = 1;
                break;
            case 1:
                if (lastSharkMovespeed == 2) {
                    lastSharkMovespeed = 1;
                } else if (lastSharkMovespeed == 1) {
                    lastSharkMovespeed = 2;
                }   super.setMoveSpeedX(lastSharkMovespeed);
                super.setMoveSpeedX(1);
                break;
            default:
                super.setMoveSpeedX((int) Math.ceil(Math.random() * 3));
                break;
        }
    }
    
    public void setSharkMovespeedY() {
        super.setMoveSpeedY(0);
    }
    
    public void setSharkSpawnLocationX(){
        int temp = (int)Math.round(Math.random()*Game.getLimitX());
        if(temp < (double)Game.getLimitX()/2){super.setSpawnLocationX(0);} // skal det være en double her i tilfælde af ulige limitX?
        else {super.setSpawnLocationX(Game.getLimitX());}
        
        
    }
    
    public void setSharkSpawnLocationY(){
        int temp = (int)Math.round(Math.random()*Game.getLimitY());
        if(temp < (double)Game.getLimitY()/2){super.setSpawnLocationY(0);} // skal det være en double her i tilfælde af ulige limitX?
        else {super.setSpawnLocationY((Game.getLimitY()-2)+2);}
        
        
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
