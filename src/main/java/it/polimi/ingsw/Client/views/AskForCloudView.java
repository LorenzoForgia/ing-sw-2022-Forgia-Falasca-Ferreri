package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.CloudTiles;
import it.polimi.ingsw.Model.IslandTiles;
import it.polimi.ingsw.Model.SchoolBoard;
import it.polimi.ingsw.messages.AnsMoveStudent3Msg;
import it.polimi.ingsw.messages.AnsNumStepMNMsg;
import it.polimi.ingsw.messages.CloudMsg;
import it.polimi.ingsw.messages.NumStepMNMsg;

import java.util.ArrayList;
import java.util.Scanner;

public class AskForCloudView extends View{
    AnsNumStepMNMsg answerMsg;
    public AskForCloudView(AnsNumStepMNMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        Displayer d=new Displayer();
        d.showAllCloudTiles(answerMsg.getCloudTiles());
        Scanner scanner= new Scanner(System.in);
        System.out.println("Scegli il numero della nuvola da cui vuoi prendere gli studenti");
        Boolean ex=false;
        while(!ex) {
            try {
                int cloud = Integer.parseInt(scanner.nextLine());
                ex = true;
                CloudMsg cloudMsg = new CloudMsg(cloud);
                getOwner().getServerHandler().sendCommandMessage(cloudMsg);
            } catch (NumberFormatException e) {
                System.out.println("Errore: Inserire numero corretto");
                ex = false;
            }
        }
    }
}
