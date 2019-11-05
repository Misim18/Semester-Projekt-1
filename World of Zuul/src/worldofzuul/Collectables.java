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
public class Collectables extends Coordinate {
    private final String name; 
    private final int weight; 
    
    public Collectables(int coordinateX, int coordinateY, String name, int weight){
        super(coordinateX, coordinateY);    
        this.name = name; 
        this.weight = weight; 
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }
}
