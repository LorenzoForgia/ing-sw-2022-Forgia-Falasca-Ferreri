package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Exception.ColorNoInEntranceException;
import it.polimi.ingsw.Exception.IslandNotInListException;
import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class MoveStudent2Msg extends CommandMsg{
    private Color s;
    private int l;
    public MoveStudent2Msg(Color s, int l){
        this.s=s;
        this.l=l;
    }
    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException
    {
        GameController game = clientHandler.getGame();
        synchronized (game) {
            if (l == 12) {
                try {
                    game.CheckColor(s, game.getChoosenPlayer().GetPlayerTurn());
                    game.PutStudentInLocation(s, game.getChoosenPlayer().GetPlayerTurn().getMySchoolBoard().getDiningRoom(), game.getChoosenPlayer().GetPlayerTurn());
                    game.DiningRoomChosen(game.getChoosenPlayer().GetPlayerTurn(), s);
                    AnsMoveStudent2Msg ansMoveStudent2Msg= new AnsMoveStudent2Msg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName(), game.getGameModel().getGeneralBoard(), game.getGameModel().getPlayers(), game.getGameModel().getModExpert());
                    clientHandler.sendAnswerMessage(ansMoveStudent2Msg);
                } catch (ColorNoInEntranceException e) {
                    AnsColorExc2Msg ansColorExcMsg= new AnsColorExc2Msg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName());
                    clientHandler.sendAnswerMessage(ansColorExcMsg);
                }

            }else{
                try {
                    game.CheckColor(s, game.getChoosenPlayer().GetPlayerTurn());
                    try{
                        game.IslandChosen(game.getChoosenPlayer().GetPlayerTurn(), l, s);
                        AnsMoveStudent2Msg ansMoveStudent2Msg= new AnsMoveStudent2Msg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName(), game.getGameModel().getGeneralBoard(), game.getGameModel().getPlayers(), game.getGameModel().getModExpert());
                        clientHandler.sendAnswerMessage(ansMoveStudent2Msg);
                    }catch (IslandNotInListException e){
                        AnsIslandExc2Msg ansIslandExc2Msg= new AnsIslandExc2Msg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName());
                        clientHandler.sendAnswerMessage(ansIslandExc2Msg);
                    }
                } catch (ColorNoInEntranceException e) {
                    AnsColorExc2Msg ansColorExcMsg= new AnsColorExc2Msg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName());
                    clientHandler.sendAnswerMessage(ansColorExcMsg);
                }

            }

        }
    }
}
