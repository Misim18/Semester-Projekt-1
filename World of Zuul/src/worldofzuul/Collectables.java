package worldofzuul;

public class Collectables extends Coordinate {

    private final String name;
    private final int weight;

    public Collectables() {
        super(0, 0); //This seems to be nessesary as super wouldn't take a method returning an int, as an argument
        this.setCoordinateX(setRandomPositionX()); //sets the coordinates to the returned value of setRandomPositionX (method)
        this.setCoordinateY(setRandomPositionY()); //sets the coordinates to the returned value of setRandomPositionY (method)
        this.checkDoublePlaceing();
        this.name = setRandomName();  //How it should be
        this.weight = 1; //this CAN be made interactive based on the name of the collectable
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int setRandomPositionX() {
        int startPositionX = (int) Math.round(Math.random() * (Game.getLimitX() - 1)); //minus one, because arrays are 0 indexed (see next line)

        return startPositionX;
    }

    public int setRandomPositionY() {
        int startPositionY = (int) Math.round(Math.random() * (Game.getLimitY() - 2)) + 1;  //as to not put a collectable on the boat

        return startPositionY;
    }

    public String setRandomName() {
        int temp = (int) Math.round(Math.random() * (Game.getItemNames().length - 1)); //minus one, because arrays are 0 indexed (see next line)

        return Game.getItemNamesElement(temp);
    }

    @Override
    public String toString() {
        return name + " - x:" + getCoordinateX() + " y:" + getCoordinateY();
    }
    
    public void checkDoublePlaceing() {
        int xPosition = this.getCoordinateX();
        int yPosition = this.getCoordinateY();

        boolean run = true;
        int counter;
        //Makes sure Hostiles are never spawned on the same y position 
        //(Note: Endless loop if number of hostiles > limitY-2)
        do {
            counter = 0;
            for (int i = 0; i < Room.getCollectablesLeft().size(); i++) {
                if (Room.getCollectablesLeft().get(i).getCoordinateX() == xPosition
                && Room.getCollectablesLeft().get(i).getCoordinateY() == yPosition) {
                    xPosition = (int) Math.round(Math.random() * (Game.getLimitX() - 1));
                    yPosition = (int) Math.round(Math.random() * (Game.getLimitY() - 2)) + 1;
                    break;
                } else {
                    counter++;
                }
            }
            if (counter == Room.getNumberOfCollectablesLeft()) {
                run = false;
            }

        } while (run);

        this.setCoordinateX(xPosition);
        this.setCoordinateY(yPosition);
    }
}
