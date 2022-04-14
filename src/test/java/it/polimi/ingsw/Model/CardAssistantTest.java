package it.polimi.ingsw.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardAssistantTest {
    @Test
    public void GetcardvalueTest(){
        assertEquals(9,CardAssistant.Dieci.getCardValue());
    }
    @Test
    public void GetmovementMNTest(){
        assertEquals(5,CardAssistant.Dieci.getMovementMN());
    }

}