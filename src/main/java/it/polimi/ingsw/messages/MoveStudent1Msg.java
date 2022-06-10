package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Exception.ColorNoInEntranceException;
import it.polimi.ingsw.Exception.IslandNotInListException;
import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class MoveStudent1Msg extends CommandMsg{
    private Color s;
    private int l;
    public MoveStudent1Msg(Color s, int l){
        this.s=s;
        this.l=l;
    }
    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException
    {
        GameController game = clientHandler.getGame();
        synchronized (game) {
            /*try {
                while (!clientHandler.getNickname().equals(game.getChoosenPlayer().GetPlayerTurn().getNickName())) {
                    game.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

            if (l == 12) {
                try {
                    game.CheckColor(s, game.getChoosenPlayer().GetPlayerTurn());
                    game.PutStudentInLocation(s, game.getChoosenPlayer().GetPlayerTurn().getMySchoolBoard().getDiningRoom(), game.getChoosenPlayer().GetPlayerTurn());
                    game.DiningRoomChosen(game.getChoosenPlayer().GetPlayerTurn(), s);
                    game.incrementview();
                    AnsMoveStudent1Msg ansMoveStudent1Msg= new AnsMoveStudent1Msg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName(), game.getGameModel().getGeneralBoard(), game.getGameModel().getPlayers(), game.getGameModel().getGeneralBoard().getChoosenCard(), game.getGameModel().getModExpert());
                    clientHandler.sendAnswerMessage(ansMoveStudent1Msg);
                } catch (ColorNoInEntranceException e) {
                    AnsColorExc1Msg ansColorExcMsg= new AnsColorExc1Msg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName());
                    clientHandler.sendAnswerMessage(ansColorExcMsg);
                }

            }else{
                try {
                    game.CheckColor(s, game.getChoosenPlayer().GetPlayerTurn());
                    try{
                        game.IslandChosen(game.getChoosenPlayer().GetPlayerTurn(), l, s);
                        game.incrementview();
                        AnsMoveStudent1Msg ansMoveStudent1Msg= new AnsMoveStudent1Msg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName(), game.getGameModel().getGeneralBoard(), game.getGameModel().getPlayers(), game.getGameModel().getGeneralBoard().getChoosenCard(), game.getGameModel().getModExpert());
                        clientHandler.sendAnswerMessage(ansMoveStudent1Msg);
                    }catch (IslandNotInListException e){
                        AnsIslandExc1Msg ansIslandExcMsg= new AnsIslandExc1Msg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName());
                        clientHandler.sendAnswerMessage(ansIslandExcMsg);
                    }
                } catch (ColorNoInEntranceException e) {
                    AnsColorExc1Msg ansColorExcMsg= new AnsColorExc1Msg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName());
                    clientHandler.sendAnswerMessage(ansColorExcMsg);
                }
            }

        }
    }
}
