package it.polimi.ingsw.Client;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

import it.polimi.ingsw.Client.views.GUI.ConnectionScene;
import it.polimi.ingsw.Client.views.GUI.JavaFXMain;
import it.polimi.ingsw.messages.*;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * A class that represents the server inside the client.
 */

public class ServerHandler implements Runnable
{

    private boolean GUI=true;
    private Socket server;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private Client owner;
    private AtomicBoolean shouldStop = new AtomicBoolean(false);
    private Runnable connectionClosedObserver;


    /**
     * Initializes a new handler using a specific socket connected to
     * a server.
     * @param server The socket connection to the server.
     */

    public ServerHandler(Socket server, Client owner)
    {
        this.server = server;
        this.owner = owner;
    }


    /**
     * Connects to the server and runs the event loop.
     */

    @Override
    public void run()
    {
        try {
            output = new ObjectOutputStream(server.getOutputStream());
            input = new ObjectInputStream(server.getInputStream());
        } catch (IOException e) {
            System.out.println("could not open connection to " + server.getInetAddress());
            owner.terminate();
            return;
        }

        try {
            PingClient pingClient=new PingClient(this);
            Thread t1 =new Thread(pingClient);
            t1.start();
            handleClientConnection();
        }catch(SocketTimeoutException e){
            System.out.println("Server offline" + server.getInetAddress() + " connection dropped,partita finita");
            if(GUI){
                Platform.runLater(()->{
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Partita finita,per una disconnesione", ButtonType.OK);
                    alert.showAndWait();

                });
            }
        }catch (IOException e) {
            System.out.println("server " + server.getInetAddress() + " connection dropped,partita finita");
            if(GUI){
                Platform.runLater(()->{
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Partita finita,per una disconnesione", ButtonType.OK);
                    alert.showAndWait();

                });
            }
        }

        try {
            server.close();
        } catch (IOException e) { }
        if(!GUI) {
            owner.terminate();
        }
    }


    /**
     * An event loop that receives messages from the server and processes
     * them in the order they are received.
     * @throws IOException If a communication error occurs.
     */

    private void handleClientConnection() throws IOException
    {
        try {
            boolean stop = false;
            while (!stop) {
                /* read commands from the server and process them */

                try {
                    server.setSoTimeout(15000);
                    Object next = input.readObject();
                    AnswerMsg command = (AnswerMsg)next;
                    command.processMessage(this);
                } catch (IOException e) {
                    /* Check if we were interrupted because another thread has asked us to stop */

                    if (shouldStop.get()) {
                        /* Yes, exit the loop gracefully */

                        stop = true;
                    } else {
                        /* No, rethrow the exception */

                        throw e;
                    }
                }
            }
        } catch (ClassNotFoundException | ClassCastException e) {
            System.out.println("invalid stream from server");
        }
    }


    /**
     * The game instance associated with this client.
     * @return The game instance.
     */

    public Client getClient()
    {
        return owner;
    }


    /**
     * Sends a message to the server.
     * @param commandMsg The message to be sent.
     */

    public void sendCommandMessage(CommandMsg commandMsg)
    {
        try {
            output.writeObject(commandMsg);
            output.reset();
        } catch (IOException e) {
            System.out.println("Communication error");
            owner.terminate();
        }
    }


    /**
     * Requires the run() method to stop as soon as possible.
     */

    public void stop()
    {
        shouldStop.set(true);
        try {
            server.shutdownInput();
        } catch (IOException e) { }
    }
    public ObjectInputStream getInput() {
        return input;
    }
    public ObjectOutputStream getOutput() {
        return output;
    }
    public Socket getServer() {
        return server;
    }

    /** cambiamento per chiusura finestre**/
    synchronized public boolean isConnected()
    {
        return ConnectionScene.serverHandlerThread != null;
    }



}
