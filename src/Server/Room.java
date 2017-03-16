package Server;

import java.io.*;

/**
 * Created by N33na on 11.03.2017.
 */
public class Room implements Runnable{

    private Thread thread;
    private Hero hero1;
    private Hero hero2;

    private PrintWriter p1PW;
    private BufferedReader p1BR;
    private PrintWriter p2PW;
    private BufferedReader p2BR;

    @Override
    public void run() {
        // let them know, who they are
        p1PW.println(hero1.getName());
        p2PW.println(hero2.getName());

        // let them know, who they are fighting with
        p1PW.println(hero2.getName());
        p2PW.println(hero1.getName());

        boolean gameIsRunning = true;
        while (gameIsRunning){
            if(!hpCheck())
                gameIsRunning = false;
        }

        endGame();
        System.out.println("End of the game");
    }

    public Room(Hero player1, Hero player2) throws IOException {
        this.hero1 = player1;
        p1BR = new BufferedReader(new InputStreamReader(hero1.getSocket().getInputStream()));
        p1PW = new PrintWriter(hero1.getSocket().getOutputStream(), true);
        this.hero2 = player2;
        p2BR = new BufferedReader(new InputStreamReader(hero2.getSocket().getInputStream()));
        p2PW = new PrintWriter(hero2.getSocket().getOutputStream(), true);

        this.thread = new Thread(this);
        this.thread.start();
    }

    private boolean hpCheck (){

        return false;
    }



    private boolean turn(Hero activeHero, Hero waitHero){
        try {
        //    System.out.println(heroes.indexOf(activeHero) + 1);
            while (activeHero.getInputStream().read()!= 0){

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void endGame(){
        try {
            hero1.getSocket().close();
            hero2.getSocket().close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
