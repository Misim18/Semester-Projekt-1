package worldofzuul;

/**
 *
 * @author sofie
 */
public abstract class Coordinate {
	private int coordinateX;
	private int coordinateY;

	public Coordinate(int coordinateX, int coordinateY){
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
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

	public void setCoordinate_X_Y(int xPos, int yPos){
		this.coordinateX = xPos;
		this.coordinateY = yPos;

	}
        // used in the text based game.
	@Override
	public String toString(){
		return "\n" +
			"x:" + getCoordinateX() +
			" y:" + getCoordinateY();
	}
}
