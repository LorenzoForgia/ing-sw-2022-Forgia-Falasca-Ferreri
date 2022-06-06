package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Model.IslandTiles;
import it.polimi.ingsw.Model.SchoolBoard;
import it.polimi.ingsw.messages.AnsMoveStudent3Msg;
import it.polimi.ingsw.messages.MoveStudent3Msg;
import it.polimi.ingsw.messages.MoveStudent4Msg;

import java.util.ArrayList;
import java.util.Scanner;

public class MoveStudent4View extends View{
    AnsMoveStudent3Msg answerMsg;
    public MoveStudent4View(AnsMoveStudent3Msg answerMsg)
    {
        this.answerMsg = answerMsg;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int isl=0;
        Displayer displayer= new Displayer();
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
        System.out.println(answerMsg.GetPlayer() + " scegli il quarto studente!");
        Boolean flag=false;
        int count=0;
        Color cdef=Color.Blue;
        while(!flag) {
            if(count==0) {
                System.out.println("Scegli il colore dello studente che vuoi spostare");
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
        System.out.println("Vuoi spostarlo nella sala a su un'isola? sala/isola");
        String ris= scanner.nextLine();
        flag=false;
        while(!flag) {
            if (ris.equals("sala")) {
                isl = 12;
                MoveStudent4Msg moveStudentMsg = new MoveStudent4Msg(student, isl);
                getOwner().getServerHandler().sendCommandMessage(moveStudentMsg);
                flag=true;
            } else if(ris.equals("isola")){
                System.out.println("Su quale isola vuoi spostarlo?");
                Boolean ex=false;
                while(!ex) {
                    try {
                        isl = Integer.parseInt(scanner.nextLine());
                        ex=true;
                    } catch (NumberFormatException e) {
                        System.out.println("Errore: Su quale isola vuoi spostarlo");
                        ex=false;
                    }
                }
                MoveStudent4Msg moveStudentMsg = new MoveStudent4Msg(student, isl);
                getOwner().getServerHandler().sendCommandMessage(moveStudentMsg);
                flag=true;
            } else{
                System.out.println("Errore inserimento scelta,ripetere: Vuoi spostarlo nella sala o su un'isola? sala/isola");
                ris= scanner.nextLine();
            }
        }
    }
}
