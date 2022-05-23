package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.messages.AnsCCNotInTableExcMsg;
import it.polimi.ingsw.messages.AnsPlayerAlrUsedCCExcMsg;
import it.polimi.ingsw.messages.CCMsg;

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
        System.out.println("Hai già usato questa carta! Riprova");
        int numcard=Integer.parseInt(scanner.nextLine());
        CCMsg ccMsg= new CCMsg(numcard);
        getOwner().getServerHandler().sendCommandMessage(ccMsg);
    }
}
