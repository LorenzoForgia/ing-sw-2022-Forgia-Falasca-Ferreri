package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Exception.ColorNoInEntranceException;
import it.polimi.ingsw.Exception.IslandNotInListException;
import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class MoveStudent3Msg extends CommandMsg{
    private Color s;
    private int l;
    public MoveStudent3Msg(Color s, int l){
        this.s=s;
        this.l=l;
    }
    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException {
        GameController game = clientHandler.getGame();
        synchronized (game) {

            if (l == 12) {
                try {
                    game.CheckColor(s, game.getChoosenPlayer().GetPlayerTurn());
                    game.PutStudentInLocation(s, game.getChoosenPlayer().GetPlayerTurn().getMySchoolBoard().getDiningRoom(), game.getChoosenPlayer().GetPlayerTurn());
                    game.DiningRoomChosen(game.getChoosenPlayer().GetPlayerTurn(), s);
                    game.incrementview();
                    AnsMoveStudent3Msg ansMoveStudent3Msg = new AnsMoveStudent3Msg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName(), game.getGameModel().getGeneralBoard(), game.getGameModel().getPlayers(), game.getGameModel().getGeneralBoard().getChoosenCard(), game.getGameModel().getModExpert());
                    clientHandler.sendAnswerMessage(ansMoveStudent3Msg);
                } catch (ColorNoInEntranceException e) {
                    game.decrementview();
                    AnsColorExc3Msg ansColorExcMsg = new AnsColorExc3Msg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName());
                    clientHandler.sendAnswerMessage(ansColorExcMsg);
                }

            } else {
                try {
                    game.CheckColor(s, game.getChoosenPlayer().GetPlayerTurn());
                    try{
                        game.IslandChosen(game.getChoosenPlayer().GetPlayerTurn(), l, s);
                        game.incrementview();
                        AnsMoveStudent3Msg ansMoveStudent3Msg = new AnsMoveStudent3Msg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName(), game.getGameModel().getGeneralBoard(), game.getGameModel().getPlayers(), game.getGameModel().getGeneralBoard().getChoosenCard(), game.getGameModel().getModExpert());
                        clientHandler.sendAnswerMessage(ansMoveStudent3Msg);
                    }catch (IslandNotInListException e){
                        game.decrementview();
                        AnsIslandExc3Msg ansIslandExc3Msg= new AnsIslandExc3Msg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName());
                        clientHandler.sendAnswerMessage(ansIslandExc3Msg);
                    }
                } catch (ColorNoInEntranceException e) {
                    game.decrementview();
                    AnsColorExc3Msg ansColorExcMsg = new AnsColorExc3Msg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName());
                    clientHandler.sendAnswerMessage(ansColorExcMsg);
                }

            }

        }
    }
}
