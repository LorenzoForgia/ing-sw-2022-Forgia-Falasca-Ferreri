package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Model.SchoolBoard;
import it.polimi.ingsw.messages.AnsMoveStudent1Msg;
import it.polimi.ingsw.messages.MoveStudent1Msg;
import it.polimi.ingsw.messages.MoveStudent2Msg;
import it.polimi.ingsw.messages.TurnDecidedMsg;

import java.util.ArrayList;
import java.util.Scanner;

public class MoveStudent2View extends View{
    AnsMoveStudent1Msg answerMsg;
    public MoveStudent2View(AnsMoveStudent1Msg answerMsg)
    {
        this.answerMsg = answerMsg;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int isl=0;
        Displayer displayer= new Displayer();
        ArrayList<SchoolBoard> schoolBoards= new ArrayList<SchoolBoard>();
        for(int i=0; i<answerMsg.GetGB().getSchoolBoard().size();i++){
            schoolBoards.add(answerMsg.GetGB().getSchoolBoard().get(i));
        }
        displayer.displayAllSchoolboard(schoolBoards,answerMsg.GetPlayers());
        System.out.println(answerMsg.GetPlayer() + " scegli il secondo studente!");
        Color student= Color.valueOf(scanner.nextLine());
        System.out.println("Vuoi spostarlo nella sala a su un'isola? sala/isola");
        String ris= scanner.nextLine();
        if(ris.equals("sala")){
            isl=12;
            MoveStudent2Msg moveStudentMsg= new MoveStudent2Msg(student, isl);
            getOwner().getServerHandler().sendCommandMessage(moveStudentMsg);
        }else{
            System.out.println("Su quale isola vuoi spostarlo?");
            isl=Integer.parseInt(scanner.nextLine());
            MoveStudent2Msg moveStudentMsg= new MoveStudent2Msg(student, isl);
            getOwner().getServerHandler().sendCommandMessage(moveStudentMsg);
        }
    }
}
