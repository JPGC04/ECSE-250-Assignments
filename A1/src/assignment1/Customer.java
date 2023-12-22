package assignment1;

public class Customer {
    private String customerName;

    private int customerBalance;

    private Basket customerBasket;

    public Customer(String customerName, int customerBalance) {
        this.customerName = customerName;
        this.customerBalance = customerBalance;
        this.customerBasket = new Basket();
    }

    public String getName() {
        return this.customerName;
    }

    public int getBalance() {
        return this.customerBalance;
    }

    public Basket getBasket() {
        return this.customerBasket;
    }

    public int addFunds(int newFunds) {
        if (newFunds < 0) {
            throw new IllegalArgumentException("The added funds are less than 0.");
        }
        this.customerBalance += newFunds;
        return this.customerBalance;
    }

    public int addToBasket(Reservation inputReservation) {
        if (this.customerName == inputReservation.reservationName()) {
            this.customerBasket.add(inputReservation);
            return this.customerBasket.getNumOfReservations();
        }
        throw new IllegalArgumentException("The reservation does not refer to this customer.");
    }

    public int addToBasket(Hotel hotelReservation, String roomType, int numOfNights, boolean includedBreakfast) {
        if (includedBreakfast) {
            this.addToBasket(new BnBReservation(this.customerName, hotelReservation, roomType, numOfNights));
        } else {
            this.addToBasket(new HotelReservation(this.customerName, hotelReservation, roomType, numOfNights));
        }
        return this.customerBasket.getNumOfReservations();
    }

    public int addToBasket(Airport airport1, Airport airport2) {
        try {
            this.addToBasket(new FlightReservation(this.customerName, airport1, airport2));
        } finally {
            return this.customerBasket.getNumOfReservations();
        }
    }

    public boolean removeFromBasket(Reservation inputReservation) {
        return this.customerBasket.remove(inputReservation);
    }

    public int checkOut() {
        int totalCost = this.customerBasket.getTotalCost();
        ;
        if (this.customerBalance < totalCost) {
            throw new IllegalStateException("The balance is not enough to cover the cost of this basket.");
        }
        this.customerBalance -= totalCost;
        this.customerBasket.clear();
        return this.customerBalance;
    }
}
