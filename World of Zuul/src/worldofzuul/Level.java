/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

/**
 *
 * @author mikai
 */
public class Level {
    
    private int levelSizeX;
    private int levelSizeY;
    private int reward;
    private int amountOfCollectables;

    public Level(int levelReached) {
        this.levelSizeX = 10*levelReached;
        this.levelSizeY = 10*levelReached;
        this.reward = 1*levelReached;
        this.amountOfCollectables = 5*levelReached;
    } 
  
    public int getLevelSizeX() {
        return levelSizeX;
    }

    public void setLevelSizeX(int levelSizeX) {
        this.levelSizeX = levelSizeX;
    }

    public int getLevelSizeY() {
        return levelSizeY;
    }

    public void setLevelSizeY(int levelSizeY) {
        this.levelSizeY = levelSizeY;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getAmountOfCollectables() {
        return amountOfCollectables;
    }

    public void setAmountOfCollectables(int amountOfCollectables) {
        this.amountOfCollectables = amountOfCollectables;
    }
    
    
    
    
    
}
