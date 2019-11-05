package worldofzuul;

public class Hostiles extends Coordinate {
private int Direction;
private int Damage;
private int startPostitionX;
private int startPostitionY;

public Hostiles(int dmg, int lvlsizeX, int lvlsizeY)
    {
    super(0,0); //Changed later
    this.Damage = dmg;
    setDirection();
    setStartPostitionX(lvlsizeX);
    setStartPostitionY(lvlsizeY);
    
    }

    public int getDirection() {
        return Direction;
    }

    public void setDirection() {
        int temp = (int) Math.round(Math.random());
    
        if(temp == 1){
        this.Direction = 1;
        } else {
            this.Direction = -1;
        }
    }

    public int getDamage() {
        return Damage;
    }

    public void setDamage(int Damage) {
        this.Damage = Damage;
    }

    public void setStartPostitionX(int lvlSizeX) {
        int temp = (int)Math.round(Math.random()*lvlSizeX);
        if(temp < lvlSizeX/2){this.startPostitionX = 0;} 
        else {this.startPostitionX = lvlSizeX;}
    }

    public void setStartPostitionY(int lvlSizeY) {
        int temp = (int)Math.round(Math.random()*(lvlSizeY-1));
        this.startPostitionY = temp;
    }
    
    

}