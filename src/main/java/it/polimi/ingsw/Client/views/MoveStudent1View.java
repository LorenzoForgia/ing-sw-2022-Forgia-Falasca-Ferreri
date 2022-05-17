package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Model.SchoolBoard;
import it.polimi.ingsw.messages.AnsAskCAMsg;
import it.polimi.ingsw.messages.AnsMoveStudent1Msg;
import it.polimi.ingsw.messages.MoveStudent1Msg;

import java.util.ArrayList;
import java.util.Scanner;

public class MoveStudent1View extends View{
    AnsAskCAMsg answerMsg;
    public MoveStudent1View(AnsAskCAMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        Scanner scanner= new Scanner(System.in);
        Displayer displayer= new Displayer();
        ArrayList<SchoolBoard> schoolBoards= new ArrayList<SchoolBoard>();
        int isl;
        System.out.println(answerMsg.GetPlayer() + " è il tuo turno!");
        for(int i=0; i<answerMsg.GetGB().getSchoolBoard().size();i++){
            schoolBoards.add(answerMsg.GetGB().getSchoolBoard().get(i));
        }
        displayer.displayAllSchoolboard(schoolBoards,answerMsg.GetPlayers());
        System.out.println("Scegli il colore dello studente che vuoi spostare");
        Color student= Color.valueOf(scanner.nextLine());
        System.out.println("Vuoi spostarlo nella sala a su un'isola? sala/isola");
        String ris= scanner.nextLine();
        if(ris.equals("sala")){
            isl=12;
            MoveStudent1Msg moveStudentMsg= new MoveStudent1Msg(student, isl);
            getOwner().getServerHandler().sendCommandMessage(moveStudentMsg);
        }else{
            System.out.println("Su quale isola vuoi spostarlo?");
            isl=Integer.parseInt(scanner.nextLine());
            MoveStudent1Msg moveStudentMsg= new MoveStudent1Msg(student, isl);
            getOwner().getServerHandler().sendCommandMessage(moveStudentMsg);
        }
    }
}
