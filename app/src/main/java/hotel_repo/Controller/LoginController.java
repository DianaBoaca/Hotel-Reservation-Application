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

    @FXML
    public void handleLoginAction2() {
        try {
            UserService.loginUser(usernameField.getText(), passwordField.getText());
            loginMessage.setText("Logged in successfully!");
        } catch (UsernameNotFoundException e) {
            loginMessage.setText(e.getMessage());
        } catch (IncorrectPasswordException e) {
            loginMessage.setText(e.getMessage());
        }
    }

}
