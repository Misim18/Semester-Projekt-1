package worldofzuul;

import java.util.ArrayList;

public class Character {
	private static String name = "Temp"; //consider revising this to work with scanner input
	private static int breath, life, levelReached, carryCapacity;
	private static ArrayList<Collectables> inventory;

	public Character(){ //Incorporate scanner name thingy (later)
		breath = 0;
		life = 0;
		levelReached = 0;
		carryCapacity = 0;
		inventory = new ArrayList<>();
	}

	// Name
	public String getName(){
		return this.name;
	}

	// Breath
	public int getBreath(){
		return this.breath;
	}
	public void setBreath(int breath){
		this.breath = breath;
	}

	// Life
	public int getLife(){
		return this.life;
	}
	public void setLife(int life){
		this.life = life;
	}

	// LevelReached
	public int getLevelReached(){
		return this.levelReached;
	}
	public void setLevelReached(int levelReached){
		this.levelReached = levelReached;
	}

	// carryCapacity
	public int getCarryCapacity(){
		return this.carryCapacity;
	}
	public void setCarryCapacity(int carryCapacity){
		this.carryCapacity = carryCapacity;
	}

	// addToInventory
	public void addToInventory(Collectables collectable){
		inventory.add(collectable);
	}

	// removeFromInventory
	public void removeFromInventory(Collectables collectable){
		inventory.remove(collectable);

	}

	// dumpInventory
	public ArrayList<Collectables> dumpInventory(){
		return inventory;
	}
}
