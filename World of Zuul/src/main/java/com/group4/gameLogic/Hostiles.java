package com.group4.gameLogic;

public abstract class Hostiles extends Coordinate {

    private int DirectionX; //Hostiles moving horizontal
    private int DirectionY; //Hostiles moving vertical
    private int Damage;
    private int MoveSpeedX; //This can be timed with the corresponding direction value.
    private int MoveSpeedY; //This can be timed with the corresponding direction value.

    public Hostiles() {
        super(); // Sets the coordinate to x0, y0
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

    public void setStartPositionX() {
        //insert code in subClass
    }

    public void setStartPositionY() {
        //insert code in subClass
    }

    public void moveX() {

    }

    public void moveY() {

    }

}
