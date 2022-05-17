package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Exception.ColorNoInEntranceException;
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
                } catch (ColorNoInEntranceException e) {
                    AnsColorExc2Msg ansColorExcMsg= new AnsColorExc2Msg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName());
                    clientHandler.sendAnswerMessage(ansColorExcMsg);
                }
                game.PutStudentInLocation(s, game.getChoosenPlayer().GetPlayerTurn().getMySchoolBoard().getDiningRoom(), game.getChoosenPlayer().GetPlayerTurn());
                game.DiningRoomChosen(game.getChoosenPlayer().GetPlayerTurn(), s);
            }else{
                try {
                    game.CheckColor(s, game.getChoosenPlayer().GetPlayerTurn());
                } catch (ColorNoInEntranceException e) {
                    AnsColorExc2Msg ansColorExcMsg= new AnsColorExc2Msg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName());
                    clientHandler.sendAnswerMessage(ansColorExcMsg);
                }
                for(int i=0; i< game.getGameModel().getGeneralBoard().GetIslands().size();i++){
                    if(l==game.getGameModel().getGeneralBoard().GetIslands().get(i).getNumberID()){
                        game.PutStudentInLocation(s, game.getGameModel().getGeneralBoard().GetIslands().get(i),game.getChoosenPlayer().GetPlayerTurn());
                    }
                }
            }
            AnsMoveStudent2Msg ansMoveStudent2Msg= new AnsMoveStudent2Msg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName(), game.getGameModel().getGeneralBoard(), game.getGameModel().getPlayers());
            clientHandler.sendAnswerMessage(ansMoveStudent2Msg);
        }
    }
}
