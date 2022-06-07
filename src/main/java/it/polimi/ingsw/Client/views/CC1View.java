package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Model.IslandTiles;
import it.polimi.ingsw.Model.SchoolBoard;
import it.polimi.ingsw.messages.AnsCC1Msg;
import it.polimi.ingsw.messages.AnsColorExc1Msg;
import it.polimi.ingsw.messages.CC1Msg;
import it.polimi.ingsw.messages.CC3Msg;

import java.util.ArrayList;
import java.util.Scanner;

public class CC1View extends View{
    AnsCC1Msg answerMsg;
    public CC1View(AnsCC1Msg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        Scanner scanner= new Scanner(System.in);
        Displayer displayer= new Displayer();
        displayer.displayAllSchoolboard(answerMsg.GetGB().getSchoolBoard(),answerMsg.GetPlayers());
        displayer.showAllIsland(answerMsg.GetGB().GetIslands());
        /**stampa studenti sulla charactercard**/
        displayer.displayCharactercard(answerMsg.GetCharacterCard());
        boolean flag=false;
        int count=0;
        Color cdef=Color.Blue;
        while(!flag) {
            if(count==0) {
                System.out.println("Scegli lo studente");
            }else{
                System.out.println("Colore dello studente invalido! Riprova");
            }
            String colorchosen = scanner.nextLine();
            Color[] colors = Color.values();
            for (int i = 0; i < 5 && !flag; i++) {
                if (colors[i].getName().equals(colorchosen)) {
                    cdef=colors[i];
                    flag = true;
                }
            }
            count++;
        }
        Color student= cdef;
        System.out.println("Scegli il numero dell'isola su cui vuoi mettere lo studente");
        int isl;
        boolean b=false;
        while(!b) {
            try {
                isl=Integer.parseInt(scanner.nextLine());
                b = true;
                CC1Msg cc1Msg= new CC1Msg(isl, student);
                getOwner().getServerHandler().sendCommandMessage(cc1Msg);
            } catch (NumberFormatException e) {
                System.out.println("Errore: Inserire numero corretto");
                b = false;
            }
        }
    }
}
