package it.polimi.ingsw.messages;
import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Exception.IllegalArgumentException;
import it.polimi.ingsw.Exception.IllegalNumberOfStepException;
import it.polimi.ingsw.Server.*;

import java.io.IOException;


/**
 * A message sent to request a new game to the server.
 **/

public class NewGameMsg extends CommandMsg
{

  private int numPlayers;
  private boolean modExpert;
  public NewGameMsg(int numPlayers,boolean modExpert){
    this.numPlayers=numPlayers;
    this.modExpert=modExpert;

  }
  @Override
  public void processMessage(ClientHandler clientHandler) throws IOException
  {
    BooleanCheckMsg answerMsg;
    GameController game = clientHandler.getGame();

    try {
      game.CheckNumOfPlayer(numPlayers);
      answerMsg = new BooleanCheckMsg(this,BooleanCheckMsg.Status.OK);
      game.newGame(numPlayers,modExpert);
    } catch (IllegalArgumentException e) {
      answerMsg = new BooleanCheckMsg(this,BooleanCheckMsg.Status.KO);
    }

    clientHandler.sendAnswerMessage(answerMsg);

  }
}
