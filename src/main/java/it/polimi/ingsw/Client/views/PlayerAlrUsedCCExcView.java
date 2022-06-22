package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.messages.AnsCCNotInTableExcMsg;
import it.polimi.ingsw.messages.AnsPlayerAlrUsedCCExcMsg;
import it.polimi.ingsw.messages.CCMsg;
import it.polimi.ingsw.messages.CannotPlayCCMsg;

import java.util.Scanner;

public class PlayerAlrUsedCCExcView extends View{
    AnsPlayerAlrUsedCCExcMsg answerMsg;
    public PlayerAlrUsedCCExcView(AnsPlayerAlrUsedCCExcMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Hai già usato questa carta!");
        CannotPlayCCMsg ccMsg= new CannotPlayCCMsg();
        getOwner().getServerHandler().sendCommandMessage(ccMsg);
    }
}
