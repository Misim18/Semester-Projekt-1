package com.group4.gameLogic;

public class Collectables extends Coordinate {

    private final String name;
    private final int weight;
    private static String[] itemNames;

    public Collectables() {
        super(); // it is the position to x0, y0
        this.setCoordinateX(setRandomPositionX()); //sets the coordinates to the returned value of setRandomPositionX (method)
        this.setCoordinateY(setRandomPositionY()); //sets the coordinates to the returned value of setRandomPositionY (method)
        this.name = setRandomName();  //How it should be
        this.weight = 1; //this CAN be made interactive based on the name of the collectable
    }

    public static final void initializeItemNames() {
        itemNames = new String[8];
        itemNames[0] = "Food Wrapper";
        itemNames[1] = "Plastic Straw";
        itemNames[2] = "Plastic Fork / Knife / Spoon";
        itemNames[3] = "Plastic Bottle";
        itemNames[4] = "Plastic Bottle Cap";
        itemNames[5] = "Plastic Bag";
        itemNames[6] = "Plastic Lid";
        itemNames[7] = "Plastic Cup / Plate";

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
        int foodWrap = 3728712;
        int strawStir = 3668871;
        int forkKnifeSpoon = 1968065;
        int plasticBottle = 1754908;
        int bottleCap = 1390232;
        int plasticBag = (964541 + 938929);
        int plasticLid = 729892;
        int plasticCupPlate = 656276;

        int TotalTrash = foodWrap + strawStir + forkKnifeSpoon + plasticBottle + bottleCap + plasticBag + plasticLid + plasticCupPlate;

        int temp = (int) Math.round(Math.random() * TotalTrash);

        if (isBetween(temp, 0, foodWrap)) {
            temp = 0;
        } else if (isBetween(temp, foodWrap, foodWrap + strawStir)) {
            temp = 1;
        } else if (isBetween(temp, foodWrap + strawStir, foodWrap + strawStir + forkKnifeSpoon)) {
            temp = 2;
        } else if (isBetween(temp, foodWrap + strawStir + forkKnifeSpoon, foodWrap + strawStir + forkKnifeSpoon + plasticBottle)) {
            temp = 3;
        } else if (isBetween(temp, foodWrap + strawStir + forkKnifeSpoon + plasticBottle, foodWrap + strawStir + forkKnifeSpoon + plasticBottle + bottleCap)) {
            temp = 4;
        } else if (isBetween(temp, foodWrap + strawStir + forkKnifeSpoon + plasticBottle + bottleCap, foodWrap + strawStir + forkKnifeSpoon + plasticBottle + bottleCap + plasticBag)) {
            temp = 5;
        } else if (isBetween(temp, foodWrap + strawStir + forkKnifeSpoon + plasticBottle + bottleCap + plasticBag, foodWrap + strawStir + forkKnifeSpoon + plasticBottle + bottleCap + plasticBag + plasticLid)) {
            temp = 6;
        } else if (isBetween(temp, foodWrap + strawStir + forkKnifeSpoon + plasticBottle + bottleCap + plasticBag + plasticLid, foodWrap + strawStir + forkKnifeSpoon + plasticBottle + bottleCap + plasticBag + plasticLid + plasticCupPlate)) {
            temp = 7;
        }

        switch (temp) {
            case 2:
                temp = (int) Math.round(Math.random() * 2);

                switch (temp) {
                    case 0:
                        return "Plastic Fork";
                    case 1:
                        return "Plastic Knife";
                    case 2:
                        return "Plastic Spoon";
                    default:
                        break;
                }
            case 7:
                temp = (int) Math.round(Math.random());

                switch (temp) {
                    case 0:
                        return "Plastic Cup";
                    case 1:
                        return "Plastic Plate";
                    default:
                        break;
                }
            default:
                return getItemNamesElement(temp);
        }
    }

    public static boolean isBetween(int x, int lower, int upper) {
        return (lower <= x && x <= upper);
    }

    @Override
    public String toString() {
        return name + " - x:" + getCoordinateX() + " y:" + getCoordinateY();
    }

}
