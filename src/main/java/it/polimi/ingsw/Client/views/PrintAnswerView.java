package it.polimi.ingsw.Client.views;


import it.polimi.ingsw.messages.AnswIfAllowed;
import it.polimi.ingsw.messages.AskIfGameCreated;
import it.polimi.ingsw.messages.Login;

import java.util.Scanner;

/**
 * View that handles displaying the results of the valid nickname
 * returned by the server.
 */

public class PrintAnswerView extends View
{
  /** The answer message containing the data from the server */

  private AnswIfAllowed answerMsg;


  /**
   * Initialize with an answer from the server.
   * @param answerMsg The answer message.
   */

  public PrintAnswerView(AnswIfAllowed answerMsg)
  {
    this.answerMsg = answerMsg;
  }


  @Override
  public void run()
  {
    /*View nextView = new NextNumberView();*/
    Scanner scanner = new Scanner(System.in);

    AnswIfAllowed.Status moveStatus = answerMsg.getMoveStatus();
     if (moveStatus == AnswIfAllowed.Status.INVALID) {
        System.out.println("Nickname già utilizzato! Inserisci un nuovo nickname!");
        String nickname = (scanner.nextLine());
        Login login=new Login(nickname);
        getOwner().getServerHandler().sendCommandMessage(login);
     } else {
         System.out.println("Loggato correttamente!");
      /* answer if a game is already created*/
         getOwner().getServerHandler().sendCommandMessage(new AskIfGameCreated());

        /*getOwner().terminate();
        nextView = null;*/

      }

    /*if (nextView != null)
      getOwner().transitionToView(nextView);*/
  }
}
