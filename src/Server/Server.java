package Server;

import java.io.BufferedReader;
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
                Hero h1 = new Hero(p1);

                Socket p2 = serverSocket.accept();
                System.out.println("2nd connected");
                Hero h2 = new Hero(p2);

                BufferedReader p1BR = new BufferedReader(new InputStreamReader(p1.getInputStream()));
                PrintWriter p1PW = new PrintWriter(p1.getOutputStream(), true);
                /*
                String message = p1BR.readLine();
                p1PW.println(message);
                */

                System.out.println("Room is creating..");
                new Room(h1, h2);
                System.out.println("Room is created");

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) { new Server().go(); }

}
