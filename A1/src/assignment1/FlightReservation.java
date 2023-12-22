package assignment1;

public class FlightReservation extends Reservation {
    private Airport departureAirport;

    private Airport arrivalAirport;

    public FlightReservation(String clientName, Airport departureAirport, Airport arrivalAirport) {
        super(clientName);
        if (departureAirport.equals(arrivalAirport)) {
            throw new IllegalArgumentException("Both Airport objects are equal.");
        }
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public int getCost() {
        return (int) Math.ceil((Airport.getDistance(this.departureAirport, this.arrivalAirport)/167.52*124) + departureAirport.getFees() + arrivalAirport.getFees() + 5375);
    }

    public boolean equals(Object inputObject) {
        return ((inputObject instanceof FlightReservation) && (this.departureAirport.equals(((FlightReservation) inputObject).departureAirport)) && (this.arrivalAirport.equals(((FlightReservation) inputObject).arrivalAirport)) && (this.reservationName() == ((FlightReservation) inputObject).reservationName()));
    }
}
