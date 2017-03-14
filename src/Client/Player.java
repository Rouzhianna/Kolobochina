package Client;

import gui.controllers.StartController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by N33na on 11.03.2017.
 */

public class Player extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override

    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gui/start_win.fxml"));
        Parent root = null;
        root = loader.load();

        StartController startController = loader.getController();
        startController.setStage(primaryStage);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

    }
}
