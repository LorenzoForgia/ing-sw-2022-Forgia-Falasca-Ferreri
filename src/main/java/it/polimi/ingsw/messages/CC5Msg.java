package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class CC5Msg extends CommandMsg{
    private int isl;

    public CC5Msg(int isl){
        this.isl= isl;
    }

    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException {
        GameController game = clientHandler.getGame();
        synchronized (game) {

        }
    }
}
