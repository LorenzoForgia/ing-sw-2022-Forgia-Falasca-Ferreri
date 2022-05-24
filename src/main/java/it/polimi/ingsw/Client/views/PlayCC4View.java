package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.IslandTiles;
import it.polimi.ingsw.Model.SchoolBoard;
import it.polimi.ingsw.messages.AnsMoveStudent2Msg;
import it.polimi.ingsw.messages.AnsMoveStudent3Msg;
import it.polimi.ingsw.messages.CCMsg;
import it.polimi.ingsw.messages.NumStepMNMsg;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayCC4View extends View{
    AnsMoveStudent3Msg answerMsg;
    public PlayCC4View(AnsMoveStudent3Msg answerMsg)
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
        System.out.println("Vuoi giocare una carta personaggio? si/no");
        String card = scanner.nextLine();
        if (card.equals("si")) {
            System.out.println("Qual'è il numero della carta personaggio che vuoi giocare?");
            int numcard = Integer.parseInt(scanner.nextLine());
            CCMsg ccMsg = new CCMsg(numcard);
            getOwner().getServerHandler().sendCommandMessage(ccMsg);
        } else {
            int step;
            System.out.println("Quanti passi di madre natura vuoi fare?");
            step = Integer.parseInt(scanner.nextLine());
            NumStepMNMsg numStepMNMsg= new NumStepMNMsg(step);
            getOwner().getServerHandler().sendCommandMessage(numStepMNMsg);
        }
    }
}
