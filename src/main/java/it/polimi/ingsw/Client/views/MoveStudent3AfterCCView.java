package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Model.IslandTiles;
import it.polimi.ingsw.Model.SchoolBoard;
import it.polimi.ingsw.messages.AnsPlayAfterCCMsg;
import it.polimi.ingsw.messages.MoveStudent1Msg;
import it.polimi.ingsw.messages.MoveStudent3Msg;

import java.util.ArrayList;
import java.util.Scanner;

public class MoveStudent3AfterCCView extends View{
    AnsPlayAfterCCMsg answerMsg;
    public MoveStudent3AfterCCView(AnsPlayAfterCCMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Displayer displayer = new Displayer();
        int isl=0;
        System.out.println(answerMsg.GetPlayer() + " hai giocato la carta personaggio scelta!");
        displayer.displayAllSchoolboard(answerMsg.GetGB().getSchoolBoard(),answerMsg.GetPlayers());
        displayer.showAllIsland(answerMsg.GetGB().GetIslands());
        boolean flag = false;
        int count = 0;
        Color cdef = Color.Blue;
        while (!flag) {
            if (count == 0) {
                System.out.println("Ora scegli il colore del terzo studente che vuoi spostare");
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
        flag=false;
        while(!flag) {
            if (ris.equals("sala")) {
                isl = 123;
                MoveStudent3Msg moveStudentMsg = new MoveStudent3Msg(student, isl);
                getOwner().getServerHandler().sendCommandMessage(moveStudentMsg);
                flag=true;
            } else if(ris.equals("isola")){
                System.out.println("Su quale isola vuoi spostarlo?");
                boolean ex=false;
                while(!ex) {
                    try {
                        isl = Integer.parseInt(scanner.nextLine());
                        ex=true;
                    } catch (NumberFormatException e) {
                        System.out.println("Errore: Su quale isola vuoi spostarlo");
                        ex=false;
                    }
                }
                MoveStudent3Msg moveStudentMsg = new MoveStudent3Msg(student, isl);
                getOwner().getServerHandler().sendCommandMessage(moveStudentMsg);
                flag=true;
            } else{
                System.out.println("Errore inserimento scelta,ripetere: Vuoi spostarlo nella sala o su un'isola? sala/isola");
                ris= scanner.nextLine();
            }
        }
    }
}
