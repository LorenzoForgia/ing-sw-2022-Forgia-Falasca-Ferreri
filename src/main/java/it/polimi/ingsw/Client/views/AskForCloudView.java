package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.messages.AnsMoveStudent3Msg;
import it.polimi.ingsw.messages.AnsNumStepMNMsg;
import it.polimi.ingsw.messages.CloudMsg;

import java.util.Scanner;

public class AskForCloudView extends View{
    AnsNumStepMNMsg answerMsg;
    public AskForCloudView(AnsNumStepMNMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        /**stampa general board**/
        Scanner scanner= new Scanner(System.in);
        System.out.println("Scegli il numero della nuvola da cui vuoi prendere gli studenti");
        int cloud =Integer.parseInt(scanner.nextLine());
        CloudMsg cloudMsg= new CloudMsg(cloud);
        getOwner().getServerHandler().sendCommandMessage(cloudMsg);
    }
}
