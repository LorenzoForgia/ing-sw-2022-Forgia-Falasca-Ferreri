package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.IslandTiles;
import it.polimi.ingsw.Model.SchoolBoard;
import it.polimi.ingsw.messages.AnsMoveStudent3Msg;
import it.polimi.ingsw.messages.AnsMoveStudent4Msg;
import it.polimi.ingsw.messages.CCMsg;
import it.polimi.ingsw.messages.NumStepMNMsg;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayCC5View extends View{
    AnsMoveStudent4Msg answerMsg;
    public PlayCC5View(AnsMoveStudent4Msg answerMsg)
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
            } else if(card.equals("no")) {
                int step;
                f=true;
                boolean ex=false;
                System.out.println("Quanti passi di madre natura vuoi fare?");
                while(!ex) {
                    try {
                        step = Integer.parseInt(scanner.nextLine());
                        ex = true;
                        NumStepMNMsg numStepMNMsg= new NumStepMNMsg(step);
                        getOwner().getServerHandler().sendCommandMessage(numStepMNMsg);
                    } catch (NumberFormatException e) {
                        System.out.println("Errore: Inserire numero corretto");
                        ex = false;
                    }
                }
            }else{
                System.out.println("Errore inserimento! Riprova");
                card= scanner.nextLine();
            }
        }
    }
}
