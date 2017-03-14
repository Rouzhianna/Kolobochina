package Client.Controllers;

import Client.Helpers.Connection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by N33na on 11.03.2017.
 */
public class MainMenuController implements Initializable {

    private static final String PLAY_GAME = "../resources/playgame.fxml";

    @FXML
    private Button startGameBtn;

    public void goTo (ActionEvent ae){
        String resourse = "";
        if(ae.getSource().equals("playgame")){
            Connection.init();
            resourse = PLAY_GAME;
        }else if(ae.getSource().equals("exitgame"))
            System.exit(0);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
