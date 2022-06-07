package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.IslandTiles;
import it.polimi.ingsw.messages.AnsCC3ExcMsg;
import it.polimi.ingsw.messages.AnsCC3Msg;
import it.polimi.ingsw.messages.CC3Msg;

import java.util.ArrayList;
import java.util.Scanner;

public class CC3ExcView extends View{
    AnsCC3ExcMsg answerMsg;
    public CC3ExcView(AnsCC3ExcMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Displayer displayer= new Displayer();
        displayer.showAllIsland(answerMsg.GetGB().GetIslands());
        System.out.println("Scelta non valida! Riprova");
        System.out.println("Scegli il numero dell'isola su cui vuoi calcolare la maggioranza");
        int isl;
        boolean b=false;
        while(!b) {
            try {
                isl=Integer.parseInt(scanner.nextLine());
                b = true;
                CC3Msg cc3Msg = new CC3Msg(isl);
                getOwner().getServerHandler().sendCommandMessage(cc3Msg);
            } catch (NumberFormatException e) {
                System.out.println("Errore: Inserire numero corretto");
                b = false;
            }
        }
    }
}
