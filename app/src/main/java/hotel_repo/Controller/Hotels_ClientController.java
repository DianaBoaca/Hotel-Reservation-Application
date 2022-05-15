package hotel_repo.Controller;

import hotel_repo.Model.Hotel;
import hotel_repo.Services.HotelService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Hotels_ClientController {

    @FXML
    private Text addressField;

    @FXML
    private Label descriptionField;

    @FXML
    public void initialize() {
        ArrayList<Hotel> list = HotelService.getHotels();
        for (Hotel h : list) {
            if ((h.getName()).equals(Hotel_List_PageController.title)) {
                addressField.setText(h.getAddress());
                descriptionField.setText(h.getDescription());
            }
        }
    }

    @FXML
    public void handleReserveAction(ActionEvent event) throws Exception {
        Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();

    }

}
