package it.polimi.ingsw.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorTowerTest {
    @Test
    public void getIndexTest(){
        assertEquals(0,ColorTower.Black.getIndex());
    }

}