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
        displayer.displayAllSchoolboard(answerMsg.GetGB().getSchoolBoard(),answerMsg.GetPlayers());
        displayer.showAllIsland(answerMsg.GetGB().GetIslands());
        int step;
        System.out.println("Ora quanti passi di madre natura vuoi fare?");
        Boolean ex=false;
        while(!ex) {
            try {
                step = Integer.parseInt(scanner.nextLine());
                ex = true;
                NumStepMNMsg numStepMNMsg = new NumStepMNMsg(step);
                getOwner().getServerHandler().sendCommandMessage(numStepMNMsg);
            } catch (NumberFormatException e) {
                System.out.println("Errore: Inserire numero corretto");
                ex = false;
            }
        }
    }
}
