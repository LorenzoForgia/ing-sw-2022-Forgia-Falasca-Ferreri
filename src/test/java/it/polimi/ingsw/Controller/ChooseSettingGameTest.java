package it.polimi.ingsw.Controller;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ChooseSettingGameTest {
    @Test
    public void testChooseSettingGame(){
        ChooseSettingGame c=new ChooseSettingGame(2,false);
        assertFalse(c.isModExpert());
        assertEquals(2,c.getNumPlayers());
    }
}