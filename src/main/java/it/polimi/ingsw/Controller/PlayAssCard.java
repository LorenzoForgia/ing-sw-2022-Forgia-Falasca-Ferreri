package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayAssCard {
    private ArrayList<CardAssistant> cards = new ArrayList<CardAssistant>();

    public void GetAssCard(Player p, CardAssistant a, int numplayer) {
                cards.add(a);
                p.setCA(a);
                p.getMyDeck().RemoveCard(a);

    }
    public ArrayList<CardAssistant> GetAssCardPlayed(){
        return cards;
    }

    boolean CheckIfLast(Player p) {
        boolean flag = true;
        for (int i = 0; i < p.getMyDeck().GetDeck().size() && flag; i++) {
            for(int j=0; j< cards.size() && flag ; j++){
                if(!p.getMyDeck().GetDeck().get(i).equals(cards.get(i))){
                    flag = false;
                }
            }
        }
        return  flag;
    }

}
