package gui.controllers;

import Client.Helpers.Connection;
import Client.Helpers.Loader;
import entities.Fox;
import entities.Hero;
import entities.Kolobok;
import entities.Rabbit;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Oleg Shatin
 *         11-501
 */
public class ChoosingController {

    private static final String FIGHT_FXML = "../../gui/fight_win.fxml";

    @FXML
    public Label selectLabel;
    @FXML
    public GridPane heroesContainer;
    @FXML
    public Label infoLabel;


    Collection<Hero> availableHeroes;
    private Stage stage;

    public void initialize(){
        availableHeroes = new ArrayList<>();
        availableHeroes.add(new Kolobok());
        availableHeroes.add(new Rabbit());
        availableHeroes.add(new Fox());
        addHeroesToView();

    }
    private void addHeroesToView() {
        int i = 0;
        int j = 0;
        for (Hero hero: availableHeroes){
            hero.getImageView().setPreserveRatio(true);
            hero.getImageView().setFitWidth(150);
            hero.getImageView().setVisible(true);
            hero.getImageView().setOnMouseClicked(new EventHandler<MouseEvent>() {
                Hero selectedHero = hero;
                @Override
                public void handle(MouseEvent event) {
                    try {
                        userDoSelect(selectedHero);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
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
    private void userDoSelect(Hero selectedHero) throws IOException {
        String name = selectedHero.getHeroName();
        System.out.println(name);

        selectLabel.setText("Waiting for server connection...");
        Connection.init();
        Connection.getPrintWriter().println(name);
        selectLabel.setText("Waiting for another player...");

        if(Connection.getBufferedReader().readLine().equals("ready"))
            Loader.goTo(FIGHT_FXML, heroesContainer);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
