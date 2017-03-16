package Server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by N33na on 11.03.2017.
 */
public class Hero {

    private String name;
    private Socket socket;
    private BufferedInputStream bis;
    private BufferedOutputStream bos;

    public void setName(String name){this.name = name;}

    public Hero(Socket socket) throws IOException {
        this.socket = socket;
        this.bis = new BufferedInputStream(socket.getInputStream());
        this.bos = new BufferedOutputStream(socket.getOutputStream());
    }

    public Socket getSocket() { return socket; }

    public BufferedInputStream getInputStream() { return bis; }

    public BufferedOutputStream getOutputStream() { return bos; }
}
