package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.IslandTiles;
import it.polimi.ingsw.Model.SchoolBoard;
import it.polimi.ingsw.messages.AnsMoveStudent3Msg;
import it.polimi.ingsw.messages.AnsMoveStudent4Msg;
import it.polimi.ingsw.messages.NumStepMNMsg;

import java.util.ArrayList;
import java.util.Scanner;

public class AskForMN3PlayersView extends View{
    AnsMoveStudent4Msg answerMsg;
    public AskForMN3PlayersView(AnsMoveStudent4Msg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
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
        Scanner scanner= new Scanner(System.in);
        int step;
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
    }
}
