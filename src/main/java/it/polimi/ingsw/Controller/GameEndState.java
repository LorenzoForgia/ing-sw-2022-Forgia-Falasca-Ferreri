package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.Bag;
import it.polimi.ingsw.Model.GeneralBoard;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.SchoolBoard;

import java.util.*;
/**
 * @author Luigia Falasca and Federico Angelo Luigi Ferreri
 * **/

public class GameEndState {
    private boolean flagImmediately = false;
    private boolean flagNotImmediately = false;

    /** Check if the game has to end immediately because all the towers where placed or because there are three or
     * fewer groups of Islands
     * **/
    public boolean CheckEndGameImmediately(GeneralBoard g, List<SchoolBoard> SBWithTowers) {

       for(int i=0; i < SBWithTowers.size(); i++){
           if(SBWithTowers.get(i).getNumberOfTower()<=0){
               flagImmediately = true;
           }
       }

        if (g.GetIslands().size() <= 3) {
                flagImmediately = true;
            }

        return flagImmediately;

    }

    /** Check if the game has to end at the end of the turn because the bag is Empty
     * **/
    public void CheckEndGameRoundEndedForBag( Bag b){
        if(b.BagIsEmpty()){
            flagNotImmediately = true;
        }
    }

    /** Check if the game has to end at the end of the turn because there are no more
     * CardAssistant to play
     * **/
    public void CheckEndGameRoundEndedForCardAssistant(Player p){
         if(p.getMyDeck().GetDeck().size()==0){
            flagNotImmediately = true;
        }
    }

    /** Return if the game has to end immediately
     * **/
    public boolean isFlagImmediately() {
        return flagImmediately;
    }

    /** Return if the game has to end at the end of the turn
     * **/

    public boolean isFlagNotImmediately() {
        return flagNotImmediately;
    }
}
