package hotel_repo.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.Text;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.io.IOException;
import hotel_repo.Services.UserService;
import hotel_repo.Services.HotelService;
import hotel_repo.Model.User;

public class EditPageController {

    public static String title;

    @FXML
    public void handleTimisoaraAction(ActionEvent event) {
        Parent root;
        try {
            title = "Hotel Timisoara";
            root = FXMLLoader.load(getClass().getClassLoader().getResource("HotelTimisoara.fxml"));
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleClujAction(ActionEvent event) {
        Parent root;
        try {
            title = "Hotel Cluj";
            root = FXMLLoader.load(getClass().getClassLoader().getResource("HotelCluj.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Hotel Cluj");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleBrasovAction(ActionEvent event) {
        Parent root;
        try {
            title = "Hotel Brasov";
            root = FXMLLoader.load(getClass().getClassLoader().getResource("HotelBrasov.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Hotel Brasov");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
