package it.polimi.ingsw.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCard7Test {
    CharacterCard7 CC7= null;
    Bag b=null;
    GeneralBoard gb=null;
    Player player= null;
    SchoolBoard sb=null;

    @BeforeEach
    public void setUp(){
        CC7= new CharacterCard7(7,1,0);
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
        sb.AddStudent(Color.Blue);
        sb.AddStudent(Color.Blue);
        sb.AddStudent(Color.Blue);

    }

    @AfterEach
    public void tearDown(){
        CC7 = null;
        b=null;
        gb= null;
        sb= null;
        player = null;
    }

    @Test
    public void testUseEffect(){
        ArrayList<Color> chosenColor= new ArrayList<>();
        ArrayList<Color> chosenColor2= new ArrayList<>();
        ArrayList<Color> chosenEntrance= new ArrayList<>();
        CC7.SetCard(b,gb);
        CC7.setStudentOnEntrance(sb.getEntrance());
        chosenColor.add(CC7.getStudentOnCard().get(0));
        chosenColor.add(CC7.getStudentOnCard().get(1));
        chosenColor.add(CC7.getStudentOnCard().get(2));
        chosenColor.add(CC7.getStudentOnCard().get(3));
        chosenColor.add(CC7.getStudentOnCard().get(4));
        chosenColor.add(CC7.getStudentOnCard().get(5));
        chosenColor2.addAll(chosenColor);
        chosenEntrance.addAll(sb.getEntrance());
        CC7.setStudentChoosen(chosenColor);
        CC7.UseEffect(player);
        assertTrue(player.isUsedCharacterCard());
        assertEquals(7,player.getNameCharacterCard());
        assertTrue(CC7.getStudentOnCard().containsAll(chosenEntrance));
        assertTrue(sb.getEntrance().containsAll(chosenColor2));
    }
}