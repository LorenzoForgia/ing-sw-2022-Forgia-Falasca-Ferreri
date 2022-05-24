package it.polimi.ingsw.Model;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CharacterCard9Test {

    CharacterCard9 CC9= null;
    Bag b=null;
    GeneralBoard gb=null;
    Player player= null;

    @BeforeEach
    public void setUp(){
        CC9= new CharacterCard9(9,1,0,"");
        b= new Bag();
        b.setStudents(20);
        gb= new GeneralBoard(20);
        gb.CreateTwelveIslands();
        player= new Player("a");
    }

    @AfterEach
    public void tearDown(){
        CC9 = null;
        b=null;
        gb= null;
    }

    @Test
    public void testUseEffect(){
        CC9.SetCard(b,gb);
        CC9.UseEffect(player);
        assertTrue(player.isUsedCharacterCard());
        assertEquals(9,player.getNameCharacterCard());
    }
}