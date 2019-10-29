/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import java.util.ArrayList;

/**
 *
 * @author kkmp
 */
public class Boat extends Coordinate {
	private ArrayList<Collectables> boatInventory = new ArrayList<Collectables>;
	private int levelTrashCollected;
	private int totalTrashCollected;
	private int money;
	private int carryCapacityUpgrades;
	private int breathUpgrades;
	private int plasticReductionUpgrades;

   	public Boat() {
		super(); //Ændres alt efter Coordinate
		levelTrashCollected = 0;
		totalTrashCollected = 0;
		money = 0;
		carryCapacityUpgrades 0;
		breathUpgrades = 0;
		plasticReductionUpgrades = 0;

	}

	// BoatInventory
	public void addToBoatInventory(Collectables temp){
		boatInventory.add(temp);
	}

	public ArrayList<Collectables> getBoatInventory(){ // skal enten fjernes eller redigeres.
		return boatInventory;
	}

	public String listBoatInventory(){
		// to do, done for today
	}

	// LevelTrashCollected
	public int getLevelTrashCollected(){
		return this.levelTrashCollected;
	}
	public void setLevelTrashCollected(int levelTrashCollected){
		this.levelTrashCollected = levelTrashCollected;
	}

	// TotalTrashCollected
	public int getTotalTrashCollected(){
		return totalTrashCollected;
	}
	public void setTotalTrashCollected(int totalTrashCollected){
		this.totalTrashCollected = totalTrashCollected;
	}

	// Money
	public int getMoney(){
		return money;
	}
	public void set(int money){
		this.money = money;
	}

	// CarryCapacityUpgrades
	public int getCarryCapacityUpgrades(){
		return this.carryCapacityUpgrades;
	}
	public void setCarryCapacityUpgrade(int carryCapacityUpgrades){
		this.carryCapacityUpgrades = carryCapacityUpgrades;
	}

	// breathUpgrades
	public int getBreathUpgrades(){
		return this.breathUpgrades;
	}
	public void setBreathUpgrades(int breathUpgrades){
		this.breathUpgrades = breathUpgrades;
	}

	// PlasticReductionUpgrades
	public int getPlasticReductionUpgrades(){
		return this.plasticReductionUpgrades;
	}
	public void setPlasticReductionUpgrades(int plasticReductionUpgrades){
		this.plasticReductionUpgrades = plasticReductionUpgrades;
	}
}
