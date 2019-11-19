package worldofzuul;

import java.util.ArrayList;

public class Character extends Coordinate {

    private String name; //consider revising this to work with scanner input
    private int breath, amountOfBreathLeft, life, levelReached, carryCapacity, recyclingUpgrade, rewards;
    private ArrayList<Collectables> inventory;

    public Character(String name, int xPos, int yPos, int breath) {
        super(xPos, yPos);
        this.breath = breath;
        this.name = name;
        this.amountOfBreathLeft = breath;
        this.life = 100;
        this.levelReached = 0;   //Note all numbers are
        this.recyclingUpgrade = 0;
        this.carryCapacity = 3;
        this.inventory = new ArrayList<>();
    }

    // Checks if the player is on the surface to get air
    // Else remove on from breathLeft and then check if they died.
    public boolean UpdateBreath() {
        if (getCoordinateY() == 0) {
            this.amountOfBreathLeft = breath;
            return false;
        } else {
            this.amountOfBreathLeft--;
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
	public void OnItem(ArrayList<Collectables> collectables){
		for(int i=0; i <collectables.size(); i++){
			if(collectables.get(i).getCoordinateX() == getCoordinateX() &&
					collectables.get(i).getCoordinateY() == getCoordinateY())
			{
				// Checks if the player has room in inventory and then add it to players inventory.
				// Else Print don't have room
				if(addToInventory(collectables.get(i))){
				System.out.println("You Picked up: " + collectables.get(i).getName());
				collectables.remove(i);
				--i;
				} else {
					System.out.println("You dont have any more room.");
					System.out.println("Your inventory size: " + getCarryCapacity() + "/" + getCarryCapacity());
				}
			}
		}
	}

	// check if character has the same coorddinnate as hostile and then take damage.
	// return true if dead else return false.
	public boolean hitHostile(ArrayList<Hostiles> hostiles){
		for(Hostiles hostile : hostiles){
			if(hostile.getCoordinateX() == getCoordinateX() &&
					hostile.getCoordinateY() == getCoordinateY())
			{
				// Damage the player
				life -= hostile.getDamage();
				// Checks if the player is dead
				if(getLife()<=0){
					System.out.println("Player Health: " + getLife());
					System.out.println("You are dead");
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

    // Breath
    public int getBreath() {
        return this.amountOfBreathLeft;
    }

    public void upgradeBreath() {
        breath++;
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

    // getInventory
    public ArrayList<Collectables> getInventory() {
        return this.inventory;
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

}
