package Client.Helpers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by N33na on 15.03.2017.
 */
public class Loader {

    public static void goTo(String resource, Pane pane){
        Stage stage = (Stage) pane.getScene().getWindow();
        goTo(resource, stage);
    }

    public static void goTo(String resource, Stage stage){
        try {
            FXMLLoader f = new FXMLLoader(Loader.class.getResource(resource));
            Parent root = f.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
