package hotel_repo.Controller;

import hotel_repo.Model.Reservation;
import hotel_repo.Model.User;
import hotel_repo.Services.ReservationService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;

import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import hotel_repo.Model.Hotel;
import hotel_repo.Services.HotelService;

import static java.time.temporal.ChronoUnit.DAYS;


public class ReservationController implements Initializable {

    String Hotel_ID;
    static int Price;
    static Reservation res;

    @FXML
    private TextField commentField;

    @FXML
    private DatePicker Checkin_date;

    @FXML
    private DatePicker Checkout_date;

    @FXML
    private ChoiceBox<Integer> Room_number;

    @FXML
    private ChoiceBox<String> Room_type;


   public void getDatein(ActionEvent event) {

        LocalDate myDate = Checkin_date.getValue();
        String myFormattedDatein = myDate.format(DateTimeFormatter.ofPattern("MMM-dd-yyyy"));

   }


    public void getDateout(ActionEvent event) {

        LocalDate myDate = Checkin_date.getValue();
        String myFormattedDateout = myDate.format(DateTimeFormatter.ofPattern("MMM-dd-yyyy"));

    }

    /*public int countDays(){
        Duration duration = Duration.between(Checkin_date.getValue(), Checkout_date.getValue());
        return (int) duration.toDays();
    }*/

    public int getPrice(String type, int roomnb, int days){
       if(type.equals("double"))
           return roomnb*400*days;
       if(type.equals("triple"))
           return roomnb*500*days;
       return  roomnb*600*days;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Room_number.getItems().add(1);
        Room_number.getItems().add(2);
        Room_number.getItems().add(3);
        Room_number.getItems().add(4);
        Room_number.getItems().add(5);

        Room_type.getItems().add("double");
        Room_type.getItems().add("triple");
        Room_type.getItems().add("apartment");

    }

        @FXML
        public void findHotel() {
            ArrayList<Hotel> list = HotelService.getHotels();
            for (Hotel h : list) {
                if ((h.getName()).equals(Hotel_List_PageController.title)) {
                    Hotel_ID=h.getID();
                }
            }
        }

    @FXML
    public void handlePayAction(ActionEvent event) throws Exception{
        Parent root;
        try {
            findHotel();
            Price=getPrice(Room_type.getValue(), Room_number.getValue(), (int )DAYS.between(Checkin_date.getValue(), Checkout_date.getValue()));
            res= new Reservation(LoginController.Username, Hotel_ID,Checkin_date.getValue().format(DateTimeFormatter.ofPattern("MMM-dd-yyyy")),Checkout_date.getValue().format(DateTimeFormatter.ofPattern("MMM-dd-yyyy")), Room_type.getValue(), Room_number.getValue(), commentField.getText());

            root = FXMLLoader.load(getClass().getClassLoader().getResource("Pay.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


