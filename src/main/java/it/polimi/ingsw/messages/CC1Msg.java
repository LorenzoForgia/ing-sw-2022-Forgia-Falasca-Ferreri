package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class CC1Msg extends CommandMsg{
    private int isl;
    private Color stud;

    public CC1Msg(int isl, Color stud){
        this.isl= isl;
        this.stud=stud;
    }

    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException {
        GameController game = clientHandler.getGame();
        synchronized (game) {

        }
    }
}
