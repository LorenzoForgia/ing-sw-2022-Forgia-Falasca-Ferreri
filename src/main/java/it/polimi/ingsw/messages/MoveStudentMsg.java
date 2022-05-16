package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Exception.ColorNoInEntranceException;
import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class MoveStudentMsg extends CommandMsg{
    private Color s;
    private int l;
    public MoveStudentMsg(Color s, int l){
        this.s=s;
        this.l=l;
    }
    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException
    {
        GameController game = clientHandler.getGame();
        Player p= null;
        try{
            while(!clientHandler.getNickname().equals(game.getChoosenPlayer().GetPlayerTurn().getNickName())) {
                game.wait();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(l==12){
            try{
                game.CheckColor(s, game.getChoosenPlayer().GetPlayerTurn());
            }catch (ColorNoInEntranceException e){
                /*anscolorexc*/
            }

        }


    }
}
