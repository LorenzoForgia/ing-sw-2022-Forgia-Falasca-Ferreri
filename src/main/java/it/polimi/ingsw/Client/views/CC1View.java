package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.messages.AnsCC1Msg;
import it.polimi.ingsw.messages.AnsColorExc1Msg;
import it.polimi.ingsw.messages.CC1Msg;

import java.util.Scanner;

public class CC1View extends View{
    AnsCC1Msg answerMsg;
    public CC1View(AnsCC1Msg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        Scanner scanner= new Scanner(System.in);
        Boolean flag=false;
        int count=0;
        Color cdef=Color.Blue;
        while(!flag) {
            if(count==0) {
                System.out.println("Scegli lo studente");
            }else{
                System.out.println("Colore dello studente invalido! Riprova");
            }
            String colorchosen = scanner.nextLine();
            Color[] colors = Color.values();
            for (int i = 0; i < 5 && !flag; i++) {
                if (colors[i].getName().equals(colorchosen)) {
                    cdef=colors[i];
                    flag = true;
                }
            }
            count++;
        }
        Color student= cdef;
        System.out.println("Scegli il numero dell'sola su cui vuoi mettere lo studente");
        int isl= Integer.parseInt(scanner.nextLine());
        CC1Msg cc1Msg= new CC1Msg(isl, student);
        getOwner().getServerHandler().sendCommandMessage(cc1Msg);
    }
}
