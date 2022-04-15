package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class ChoosenPlayer {
    public void ChooseTurnPlayer(ArrayList<CardAssistant> c, Player p){
        for(int i=0;i<c.size();i++){
            for(int j=1;j<c.size();j++){
                if(c.get(i).getCardValue()>c.get(j).getCardValue()){
                    if(p.getMySchoolBoard().GetId()==i){
                        p.SetNumTurn();
                    }
                }
            }
        }
    }
    public void NumMovNM(ArrayList<CardAssistant> a, Player p){
        for(int i=0;i<a.size();i++){
            if(p.getMySchoolBoard().GetId()==i){
                p.SetNumMovNM(a.get(i).getMovementMN());
            }
        }
    }
}

