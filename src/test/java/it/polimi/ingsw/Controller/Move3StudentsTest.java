package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Move3StudentsTest {
    Player player = null;
    SchoolBoard SB = null;
    IslandTiles i= null;
    DeckCardAssistant DCA = null;
    Move3Students m= null;
    Bag b= null;

    @BeforeEach
    public void setUp() {
        m= new Move3Students();
        player = new Player("A");
        SB= new SchoolBoard(0,7);
        player.setMySchoolBoard(SB);
        b= new Bag();
        b.setStudents(120);
        SB.AddStudent(Color.Red);
        SB.AddStudent(Color.Blue);
        i = new IslandTiles(1,false,1,false,0,false);
    }

    @AfterEach
    public void tearDown() {
        m= null;
    }

    @Test
    public void testMoveMotherNature() {
       m.ChooseLocation(Color.Blue,i, player);
       assertTrue(i.getStudentsInIsland().contains(Color.Blue));
       assertFalse(SB.getEntrance().contains(Color.Blue));
    }

    @Test
    public void testMoveMotherNature2() {
        m.ChooseLocation(Color.Blue,SB.getDiningRoom(), player);
        assertFalse(i.getStudentsInIsland().contains(Color.Blue));
        assertFalse(SB.getEntrance().contains(Color.Blue));
        assertEquals(1,SB.getDiningRoom().GetNumberStudent(Color.Blue));
    }
}