package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.CloudTiles;
import it.polimi.ingsw.Model.Player;

public class ChooseCloudTiles {
    public void ChoosenCloud(Player p, CloudTiles c){
        int limit=c.getStud().size();
        for(int i=0; i<limit;i++){
            p.getMySchoolBoard().getEntrance().add(c.getStud().get(0));
            c.getStud().remove(0);
        }
    }
}
