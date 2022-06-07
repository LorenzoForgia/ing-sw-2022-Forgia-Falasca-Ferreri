package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.*;

/**
 * @author Federico Angelo Luigi Ferreri
 * **/
public class Move3Students {

    /** Move the students from the entrance to the chosen location
     * **/
    public void ChooseLocation(Color c, Location i, Player p) {
        p.getMySchoolBoard().getEntrance().remove(c);
        i.PutStudent(c);
    }

}


