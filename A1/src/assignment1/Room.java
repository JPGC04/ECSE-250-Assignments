package assignment1;

public class Room {
    private String roomType;

    private int roomPrice;

    private boolean roomAvailability;

    public Room(String roomType) {
        if (roomType == "double") {
            this.roomType = roomType;
            this.roomPrice = 9000;
            this.roomAvailability = true;
        } else if (roomType == "queen") {
            this.roomType = roomType;
            this.roomPrice = 11000;
            this.roomAvailability = true;
        } else if (roomType == "king") {
            this.roomType = roomType;
            this.roomPrice = 15000;
            this.roomAvailability = true;
        } else {
            throw new IllegalArgumentException("There is no room of such type.");
        }
    }

    public Room(Room inputRoom) {
        this.roomType = inputRoom.roomType;
        this.roomPrice = inputRoom.roomPrice;
        this.roomAvailability = inputRoom.roomAvailability;
    }

    public String getType() {
        return this.roomType;
    }

    public int getPrice() {
        return this.roomPrice;
    }

    public void changeAvailability() {
        this.roomAvailability = !this.roomAvailability;
    }

    public static Room findAvailableRoom(Room roomArray[], String roomTypeString) {
        for (int i = 0; i < roomArray.length; i++) {
            if (roomArray[i].getType() == roomTypeString && roomArray[i].roomAvailability) {
                return roomArray[i];
            }
        }
        return null;
    }

    public static boolean makeRoomAvailable(Room roomArray[], String roomTypeString) {
        for (int i = 0; i < roomArray.length; i++) {
            if (roomArray[i].getType() == roomTypeString && (!(roomArray[i].roomAvailability))) {
                roomArray[i].changeAvailability();
                return true;
            }
        }
        return false;
    }
}
