package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.CloudTiles;
import it.polimi.ingsw.Model.Player;

public class ChooseCloudTiles {
    public void ChoosenCloud(Player p, CloudTiles c){
        for(int i=0; i<c.getStud().size();i++){
            p.getMySchoolBoard().getEntrance().add(c.getStud().get(i));
        }
        for(int i=0; i<c.getStud().size();i++){
           c.getStud().remove(i);
        }
    }
}
