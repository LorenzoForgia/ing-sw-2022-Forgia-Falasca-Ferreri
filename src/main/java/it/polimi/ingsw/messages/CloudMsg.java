package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class CloudMsg extends CommandMsg{
    private int cloud;

    public CloudMsg(int cloud) {
        this.cloud=cloud;
    }

    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException
    {
        GameController game = clientHandler.getGame();
        synchronized (game) {

        }
    }
}
