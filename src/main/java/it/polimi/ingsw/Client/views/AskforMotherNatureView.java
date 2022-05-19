package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.messages.AnsMoveStudent2Msg;
import it.polimi.ingsw.messages.AnsMoveStudent3Msg;
import it.polimi.ingsw.messages.NumStepMNMsg;

import java.util.Scanner;

public class AskforMotherNatureView extends View{
    AnsMoveStudent3Msg answerMsg;
    public AskforMotherNatureView(AnsMoveStudent3Msg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        /**stampa general board**/
        Scanner scanner= new Scanner(System.in);
        int step;
        System.out.println("Quanti passi di madre natura vuoi fare?");
        step = Integer.parseInt(scanner.nextLine());
        NumStepMNMsg numStepMNMsg= new NumStepMNMsg(step);
        getOwner().getServerHandler().sendCommandMessage(numStepMNMsg);
    }
}