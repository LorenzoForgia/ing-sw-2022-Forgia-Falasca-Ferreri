package it.polimi.ingsw.Model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CharacterCard9Test {
    @Test
    public void testColorNoEffect1(){
        IslandTiles i=new IslandTiles(1,false,1,false,false);
        i.PutStudent(Color.Red);
        i.PutStudent(Color.Blue);
        i.PutStudent(Color.Yellow);
        i.PutStudent(Color.Red);
        i.PutStudent(Color.Red);
        CharacterCard9 c=new CharacterCard9(9,1,2);
        assertEquals(2,c.ColorNoEffect(i,Color.Red,5));
    }
    @Test
    public void testColorNoEffect2(){
        IslandTiles i=new IslandTiles(1,false,1,true,false);
        i.PutStudent(Color.Red);
        i.PutStudent(Color.Blue);
        i.PutStudent(Color.Yellow);
        i.PutStudent(Color.Red);
        i.PutStudent(Color.Red);
        CharacterCard9 c=new CharacterCard9(9,1,2);
        assertEquals(0,c.ColorNoEffect(i,Color.Red,0));
    }

}