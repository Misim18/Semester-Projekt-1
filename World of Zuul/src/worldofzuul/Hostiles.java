package worldofzuul;

public class Hostiles extends Coordinate {
private int Direction;
private int Damage;


public Hostiles(int dmg)
    {
    super(0,0); //This seems to be nessesary as super wouldn't take a method returning an int, as an argument
    this.setCoordinateX(setStartPositionX()); //sets the coordinates to the returned value of setStartPositionX (method)
    this.setCoordinateY(setStartPositionY()); //sets the coordinates to the returned value of setStartPositionY (method)
    this.Damage = dmg;
    setDirection();

    }

    public int getDirection() {
        return Direction;
    }

    public void setDirection() {
        if (this.getCoordinateX() == 0) {
            this.Direction = 1;
        } else if (this.getCoordinateX() == Game.getLimitX()) {
            this.Direction = -1;
        } else {
            System.out.println("Something went wrong with adding the direction");
        }
    }

    public int getDamage() {
        return Damage;
    }

    public void setDamage(int Damage) {
        this.Damage = Damage;
    }

    public int setStartPositionX() {
        int temp = (int)Math.round(Math.random()*Game.getLimitX());
        int startPositionX;
        if(temp < Game.getLimitX()/2){startPositionX = 0;}
        else {startPositionX = Game.getLimitX();}

        return startPositionX;
    }

    public int setStartPositionY() {
        int startPositionY = (int)Math.round(Math.random()*(Game.getLimitY()-2))+2;

        return startPositionY;
    }

	@Override
	public String toString(){
		return "\n Damage: " + Damage + "; Direction: " + Direction +
			"; x: " + getCoordinateX() +
			"; y: " + getCoordinateY();
	}


}
