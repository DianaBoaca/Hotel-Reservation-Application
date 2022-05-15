package hotel_repo.Controller;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import hotel_repo.Model.Hotel;
import hotel_repo.Services.HotelService;
import hotel_repo.Controller.EditPageController;

public class HotelsController {

    @FXML
    private TextField addressField;

    @FXML
    private TextArea descriptionField;

    @FXML
    public void initialize() {
        ArrayList<Hotel> list = HotelService.getHotels();
        for (Hotel h : list) {
            if ((h.getName()).equals(EditPageController.title)) {
                addressField.setText(h.getAddress());
                descriptionField.setText(h.getDescription());
            }
        }
    }

    @FXML
    public void handleSaveAction(ActionEvent event) throws Exception {
        Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
        String title = s.getTitle();
        HotelService.storage(title, addressField.getText(), descriptionField.getText());
    }

}
