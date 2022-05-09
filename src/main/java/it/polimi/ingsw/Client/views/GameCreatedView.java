package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.messages.AnsGameCreatedMsg;
import it.polimi.ingsw.messages.BooleanCheckMsg;
import it.polimi.ingsw.messages.NewGameMsg;

import java.util.Scanner;

public class GameCreatedView extends View{
    /** The view of the gamecreated */

    private BooleanCheckMsg answerMsg;


    public GameCreatedView(BooleanCheckMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }


    @Override
    public void run() {

        System.out.println("Game created");


    }
}
