package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.IslandTiles;
import it.polimi.ingsw.Model.SchoolBoard;
import it.polimi.ingsw.messages.AnsPlayAfterNotCCMsg;
import it.polimi.ingsw.messages.NumStepMNMsg;

import java.util.ArrayList;
import java.util.Scanner;

public class AskforMNafterNotCCView extends View{
    AnsPlayAfterNotCCMsg answerMsg;
    public AskforMNafterNotCCView(AnsPlayAfterNotCCMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Displayer displayer = new Displayer();
        int isl;
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
        System.out.println("Ora quanti passi di madre natura vuoi fare?");
        step = Integer.parseInt(scanner.nextLine());
        NumStepMNMsg numStepMNMsg = new NumStepMNMsg(step);
        getOwner().getServerHandler().sendCommandMessage(numStepMNMsg);
    }
}
