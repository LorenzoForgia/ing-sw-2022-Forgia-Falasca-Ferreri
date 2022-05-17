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
                game.CheckNumberOfStepsMN(step, game.getChoosenPlayer().GetPlayerTurn(), game.getChoosenPlayer().GetPlayerTurn().getCA());
            }catch (IllegalNumberOfStepException e){
                AnsNumStepExcMsg ansNumStepExcMsg= new AnsNumStepExcMsg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName());
                clientHandler.sendAnswerMessage(ansNumStepExcMsg);
            }
            answerMsg= new AnsNumStepMNMsg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName());
            clientHandler.sendAnswerMessage(answerMsg);
        }
    }
}
