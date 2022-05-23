package it.polimi.ingsw.Model;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class CharacterCard10Test {
    CharacterCard10 CC10= null;
    Bag b=null;
    GeneralBoard gb=null;
    Player player= null;
    SchoolBoard sb=null;

    @BeforeEach
    public void setUp(){
        CC10= new CharacterCard10(10,1,0);
        b= new Bag();
        b.setStudents(120);
        gb= new GeneralBoard(20);
        gb.CreateTwelveIslands();
        player= new Player("a");
        sb= new SchoolBoard(0,7);
        player.setMySchoolBoard(sb);
        sb.AddStudent(Color.Blue);
        sb.AddStudent(Color.Pink);
        sb.AddStudent(Color.Pink);
        sb.getDiningRoom().PutStudent(Color.Red);
        sb.getDiningRoom().PutStudent(Color.Red);
        sb.getDiningRoom().PutStudent(Color.Red);

    }

    @AfterEach
    public void tearDown(){
        CC10 = null;
        b=null;
        gb= null;
        sb= null;
        player= null;
    }

    @Test
    public void testUseEffect(){
        ArrayList<Color> chosenColorDining = new ArrayList<>();
        ArrayList<Color> chosenEntrance = new ArrayList<>();
        CC10.SetCard(b,gb);
        chosenEntrance.addAll(sb.getEntrance());
        CC10.setStudentOnEntrance(chosenEntrance);

        chosenColorDining.add(Color.Red);
        chosenColorDining.add(Color.Red);
        chosenColorDining.add(Color.Red);
        CC10.setStudentOnDiningRoom(chosenColorDining);
        CC10.UseEffect(player);
        assertTrue(player.isUsedCharacterCard());
        assertEquals(10,player.getNameCharacterCard());
        assertEquals(2, sb.getDiningRoom().GetNumberStudent(Color.Pink));
        assertEquals(1, sb.getDiningRoom().GetNumberStudent(Color.Blue));
        assertEquals(0, sb.getDiningRoom().GetNumberStudent(Color.Red));
        assertTrue(sb.getEntrance().contains(Color.Red));
        assertEquals(3,sb.getEntrance().size());
    }

}