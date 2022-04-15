package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.Bag;
import it.polimi.ingsw.Model.GeneralBoard;
import it.polimi.ingsw.Model.Player;

public class GameEndState {
    public boolean CheckEndGameImmediately(Player p, GeneralBoard g) {
        if (p.getMySchoolBoard().getNumberOfTower() == 0){
            return true;
        } else if(g.GetIslands().size() == 3){
            return true;
        }else{return false;}
    }
    public boolean CheckEndGameRoundEnded(Player p, GeneralBoard g, Bag b){
        if(b.BagIsEmpty()){
            return true;
        }else if(p.getMyDeck().GetDeck().size()==0){
            return true;
        }else{return false;}
    }
}
