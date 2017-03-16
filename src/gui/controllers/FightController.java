package gui.controllers;

import Client.Helpers.Connection;
import entities.Fabrics.HeroFabric;
import entities.Hero;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

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
    public Label playerNameLabel;
    @FXML
    public ImageView playerIV;
    @FXML
    public ProgressBar playerHPBar;
    @FXML
    public Label playerHp;

    @FXML
    public Label opponentNameLabel;
    @FXML
    public ImageView opponentIV;
    @FXML
    public ProgressBar opponentHPBar;
    @FXML
    public Label opponentHp;

    private Hero myself;
    private Hero enemy;
    private PrintWriter printWriter = Connection.getPrintWriter();
    private BufferedReader bufferedReader = Connection.getBufferedReader();

    public void initialize() throws IOException {
        // i'am...
        myself = HeroFabric.createAHero(bufferedReader.readLine());
        playerNameLabel.setText(myself.getHeroName());
        playerIV.setImage(myself.getBackWait());
        refreshHp();

        // you are...
        enemy = HeroFabric.createAHero(bufferedReader.readLine());
        opponentNameLabel.setText(enemy.getHeroName());
        opponentIV.setImage(enemy.getFrontWait());
    }

    public void playerAttack(MouseEvent mouseEvent) {
        enemy.setHp(enemy.getHp() - myself.getAttackPower());
        printWriter.println("ATT&" + myself.getAttackPower());
        refreshEnemyHp();
    }

    public void heal(MouseEvent mouseEvent) {
        // TODO: 16.03.2017 invent heal possibility
    }

    public void playerFlirt(MouseEvent mouseEvent) {
        printWriter.println("FLI&" + myself.flirt());
    }

    public void playerLeave(MouseEvent mouseEvent) {
        myself.setHp(0);
        printWriter.println("LEA");
        refreshHp();
    }

    private void refreshHp(){
        playerHp.setText("hp: " + myself.getHp());
        double progress = 0;
        try {
            progress = myself.getHp() / myself.getAllHp();
        }catch (Exception e){
            e.printStackTrace();
        }
        playerHPBar.setProgress(playerHPBar.getProgress() - progress);
    }
    private void refreshEnemyHp(){
        opponentHp.setText("hp: " + enemy.getHp());
        double progress = 0;
        try {
            progress = enemy.getHp() / enemy.getAllHp();
        }catch (Exception e){
            e.printStackTrace();
        }
        opponentHPBar.setProgress(playerHPBar.getProgress() - progress);
    }

}
