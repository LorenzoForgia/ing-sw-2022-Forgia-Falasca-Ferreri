package it.polimi.ingsw.Model;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCard11Test {
    CharacterCard11 CC11= null;
    Bag b=null;
    GeneralBoard gb=null;
    Player player= null;
    SchoolBoard sb=null;

    @BeforeEach
    public void setUp(){
        CC11= new CharacterCard11(11,1,0);
        b= new Bag();
        b.setStudents(120);
        gb= new GeneralBoard(20);
        gb.CreateTwelveIslands();
        player= new Player("a");
        sb= new SchoolBoard(0,7);
        player.setMySchoolBoard(sb);

    }

    @AfterEach
    public void tearDown(){
        CC11 = null;
        b=null;
        gb= null;
        sb= null;
        player= null;
    }

    @Test
    public void testUseEffect(){
        CC11.SetCard(b,gb);
        Color chosenColor= CC11.GetchoosenStudent().get(0);
        CC11.setChoosenColor(chosenColor);
        CC11.UseEffect(player);
        assertTrue(player.isUsedCharacterCard());
        assertEquals(11,player.getNameCharacterCard());
        assertEquals(1, sb.getDiningRoom().GetNumberStudent(chosenColor));
    }

}