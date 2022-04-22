package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class PlayAssCard {
    private ArrayList<CardAssistant> cards = new ArrayList<CardAssistant>();

    public void GetAssCard(Player p, CardAssistant a, int numplayer) {
        for (int i = 0; i < numplayer; i++) {
            if (p.getMySchoolBoard().GetId() == i) {
                cards.add(a);
                p.setCA(a);
                p.getMyDeck().RemoveCard(a);

            }
        }
    }
    public ArrayList<CardAssistant> GetAssCardPlayed(){
        return cards;
    }
}
