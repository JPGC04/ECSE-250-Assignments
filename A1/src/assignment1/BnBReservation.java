package assignment1;

public class BnBReservation extends HotelReservation {
    public BnBReservation(String clientName, Hotel hotelName, String roomType, int numberOfNights) {
        super(clientName, hotelName, roomType, numberOfNights);
    }

    public int getCost() {
        return (((super.getCost() / super.getNumOfNights()) + 1000) * super.getNumOfNights());
    }
}
