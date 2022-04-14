package it.polimi.ingsw.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCard2Test {
    CharacterCard2 c2=null;
    @BeforeEach
    public void setUp(){
        c2= new CharacterCard2(2,2,0);
    }
    @AfterEach
    public void tearDown(){
        c2= null;
    }
    @Test
    public void UseeffectTest(){
        assertTrue(c2.UseEffect());
    }
}