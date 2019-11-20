package gameLogic;

/**
 *
 * @author sofie
 */
public abstract class Coordinate {

    private int coordinateX;
    private int coordinateY;

    public Coordinate(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public Coordinate() {
        this(0, 0);
    }

    public int getCoordinateX() {
        return this.coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return this.coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public void setCoordinate_X_Y(int xPos, int yPos) {
        this.coordinateX = xPos;
        this.coordinateY = yPos;

    }

    @Override
    public abstract String toString();

}
