
package worldofzuul;

import java.util.ArrayList;


public class Boat extends Coordinate {
	private ArrayList<Collectables> boatInventory = new ArrayList<>();
	private int levelTrashCollected;
	private int totalTrashCollected;
	private int money;
	private int carryCapacityUpgrades;
	private int breathUpgrades;
	private int plasticReductionUpgrades;

   	public Boat(){
		super((Game.getLimitX()/2),0); //Middle x value, and top y value on the grid.
		levelTrashCollected = 0;
		totalTrashCollected = 0; 
		money = 0;
		carryCapacityUpgrades = 0;
		breathUpgrades = 0;
		plasticReductionUpgrades = 0;

	}

	public void placeBoat(int x, int y){
		this.setCoordinateX(x);
                this.setCoordinateY(y);
	}        
        
	// BoatInventory
	public void addToBoatInventory(Collectables temp){
		boatInventory.add(temp);
	}

	public ArrayList<Collectables> getBoatInventory(){ // Should be either removed or modified..
		return boatInventory;
	}

//	public String listBoatInventory(){
//		// to do, done for today
//	}

	// LevelTrashCollected
	public int getLevelTrashCollected(){
		return this.levelTrashCollected;
	}
	public void setLevelTrashCollected(int levelTrashCollected){
		this.levelTrashCollected = levelTrashCollected;
	}

	// TotalTrashCollected
	public int getTotalTrashCollected(){
		return this.totalTrashCollected;
	}
	public void setTotalTrashCollected(int totalTrashCollectedNew){
		totalTrashCollected = totalTrashCollectedNew;
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
