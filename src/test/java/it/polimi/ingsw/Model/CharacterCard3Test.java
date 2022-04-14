package it.polimi.ingsw.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCard3Test {
    CharacterCard3 c3=null;
    @BeforeEach
    public void setUp(){
        c3= new CharacterCard3(3,3,0);
    }
    @AfterEach
    public void tearDown(){
        c3= null;
    }
    @Test
    public void UseeffectTest() {
        assertTrue(c3.UseEffect());
    }
}