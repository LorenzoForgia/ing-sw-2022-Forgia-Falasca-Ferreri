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
        displayer.displayAllSchoolboard(answerMsg.GetGB().getSchoolBoard(),answerMsg.GetPlayers());
        displayer.showAllIsland(answerMsg.GetGB().GetIslands());
        int step;
        System.out.println("Ora scegli quanti passi di madre natura vuoi fare?");
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
