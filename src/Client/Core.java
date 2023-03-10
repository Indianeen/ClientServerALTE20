package Client;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.ClientInfoStatus;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Core {

    Model model = new Model();
    View view = new View();

    Socket socket;
    PrintWriter out;
    BufferedReader in;

    public Core(String ip, int port) {
        try {
            socket = new Socket(ip,port);
        } catch (IOException e) {
            System.err.println("Failed to connect to server");
            e.printStackTrace();
        }
        System.out.println("Connection ready...");
    }
    private void getStreams() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Stream ready...");
    }

    private void runProtocol() {
        Scanner tgb = new Scanner(System.in);
        System.out.println("chatting...");
        String msg = "";
        while (!msg.equals("QUIT")) {
            msg = tgb.nextLine();
            out.println("CLIENT: " + msg);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Client me = new Client("10.70.45.159", 1234);
        me.getStreams();
        ListenerThread 1 = new ListenerThread(me.in, System.out);
        Thread listener = new Thread(1);
        listener.start();
        me.runProtocol();
        listener.join();
        me.shutDown();
    }

    private void shutDown() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    JFrame frame = new
            setContentPane

}
