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
        System.out.println(answerMsg.GetPlayer() + " Gioca una carta assistente!");
        String cc= scanner.nextLine();
        CardAssistant [] ac=CardAssistant.values();
        Boolean flag=false;
        CardAssistant cardAssistant=CardAssistant.Invalid;
        for(int i=0;i<10 && !flag;i++){
            if(ac[i].getName().equals(cc)){
                cardAssistant=ac[i];
                flag=true;
            }
        }
        TurnDecidedMsg turnDecidedMsg= new TurnDecidedMsg(cardAssistant);
        getOwner().getServerHandler().sendCommandMessage(turnDecidedMsg);
    }
}
