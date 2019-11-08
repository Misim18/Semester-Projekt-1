package worldofzuul;

import java.util.ArrayList;

public class Character extends Coordinate {
	private static String name; //consider revising this to work with scanner input
	private static int breath, life, levelReached, carryCapacity;
	private static ArrayList<Collectables> inventory;

	public Character(String name, int xPos, int yPos){ //Incorporate scanner name thingy (later)
		super(xPos, yPos);
		breath = 8;
		life = 100;
		levelReached = 0;   //Note all numbers are
                this.name = name;
		carryCapacity = 3;
		inventory = new ArrayList<>();
	}

	// Name
	public static String getName(){
		return name;
	}

	// Breath
	public int getBreath(){
		return breath;
	}
	public void setBreath(int breath){
		this.breath = breath;
	}

	// Life
	public int getLife(){
		return life;
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
	public static int getCarryCapacity(){
		return carryCapacity;
	}
	public static void setCarryCapacity(int carryCapacityIn){
		carryCapacity = carryCapacityIn;
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
	public static ArrayList<Collectables> getInventory(){
		return inventory;
	}

        // dumpInventory this might need to change
	public static ArrayList<Collectables> dumpInventory(){
		return inventory;
	}

        public static void clearInventory(){
		inventory.clear();
	}

}
