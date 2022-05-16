package hotel_repo.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import java.util.Objects;
import java.io.IOException;
import hotel_repo.Exception.UsernameNotFoundException;
import hotel_repo.Exception.IncorrectPasswordException;
import hotel_repo.Services.UserService;
import hotel_repo.Model.User;

public class LoginController {

    @FXML
    private Text loginMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;

    protected static String Username;

    @FXML
      public void handleLoginAction2(ActionEvent event) {
        try {
            User user = UserService.loginUser(usernameField.getText(), passwordField.getText());
            Username=usernameField.getText();
            Parent root;

            if(Objects.equals(user.getRole(), "Hotel Manager")) {

                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("dashboard.fxml"));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("Dashboard_user.fxml"));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (UsernameNotFoundException e) {
            loginMessage.setText(e.getMessage());
        } catch (IncorrectPasswordException e) {
            loginMessage.setText(e.getMessage());
        }
    }


    public void handleLoginAction3(ActionEvent event) {
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
