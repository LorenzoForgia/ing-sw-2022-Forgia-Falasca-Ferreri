package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.Bag;
import it.polimi.ingsw.Model.GeneralBoard;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.SchoolBoard;

import java.util.*;

public class GameEndState {
    private boolean flagImmediately = false;
    private boolean flagNotImmediately = false;


    public boolean CheckEndGameImmediately(Player p, GeneralBoard g, List<SchoolBoard> SBWithTowers, int nPlayers) {
        boolean notFound= true;
        if(nPlayers==4){
            for(int i=0; i< SBWithTowers.size() && notFound; i++){
                if(p.getMySchoolBoard().ColorTower().equals(SBWithTowers.get(i).ColorTower())){
                    notFound= false;
                    if(SBWithTowers.get(i).getNumberOfTower()==0){
                        flagImmediately = true;
                    }
                }
            }
        }else {
            if (p.getMySchoolBoard().getNumberOfTower() == 0) {
                flagImmediately = true;
            }
        }

        if (g.GetIslands().size() <= 3) {
                flagImmediately = true;
            }

        return flagImmediately;

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
