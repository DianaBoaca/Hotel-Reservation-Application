package hotel_repo.Controller;

import hotel_repo.Services.ReservationService;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class CurrentReservationsPageController {

    @FXML
    private TextArea text;

    @FXML
    public void initialize() {
        if(!ReservationService.findCurrentReservations().isEmpty())
            text.setText(ReservationService.findCurrentReservations());
    }

}

