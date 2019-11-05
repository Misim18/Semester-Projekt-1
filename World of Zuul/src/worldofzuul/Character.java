package worldofzuul;

import java.util.ArrayList;

public class Character {
	private static String name; //consider revising this to work with scanner input
	private static int breath, life, levelReached, carryCapacity;
	private static ArrayList<Collectables> inventory;

	public Character(String name){ //Incorporate scanner name thingy (later)
		breath = 8;
		life = 100;
		levelReached = 0;   //Note all numbers are 
                this.name = name;
		carryCapacity = 3;
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
	public static int getLevelReached(){
		return levelReached;
	}
	public static void setLevelReached(int levelReachedIn){
		levelReached = levelReachedIn;
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
