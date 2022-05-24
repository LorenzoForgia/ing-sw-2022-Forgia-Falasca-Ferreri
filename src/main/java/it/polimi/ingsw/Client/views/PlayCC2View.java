package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Model.IslandTiles;
import it.polimi.ingsw.Model.SchoolBoard;
import it.polimi.ingsw.messages.AnsAskCAMsg;
import it.polimi.ingsw.messages.AnsMoveStudent1Msg;
import it.polimi.ingsw.messages.CCMsg;
import it.polimi.ingsw.messages.MoveStudent2Msg;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayCC2View extends View{
    AnsMoveStudent1Msg answerMsg;
    public PlayCC2View(AnsMoveStudent1Msg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Displayer displayer = new Displayer();
        ArrayList<SchoolBoard> schoolBoards = new ArrayList<SchoolBoard>();
        for (int i = 0; i < answerMsg.GetGB().getSchoolBoard().size(); i++) {
            schoolBoards.add(answerMsg.GetGB().getSchoolBoard().get(i));
        }
        displayer.displayAllSchoolboard(schoolBoards, answerMsg.GetPlayers());
        ArrayList<IslandTiles> islandTiles = new ArrayList<>();
        for (int i = 0; i < answerMsg.GetGB().GetIslands().size(); i++) {
            islandTiles.add(answerMsg.GetGB().GetIslands().get(i));
        }
        displayer.showAllIsland(islandTiles);
        /**stampa charactercards**/
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
                    System.out.println("Scegli il colore del secondo studente che vuoi spostare");
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
                MoveStudent2Msg moveStudentMsg = new MoveStudent2Msg(student, isl);
                getOwner().getServerHandler().sendCommandMessage(moveStudentMsg);
            } else {
                System.out.println("Su quale isola vuoi spostarlo?");
                isl = Integer.parseInt(scanner.nextLine());
                MoveStudent2Msg moveStudentMsg = new MoveStudent2Msg(student, isl);
                getOwner().getServerHandler().sendCommandMessage(moveStudentMsg);
            }
        }
    }
}
