package it.polimi.ingsw.messages;
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

  }
  @Override
  public void processMessage(ClientHandler clientHandler) throws IOException
  {
    clientHandler.getGame().newGame(this.numPlayers,this.modExpert);
  }
}
