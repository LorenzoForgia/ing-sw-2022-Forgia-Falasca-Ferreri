package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Model.IslandTiles;
import it.polimi.ingsw.Model.SchoolBoard;
import it.polimi.ingsw.messages.AnsMoveStudent2Msg;
import it.polimi.ingsw.messages.AnsMoveStudent3Msg;
import it.polimi.ingsw.messages.NumStepMNMsg;

import java.util.ArrayList;
import java.util.Scanner;

public class AskforMotherNatureView extends View{
    AnsMoveStudent3Msg answerMsg;
    public AskforMotherNatureView(AnsMoveStudent3Msg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        Displayer displayer = new Displayer();
        displayer.displayAllSchoolboard(answerMsg.GetGB().getSchoolBoard(),answerMsg.GetPlayers());
        displayer.showAllIsland(answerMsg.GetGB().GetIslands());
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
