package com.group4.gameLogic;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Character extends Coordinate {

    private String name; //consider revising this to work with scanner input
    private int breath, amountOfBreathLeft, life, levelReached, carryCapacity, recyclingUpgrade, rewards;
	private ObservableList<Collectables> inventory;
    private HashMap<String, Integer> collectablesData = new HashMap<String, Integer>();

    public Character(String name, int xPos, int yPos) {
        super(xPos, yPos);
        this.breath = 16;
        this.name = name;
        this.amountOfBreathLeft = breath;
        this.life = 100;
        this.levelReached = 0;   //Note all numbers are
        this.recyclingUpgrade = 0;
        this.carryCapacity = 3;
	this.inventory = FXCollections.observableArrayList();
        this.rewards = 0;
    }

	public Character(int xPos, int yPos){
		this("ThisIsAPlaceHolderForUI", xPos, yPos);
	}
    public void incrementCollectablesData(String type) {
        if (this.collectablesData.get(type) == null) {
            this.collectablesData.put(type, 1);
        }else {
            this.collectablesData.put(type, (this.collectablesData.get(type) + 1));
        }
    }

    public HashMap getCollectablesData(){
		return this.collectablesData;
    }

    // Checks if the player is on the surface to get air
    // Else remove on from breathLeft and then check if they died.
    public boolean UpdateBreath() {
        this.amountOfBreathLeft--;
        if (getCoordinateY() == 0) {
            this.amountOfBreathLeft = breath;
            return false;
        } else {
            if (this.amountOfBreathLeft <= 0) {
                // They are dead
                life = 0;
                return true;
            } else {
                return false;
            }
        }

    }

    // check if character has the same coordinate as collectables and then pick it up.
    public void OnItem(Room[][] itemInRoom) {
		if(itemInRoom[getCoordinateX()][getCoordinateY()].getCollectable() != null ){
			if(addToInventory(itemInRoom[getCoordinateX()][getCoordinateY()].getCollectable())){
				itemInRoom[getCoordinateX()][getCoordinateY()].clearCollectable();
			} else {
				System.out.println("You dont have any more room.");
				System.out.println("Your inventory size: " + getCarryCapacity() + "/" + getCarryCapacity());
			}
		}
    }



    // check if character has the same coorddinnate as hostile and then take damage.
    // return true if dead else return false.
    public boolean hitHostile(ArrayList<Hostiles> hostiles) {
        for (Hostiles hostile : hostiles) {
            if (hostile.getCoordinateX() == getCoordinateX()
                    && hostile.getCoordinateY() == getCoordinateY()) {
                // Damage the player
                life -= hostile.getDamage();
                // Checks if the player is dead
                if (getLife() <= 0) {
                    return true;
                }
            }
        }
        return false;

    }

    // Name
    public String getName() {
        return this.name;
    }

    public void setName(String nameIn) {
        this.name = nameIn;
    }

    // Breath
    public int getBreath() {
        return this.amountOfBreathLeft;
    }

    public void upgradeBreath() {
        breath = breath + 6;
        amountOfBreathLeft = breath;
    }

    public int getRewards() {
        return this.rewards;
    }

    public void setRewards(int rewardsIn) {
        this.rewards = rewardsIn;
    }

    // Life
    public int getLife() {
        return this.life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    // LevelReached
    public int getLevelReached() {
        return this.levelReached;
    }

    public void setLevelReached(int levelReachedIn) {
        this.levelReached = levelReachedIn;
    }

    // carryCapacity
    public int getCarryCapacity() {
        return this.carryCapacity;
    }

    // This is not used yey -- Kevin 11-11-2019
    public void setCarryCapacity(int carryCapacityIn) {
        this.carryCapacity = carryCapacityIn;
    }

    // addToInventory
    public boolean addToInventory(Collectables collectable) {
        if (this.inventory.size() < this.carryCapacity) {
            this.inventory.add(collectable);
            return true;
        } else {
            return false;
        }
    }

    public void addToInventoryCheat(Collectables collectable) {
        this.inventory.add(collectable);
    }

    // getInventory
    public ObservableList<Collectables> getInventory() {
        return this.inventory;
    }

    public void setInventory(ObservableList<Collectables> inventory) {
        this.inventory = inventory;
    }

    public void clearInventory() {
        this.inventory.clear();
    }

    public int getRecyclingUpgrade() {
        return this.recyclingUpgrade;
    }

    // This is not used yet 11-11-2019
    public void setRecyclingUpgrade(int aRecyclingUpgrade) {
        this.recyclingUpgrade = aRecyclingUpgrade;
    }

    @Override
    public String toString() {
        return "Error toString on character object";
    }

    public void setBreath(int value){
        this.breath = value;
    }

}
