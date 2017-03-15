package gui.controllers;

import entities.Hero;
import entities.Kolobok;
import entities.Rabbit;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Oleg Shatin
 *         11-501
 */
public class ChoosingController {
    @FXML
    public GridPane HeroesContainer;
    Collection<Hero> avalibleHeroes;
    private Stage stage;

    public void initialize(){
        //todo: init all heroes
        avalibleHeroes = new ArrayList<>();
        avalibleHeroes.add(new Kolobok());
        avalibleHeroes.add(new Rabbit());
        addHeroesToView();

    }
    private void addHeroesToView() {
        int i = 0;
        int j = 0;
        for (Hero hero: avalibleHeroes){
            hero.getImageView().setPreserveRatio(true);
            hero.getImageView().setFitWidth(150);
            hero.getImageView().setVisible(true);
            HeroesContainer.add(hero.getImageView(), i, j);
            if (i == HeroesContainer.getColumnConstraints().size() - 1) {
                if (j == HeroesContainer.getRowConstraints().size() - 1) {
                    HeroesContainer.addRow(HeroesContainer.getRowConstraints().size());
                }
                j++;
                i = 0;
            } else {
                i++;
            }
        }
        HeroesContainer.setVisible(true);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
