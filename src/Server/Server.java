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
                Socket socket1 = serverSocket.accept();
                BufferedReader p1BR = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
                PrintWriter p1PW = new PrintWriter(socket1.getOutputStream(), true);
                String name = p1BR.readLine();
                Hero h1 = createHero(name, socket1);

                Socket socket2 = serverSocket.accept();
                BufferedReader p2BR = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
                PrintWriter p2PW = new PrintWriter(socket2.getOutputStream(), true);
                name = p2BR.readLine();
                Hero h2 = createHero(name, socket2);

                p1PW.println("ready");
                p2PW.println("ready");

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
