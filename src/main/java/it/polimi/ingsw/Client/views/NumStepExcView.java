package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.messages.AnsColorExc2Msg;
import it.polimi.ingsw.messages.AnsNumStepExcMsg;
import it.polimi.ingsw.messages.NumStepMNMsg;

import java.util.Scanner;

public class NumStepExcView extends View{
    AnsNumStepExcMsg answerMsg;
    public NumStepExcView(AnsNumStepExcMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        Scanner scanner= new Scanner(System.in);
        int step;
        System.out.println("Numero passi invalido! Riprova");
        boolean ex=false;
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
