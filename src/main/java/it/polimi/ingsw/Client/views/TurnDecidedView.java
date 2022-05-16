package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.messages.AnsGameStartedMsg;
import it.polimi.ingsw.messages.AnsTurnDecidedMsg;
import it.polimi.ingsw.messages.FirstPlayerTurnMsg;
import it.polimi.ingsw.messages.MoveStudentMsg;

import java.util.Scanner;

public class TurnDecidedView extends View{
    private AnsTurnDecidedMsg answerMsg;


    public TurnDecidedView(AnsTurnDecidedMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }


    @Override
    public void run() {
        Scanner scanner= new Scanner(System.in);
        int isl;
        System.out.println("L'ordine dei giocatori nel round è:");
        for(int i=0; i< answerMsg.getNickname().size(); i++){
            System.out.println(answerMsg.getNickname().get(i));
        }
        System.out.println("Ha inizio la fase d'azione!");

        /**stampa school board**/

        System.out.println("Scegli il colore dello studente che vuoi spostare");
        Color student= Color.valueOf(scanner.nextLine());
        System.out.println("Vuoi spostarlo nella sala a su un'isola? sala/isola");
        String ris= scanner.nextLine();
        if(ris.equals("sala")){
            isl=12;
            MoveStudentMsg moveStudentMsg= new MoveStudentMsg(student, isl);
            getOwner().getServerHandler().sendCommandMessage(moveStudentMsg);
        }else{
            System.out.println("Su quale isola vuoi spostarlo?");
            isl=Integer.parseInt(scanner.nextLine());
            MoveStudentMsg moveStudentMsg= new MoveStudentMsg(student, isl);
            getOwner().getServerHandler().sendCommandMessage(moveStudentMsg);
        }
        /*FirstPlayerTurnMsg firstPlayerTurnMsg = new FirstPlayerTurnMsg();
        getOwner().getServerHandler().sendCommandMessage(firstPlayerTurnMsg);*/


    }
}
