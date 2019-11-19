package worldofzuul;

public class Collectables extends Coordinate {

    private final String name;
    private final int weight;
    private static String[] itemNames;

    public Collectables() {
        super(); // it is the possion to x0, y0
        this.setCoordinateX(setRandomPositionX()); //sets the coordinates to the returned value of setRandomPositionX (method)
        this.setCoordinateY(setRandomPositionY()); //sets the coordinates to the returned value of setRandomPositionY (method)
        this.checkDoublePlaceing();
        this.name = setRandomName();  //How it should be
        this.weight = 1; //this CAN be made interactive based on the name of the collectable
    }

    public static final void initializeItemNames() {
        itemNames = new String[7];
        itemNames[0] = "Food Wrapper";
        itemNames[1] = "Plastic Bottle";
        itemNames[2] = "Plastic Bottle Cap";
        itemNames[3] = "Plastic Bag";
        itemNames[4] = "Straw";
        itemNames[5] = "Plastic Take Away Container";
        itemNames[6] = "Plastic Lid";

//        //used for verifying content of itemNames
//        for (int x = 0; x < getItemNames().length; x++)
//    {
//        System.out.println(getItemNames()[x]);
//    }
    }

    public static String[] getItemNames() { //Returns the entire array
        return itemNames;
    }

    public static String getItemNamesElement(int x) { //Returns the x'th array element
        return itemNames[x];
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
        int temp = (int) Math.round(Math.random() * (getItemNames().length - 1)); //minus one, because arrays are 0 indexed (see next line)

        return getItemNamesElement(temp);
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
