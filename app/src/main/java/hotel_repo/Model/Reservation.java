package hotel_repo.Model;

import org.dizitart.no2.objects.Id;
//import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Reservation {

    private String User;
    private String Hotel_ID;
    private String Checkin_date;
    private String Checkout_date;
    private String Room_type;
    private int Room_number;
    private String Comment;


    public Reservation(String User, String Hotel_ID, String Checkin_date, String Checkout_date,String Room_type, int Room_number, String Comment) {
        //this.ID=ID;
        this.User=User;
        this.Hotel_ID=Hotel_ID;
        this.Checkin_date=Checkin_date;
        this.Checkout_date=Checkout_date;
        this.Room_type=Room_type;
        this.Room_number=Room_number;
        this.Comment=Comment;
    }

    public Reservation() {
    }

    public void setHotel_ID(String hotel_ID) {
        Hotel_ID = hotel_ID;
    }

    public String getHotel_ID() {
        return Hotel_ID;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getCheckin_date() {
        return Checkin_date;
    }

    public void setCheckin_date(String checkin_date) {
        Checkin_date = checkin_date;
    }

    public String getCheckout_date() {
        return Checkout_date;
    }

    public void setCheckout_date(String checkout_date) {
        Checkout_date = checkout_date;
    }

    public String getRoom_type() {
        return Room_type;
    }

    public void setRoom_Type(String room_Type) {
        Room_type = room_Type;
    }

    public int getRoom_number() {
        return Room_number;
    }

    public void setRoom_number(int room_number) {
        Room_number = room_number;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;
        Reservation that = (Reservation) o;
        return Room_number == that.Room_number && User.equals(that.User) && Hotel_ID.equals(that.Hotel_ID) && Checkin_date.equals(that.Checkin_date) && Checkout_date.equals(that.Checkout_date) && Room_type.equals(that.Room_type) && Objects.equals(Comment, that.Comment);
    }

}
