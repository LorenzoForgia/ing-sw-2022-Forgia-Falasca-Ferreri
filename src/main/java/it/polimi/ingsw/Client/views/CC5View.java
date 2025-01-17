package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.IslandTiles;
import it.polimi.ingsw.Model.SchoolBoard;
import it.polimi.ingsw.messages.AnsCC3Msg;
import it.polimi.ingsw.messages.AnsCC5Msg;
import it.polimi.ingsw.messages.CC3Msg;
import it.polimi.ingsw.messages.CC5Msg;

import java.util.ArrayList;
import java.util.Scanner;

public class CC5View extends View{
    AnsCC5Msg answerMsg;
    public CC5View(AnsCC5Msg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Displayer displayer= new Displayer();
        displayer.showAllIsland(answerMsg.GetGB().GetIslands());
        System.out.println("Scegli il numero dell'isola su cui vuoi mettere la tessera divieto");
        int isl;
        boolean b=false;
        while(!b) {
            try {
                isl=Integer.parseInt(scanner.nextLine());
                b = true;
                CC5Msg cc5Msg = new CC5Msg(isl);
                getOwner().getServerHandler().sendCommandMessage(cc5Msg);
            } catch (NumberFormatException e) {
                System.out.println("Errore: Inserire numero corretto");
                b = false;
            }
        }
    }
}
