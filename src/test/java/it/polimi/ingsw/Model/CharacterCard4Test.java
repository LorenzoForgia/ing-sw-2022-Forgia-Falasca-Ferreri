package it.polimi.ingsw.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCard4Test {
    CharacterCard4 c4=null;
    @BeforeEach
    public void setUp(){
        c4= new CharacterCard4(4,1,0);
    }
    @AfterEach
    public void tearDown(){
        c4= null;
    }
    @Test
    public void AddtwomvntNMTest(){
       c4.AddTwoMvntMN(CardAssistant.Cinque);
       assertEquals(5, CardAssistant.Cinque.getMovementMN()+2);
    }
}