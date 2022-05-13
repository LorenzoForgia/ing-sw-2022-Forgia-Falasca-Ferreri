package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.*;

import java.util.List;

public class Move3Students {
    public void ChooseLocation(Color c, Location i, Player p) {
        p.getMySchoolBoard().getEntrance().remove(c);
        i.PutStudent(c);
    }

}


