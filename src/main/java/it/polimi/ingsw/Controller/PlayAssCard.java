package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayAssCard {
    private ArrayList<CardAssistant> cards = new ArrayList<CardAssistant>();

    public void GetAssCard(Player p, CardAssistant a) {
                cards.add(a);
                p.setCA(a);
                p.getMyDeck().RemoveCard(a);

    }
    public ArrayList<CardAssistant> GetAssCardPlayed(){
        return cards;
    }

    public void ResetCardPlayed(){
        cards= new ArrayList<>();
    }

    boolean CheckIfLast(Player p) {
        boolean flag = true;
        List<CardAssistant> cards2 = new ArrayList<>();
        cards2.addAll(p.getMyDeck().GetDeck());
        for(int i=0; i < cards.size() && flag ; i ++){
            if(cards2.contains(cards.get(i))) {
                cards2.remove(cards.get(i));
            }
            if(cards2.size()==0){
                flag = false;
            }
        }
        return  (!flag);
    }

}
