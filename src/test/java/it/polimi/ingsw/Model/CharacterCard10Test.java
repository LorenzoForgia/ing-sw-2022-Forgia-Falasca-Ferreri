package it.polimi.ingsw.Model;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class CharacterCard10Test {
   @Test
    void testEffectchangeStudents(){
       
        CharacterCard10 c10=new CharacterCard10(10,1,1);
        List<Color> entrancestud= new ArrayList<Color>();
        List<Color> diningstud= new ArrayList<Color>();
        SchoolBoard s=new SchoolBoard(1,7);
        s.AddStudent(Color.Red);
        s.AddStudent(Color.Blue);
        s.AddStudent(Color.Pink);
        s.getDiningRoom().PutStudent(Color.Yellow);
        s.getDiningRoom().PutStudent(Color.Green);
        entrancestud.add(Color.Red);
        entrancestud.add(Color.Blue);
        diningstud.add(Color.Yellow);
        diningstud.add(Color.Green);
        c10.EffectchangeStudents(entrancestud,diningstud,s);
       assertEquals(2,s.getDiningRoom().GetNumberStudent());
        assertEquals(1,s.getDiningRoom().GetNumberStudent(Color.Red));
        assertEquals(1,s.getDiningRoom().GetNumberStudent(Color.Blue));
        assertEquals(3,s.GetNumberStudent());
        assertEquals(1,s.GetNumberStudent(Color.Yellow));
        assertEquals(1,s.GetNumberStudent(Color.Green));
        assertEquals(1,s.GetNumberStudent(Color.Pink));
    }



}