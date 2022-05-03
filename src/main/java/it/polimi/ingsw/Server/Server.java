package it.polimi.ingsw.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Server port?");
        int socketPort;
        try {
            socketPort = Integer.parseInt(scanner.nextLine());
       } catch(NumberFormatException e){
           System.out.println("Invalid number port");
           System.exit(1);
           return;
       }


        /* Open the server socket. */
        ServerSocket socket;
        try {
            socket = new ServerSocket(socketPort);
        } catch (IOException e) {
            System.out.println("cannot open server socket");
            System.exit(1);
            return;
        }

        while (true) {
            try {
                /* accepts connections; for every connection we accept,
                 * create a new Thread executing a ClientHandler */
                Socket client = socket.accept();
                ClientHandler clientHandler = new ClientHandler(client);
                clientHandler.run();
            } catch (IOException e) {
                System.out.println("connection dropped");
            }
        }
    }
}
