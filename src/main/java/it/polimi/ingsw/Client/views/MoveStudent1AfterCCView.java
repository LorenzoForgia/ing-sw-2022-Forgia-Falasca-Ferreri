package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Model.IslandTiles;
import it.polimi.ingsw.Model.SchoolBoard;
import it.polimi.ingsw.messages.AnsAskCAMsg;
import it.polimi.ingsw.messages.AnsMoveStudent1AfterCCMsg;
import it.polimi.ingsw.messages.MoveStudent1Msg;

import java.util.ArrayList;
import java.util.Scanner;

public class MoveStudent1AfterCCView extends View{
    AnsMoveStudent1AfterCCMsg answerMsg;
    public MoveStudent1AfterCCView(AnsMoveStudent1AfterCCMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        Scanner scanner= new Scanner(System.in);
        Displayer displayer= new Displayer();
        int isl;
        System.out.println(answerMsg.GetPlayer() + " hai giocato la carta personaggio scelta!");
        ArrayList<SchoolBoard> schoolBoards= new ArrayList<SchoolBoard>();
        for(int i=0; i<answerMsg.GetGB().getSchoolBoard().size();i++){
            schoolBoards.add(answerMsg.GetGB().getSchoolBoard().get(i));
        }
        displayer.displayAllSchoolboard(schoolBoards,answerMsg.GetPlayers());
        ArrayList<IslandTiles> islandTiles=new ArrayList<>();
        for(int i=0; i<answerMsg.GetGB().GetIslands().size();i++){
            islandTiles.add(answerMsg.GetGB().GetIslands().get(i));
        }
        displayer.showAllIsland(islandTiles);
        Boolean flag=false;
        int count=0;
        Color cdef=Color.Blue;
        while(!flag) {
            if(count==0) {
                System.out.println("Ora scegli il colore dello studente che vuoi spostare");
            }else{
                System.out.println("Errore inserimento colore:Seleziona un colore valido");
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
        System.out.println("Vuoi spostarlo nella sala o su un'isola? sala/isola");
        String ris= scanner.nextLine();
        if(ris.equals("sala")){
            isl=12;
            MoveStudent1Msg moveStudentMsg= new MoveStudent1Msg(student, isl);
            getOwner().getServerHandler().sendCommandMessage(moveStudentMsg);
        }else{
            System.out.println("Su quale isola vuoi spostarlo?");
            isl=Integer.parseInt(scanner.nextLine());
            MoveStudent1Msg moveStudentMsg= new MoveStudent1Msg(student, isl);
            getOwner().getServerHandler().sendCommandMessage(moveStudentMsg);
        }
    }
}
