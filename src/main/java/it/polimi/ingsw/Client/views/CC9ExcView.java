package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Model.IslandTiles;
import it.polimi.ingsw.Model.SchoolBoard;
import it.polimi.ingsw.messages.AnsCC9ExcMsg;
import it.polimi.ingsw.messages.AnsCC9Msg;
import it.polimi.ingsw.messages.CC9Msg;

import java.util.ArrayList;
import java.util.Scanner;

public class CC9ExcView extends View{
    AnsCC9ExcMsg answerMsg;
    public CC9ExcView(AnsCC9ExcMsg answerMsg)
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
        System.out.println("Scelta non valida! Riprova");
        while (!flag) {
            if (count == 0) {
                System.out.println("Scegli il colore di studente che non fornisce influenza per questo turno");
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
        CC9Msg cc9Msg= new CC9Msg(color);
        getOwner().getServerHandler().sendCommandMessage(cc9Msg);
    }
}
