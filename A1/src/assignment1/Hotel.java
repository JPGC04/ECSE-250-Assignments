package assignment1;

public class Hotel {
    private String hotelName;

    private Room hotelRooms[];

    public Hotel(String hotelName, Room[] hotelRooms) {
        this.hotelName = hotelName;

        Room[] hotelRoomsCopy = new Room[hotelRooms.length];
        for (int i = 0; i < hotelRooms.length; i++) {
            hotelRoomsCopy[i] = new Room(hotelRooms[i]);
        }
        this.hotelRooms = hotelRoomsCopy;
    }

    public int reserveRoom(String roomType) {
        Room tempRoom = Room.findAvailableRoom(this.hotelRooms, roomType);
        if (tempRoom == null) {
            throw new IllegalArgumentException("There is no available room of such type.");
        }
        tempRoom.changeAvailability();
        return tempRoom.getPrice();
    }

    public boolean cancelRoom(String hotelRoomType) {
        return Room.makeRoomAvailable(this.hotelRooms, hotelRoomType);
    }
}
