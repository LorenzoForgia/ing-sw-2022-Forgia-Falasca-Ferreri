package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Model.IslandTiles;
import it.polimi.ingsw.Model.SchoolBoard;
import it.polimi.ingsw.messages.AnsCC1ExcMsg;
import it.polimi.ingsw.messages.AnsCC1Msg;
import it.polimi.ingsw.messages.CC1Msg;

import java.util.ArrayList;
import java.util.Scanner;

public class CC1ExcView extends View{
    AnsCC1ExcMsg answerMsg;
    public CC1ExcView(AnsCC1ExcMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        Scanner scanner= new Scanner(System.in);
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
        /**stampa studenti sulla charactercard**/
        System.out.println("Scelta non valida! Riprova");
        displayer.displayCharactercard(answerMsg.GetCharacterCard());
        Boolean flag=false;
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
        int isl= Integer.parseInt(scanner.nextLine());
        CC1Msg cc1Msg= new CC1Msg(isl, student);
        getOwner().getServerHandler().sendCommandMessage(cc1Msg);
    }
}