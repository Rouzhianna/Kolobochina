package Server;

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


            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) { new Server().go(); }

}
