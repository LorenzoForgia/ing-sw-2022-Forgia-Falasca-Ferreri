package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.IslandTiles;
import it.polimi.ingsw.Model.SchoolBoard;
import it.polimi.ingsw.messages.AnsPlayAfterCCMsg;
import it.polimi.ingsw.messages.NumStepMNMsg;

import java.util.ArrayList;
import java.util.Scanner;

public class AskforMNafterCCView extends View{
    AnsPlayAfterCCMsg answerMsg;
    public AskforMNafterCCView(AnsPlayAfterCCMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Displayer displayer = new Displayer();
        int isl;
        System.out.println(answerMsg.GetPlayer() + " hai giocato la carta personaggio scelta!");
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
        int step;
        System.out.println("Ora scegli quanti passi di madre natura vuoi fare?");
        step = Integer.parseInt(scanner.nextLine());
        NumStepMNMsg numStepMNMsg = new NumStepMNMsg(step);
        getOwner().getServerHandler().sendCommandMessage(numStepMNMsg);
    }
}
