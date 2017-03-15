package gui.controllers;

import Client.Helpers.Loader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StartController {

    private Stage stage;

    private static final String CHOOSE_FXML = "../../gui/choose_fighter_win.fxml";

    @FXML
    private Pane menuPane;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void mouseClicked(MouseEvent mouseEvent) {
        Loader.goTo(CHOOSE_FXML, menuPane);
    }


    public void exitGame(MouseEvent mouseEvent) {
        System.exit(0);
    }

}
