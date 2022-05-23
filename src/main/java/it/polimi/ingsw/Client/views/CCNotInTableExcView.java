package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.messages.AnsCCNotInTableExcMsg;
import it.polimi.ingsw.messages.AnsColorExc1Msg;
import it.polimi.ingsw.messages.CCMsg;

import java.util.Scanner;

public class CCNotInTableExcView extends View{
    AnsCCNotInTableExcMsg answerMsg;
    public CCNotInTableExcView(AnsCCNotInTableExcMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        Scanner scanner= new Scanner(System.in);
        System.out.println("La carta non è sul tavolo! Riprova");
        int numcard=Integer.parseInt(scanner.nextLine());
        CCMsg ccMsg= new CCMsg(numcard);
        getOwner().getServerHandler().sendCommandMessage(ccMsg);
    }
}
