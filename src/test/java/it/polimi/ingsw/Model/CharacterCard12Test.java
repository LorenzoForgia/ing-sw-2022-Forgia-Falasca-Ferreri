package it.polimi.ingsw.Model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CharacterCard12Test {
   @Test
    public void testUseEffect12(){
       Bag b=new Bag();
       SchoolBoard s1=new SchoolBoard(1,1);
       SchoolBoard s2=new SchoolBoard(2,2);
       SchoolBoard s3=new SchoolBoard(3,3);
       SchoolBoard s4=new SchoolBoard(4,4);
       DeckCardAssistant d1=new DeckCardAssistant();
       DeckCardAssistant d2=new DeckCardAssistant();
       DeckCardAssistant d3=new DeckCardAssistant();
       DeckCardAssistant d4=new DeckCardAssistant();
       Player p1=new Player("A",10,s1,d1);
       Player p2=new Player("B",10,s2,d2);
       Player p3=new Player("C",10,s3,d3);
       Player p4=new Player("D",10,s4,d4);
       s1.getDiningRoom().PutStudent(Color.Red);       /** Player1 has 1 Red students **/
       s1.getDiningRoom().PutStudent(Color.Green);
       s2.getDiningRoom().PutStudent(Color.Red);       /** Player2 has 2 Red students **/
       s2.getDiningRoom().PutStudent(Color.Red);
       s2.getDiningRoom().PutStudent(Color.Blue);
       s3.getDiningRoom().PutStudent(Color.Red);     /** Player3 has 3 Red students **/
       s3.getDiningRoom().PutStudent(Color.Red);
       s3.getDiningRoom().PutStudent(Color.Red);
       s3.getDiningRoom().PutStudent(Color.Pink);
       s4.getDiningRoom().PutStudent(Color.Blue);    /** Player4 has 0 red students**/
       s4.getDiningRoom().PutStudent(Color.Green);
       s4.getDiningRoom().PutStudent(Color.Yellow);
       CharacterCard12 c=new CharacterCard12(12,8,2);
       Player[] ArrPlay=new Player[4];
       ArrPlay[0]=p1;
       ArrPlay[1]=p2;
       ArrPlay[2]=p3;
       ArrPlay[3]=p4;
       assertTrue(b.BagIsEmpty());
       c.useEffect12(Color.Red,ArrPlay,b);
       assertEquals(6,b.getStudents().size());
       assertEquals(0,s1.getDiningRoom().GetNumberStudent(Color.Red));
       assertEquals(1,s1.getDiningRoom().GetNumberStudent());
       assertEquals(0,s2.getDiningRoom().GetNumberStudent(Color.Red));
       assertEquals(1,s2.getDiningRoom().GetNumberStudent());
       assertEquals(0,s3.getDiningRoom().GetNumberStudent(Color.Red));
       assertEquals(1,s3.getDiningRoom().GetNumberStudent());
       assertEquals(0,s4.getDiningRoom().GetNumberStudent(Color.Red));
       assertEquals(3,s4.getDiningRoom().GetNumberStudent());

   }

}