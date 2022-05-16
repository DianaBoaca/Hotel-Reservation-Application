package hotel_repo.Exception;

public class UnavailableDateException extends Exception {

    /*private Date checkin_date;
    private Date checkout_date;



    public UnavailabeDateException(Reservation reservation) {
        super("Invalid date!");
        this.checkin_date= reservation.getCheckin_date();
        this.checkout_date= reservation.getCheckout_date();
    }

    public Date getCheckin_date() {
        return checkin_date;
    }
    public Date getCheckout_date() {
        return checkout_date;
    }*/
    public UnavailableDateException() {
        super("Invalid date!");
    }


}
