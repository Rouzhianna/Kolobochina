package Server;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by N33na on 11.03.2017.
 */
public class Room implements Runnable{

    private Thread thread;
    private List<Hero> heroes;

    private PrintWriter p1PW;
    private BufferedReader p1BR;
    private PrintWriter p2PW;
    private BufferedReader p2BR;

    @Override
    public void run() {
        // let them know, who they are
        p1PW.println(heroes.get(0).getName());
        p2PW.println(heroes.get(1).getName());

        // let them know, who they fight with
        p1PW.println(heroes.get(1).getName());
        p2PW.println(heroes.get(0).getName());

        while (true){
            // TODO: 17.03.2017 hp check
            try {
                p1PW.println("TUR");
                String command = p1BR.readLine();
                handleCommand(heroes.get(0), heroes.get(1),command);
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        }

        endGame();
        System.out.println("End of the game");
    }

    public Room(Hero player1, Hero player2) throws IOException {
        heroes = new ArrayList<>();
        heroes.add(player1);
        p1BR = new BufferedReader(new InputStreamReader(heroes.get(0).getSocket().getInputStream()));
        p1PW = new PrintWriter(heroes.get(0).getSocket().getOutputStream(), true);
        heroes.add(player2);
        p2BR = new BufferedReader(new InputStreamReader(heroes.get(1).getSocket().getInputStream()));
        p2PW = new PrintWriter(heroes.get(1).getSocket().getOutputStream(), true);

        this.thread = new Thread(this);
        this.thread.start();
    }

    private void handleCommand(Hero me, Hero enemy, String s){
        if(s.equals("LOS"));

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
            for(Hero hero: heroes){
                hero.getSocket().close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
