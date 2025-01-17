package it.polimi.ingsw.messages;

import java.io.Serializable;
import java.util.*;


/**
 * A generic message sent over a network link.
 */

public abstract class NetworkMessage implements Serializable
{
  UUID identifier = UUID.randomUUID();


  /**
   * Unique identifier for the message.
   * Allows matching a message with its response.
   * @return The identifier
   */

  public UUID getIdentifier()
  {
    return identifier;
  }
}
