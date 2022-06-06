package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Model.IslandTiles;
import it.polimi.ingsw.Model.SchoolBoard;
import it.polimi.ingsw.messages.AnsCC11Msg;
import it.polimi.ingsw.messages.AnsCC9Msg;
import it.polimi.ingsw.messages.CC11Msg;
import it.polimi.ingsw.messages.CC9Msg;

import java.util.ArrayList;
import java.util.Scanner;

public class CC11View extends View{
    AnsCC11Msg answerMsg;
    public CC11View(AnsCC11Msg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Boolean flag = false;
        int count = 0;
        Color cdef = Color.Blue;
        Displayer displayer= new Displayer();
        displayer.displayAllSchoolboard(answerMsg.GetGB().getSchoolBoard(),answerMsg.GetPlayers());
        displayer.showAllIsland(answerMsg.GetGB().GetIslands());
        /**stampa studenti sulla carta**/
        displayer.displayCharactercard(answerMsg.GetCharacterCard());
        while (!flag) {
            if (count == 0) {
                System.out.println("Scegli lo studente da mettere nella sala");
            } else {
                System.out.println("Colore dello studente invalido! Riprova");
            }
            String colorchosen = scanner.nextLine();
            Color[] colors = Color.values();
            for (int i = 0; i < 5 && !flag; i++) {
                if (colors[i].getName().equals(colorchosen)) {
                    cdef = colors[i];
                    flag = true;
                }
            }
            count++;
        }
        Color color = cdef;
        CC11Msg cc11Msg= new CC11Msg(color);
        getOwner().getServerHandler().sendCommandMessage(cc11Msg);
    }
}
