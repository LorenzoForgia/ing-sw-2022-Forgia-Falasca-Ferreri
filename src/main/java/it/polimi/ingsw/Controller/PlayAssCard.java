package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Luigia Falasca and Federico Angelo Luigi Ferreri
 * **/
public class PlayAssCard {
    private ArrayList<CardAssistant> cards = new ArrayList<CardAssistant>();

    /** When AssistantCard is played, this method remove it from the deck,
     * add in the list of played cards and saves it in Player Class
     * **/
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

    /** Check if the player has left different Assistant cards form played Assistant cards
     * return false if the player has them, true if the player doesn't have them
     * **/
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
