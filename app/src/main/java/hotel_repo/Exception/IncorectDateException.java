package hotel_repo.Exception;

public class IncorectDateException extends Exception {

    public IncorectDateException() {
        super("Incorrect. Checkout date before checkin date!");
    }


}
