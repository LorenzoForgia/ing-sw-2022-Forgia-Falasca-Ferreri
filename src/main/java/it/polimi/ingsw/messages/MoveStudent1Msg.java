package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Exception.ColorNoInEntranceException;
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
                } catch (ColorNoInEntranceException e) {
                    AnsColorExcMsg ansColorExcMsg= new AnsColorExcMsg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName());
                    clientHandler.sendAnswerMessage(ansColorExcMsg);
                }
                game.PutStudentInLocation(s, game.getChoosenPlayer().GetPlayerTurn().getMySchoolBoard().getDiningRoom(), game.getChoosenPlayer().GetPlayerTurn());
                game.DiningRoomChosen(game.getChoosenPlayer().GetPlayerTurn(), s);
            }else{
                try {
                    game.CheckColor(s, game.getChoosenPlayer().GetPlayerTurn());
                } catch (ColorNoInEntranceException e) {
                    AnsColorExcMsg ansColorExcMsg= new AnsColorExcMsg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName());
                    clientHandler.sendAnswerMessage(ansColorExcMsg);
                }
                for(int i=0; i< game.getGameModel().getGeneralBoard().GetIslands().size();i++){
                    if(l==game.getGameModel().getGeneralBoard().GetIslands().get(i).getNumberID()){
                      game.PutStudentInLocation(s, game.getGameModel().getGeneralBoard().GetIslands().get(i),game.getChoosenPlayer().GetPlayerTurn());
                    }
                }
            }
            AnsMoveStudent1Msg ansMoveStudent1Msg= new AnsMoveStudent1Msg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName(), game.getGameModel().getGeneralBoard(), game.getGameModel().getPlayers());
            clientHandler.sendAnswerMessage(ansMoveStudent1Msg);
        }
    }
}
