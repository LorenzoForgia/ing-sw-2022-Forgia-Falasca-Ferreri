package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Model.IslandTiles;
import it.polimi.ingsw.Model.SchoolBoard;
import it.polimi.ingsw.messages.AnsPlayAfterNotCCMsg;
import it.polimi.ingsw.messages.MoveStudent2Msg;

import java.util.ArrayList;
import java.util.Scanner;

public class MoveStudent2AfterNotCCView extends View{
    AnsPlayAfterNotCCMsg answerMsg;
    public MoveStudent2AfterNotCCView(AnsPlayAfterNotCCMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Displayer displayer = new Displayer();
        int isl;
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
        Boolean flag = false;
        int count = 0;
        Color cdef = Color.Blue;
        while (!flag) {
            if (count == 0) {
                System.out.println("Ora scegli il colore del secondo studente che vuoi spostare");
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
