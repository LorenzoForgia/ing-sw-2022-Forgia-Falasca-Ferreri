package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.messages.AnsFirstPlayerTurnMsg;
import it.polimi.ingsw.messages.AnsGameStartedMsg;

import java.util.Scanner;

public class FirstPlayerTurnView extends View{
    private AnsFirstPlayerTurnMsg answerMsg;


    public FirstPlayerTurnView(AnsFirstPlayerTurnMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }


    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gioca una carta assistente!");
        System.out.println("Valore della carta:");
        int cardvalue = Integer.parseInt(scanner.nextLine());
        System.out.println("Numero di movimenti che può fare Madre Natura:");
        int MovmntNM = Integer.parseInt(scanner.nextLine());


    }

}
