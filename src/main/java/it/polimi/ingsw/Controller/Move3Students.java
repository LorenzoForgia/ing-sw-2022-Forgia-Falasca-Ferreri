package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Model.IslandTiles;
import it.polimi.ingsw.Model.Player;

public class Move3Students {
    public void ChooseIsland(Color c, IslandTiles i, Player p){
        p.getMySchoolBoard().getEntrance().remove(c);
        i.PutStudent(c);
    }
    public void ChooseDiningRoom(Color c,Player p){
        p.getMySchoolBoard().getDiningRoom().PutStudent(c);
        p.getMySchoolBoard().getEntrance().remove(c);
    }
}
