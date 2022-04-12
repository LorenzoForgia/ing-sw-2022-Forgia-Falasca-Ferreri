package it.polimi.ingsw.Model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BagTest {
   @Test
   public void testsetStudents1(){
       Bag b1=new Bag();
       Bag b2=new Bag();
       b1.PutStudent(Color.Green);
       b1.PutStudent(Color.Green);
       b1.PutStudent(Color.Red);
       b1.PutStudent(Color.Red);
       b1.PutStudent(Color.Yellow);
       b1.PutStudent(Color.Yellow);
       b1.PutStudent(Color.Pink);
       b1.PutStudent(Color.Pink);
       b1.PutStudent(Color.Blue);
       b1.PutStudent(Color.Blue);
       b2.setStudents(10);
       assertEquals(b1.getStudents(),(b2.getStudents()));
   }

   @Test public void testCatchStudent1(){
        Bag b1=new Bag();
        b1.PutStudent(Color.Red);
        assertEquals(b1.CatchStudent(),Color.Red);

   }

    @Test public void testCatchStudent2(){
        Bag b1=new Bag();
        b1.PutStudent(Color.Red);
        assertNotEquals(b1.CatchStudent(),Color.Yellow);

    }
    @Test public void testBagIsEmpty1() {
       Bag b=new Bag();
       assertTrue(b.BagIsEmpty());
    }

    @Test public void testBagIsEmpty2() {
        Bag b=new Bag();
        b.PutStudent(Color.Yellow);
        assertFalse((b.BagIsEmpty()));
    }

    @Test public void testBagIsEmpty3() {
        Bag b=new Bag();
        b.PutStudent(Color.Yellow);
        b.CatchStudent();
        assertTrue((b.BagIsEmpty()));
    }

}