package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Exception.IllegalNumberOfStepException;
import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class NumStepMNMsg extends CommandMsg{
    private int step;
    public NumStepMNMsg(int step){
        this.step =step;
    }
    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException
    {
        AnsNumStepMNMsg answerMsg;
        GameController game = clientHandler.getGame();

        synchronized (game){
            try {
                game.CheckNumberOfStepsMN(step, game.getChoosenPlayer().GetPlayerTurn());
                if(game.getGameEndState().isFlagImmediately()){
                    game.resetcountmodexpview();
                    game.notifyAll();
                    AnsEndGameMsg ansEndGameMsg= new AnsEndGameMsg(this, game.showWinner());
                    clientHandler.sendAnswerMessage(ansEndGameMsg);
                }else{
                    game.resetcountmodexpview();
                    answerMsg= new AnsNumStepMNMsg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName(),game.getGameModel().getGeneralBoard().getClouds());
                    clientHandler.sendAnswerMessage(answerMsg);
                }
            }catch (IllegalNumberOfStepException e){
                AnsNumStepExcMsg ansNumStepExcMsg= new AnsNumStepExcMsg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName(), game.getGameModel().getPlayers());
                clientHandler.sendAnswerMessage(ansNumStepExcMsg);
            }
        }
    }
}
