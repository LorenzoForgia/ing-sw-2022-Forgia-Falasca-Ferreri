package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Model.IslandTiles;
import it.polimi.ingsw.Model.SchoolBoard;
import it.polimi.ingsw.messages.AnsMoveStudent1Msg;
import it.polimi.ingsw.messages.AnsMoveStudent2Msg;
import it.polimi.ingsw.messages.CCMsg;
import it.polimi.ingsw.messages.MoveStudent3Msg;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayCC3View extends View{
    AnsMoveStudent2Msg answerMsg;
    public PlayCC3View(AnsMoveStudent2Msg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Displayer displayer = new Displayer();
        displayer.displayAllSchoolboard(answerMsg.GetGB().getSchoolBoard(),answerMsg.GetPlayers());
        displayer.showAllIsland(answerMsg.GetGB().GetIslands());
        /**stampa Charactercards**/
        for(int i=0;i<answerMsg.GetPlayers().size();i++){
            if(answerMsg.GetPlayers().get(i).getNickName().equals(answerMsg.GetPlayer())) {
                displayer.displayWallet(answerMsg.GetPlayers().get(i).getNumberCoins());
            }
        }
        displayer.displayAllcharactercard(answerMsg.GetCharacterCards());
        System.out.println("Vuoi giocare una carta personaggio? si/no");
        String card = scanner.nextLine();
        if (card.equals("si")) {
            System.out.println("Qual'è il numero della carta personaggio che vuoi giocare?");
            int numcard = Integer.parseInt(scanner.nextLine());
            CCMsg ccMsg = new CCMsg(numcard);
            getOwner().getServerHandler().sendCommandMessage(ccMsg);
        } else {
            Boolean flag = false;
            int count = 0;
            int isl;
            Color cdef = Color.Blue;
            while (!flag) {
                if (count == 0) {
                    System.out.println("Scegli il colore del terzo studente che vuoi spostare");
                } else {
                    System.out.println("Errore inserimento colore:Seleziona un colore valido");
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
            Color student = cdef;
            System.out.println("Vuoi spostarlo nella sala o su un'isola? sala/isola");
            String ris = scanner.nextLine();
            if (ris.equals("sala")) {
                isl = 12;
                MoveStudent3Msg moveStudentMsg = new MoveStudent3Msg(student, isl);
                getOwner().getServerHandler().sendCommandMessage(moveStudentMsg);
            } else {
                System.out.println("Su quale isola vuoi spostarlo?");
                isl = Integer.parseInt(scanner.nextLine());
                MoveStudent3Msg moveStudentMsg = new MoveStudent3Msg(student, isl);
                getOwner().getServerHandler().sendCommandMessage(moveStudentMsg);
            }
        }
    }
}
