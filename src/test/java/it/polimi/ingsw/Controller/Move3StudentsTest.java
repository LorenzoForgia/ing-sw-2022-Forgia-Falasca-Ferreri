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
    public void setUp(){
        SB = new SchoolBoard(1, 7);
        player = new Player( "player1" , 1, SB, DCA);
        i= new IslandTiles(1, false, 1, false, 0,false);
        m= new Move3Students();
        b= new Bag();
        b.setStudents(50);
        SB.PutStudent(2,b);
    }

    @AfterEach
    public void tearDown() {
        player = null;
        SB = null;
        i= null;
        DeckCardAssistant DCA = null;
        m= null;
        b= null;
    }

    @Test
    public void testMove3Student(){
        m.ChooseIsland(player.getMySchoolBoard().getEntrance().get(0), i,player);
        m.ChooseIsland(player.getMySchoolBoard().getEntrance().get(0),i, player);
        m.ChooseDiningRoom(player.getMySchoolBoard().getEntrance().get(0), player);
        assertEquals(2, i.getStudentsInIsland().size());
        assertEquals(1, player.getMySchoolBoard().getDiningRoom().GetNumberStudent());
        assertEquals(4, player.getMySchoolBoard().GetNumberStudent());
    }


    @Test
    public void testRightProfessorTable(){
       GeneralBoard Gb= new GeneralBoard(0);
       Gb.CreateSchoolBoards(2);
       Gb.getSchoolBoard().get(0).getDiningRoom().PutStudent(Color.Red);
       Gb.getSchoolBoard().get(0).getDiningRoom().PutStudent(Color.Red);
       try {
           Gb.getSchoolBoard().get(0).PutProfessor(Color.Red);
       }catch (IllegalMoveException e){
           fail();
       }
       m.RightProfessorTable(Gb, 2);

       assertEquals(1,Gb.getSchoolBoard().get(0).getProfessorTable().size());
    }

    @Test
    public void testRightProfessorTable2(){
        GeneralBoard Gb= new GeneralBoard(0);
        Gb.CreateSchoolBoards(2);
        Gb.getSchoolBoard().get(0).getDiningRoom().PutStudent(Color.Red);
        Gb.getSchoolBoard().get(0).getDiningRoom().PutStudent(Color.Red);
        Gb.getSchoolBoard().get(0).getDiningRoom().PutStudent(Color.Pink);
        try {
            Gb.getSchoolBoard().get(0).PutProfessor(Color.Red);
        }catch (IllegalMoveException e){
            fail();
        }
        m.RightProfessorTable(Gb, 2);

        assertEquals(2,Gb.getSchoolBoard().get(0).getProfessorTable().size());
    }
}