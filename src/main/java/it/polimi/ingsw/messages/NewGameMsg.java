package it.polimi.ingsw.messages;
import it.polimi.ingsw.Server.*;

import java.io.IOException;


/**
 * A message sent to request a new game to the server.
 **/

public class NewGameMsg extends CommandMsg
{
  @Override
  public void processMessage(ClientHandler clientHandler) throws IOException
  {
    clientHandler.getGame().newGame();
  }
}
