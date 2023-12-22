package assignment1;

public class Airport {
    private int xCoord;

    private int yCoord;

    private int airportFees;

    public Airport(int xCoord, int yCoord, int airportFees) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.airportFees = airportFees;
    }

    public int getFees() { return airportFees; }

    public static int getDistance(Airport airport1, Airport airport2) {
        return (int) Math.ceil(java.lang.Math.sqrt((Math.pow(airport1.xCoord - airport2.xCoord, 2) + Math.pow(airport1.yCoord - airport2.yCoord,2))));
    }
}
