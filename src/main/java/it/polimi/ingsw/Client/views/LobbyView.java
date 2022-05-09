package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.messages.AnsGameCreatedMsg;
import it.polimi.ingsw.messages.AnswIfAllowed;
import it.polimi.ingsw.messages.AskIfGameCreated;
import it.polimi.ingsw.messages.Login;

import java.util.Scanner;

public class LobbyView extends View{
    /** The answer message containing the data from the server */

    private AnsGameCreatedMsg answerMsg;


    /**
     * Initialize with an answer from the server.
     * @param answerMsg The answer message.
     */

    public LobbyView(AnsGameCreatedMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }


    @Override
    public void run()
    {

        System.out.println("LOBBY");

    }
}
