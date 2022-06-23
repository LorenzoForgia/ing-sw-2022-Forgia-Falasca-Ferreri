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
        boolean f=false;
        while(!f) {
            if (card.equals("si")) {
                System.out.println("Qual'è il numero della carta personaggio che vuoi giocare?");
                f=true;
                boolean b=false;
                while(!b) {
                    try {
                        int numcard=Integer.parseInt(scanner.nextLine());
                        b = true;
                        CCMsg ccMsg= new CCMsg(numcard);
                        getOwner().getServerHandler().sendCommandMessage(ccMsg);
                    } catch (NumberFormatException e) {
                        System.out.println("Errore: Inserire numero corretto");
                        b = false;
                    }
                }
            } else if(card.equals("no")){
                boolean flag = false;
                f=true;
                int count = 0;
                int isl=0;
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
            }else{
                System.out.println("Errore inserimento! Riprova");
                card= scanner.nextLine();
            }
        }

    }
}
