package Client.gui.controllers;

import Client.Helpers.Connection;
import Client.Helpers.Loader;
import Client.Helpers.Status;
import Client.entities.Fabrics.HeroFabric;
import Client.entities.Hero;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
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
import java.net.SocketException;

/**
 * @author Oleg Shatin and Nina Fazlyeva, yo
 *         11-501
 */
public class FightController {

    private final static String WIN_FXML = "../gui/winner_win.fxml";
    private final static String LOS_FXML = "../gui/looser_win.fxml";

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

    private static Hero myself;
    private static Hero enemy;
    private Status status;
    private PrintWriter printWriter = Connection.getPrintWriter();
    private BufferedReader bufferedReader = Connection.getBufferedReader();

    public void initialize() throws IOException {
        // i'am...
        myself = HeroFabric.createAHero(bufferedReader.readLine());
        playerNameLabel.setText(myself.getHeroName());
        playerIV.setImage(myself.getBackWait());
        refreshHp();
        if (myself.getHeroName().equalsIgnoreCase("fox"))
            healBtn.setOnMouseClicked(null);

        // you are...
        enemy = HeroFabric.createAHero(bufferedReader.readLine());
        opponentNameLabel.setText(enemy.getHeroName());
        opponentIV.setImage(enemy.getFrontWait());
        refreshEnemyHp();

        Thread handling = new Thread(() -> {
            while (true) {
                try {
                    String command = bufferedReader.readLine();
                    if (command.equals("WAI"))
                        status = Status.WAITING;
                    else if (command.equals("TUR"))
                        status = Status.TURN;
                    else if (command.equals("WIN")) {
                        Platform.runLater(() ->
                                Loader.goTo(WIN_FXML, root));
                        break;
                    } else if (command.equals("LOS")) {
                        Platform.runLater(() ->
                                Loader.goTo(LOS_FXML, root));
                        break;
                    } else {
                        String[] commands = command.split("&");
                        switch (commands[0]) {
                            case "ATT": {
                                console.setText(console.getText() + "\n" + enemy.getHeroName() +
                                        " has attacked you and inflicted " + Integer.parseInt(commands[1])
                                        + " damage points.");
                                myself.setHp(myself.getHp() - Integer.parseInt(commands[1]));
                                Platform.runLater(() -> refreshHp());
                                if (myself.getHp() <= 0)
                                    printWriter.println("LOS");
                                break;
                            }
                            case "HEA": {
                                enemy.setHp(Integer.parseInt(commands[1]));
                                Platform.runLater(() -> {
                                    refreshEnemyHp();
                                    console.setText(console.getText() + "\n" + enemy.getHeroName() +
                                            " healed himself, so now he has " + enemy.getHp() + " health points.");
                                });
                                break;
                            }
                            case "FLI": {
                                String flirtCom = "\n" + enemy.getHeroName() + "has very pretty eyes, ";
                                flirtCom += (commands[1].equals("true") ? "and you don't want to hit him." :
                                        "but you know his plan, so... LOL!");
                                myself.setFlirted(Boolean.parseBoolean(commands[1]));
                                String finalFlirtCom = flirtCom;
                                Platform.runLater(() -> console.setText(console.getText() + finalFlirtCom));
                            }
                        }
                    }
                } catch (SocketException s){
                    s.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        handling.start();

    }

    private void setTextOnAction(String action, int points) {
        switch (action) {
            case "ATT": {
                console.setText(console.getText() + "\nYou attacked " + enemy.getHeroName() +
                        " and inflicted " + points + " damage points.");
                break;
            }
            case "HEA": {
                console.setText(console.getText() + "\nYou healed yourself, so now you have " +
                        myself.getHp() + " health points.");
                break;
            }
            case "FLI": {
                String flirtText = "\nYou have very pretty eyes, ";
                flirtText += (points == 0 ? "and " + enemy.getHeroName() + " doesn't want to hit you." :
                        "but " + enemy.getHeroName() + "still wants to hit you. LOL");
                console.setText(console.getText() + flirtText);
//                        "and " + enemy.getHeroName() + " doesn't want to hit you."));
                break;
            }
            case "LEA": {
                console.setText(console.getText() + "\nYou leaved this battle. What a pity.");
            }
        }
    }

    public void btnHandler(MouseEvent mouseEvent) {
        if (status == Status.TURN) {
            myself.reduceNowCoolDown();
            if (mouseEvent.getSource().equals(attackBtn))
                attack();
            else if (mouseEvent.getSource().equals(healBtn))
                heal();
            else if (mouseEvent.getSource().equals(flirtBtn))
                flirt();
            else if (mouseEvent.getSource().equals(leaveBtn))
                leave();
        }
    }

    public void attack() {
        int attackPower = (int) (myself.getAttackPower() * (myself.isFlirted() ? 0.5 : 1));
        myself.setImageView(new ImageView(myself.getBackAttack()));
        new AnimationTimer() {
            long was = 0;

            @Override
            public void handle(long now) {
                if (now - was > 10000)
                    myself.setImageView(new ImageView(myself.getBackWait()));
            }

        }.start();
        enemy.setHp(enemy.getHp() - attackPower);
        myself.setFlirted(false);
        Platform.runLater(()->setTextOnAction("ATT", (int) attackPower));
        printWriter.println("ATT&" + attackPower);
        refreshEnemyHp();
        status = Status.WAITING;
    }

    public void heal() {
        if (myself.getNowCoolDown() == 0 && myself.getHp() != myself.getAllHp()) {
            myself.heal();
            setTextOnAction("HEA", myself.getHp());
            printWriter.println("HEA&" + myself.getHp());
            refreshHp();
            status = Status.WAITING;
        }
    }

    public void flirt() {
        boolean flag = myself.flirt();
        setTextOnAction("FLI", flag ? 0 : 1);
        printWriter.println("FLI&" + flag);
    }

    public void leave() {
        setTextOnAction("LEA", 0);
        printWriter.println("LEA");
    }

    private void refreshHp() {
        playerHp.setText("hp: " + (myself.getHp() > 0 ? myself.getHp() : 0) + "/" + myself.getAllHp());
        playerHPBar.setProgress(countProgress(myself));
    }

    private void refreshEnemyHp() {
        opponentHp.setText("hp: " + (enemy.getHp() > 0 ? enemy.getHp() : 0) + "/" + enemy.getAllHp());
        opponentHPBar.setProgress(countProgress(enemy));
    }

    private double countProgress(Hero hero) {
        double progress = 0;
        try {
            progress = (double) hero.getHp() / (double) hero.getAllHp();
            System.out.println("progress: " + progress);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (progress);
    }

}
