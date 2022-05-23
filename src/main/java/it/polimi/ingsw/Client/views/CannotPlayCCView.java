package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.messages.AnsCannotPlayCCMsg;
import it.polimi.ingsw.messages.AnsColorExc1Msg;

public class CannotPlayCCView extends View{
    AnsCannotPlayCCMsg answerMsg;
    public CannotPlayCCView(AnsCannotPlayCCMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        System.out.println(answerMsg.GetPlayer() +" non ti è consentito giocare una carta personaggio!");

    }
}
