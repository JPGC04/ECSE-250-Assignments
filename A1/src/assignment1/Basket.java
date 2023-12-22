package assignment1;

public class Basket {
    private Reservation reservationArray[];

    private int numOfReservations = 0;

    public Basket() {
        this.reservationArray = new Reservation[0];
    }

    public Reservation[] getProducts() {
        return this.reservationArray.clone();
    }

    public int add(Reservation reservationObject) {
        Reservation tempReservations[] = new Reservation[this.reservationArray.length + 1];
        for (int i = 0; i < tempReservations.length - 1; i++) {
            tempReservations[i] = reservationArray[i];
        }
        tempReservations[tempReservations.length - 1] = reservationObject;
        this.reservationArray = tempReservations;
        this.numOfReservations++;
        return this.numOfReservations;
    }

    public boolean remove(Reservation reservationObject) {
        if (this.reservationArray.length == 0) {
            return false;
        }
        Reservation tempReservationArray[] = new Reservation[this.reservationArray.length - 1];
        int position = -1;
        boolean reservationFound = false;
        for (int i = 0; i < this.reservationArray.length; i++) {
            if (reservationObject.equals(this.reservationArray[i]) && !reservationFound) {
                reservationFound = true;
                position = i;
                this.numOfReservations -= 1;
            } else if ((i == this.reservationArray.length - 1) && !reservationFound) {
                return false;
            }
        }
        for (int i = 0; i < this.reservationArray.length; i++) {
            if (i < position) {
                tempReservationArray[i] = this.reservationArray[i];
            } else if (i > position) {
                tempReservationArray[i - 1] = this.reservationArray[i];
            }
        }
        this.reservationArray = tempReservationArray;
        return true;
    }

    public void clear() {
        this.numOfReservations = 0;
        this.reservationArray = new Reservation[0];
    }

    public int getNumOfReservations() {
        return this.numOfReservations;
    }

    public int getTotalCost() {
        int tempCost = 0;
        for (int i = 0; i < numOfReservations; i++) {
            tempCost += this.reservationArray[i].getCost();
        }
        return tempCost;
    }
}
