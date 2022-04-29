package it.polimi.ingsw.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCard1Test {
    CharacterCard1 c1=null;
    @BeforeEach
    public void setUp(){
        c1= new CharacterCard1(1,1,0);
    }
    @AfterEach
    public void tearDown(){
        c1 = null;
    }

    @Test
    public void DrawStudentTest(){
        Bag b= new Bag();
        b.setStudents(10);
        c1.DrawStudent(b);
        assertEquals(4,c1.GetchoosenStudent().size());
        
    }
    @Test
    public void PutonislandTest(){
        IslandTiles i= new IslandTiles(1,false,1,false,0,false);
        c1.PutOnIsland(i,Color.Yellow);
        assertEquals(Color.Yellow, i.getStudentsInIsland().get(0));
        assertEquals(1,i.getStudentsInIsland().size());
    }
    @Test
    public void AddstudfrombagTest(){
        Bag b= new Bag();
        b.setStudents(10);
        c1.AddStudFromBag(b);
        assertEquals(1,c1.GetchoosenStudent().size());
    }
}