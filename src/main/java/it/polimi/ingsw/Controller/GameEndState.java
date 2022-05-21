package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.Bag;
import it.polimi.ingsw.Model.GeneralBoard;
import it.polimi.ingsw.Model.Player;

public class GameEndState {
    private boolean flagImmediately = false;
    private boolean flagNotImmediately = false;
    public boolean CheckEndGameImmediately(Player p, GeneralBoard g) {
        if (p.getMySchoolBoard().getNumberOfTower() == 0){
            flagImmediately  = true;
            return true;
        } else if(g.GetIslands().size() <= 3){
            flagImmediately  = true;
            return true;
        }else{return false;}
    }

    public void CheckEndGameRoundEndedForBag( Bag b){
        if(b.BagIsEmpty()){
            flagNotImmediately = true;
        }
    }
    public void CheckEndGameRoundEndedForCardAssistant(Player p){
         if(p.getMyDeck().GetDeck().size()==0){
            flagNotImmediately = true;
        }
    }

    public boolean isFlagImmediately() {
        return flagImmediately;
    }

    public boolean isFlagNotImmediately() {
        return flagNotImmediately;
    }
}
