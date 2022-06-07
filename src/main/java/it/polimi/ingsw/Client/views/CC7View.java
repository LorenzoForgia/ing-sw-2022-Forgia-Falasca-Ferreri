package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Model.IslandTiles;
import it.polimi.ingsw.Model.SchoolBoard;
import it.polimi.ingsw.messages.*;

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
        boolean flag=false;
        int count=0;
        int numstud=0;
        Color cdef=Color.Blue;
        Displayer displayer= new Displayer();
        displayer.displayAllSchoolboard(answerMsg.GetGB().getSchoolBoard(),answerMsg.GetPlayers());
        displayer.showAllIsland(answerMsg.GetGB().GetIslands());
        /**stampa studenti sopra charactercard**/
        displayer.displayCharactercard(answerMsg.GetCharacterCard());
        System.out.println("Quanti studenti vuoi prendere? ( max 3 studenti)");
        boolean b=false;
        while(!b) {
            try {
                numstud=Integer.parseInt(scanner.nextLine());
                b = true;
            } catch (NumberFormatException e) {
                System.out.println("Errore: Inserire numero corretto");
                b = false;
            }
        }
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
