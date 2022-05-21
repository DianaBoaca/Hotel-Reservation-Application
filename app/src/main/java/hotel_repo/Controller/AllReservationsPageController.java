package hotel_repo.Controller;

import hotel_repo.Services.ReservationService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.io.IOException;

public class AllReservationsPageController {

    @FXML
    private TextArea text;

    @FXML
    public void initialize() {
        if(!ReservationService.findAllReservations().isEmpty())
            text.setText(ReservationService.findAllReservations());
    }

}

