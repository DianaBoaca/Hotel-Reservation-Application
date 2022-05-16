package hotel_repo.Controller;

import hotel_repo.Model.Reservation;
import hotel_repo.Services.ReservationService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

public class My_Reservation_PageController {

    @FXML
    private Label label;

    @FXML
    public void initialize() {
        if(!ReservationService.findReservation(LoginController.Username).isEmpty())
            label.setText(ReservationService.findReservation(LoginController.Username));
    }

    @FXML
    public void handleGoBackAction(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Dashboard_user.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
