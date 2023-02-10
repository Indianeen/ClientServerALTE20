package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Core {
    ServerSocket server;
    Socket client;

    PrintWriter out;
    BufferedReader in;

    public Server(int port) {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Failed to open serversocket.");
            e.printStackTrace();
        }
        System.out.println("Server started...");
    }

    private void acceptClient() {
        try {
            client = server.accept();
        } catch (IOException e) {
            System.err.println("Failed to connect to client");
            e.printStackTrace();
        }
        System.out.println("client connected...");
    }

    private void getStreams() {
        try {
            out = new PrintWriter(client.getOutputStream(), true);
            in =  new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Streams ready ...");
    }

    private void runProtocol() {

    }
}
