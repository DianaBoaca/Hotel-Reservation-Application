package hotel_repo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import hotel_repo.Services.FileSystemService;
import hotel_repo.Services.UserService;
import hotel_repo.Services.HotelService;
import hotel_repo.Model.Hotel;

import java.nio.file.Files;
import java.nio.file.Path;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        initDirectory();
        UserService.initDatabase();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        primaryStage.setTitle("Hotel Reservation Application");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        HotelService.setHotels();
    }

    private void initDirectory() {
        Path applicationHomePath = FileSystemService.APPLICATION_HOME_PATH;
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }

    public static void main(String[] args) { launch(args); }

}