package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.messages.AnsColorExc3Msg;
import it.polimi.ingsw.messages.AnsColorExc4Msg;
import it.polimi.ingsw.messages.MoveStudent3Msg;
import it.polimi.ingsw.messages.MoveStudent4Msg;

import java.util.Scanner;

public class ColorExc4View extends View{
    AnsColorExc4Msg answerMsg;
    public ColorExc4View(AnsColorExc4Msg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        int isl=0;
        System.out.println("Scelta non consentita! Scegli di nuovo il colore di uno studente:");
        Scanner scanner = new Scanner(System.in);
        Color student= Color.valueOf(scanner.nextLine());
        System.out.println("Vuoi spostarlo nella sala o su un'isola? sala/isola");
        String ris= scanner.nextLine();
        boolean flag=false;
        while(!flag) {
            if (ris.equals("sala")) {
                isl = 123;
                MoveStudent4Msg moveStudentMsg = new MoveStudent4Msg(student, isl);
                getOwner().getServerHandler().sendCommandMessage(moveStudentMsg);
                flag=true;
            } else if(ris.equals("isola")){
                System.out.println("Su quale isola vuoi spostarlo?");
                boolean ex=false;
                while(!ex) {
                    try {
                        isl = Integer.parseInt(scanner.nextLine());
                        ex=true;
                    } catch (NumberFormatException e) {
                        System.out.println("Errore: Su quale isola vuoi spostarlo");
                        ex=false;
                    }
                }
                MoveStudent4Msg moveStudentMsg = new MoveStudent4Msg(student, isl);
                getOwner().getServerHandler().sendCommandMessage(moveStudentMsg);
                flag=true;
            } else{
                System.out.println("Errore inserimento scelta,ripetere: Vuoi spostarlo nella sala o su un'isola? sala/isola");
                ris= scanner.nextLine();
            }
        }
    }
}
