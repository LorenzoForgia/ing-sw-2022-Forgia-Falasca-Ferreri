package it.polimi.ingsw.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameModelTest {


    @Test
    void gameModelTest() {
        GameModel gm=new GameModel();
        Player p1=new Player("A");
        Player p2=new Player("B");
        gm.addPlayer(p1);
        gm.addPlayer(p2);
        Bag b=new Bag();
        gm.setBag(b);
        assertEquals(2,gm.getPlayers().size());
        gm.setModExpert(true);
        assertEquals(true,gm.getModExpert());
        gm.setNumplayers(2);
        assertEquals(2,gm.getNumplayers());

    }

}