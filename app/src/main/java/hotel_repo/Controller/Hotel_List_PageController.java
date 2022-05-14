package hotel_repo.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.Text;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import java.io.IOException;
import hotel_repo.Services.UserService;
import hotel_repo.Model.User;

public class Hotel_List_PageController {

    @FXML
    public void handleTimisoaraAction() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Hotel_Timisoara_Client.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleClujAction() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Hotel_Cluj_Client.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleBrasovAction() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Hotel_Brasov_Client.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
