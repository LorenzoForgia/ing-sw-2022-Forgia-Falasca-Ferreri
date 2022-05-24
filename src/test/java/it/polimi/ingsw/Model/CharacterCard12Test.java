package it.polimi.ingsw.Model;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCard12Test {
    CharacterCard12 CC12= null;
    Bag b=null;
    GeneralBoard gb=null;
    Player player1= null;
    Player player2= null;
    Player player3= null;
    SchoolBoard sb1=null;
    SchoolBoard sb2=null;
    SchoolBoard sb3=null;

    @BeforeEach
    public void setUp(){
        CC12= new CharacterCard12(12,1,0,"");
        b= new Bag();
        b.setStudents(120);
        gb= new GeneralBoard(20);
        gb.CreateTwelveIslands();
        player1= new Player("a");
        player2= new Player("b");
        player3= new Player("c");
        sb1= new SchoolBoard(0,9);
        sb2= new SchoolBoard(1,9);
        sb3= new SchoolBoard(2,9);
        player1.setMySchoolBoard(sb1);
        player2.setMySchoolBoard(sb2);
        player3.setMySchoolBoard(sb3);
        sb1.getDiningRoom().PutStudent(Color.Blue);
        sb1.getDiningRoom().PutStudent(Color.Blue);
        sb1.getDiningRoom().PutStudent(Color.Blue);
        sb1.getDiningRoom().PutStudent(Color.Blue);
        sb2.getDiningRoom().PutStudent(Color.Blue);
        sb2.getDiningRoom().PutStudent(Color.Blue);
        sb2.getDiningRoom().PutStudent(Color.Blue);

    }

    @AfterEach
    public void tearDown(){
        CC12 = null;
        b=null;
        gb= null;
        sb1= null;
        sb2= null;
        sb2= null;
        player1= null;
        player2= null;
        player3= null;
    }

    @Test
    public void testUseEffect(){
        ArrayList<Player> players= new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        CC12.SetCard(b,gb);
        CC12.setChosenColor(Color.Blue);
        CC12.setPlayers(players);
        CC12.UseEffect(player1);
        assertTrue(player1.isUsedCharacterCard());
        assertEquals(12,player1.getNameCharacterCard());
        assertEquals(1, sb1.getDiningRoom().GetNumberStudent(Color.Blue));
        assertEquals(0, sb2.getDiningRoom().GetNumberStudent(Color.Blue));
        assertEquals(0, sb3.getDiningRoom().GetNumberStudent(Color.Blue));
    }
}