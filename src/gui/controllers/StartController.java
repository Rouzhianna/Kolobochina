package gui.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController {

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void userClickedFirstButton(MouseEvent mouseEvent) throws IOException {
        // TODO: 11.03.2017 add some logic to connect to serv
        //this
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../choose_fighter_win.fxml"));
        Parent root = loader.load();
        ChoosingController controller = loader.getController();
        controller.setStage(stage);
        stage.setScene(new Scene(root, 800, 600));
        stage.show();

    }
}
