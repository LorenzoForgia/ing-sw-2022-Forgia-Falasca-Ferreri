package it.polimi.ingsw.Model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CloudTilesTest {
    @Test
    public void testPutStudent1(){
        CloudTiles c=new CloudTiles(1);
        assertEquals(1,c.getNumid());
        Bag b1=new Bag();
        b1.PutStudent(Color.Green);
        b1.PutStudent(Color.Red);
        b1.PutStudent(Color.Blue);
        b1.PutStudent(Color.Yellow);
        c.PutStudents(3,b1);
        assertTrue(b1.BagIsEmpty());
        assertEquals(4,c.getStud().size());
    }
    @Test
    public void testPutStudent2(){
        CloudTiles c=new CloudTiles(1);
        Bag b1=new Bag();
        b1.PutStudent(Color.Green);
        b1.PutStudent(Color.Red);
        b1.PutStudent(Color.Blue);
        c.PutStudents(4,b1);
        assertTrue(b1.BagIsEmpty());
        assertEquals(3,c.getStud().size());
    }

    @Test
    public void testCatchStudent(){
        CloudTiles c=new CloudTiles(0);
        Bag b1=new Bag();
        b1.PutStudent(Color.Green);
        b1.PutStudent(Color.Red);
        b1.PutStudent(Color.Blue);
        c.PutStudents(4,b1);
        assertEquals(3,c.CatchStudent().size());
        assertEquals(0,c.getStud().size());
    }

}