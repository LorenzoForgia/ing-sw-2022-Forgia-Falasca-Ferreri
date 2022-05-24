package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.messages.*;

import java.util.ArrayList;
import java.util.Scanner;

public class CC10View extends View{
    AnsCC10Msg answerMsg;
    public CC10View(AnsCC10Msg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Color> entrancestud= new ArrayList<>();
        ArrayList<Color> diningstud=new ArrayList<>();
        Boolean flag=false;
        int count=0;
        Color cdef=Color.Blue;
        System.out.println("Quanti studenti vuoi scambiare? ( max 2 studenti)");
        int numstud = Integer.parseInt(scanner.nextLine());
        for(int j=0; j<numstud;j++){
            while(!flag) {
                if(count==0) {
                    System.out.println("Scegli lo studente che vuoi scambiare dell'ingresso");
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
            count=0;
            flag=false;
            entrancestud.add(cdef);
        }
        for(int j=0; j<numstud;j++){
            while(!flag) {
                if(count==0) {
                    System.out.println("Scegli lo studente che vuoi scambiare dell'ingresso");
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
            count=0;
            flag=false;
            diningstud.add(cdef);
        }
        CC10Msg cc10Msg = new CC10Msg(entrancestud, diningstud);
        getOwner().getServerHandler().sendCommandMessage(cc10Msg);
    }
}
