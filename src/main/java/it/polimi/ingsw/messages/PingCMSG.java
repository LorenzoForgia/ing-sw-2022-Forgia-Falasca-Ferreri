package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class PingCMSG extends CommandMsg {
    public PingCMSG() {
    }

    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException {
    }
}

