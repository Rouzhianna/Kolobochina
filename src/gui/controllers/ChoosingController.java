package gui.controllers;

import entities.Hero;
import entities.Kolobok;
import entities.Rabbit;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Oleg Shatin
 *         11-501
 */
public class ChoosingController {
    @FXML
    public GridPane heroesContainer;
    @FXML
    public Label infoLabel;
    Collection<Hero> avalibleHeroes;
    private Stage stage;

    public void initialize(){
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
            hero.getImageView().setOnMouseClicked(new EventHandler<MouseEvent>() {
                Hero selectedHero = hero;
                @Override
                public void handle(MouseEvent event) {
                    userDoSelect(selectedHero);
                }
            });
            hero.getImageView().setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    infoLabel.setTranslateX(event.getSceneX());
                    infoLabel.setTranslateY(event.getSceneY());
                    infoLabel.setText(hero.getDesc());
                    infoLabel.setVisible(true);
                }
            });
            hero.getImageView().setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    infoLabel.setVisible(false);
                }
            });
            heroesContainer.add(hero.getImageView(), i, j);
            if (i == heroesContainer.getColumnConstraints().size() - 1) {
                if (j == heroesContainer.getRowConstraints().size() - 1) {
                    heroesContainer.addRow(heroesContainer.getRowConstraints().size());
                }
                j++;
                i = 0;
            } else {
                i++;
            }
        }
        heroesContainer.setVisible(true);
    }
    //method invoked by event handler
    private void userDoSelect(Hero selectedHero) {
        //todo: override this
        heroesContainer.add(new Label(selectedHero.getClass().getSimpleName()), 2, 1);

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
