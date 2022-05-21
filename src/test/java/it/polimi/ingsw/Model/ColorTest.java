package it.polimi.ingsw.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorTest {
    @Test
    public void getIndexTest(){
        assertEquals(0,Color.Green.getIndex());
        assertEquals("Green",Color.Green.getName());
        assertEquals("\u001B[32m",Color.Green.getEscape());
        Color.Green.toString();
    }

}