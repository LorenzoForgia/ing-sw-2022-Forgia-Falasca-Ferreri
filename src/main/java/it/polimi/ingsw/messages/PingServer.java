package it.polimi.ingsw.messages;

import it.polimi.ingsw.Server.ClientHandler;

import java.io.*;

import static java.lang.Thread.sleep;

public class PingServer implements Runnable{
    public PingServer(ClientHandler clientHandler) {
        this.clientHandler = clientHandler;
    }

    private ClientHandler clientHandler;


    @Override
    public void run() {
        try {
            handleClientDisconnection();
        } catch (IOException e) {
            System.out.println("IOexception partita finita" + this.clientHandler.getClient().getInetAddress() + " connection dropped");
            System.exit(130);
        }

    }
    private void handleClientDisconnection() throws IOException
    {
        try {
            while (true) {
                sleep(7500);
                this.sendPing();
            }
        }catch(ClassCastException e){
            System.out.println("invalid stream from client:ClassCastException");
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception");
        }

    }

   private void sendPing()throws IOException{
        synchronized (this.clientHandler) {
            PingSMSG ping = new PingSMSG(new PingCMSG());
            this.clientHandler.getOutput().writeObject(ping);
            this.clientHandler.getOutput().flush();
            this.clientHandler.getOutput().reset();
        }

   }
}
