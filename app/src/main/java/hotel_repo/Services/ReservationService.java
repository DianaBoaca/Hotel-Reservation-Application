package hotel_repo.Services;

import hotel_repo.Controller.EditPageController;
import hotel_repo.Exception.IncorectDateException;
import hotel_repo.Exception.UnavailableDateException;
import hotel_repo.Model.Hotel;
import hotel_repo.Model.Reservation;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectFilter;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

import static hotel_repo.Services.FileSystemService.getPathToFile;
import static hotel_repo.Services.HotelService.getHotelbyID;
import static hotel_repo.Services.HotelService.getRoom_NumberbyID;
import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

public class ReservationService {

    private static ObjectRepository<Reservation> reservationRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("reservation.db").toFile())
                .openOrCreate("test", "test");

        reservationRepository = database.getRepository(Reservation.class);
    }

    public static void addReservation(String User, String Hotel_ID, String Checkin_date, String Checkout_date, String Room_type, int Room_number, String Comment) throws UnavailableDateException, IncorectDateException {
        checkUnavailableDateException(Checkin_date, Checkout_date, Hotel_ID);
        reservationRepository.insert(new Reservation(User, Hotel_ID, Checkin_date, Checkout_date, Room_type, Room_number, Comment));

    }

    public static void addReservation(Reservation res) throws UnavailableDateException, IncorectDateException {
        checkUnavailableDateException(res.getCheckin_date(), res.getCheckout_date(), res.getHotel_ID());
        reservationRepository.insert(res);
    }

    public static LocalDate toDate(String d){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-dd-yyyy");
        LocalDate localDate = LocalDate.parse(d, formatter);
        return localDate;

    }
  
  public static String dtoString(LocalDate d){
        String pattern = "MMM-dd-yyyy";
        String formattedDate = d.format(DateTimeFormatter.ofPattern(pattern));

        return formattedDate;
    }

    public static void checkUnavailableDateException(String Checkin_date, String Checkout_date, String id) throws IncorectDateException, UnavailableDateException{

        int y;
        Integer x = getRoom_NumberbyID(id);
        LocalDate in = toDate(Checkin_date);
        LocalDate out = toDate(Checkout_date);



        if(out.isBefore(in)) throw new IncorectDateException();


        ArrayList<String> dates = getHotelbyID(id).getDates();
        ArrayList<Integer> dates_nr = getHotelbyID(id).getDates_count();


        /*for (LocalDate datefor = in; datefor.isBefore(out); datefor = datefor.plusDays(1)) {

            if (dates.contains(dtoString(datefor))){

                y = dates.indexOf(dtoString(datefor));

                if(dates_nr.get(y).equals(x)) throw new UnavailableDateException();

                dates_nr.add(y, dates_nr.get(y)+ (Integer) 1);
            }
            else{

                dates.add(dtoString(datefor));
                y = dates.indexOf(dtoString(datefor));
                dates_nr.add(y, dates_nr.get(y)+ (Integer) 1);
            }
        }*/
    }

    public static String findReservation(String user) {

        String s = "";

        for (Reservation res : reservationRepository.find(ObjectFilters.eq("User", user))) {
            s +="Hotel: " + res.getHotel_ID() + ", Checkin Date: " + res.getCheckin_date() + ", Checkout Date: " + res.getCheckout_date()+" Room type: "+res.getRoom_type() + ", Number of rooms:" + res.getRoom_number()+ "\n\n";
        }

        return s;
    }

    public static String findAllReservations() {

        String s = "";

        for (Reservation res : reservationRepository.find()) {
           s += "Hotel ";
            if(res.getHotel_ID().equals("01"))
                s += "Timisoara";
            else if(res.getHotel_ID().equals("02"))
                s += "Cluj";
            else
                s += "Brasov";

            s +=", Username: "+ res.getUser() + ", Checkin Date: " + res.getCheckin_date() + ", Checkout Date: " + res.getCheckout_date()+" Room type: "+res.getRoom_type() + ", Number of rooms:" + res.getRoom_number()+ "\n\n";
        }

        return s;
    }

}

