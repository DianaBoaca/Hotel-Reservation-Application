package hotel_repo.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Dashboard_userController {

    @FXML
    public void handleViewHotelsAction(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Hotel_List_Page.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleHistoryReservationAction(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("My_Reservation_Page.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleLogoutAction(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
