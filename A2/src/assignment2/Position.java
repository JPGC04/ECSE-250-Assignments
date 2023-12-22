package assignment2;

public class Position {
    private int xCoord;
    private int yCoord;

    public Position(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException();
        }
        this.xCoord = x;
        this.yCoord = y;

    }

    public Position(Position positionInput) {
        if (positionInput.getX() < 0 || positionInput.getY() < 0) {
            throw new IllegalArgumentException();
        }
        this.xCoord = positionInput.xCoord;
        this.yCoord = positionInput.yCoord;

    }

    public void reset(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException();
        }
        this.xCoord = x;
        this.yCoord = y;

    }

    public void reset(Position positionInput) {
        if (positionInput.getX() < 0 || positionInput.getY() < 0) {
            throw new IllegalArgumentException();
        }
        this.xCoord = positionInput.xCoord;
        this.yCoord = positionInput.yCoord;
    }

    public int getDistance(Position inputPosition) {
        if (inputPosition.xCoord < 0 || inputPosition.yCoord < 0) {
            throw new IllegalArgumentException();
        }
        return (Math.abs(inputPosition.getX() - this.getX()) + Math.abs(inputPosition.getY() - this.getY()));
    }

    public int getX() {
        return this.xCoord;
    }

    public int getY() {
        return this.yCoord;
    }

    public void moveWest() {
        if (this.xCoord - 1 < 0 || this.yCoord < 0) {
            throw new IllegalArgumentException();
        }
        this.xCoord--;

    }

    public void moveEast() {
        if (this.xCoord + 1 < 0 || this.yCoord < 0) {
            throw new IllegalArgumentException();
        }
        this.xCoord++;

    }

    public void moveNorth() {
        if (this.xCoord < 0 || this.yCoord - 1 < 0) {
            throw new IllegalArgumentException();
        }
        this.yCoord--;
    }

    public void moveSouth() {
        if (this.xCoord < 0 || this.yCoord + 1 < 0) {
            throw new IllegalArgumentException();
        }
        this.yCoord++;

    }

    public boolean equals(Object object) {
        return ((object instanceof Position) && (((Position) object).getX() == this.getX())
                && (((Position) object).getY() == this.getY()));
    }
}
