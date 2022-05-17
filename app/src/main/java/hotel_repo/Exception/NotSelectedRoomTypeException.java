package hotel_repo.Exception;

public class NotSelectedRoomTypeException extends Exception {

    public NotSelectedRoomTypeException() {
        super("Please select a room type.");
    }


}
