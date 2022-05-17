package hotel_repo.Exception;

public class NotSelectedRoomNumberException extends Exception {

    public NotSelectedRoomNumberException() {
        super("Please select a room number.");
    }


}
