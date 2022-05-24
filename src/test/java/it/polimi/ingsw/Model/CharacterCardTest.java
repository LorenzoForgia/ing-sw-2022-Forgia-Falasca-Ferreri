package it.polimi.ingsw.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCardTest {
    @Test
    public void CharactercardTest(){
        CharacterCard c= new CharacterCard1(1,1,0,"");
        assertEquals(1,c.getName());
        assertEquals(0,c.getCountUse());
        assertEquals(1,c.getCost());
        c.setCountUse();
        assertEquals(1,c.getCountUse());
        assertEquals(2,c.getCost());
    }




}