package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.Bag;
import it.polimi.ingsw.Model.GeneralBoard;

/**
 * @author Federico Angelo Luigi Ferreri
 * **/

public class AddStudentsOnClouds {
    /** If the bag is not empty, add the students on clouds after each turn
     * **/
    public void RestartTurn(GeneralBoard g,Bag b, int numplayer) {
        if (!b.BagIsEmpty()) {
            if (numplayer == 2) {
                for (int i = 0; i < g.getClouds().size(); i++) {
                    g.getClouds().get(i).PutStudents(2, b);
                }
            } else if (numplayer == 3) {
                for (int i = 0; i < g.getClouds().size(); i++) {
                    g.getClouds().get(i).PutStudents(3, b);
                }
            } else if (numplayer == 4) {
                for (int i = 0; i < g.getClouds().size(); i++) {
                    g.getClouds().get(i).PutStudents(4, b);
                }
            }
        }
    }
}
