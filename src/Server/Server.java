package Server;

import entities.Fabrics.HeroFabric;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by N33na on 11.03.2017.
 */

/**
 *  ждет клиентов, отпр-ет активного игрока, ,
 */

public class Server {

    private final int PORT = 6543;

    private void go(){
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true){
                Socket p1 = serverSocket.accept();
                System.out.println("1st connected");
                BufferedReader p1BR = new BufferedReader(new InputStreamReader(p1.getInputStream()));
                PrintWriter p1PW = new PrintWriter(p1.getOutputStream(), true);
                String s = p1BR.readLine();
                System.out.println("cl1: " + s);
                Hero h1 = createHero(s, p1);
                System.out.println("hero 1 created");

                Socket p2 = serverSocket.accept();
                System.out.println("2nd connected");
                BufferedReader p2BR = new BufferedReader(new InputStreamReader(p1.getInputStream()));
                PrintWriter p2PW = new PrintWriter(p1.getOutputStream(), true);
                s = p1BR.readLine();
                System.out.println("cl2: " + s);
                Hero h2 = createHero(s, p2);
                System.out.println("hero 2 created");

                System.out.println("Room is creating..");
                new Room(h1, h2);
                System.out.println("Room is created");

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Hero createHero(String name, Socket socket) throws IOException {
        Hero hero = new Hero(socket);
        hero.setName(name);
        return hero;
    }

    public static void main(String[] args) { new Server().go(); }

}
