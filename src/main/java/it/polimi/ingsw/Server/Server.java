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




public class Server
{
    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Specificare numero di porta del server: ");
        int socketPort = 4567;
        try{
            socketPort=Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException e){
            System.out.println("numero di porta non valido!,inserito automaticamente numero di porta 4567");
        }


        ServerSocket socket;
        GameController gamecontroller=new GameController();
        try {
            if(socketPort<=1024 || socketPort>65535){
                System.out.println("numero di porta non valido!,inserito automaticamente numero di porta 4567");
                socketPort=4567;
            }
            socket = new ServerSocket(socketPort);
            System.out.println("Server In Ascolto Sulla Porta "+socketPort+"...");
        } catch (IOException e) {
            System.out.println("Non è stato possibile aprire il socket del Server,riavviare l'applicazione");
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