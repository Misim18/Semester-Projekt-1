package worldofzuul;

import java.util.ArrayList;

public class Character extends Coordinate {
	private static String name; //consider revising this to work with scanner input
	private static int breath, amountOfBreathLeft, life, levelReached, carryCapacity, recyclingUpgrade, rewards;
	private static ArrayList<Collectables> inventory;

	public Character(String name, int xPos, int yPos, int breath){
		super(xPos, yPos);
		this.breath = breath;
                this.name = name;
		amountOfBreathLeft = breath;
		life = 100;
		levelReached = 0;   //Note all numbers are
                recyclingUpgrade = 0;
		carryCapacity = 3;
		inventory = new ArrayList<>();
	}

	// Checks if the player is on the surface to get air
	// Else remove on from breathLeft and then check if they died.
	public boolean UpdateBreath(){
		if(getCoordinateY() == 0){
			amountOfBreathLeft = breath;
			return false;
		} else {
			--amountOfBreathLeft;
			if(amountOfBreathLeft <= 0){
				// They are dead
				life = 0;
				return true;
			} else{
				return false;
			}
		}

	}
	// Name
	public static String getName(){
		return name;
	}

	// Breath
	public int getBreath(){
		return amountOfBreathLeft;
	}
	public static void setBreath(int breathIn){
		breath = breathIn;
		amountOfBreathLeft = breath;
	}

        public static int getRewards() {
            return rewards;
        }

        public static void setRewards(int rewardsIn) {
            rewards = rewardsIn;
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

	// This is not used yey -- Kevin 11-11-2019
	public static void setCarryCapacity(int carryCapacityIn){
		carryCapacity = carryCapacityIn;
	}

	// addToInventory
	public boolean addToInventory(Collectables collectable){
		if(inventory.size()<carryCapacity){
			inventory.add(collectable);
			return true;
		} else{
			return false;
		}
	}


	// getInventory
	public static ArrayList<Collectables> getInventory(){
		return inventory;
	}

    public static void clearInventory(){
		inventory.clear();
	}

    public static int getRecyclingUpgrade() {
        return recyclingUpgrade;
    }

	// This is not used yet 11-11-2019
    public static void setRecyclingUpgrade(int aRecyclingUpgrade) {
        recyclingUpgrade = aRecyclingUpgrade;
    }

}
