package com.group4.gameLogic;

import java.util.ArrayList;

public class Boat extends Room {

    private ArrayList<Collectables> boatInventory = new ArrayList<>();
    private int levelTrashCollected;
    private int totalTrashCollected;
    private int carryCapacityUpgrades;

    public Boat(int x, int y, String description) {
        super(x, y, description); //Middle x value, and top y value on the grid.
        levelTrashCollected = 0;
        totalTrashCollected = 0;
        carryCapacityUpgrades = 0;
    }

    // BoatInventory
    public void addToBoatInventory(Collectables temp) {
        boatInventory.add(temp);
    }

    public ArrayList<Collectables> getBoatInventory() { // Should be either removed or modified..
        return boatInventory;
    }

    // LevelTrashCollected
    public int getLevelTrashCollected() {
        return this.levelTrashCollected;
    }

    // TotalTrashCollected
    public int getTotalTrashCollected() {
        return this.totalTrashCollected;
    }

    public void setTotalTrashCollected(int totalTrashCollectedNew) {
        totalTrashCollected = totalTrashCollectedNew;
    }

    // CarryCapacityUpgrades
    public int getCarryCapacityUpgrades() {
        return this.carryCapacityUpgrades;
    }

    public void setCarryCapacityUpgrade(int carryCapacityUpgrades) {
        this.carryCapacityUpgrades = carryCapacityUpgrades;
    }


    // Checks if the player is on boat and then emptys player inventory to boat.
    // return false: you are still missing some items.
    // return true: you have collected all items.
    @Override
    public boolean playerOnBoat(Character player, int collectablesleft) {

            for (Collectables item : player.getInventory()) {
                addToBoatInventory(item);
            }
            player.clearInventory();
            if (collectablesleft <= 0) {
                System.out.println("There are no more items left");
                return true;
            } else {
                System.out.println("There are still more items left: "
                        + collectablesleft);
                return false;
            }
    }

    @Override
    public void countCollectableTypes(Character player) {
        String itemName;
        for (Collectables item : getBoatInventory()) {
            itemName = item.getName();
            player.incrementCollectablesData(itemName);
            }
        this.boatInventory.clear();
        }

    @Override
    public void printCollectablesData(Character player){
        for (var i : player.getCollectablesData().keySet()){
        System.out.println(i + ": " + player.getCollectablesData().get(i));
    }
    }

    @Override
    public String toString() {
        return "Boat - x:" + getCoordinateX() + " y:" + getCoordinateY();
    }

    public void setBoatDescription(String description){
        this.setDescription(description);
    }
}
