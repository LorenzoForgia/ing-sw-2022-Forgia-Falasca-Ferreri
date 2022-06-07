package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.messages.AnsNotEnoughCoinsExcMsg;
import it.polimi.ingsw.messages.AnsPlayerAlrUsedCCExcMsg;
import it.polimi.ingsw.messages.CCMsg;

import java.util.Scanner;

public class NotEnoughCoinsExcView extends View{
    AnsNotEnoughCoinsExcMsg answerMsg;
    public NotEnoughCoinsExcView(AnsNotEnoughCoinsExcMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Non hai abbasatanza monete per usare questa carta! Riprova");
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
