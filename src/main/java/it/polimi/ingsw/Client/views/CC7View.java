package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Model.IslandTiles;
import it.polimi.ingsw.Model.SchoolBoard;
import it.polimi.ingsw.messages.AnsCC3Msg;
import it.polimi.ingsw.messages.AnsCC7Msg;
import it.polimi.ingsw.messages.CC3Msg;
import it.polimi.ingsw.messages.CC7Msg;

import java.util.ArrayList;
import java.util.Scanner;

public class CC7View extends View{
    AnsCC7Msg answerMsg;
    public CC7View(AnsCC7Msg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Color> students= new ArrayList<Color>();
        ArrayList<Color> entrancestud= new ArrayList<Color>();
        Boolean flag=false;
        int count=0;
        Color cdef=Color.Blue;
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
        /**stampa studenti sopra charactercard**/
        System.out.println("Quanti studenti vuoi prendere? ( max 3 studenti)");
        int numstud = Integer.parseInt(scanner.nextLine());
        for(int j=0; j<numstud;j++){
            while(!flag) {
                if(count==0) {
                    System.out.println("Scegli lo studente sulla carta che vuoi scambiare");
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
            count=0;
            flag=false;
            students.add(cdef);
        }
        for(int j=0; j<numstud;j++){
            while(!flag) {
                if(count==0) {
                    System.out.println("Scegli lo studente del tuo ingresso che vuoi scambiare");
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
            count=0;
            flag=false;
            entrancestud.add(cdef);
        }
        CC7Msg cc7Msg = new CC7Msg(students, entrancestud);
        getOwner().getServerHandler().sendCommandMessage(cc7Msg);
    }
}
