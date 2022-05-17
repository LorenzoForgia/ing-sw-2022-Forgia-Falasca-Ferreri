package it.polimi.ingsw.Server;

import it.polimi.ingsw.Controller.GameController;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


/**
 * Server for the Mastermind game.
 */

public class Server
{
    public static void main(String[] args)
    {
        /* Read the port number from System.in. In your project you
         * could also use a configuration file for the same purpose.
         *   For simplicity we are not doing any error checking when
         * parsing the port number, but in a real project you need to
         * always handle invalid inputs! */

        /*  A FINE IMPLEMENTAZIONE
        Scanner scanner = new Scanner(System.in);
        System.out.println("Server port?");
        int socketPort = Integer.parseInt(scanner.nextLine());*/

        ServerSocket socket;
        GameController gamecontroller=new GameController();
        try {
            socket = new ServerSocket(4567);
            System.out.println("Server In Ascolto Sulla Porta 4567 ...");
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
                ClientHandler clientHandler = new ClientHandler(client,gamecontroller);
                Thread thread = new Thread(clientHandler, "server_" + client.getInetAddress());
                thread.start();
            } catch (IOException e) {
                System.out.println("connection dropped");
            }
        }
    }
}