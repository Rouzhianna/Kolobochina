package gui.controllers;

import Client.Helpers.Connection;
import Client.Helpers.Loader;
import Client.Helpers.Status;
import entities.Fabrics.HeroFabric;
import entities.Hero;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

    private final static String WIN_FXML = "";
    private final static String LOS_FXML = "";

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

    @FXML
    public Button attackBtn;
    @FXML
    public Button healBtn;
    @FXML
    public Button flirtBtn;
    @FXML
    public Button leaveBtn;

    private Hero myself;
    private Hero enemy;
    private Status status;
    private PrintWriter printWriter = Connection.getPrintWriter();
    private BufferedReader bufferedReader = Connection.getBufferedReader();

    public void initialize() throws IOException {
        // i'am...
        myself = HeroFabric.createAHero(bufferedReader.readLine());
        playerNameLabel.setText(myself.getHeroName());
        playerIV.setImage(myself.getBackWait());
        refreshHp();
        if(myself.getHeroName().equalsIgnoreCase("fox"))
            healBtn.setOnMouseClicked(null);

        // you are...
        enemy = HeroFabric.createAHero(bufferedReader.readLine());
        opponentNameLabel.setText(enemy.getHeroName());
        opponentIV.setImage(enemy.getFrontWait());

        Thread thread = new Thread(() -> {
            while (true){
                try {
                    String command = bufferedReader.readLine();
                    if(command.equals("WAI"))
                        status = Status.WATITING;
                    else if(command.equals("TUR"))
                        status = Status.TURN;
                    else if(command.equals("WON"))
                        Loader.goTo(WIN_FXML, root);
                    else if(command.equals("LOS"))
                        Loader.goTo(LOS_FXML, root);
                    else {
                        String[] commands = command.split("&");

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

    }

    public void btnHandler(MouseEvent mouseEvent){
        // TODO: 17.03.2017 прием знаков с сервера
        if(status == Status.TURN){
            if(mouseEvent.getSource().equals(attackBtn))
                playerAttack();
            else if(mouseEvent.getSource().equals(healBtn))
                heal();
            else if(mouseEvent.getSource().equals(flirtBtn))
                playerFlirt();
            else if(mouseEvent.getSource().equals(leaveBtn))
                playerLeave();
        }
    }

    public void playerAttack() {
        double attackPower = (myself.isFlirted() ? 0.5 : 1);
        myself.setImageView(new ImageView(myself.getBackAttack()));
        new AnimationTimer(){
            long was = 0;
            @Override
            public void handle(long now) {
                myself.setImageView(new ImageView(myself.getBackWait()));
            }

        }.start();
        enemy.setHp((int) (enemy.getHp() - myself.getAttackPower() * attackPower));
        printWriter.println("ATT&" + myself.getAttackPower());
        refreshEnemyHp();
        status = Status.WATITING;
    }

    public void heal() {
        if(myself.getNowCoolDown() == 0){
            myself.heal();
            printWriter.println("HEA&" + myself.getHp());
            refreshHp();
        }
        else printWriter.println("HEA&error");
        status = Status.WATITING;
    }

    public void playerFlirt() {
        printWriter.println("FLI&" + myself.flirt());
    }

    public void playerLeave() {
        myself.setHp(0);
        printWriter.println("LEA");
        refreshHp();
    }

    private void refreshHp(){
        playerHp.setText("hp: " + myself.getHp() + "/" + myself.getAllHp());
        playerHPBar.setProgress(countProgress(myself));
    }

    private void refreshEnemyHp(){
        opponentHp.setText("hp: " + enemy.getHp() + "/" + enemy.getAllHp());
        opponentHPBar.setProgress(countProgress(enemy));
    }

    private double countProgress(Hero hero){
        double progress = 0;
        try {
            progress = (double) hero.getHp() / (double) hero.getAllHp();
            System.out.println("progress: " + progress);
        }catch (Exception e){
            e.printStackTrace();
        }
        return (progress > 0 ? progress : 0);
    }

}
