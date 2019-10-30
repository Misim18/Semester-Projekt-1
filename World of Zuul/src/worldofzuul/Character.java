public class Character {
	private String Name = "";
	private int breath, life, levelReached, carryCapacity;
	private ArrayList<Collectables> inventory;

	public Character{
		breath = 0;
		lift = 0;
		levelReached = 0;
		carryCapacity = 0;
		inventory = new ArrayList();
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
		this.life = lift;
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
	public void addToInventory(Collectable collectable){
		inventory.add(collectable);
	}

	// removeFromInventory
	public void removeFromInventory(Collectable collectable){
		inventory.remove(collectable);

	}

	// dumpInventory
	public ArrayList<Collectable> dumpInventory(){
		return inventory;
	}
}
