package com.group4.gameLogic;

public class Level {

    private int levelSizeX;
    private int levelSizeY;
    private int reward;
    private int amountOfCollectables;
    private int amountOfActiveHostiles;

    public Level(int levelReached) {
        this.levelSizeX = 10 * levelReached;
        this.levelSizeY = 10 * levelReached;
        this.reward = 1 + 1 * levelReached;
        this.amountOfCollectables = 5 * levelReached;
        this.amountOfActiveHostiles = 3 + 3 * levelReached;
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

    public int getAmountOfActiveHostiles() {
        return amountOfActiveHostiles;
    }

    public void setAmountOfActiveHostiles(int amountOfActiveHostiles) {
        this.amountOfActiveHostiles = amountOfActiveHostiles;
    }

}
