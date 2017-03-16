package gui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * @author Oleg Shatin
 *         11-501
 */
public class FightController {
    @FXML
    public GridPane root;
    @FXML
    public TextArea console;
    @FXML
    public ImageView playerIV;
    @FXML
    public ProgressBar playerHPBar;
    @FXML
    public ProgressBar opponentHPBar;
    @FXML
    public ImageView opponentIV;
    @FXML
    public Label opponentNameLabel;
    @FXML
    public Label playerNameLabel;

    public void initialize(){
        //todo: add player and opponent name, add pics to image views.
    }

    public void playerAttack(MouseEvent mouseEvent) {
    }

    public void playerGetHealth(MouseEvent mouseEvent) {
    }

    public void playerFlirt(MouseEvent mouseEvent) {
    }

    public void playerLeave(MouseEvent mouseEvent) {
    }
}
