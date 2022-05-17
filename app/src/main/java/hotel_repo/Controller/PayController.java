package hotel_repo.Controller;

import hotel_repo.Exception.IncorectDateException;
import hotel_repo.Exception.UnavailableDateException;
import hotel_repo.Model.Reservation;
import hotel_repo.Services.ReservationService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.dizitart.no2.Cursor;

import java.io.IOException;

public class PayController {

    @FXML
    private TextField Name;

    @FXML
    private TextField cardNumber;

    @FXML
    private Text Amount;

    @FXML
    public void initialize() {
        Amount.setText(String.valueOf(ReservationController.Price));
    }

    @FXML
    private Text payMessage;

    public boolean notValid(String s){
        if(s.isEmpty()) return true;
        try {
            Integer i = Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return true;
        }

        return false;
    }

    @FXML
    public void handleValidateAction(ActionEvent event) throws UnavailableDateException, IncorectDateException {

       if(Name.getText().isEmpty())
           payMessage.setText("Please enter cardholder's name!");
       else
           if(notValid(cardNumber.getText()) )
               payMessage.setText("Please enter a valid card number!");
           else {
               try {
                   payMessage.setText("Successful reservation");
                   ReservationService.addReservation(ReservationController.res);
               }catch(IncorectDateException e){
                   payMessage.setText(e.getMessage());
               }catch(UnavailableDateException e){
                   payMessage.setText(e.getMessage());
               }
           }
    }

    @FXML
    public void handleCloseAppAction(ActionEvent event) {
        javafx.application.Platform.exit();
    }
}
