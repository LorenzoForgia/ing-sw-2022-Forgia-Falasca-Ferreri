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

    game.newGame(this.numPlayers, this.modExpert);
    answerMsg = new BooleanCheckMsg(this,BooleanCheckMsg.Status.OK);


    clientHandler.sendAnswerMessage(answerMsg);

  }
}
