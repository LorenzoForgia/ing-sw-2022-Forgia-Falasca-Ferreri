package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Model.IslandTiles;
import it.polimi.ingsw.Model.SchoolBoard;
import it.polimi.ingsw.messages.*;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayCC4Players3View extends View{
    AnsMoveStudent3Msg answerMsg;
    public PlayCC4Players3View(AnsMoveStudent3Msg answerMsg)
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
                        System.out.println("Scegli il colore del quarto studente che vuoi spostare");
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
                        isl = 12;
                        MoveStudent4Msg moveStudentMsg = new MoveStudent4Msg(student, isl);
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
                        MoveStudent4Msg moveStudentMsg = new MoveStudent4Msg(student, isl);
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
