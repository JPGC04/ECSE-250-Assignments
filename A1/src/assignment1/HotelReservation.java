package assignment1;

public class HotelReservation extends Reservation {
    private Hotel hotelName;

    private String roomType;

    private int numberOfNights;

    private int nightlyRoomPrice;

    public HotelReservation(String clientName, Hotel hotelName, String roomType, int numberOfNights) {
        super(clientName);
        hotelName.reserveRoom(roomType);
        this.hotelName = hotelName;
        this.roomType = roomType;
        if (numberOfNights <= 0) {
            throw new IllegalArgumentException("It is impossible to reserve for less than 1 night.");
        }
        this.numberOfNights = numberOfNights;
        if (roomType == "double") {
            this.nightlyRoomPrice = 9000;
        } else if (roomType == "queen") {
            this.nightlyRoomPrice = 11000;
        } else if (roomType == "king") {
            this.nightlyRoomPrice = 15000;
        } else {
            throw new IllegalArgumentException("There is no room of such type.");
        }
    }

    public int getNumOfNights() {
        return this.numberOfNights;
    }

    public int getCost() {
        return (this.nightlyRoomPrice * this.numberOfNights);
    }

    public boolean equals(Object inputObject) {
        return ((inputObject instanceof HotelReservation)
                && (this.reservationName() == ((HotelReservation) inputObject).reservationName())
                && (this.hotelName.equals(((HotelReservation) inputObject).hotelName))
                && (this.roomType == ((HotelReservation) inputObject).roomType)
                && (this.getNumOfNights() == ((HotelReservation) inputObject).getNumOfNights())
                && (this.getCost() == ((HotelReservation) inputObject).getCost()));
    }
}
