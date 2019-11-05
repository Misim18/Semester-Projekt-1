/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

/**
 *
 * @author sofie
 */
public abstract class Coordinate {
    private int coordinateX;
    private int coordinateY; 
    
    public Coordinate(int coordinateX, int coordinateY){
        this.coordinateX = coordinateX; 
        this.coordinateY = coordinateY; 
    }

    /**
     * @return the coordinateX
     */
    public int getCoordinateX() {
        return coordinateX;
    }

    /**
     * @param coordinateX the coordinateX to set
     */
    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    /**
     * @return the coordinateY
     */
    public int getCoordinateY() {
        return coordinateY;
    }

    /**
     * @param coordinateY the coordinateY to set
     */
    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }
    
    
}
