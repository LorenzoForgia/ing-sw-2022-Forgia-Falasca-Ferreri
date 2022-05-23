package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;
import java.util.ArrayList;

public class CC7Msg extends CommandMsg{
    private ArrayList<Color> students=null;

    public CC7Msg(ArrayList<Color> students){
        this.students=students;
    }

    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException {
        GameController game = clientHandler.getGame();
        synchronized (game) {

        }
    }
}
