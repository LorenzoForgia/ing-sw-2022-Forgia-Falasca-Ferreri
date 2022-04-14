package it.polimi.ingsw.Model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CharacterCard11Test {
   @Test
   public void testDraft4Students(){
       Bag b=new Bag();
       b.PutStudent(Color.Green);
       b.PutStudent(Color.Yellow);
       b.PutStudent(Color.Blue);
       b.PutStudent(Color.Pink);
       CharacterCard11 c=new CharacterCard11(11,1,1);
       assertEquals(0,c.getStudents().size());
       c.draft4students(b);
       assertEquals(true,b.BagIsEmpty());
       assertEquals(4,c.getStudents().size());
   }
/*
    @Test
    */
}