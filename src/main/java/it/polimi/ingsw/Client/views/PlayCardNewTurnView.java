package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.Model.IslandTiles;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.SchoolBoard;
import it.polimi.ingsw.messages.AnsNewOrderMsg;
import it.polimi.ingsw.messages.AnsNewTurnMsg;
import it.polimi.ingsw.messages.TurnDecidedMsg;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayCardNewTurnView extends View{
    AnsNewOrderMsg answerMsg;
    public PlayCardNewTurnView(AnsNewOrderMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        Displayer d=new Displayer();
        ArrayList<Player> pl=new ArrayList<>();
        ArrayList<SchoolBoard> sb=new ArrayList<>();
        ArrayList<IslandTiles> is=new ArrayList<>();
        for(int i=0;i<answerMsg.getPl().size();i++){
            pl.add(answerMsg.getPl().get(i));
        }
        for(int i=0;i<answerMsg.getSb().size();i++){
            sb.add(answerMsg.getSb().get(i));
        }
        d.displayAllSchoolboard(sb,pl);
        for(int i=0;i<answerMsg.getIs().size();i++){
            is.add(answerMsg.getIs().get(i));
        }
        d.showAllIsland(is);
        ArrayList<CardAssistant> ca=new ArrayList<>();
        for(int i=0;i<answerMsg.getDca().GetDeck().size();i++){
            ca.add(answerMsg.getDca().GetDeck().get(i));
        }
        d.showAllAssistantCard(ca);
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
