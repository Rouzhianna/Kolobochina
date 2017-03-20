package Client.Helpers;

import java.io.*;
import java.net.Socket;

/**
 * Created by N33na on 11.03.2017.
 */
public class Connection {

    private static final int PORT = 6543;
    private static String HOST;

    private static Socket server;
    private static PrintWriter printWriter;
    private static BufferedReader bufferedReader;

    public static void setHost(String host){ HOST = host;}

    public static void init(){
        try {
            server = new Socket(HOST, PORT);
            printWriter = new PrintWriter(server.getOutputStream(), true);
            bufferedReader = new BufferedReader(new InputStreamReader(server.getInputStream()));
            System.out.println("Connection set");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static PrintWriter getPrintWriter() { return printWriter; }
    public static BufferedReader getBufferedReader() { return bufferedReader; }
}
