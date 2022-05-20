package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.messages.AnsFirstPlayerTurnMsg;
import it.polimi.ingsw.messages.AnsGameStartedMsg;
import it.polimi.ingsw.messages.FirstPlayerTurnMsg;
import it.polimi.ingsw.messages.TurnDecidedMsg;

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
        CardAssistant [] ac=CardAssistant.values();
        Boolean flag=false;
        CardAssistant cardAssistant=CardAssistant.Invalid;
        int count=0;
        while(!flag) {
            if(count==0) {
                System.out.println(answerMsg.GetPlayer() + " Gioca una carta assistente!");
            }else{
                System.out.println(" Errore: Gioca una carta assistente valida!");
            }
            String cc= scanner.nextLine();
            for (int i = 0; i < 10 && !flag; i++) {
                if (ac[i].getName().equals(cc)) {
                    cardAssistant = ac[i];
                    flag = true;
                }
            }
            count++;
        }
        TurnDecidedMsg turnDecidedMsg= new TurnDecidedMsg(cardAssistant);
        getOwner().getServerHandler().sendCommandMessage(turnDecidedMsg);
    }
}
