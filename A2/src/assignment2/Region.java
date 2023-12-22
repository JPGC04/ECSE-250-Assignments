package assignment2;

public class Region {
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;

    public Region(int xMin, int yMin, int xMax, int yMax) {
        if (xMin < 0 || yMin < 0 || xMax < 0 || yMax < 0 || xMin > xMax || yMin > yMax) {
            throw new IllegalArgumentException();
        }
        this.minX = xMin;
        this.minY = yMin;
        this.maxX = xMax;
        this.maxY = yMax;
    }

    public boolean contains(Position inputPos) {
        return (inputPos.getX() >= this.minX && inputPos.getX() <= this.maxX && inputPos.getY() >= this.minY && inputPos.getY() <= this.maxY);
    }
}
