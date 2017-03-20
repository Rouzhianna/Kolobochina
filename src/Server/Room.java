package Server;

import java.io.*;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by N33na on 11.03.2017.
 */
public class Room implements Runnable{

    private Thread thread;
    private List<Hero> heroes;
    private int nowAct = 0;
    private boolean flag = true;

    private List<PrintWriter> printWriters;
    private List<BufferedReader> bufferedReaders;

    @Override
    public void run() {
        // let them know, who they are
        printWriters.get(0).println(heroes.get(0).getName());
        printWriters.get(1).println(heroes.get(1).getName());

        // let them know, who they fight with
        printWriters.get(0).println(heroes.get(1).getName());
        printWriters.get(1).println(heroes.get(0).getName());

        while (flag){
            // TODO: 17.03.2017 hp check
            try {
                printWriters.get(nowAct).println("TUR");
                printWriters.get(getOtherIndex(nowAct)).println("WAI");
                String command = bufferedReaders.get(nowAct).readLine();
                handleCommand(nowAct, command);
                nowAct = getOtherIndex(nowAct);
            }catch (SocketException e){
                System.out.println("I've lost connection with " + nowAct + "!");
                break;
                //doNothing
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        endGame();
        System.out.println("End of the game");
    }

    public Room(Hero player1, Hero player2) throws IOException {
        heroes = new ArrayList<>();
        bufferedReaders = new ArrayList<>();
        printWriters = new ArrayList<>();

        heroes.add(player1);
        bufferedReaders.add(new BufferedReader(new InputStreamReader(player1.getSocket().getInputStream())));
        printWriters.add(new PrintWriter(player1.getSocket().getOutputStream(), true));

        heroes.add(player2);
        bufferedReaders.add(new BufferedReader(new InputStreamReader(player2.getSocket().getInputStream())));
        printWriters.add(new PrintWriter(player2.getSocket().getOutputStream(), true));

        this.thread = new Thread(this);
        this.thread.start();
    }

    private int getOtherIndex(int i){
        return (i + 1) % 2;
    }

    private void handleCommand(int i, String s){
        if(s.equals("LOS") || s.equals("LEA")) {
            System.out.println(s);
            printWriters.get(getOtherIndex(i)).println("WIN");
            printWriters.get(i).println("LOS");
            flag = false;
        }else {
            printWriters.get(getOtherIndex(i)).println(s);
        }
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
