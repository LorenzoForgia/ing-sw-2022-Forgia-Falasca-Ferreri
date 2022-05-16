package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.messages.AnsMoveStudent2Msg;
import it.polimi.ingsw.messages.AnsMoveStudent3Msg;

public class AskforMotherNatureView extends View{
    AnsMoveStudent3Msg answerMsg;
    public AskforMotherNatureView(AnsMoveStudent3Msg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        System.out.println("fatto");
    }
}
