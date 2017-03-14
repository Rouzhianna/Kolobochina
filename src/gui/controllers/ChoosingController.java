package gui.controllers;

import entities.Hero;
import javafx.stage.Stage;


import java.util.Collection;

/**
 * @author Oleg Shatin
 *         11-501
 */
public class ChoosingController {
    Collection<Hero> avalibleHeroes;
    private Stage stage;

    public void init(){
        //todo: init all heroes
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
