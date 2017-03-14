package Server;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by N33na on 11.03.2017.
 */
public class Room implements Runnable{

    private Thread thread;
    private List<Hero> heroes;

    @Override
    public void run() {
        boolean gameIsRunning = true;
        while (gameIsRunning){
            if(!hpCheck())
                gameIsRunning = false;
        }

        endGame();
        System.out.println("End of the game");
    }

    public Room(Hero player1, Hero player2) {
        this.heroes = new ArrayList<>();
        heroes.add(player1);
        heroes.add(player2);

        this.thread = new Thread(this);
        this.thread.start();
    }

    private boolean hpCheck (){
        for (Hero hero: heroes){
            // TODO: hp check

        }
        return false;
    }



    private boolean attack(Hero attackHero, Hero waitHero){
        try {
            System.out.println(heroes.indexOf(attackHero) + 1);
            while (attackHero.getInputStream().read()!= 0){

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void endGame(){
        try {
            for (Hero hero : heroes)
                hero.getSocket().close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
