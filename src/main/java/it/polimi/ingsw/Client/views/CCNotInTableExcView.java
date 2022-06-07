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
        boolean b=false;
        while(!b) {
            try {
                int numcard=Integer.parseInt(scanner.nextLine());
                b = true;
                CCMsg ccMsg= new CCMsg(numcard);
                getOwner().getServerHandler().sendCommandMessage(ccMsg);
            } catch (NumberFormatException e) {
                System.out.println("Errore: Inserire numero corretto");
                b = false;
            }
        }
    }
}
