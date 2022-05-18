package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InfluenceProfessorTableTest {
    InfluenceProfessorTable IPT = null;
    GeneralBoard GB = null;
    @BeforeEach
    public void setUp() {
        IPT = new InfluenceProfessorTable();
        GB = new GeneralBoard(0);

    }

    @AfterEach
    public void tearDown() {
        IPT = null;
        GB= null;
    }

    @Test
    public void testRightProfessorTable() {
        GB.CreateSchoolBoards(2);
        GB.getSchoolBoard().get(0).getDiningRoom().PutStudent(Color.Blue);
        GB.getSchoolBoard().get(1).getDiningRoom().PutStudent(Color.Red);
        IPT.RightProfessorTable(GB, 2);
        assertTrue(GB.getSchoolBoard().get(0).getProfessorTable().contains(Color.Blue) );
        assertFalse(GB.getSchoolBoard().get(0).getProfessorTable().contains(Color.Red) );
        assertFalse(GB.getSchoolBoard().get(0).getProfessorTable().contains(Color.Pink) );
        assertFalse(GB.getSchoolBoard().get(0).getProfessorTable().contains(Color.Yellow) );
        assertFalse(GB.getSchoolBoard().get(0).getProfessorTable().contains(Color.Green) );
        assertTrue(GB.getSchoolBoard().get(1).getProfessorTable().contains(Color.Red) );
        assertFalse(GB.getSchoolBoard().get(1).getProfessorTable().contains(Color.Blue) );
        assertFalse(GB.getSchoolBoard().get(1).getProfessorTable().contains(Color.Pink) );
        assertFalse(GB.getSchoolBoard().get(1).getProfessorTable().contains(Color.Yellow) );
        assertFalse(GB.getSchoolBoard().get(1).getProfessorTable().contains(Color.Green) );
    }

    @Test
    public void testRightProfessorTable2() {
        GB.CreateSchoolBoards(2);
        GB.getSchoolBoard().get(0).getDiningRoom().PutStudent(Color.Pink);
        GB.getSchoolBoard().get(1).getDiningRoom().PutStudent(Color.Yellow);
        try{
            GB.getSchoolBoard().get(0).PutProfessor(Color.Pink);
        }catch(IllegalMoveException e){
            fail();
        }
        GB.getSchoolBoard().get(1).getDiningRoom().PutStudent(Color.Pink);
        IPT.RightProfessorTable(GB, 2);
        assertFalse(GB.getSchoolBoard().get(0).getProfessorTable().contains(Color.Blue) );
        assertFalse(GB.getSchoolBoard().get(0).getProfessorTable().contains(Color.Red) );
        assertTrue(GB.getSchoolBoard().get(0).getProfessorTable().contains(Color.Pink) );
        assertFalse(GB.getSchoolBoard().get(0).getProfessorTable().contains(Color.Yellow) );
        assertFalse(GB.getSchoolBoard().get(0).getProfessorTable().contains(Color.Green) );
        assertFalse(GB.getSchoolBoard().get(1).getProfessorTable().contains(Color.Red) );
        assertFalse(GB.getSchoolBoard().get(1).getProfessorTable().contains(Color.Blue) );
        assertFalse(GB.getSchoolBoard().get(1).getProfessorTable().contains(Color.Pink) );
        assertTrue(GB.getSchoolBoard().get(1).getProfessorTable().contains(Color.Yellow) );
        assertFalse(GB.getSchoolBoard().get(1).getProfessorTable().contains(Color.Green) );
    }

    @Test
    public void testRightProfessorTable3() {
        GB.CreateSchoolBoards(2);
        GB.getSchoolBoard().get(1).getDiningRoom().PutStudent(Color.Blue);
        GB.getSchoolBoard().get(1).getDiningRoom().PutStudent(Color.Green);
        try{
            GB.getSchoolBoard().get(0).PutProfessor(Color.Blue);
        }catch(IllegalMoveException e){
            fail();
        }
        GB.getSchoolBoard().get(1).getDiningRoom().PutStudent(Color.Blue);
        IPT.RightProfessorTable(GB, 2);
        assertFalse(GB.getSchoolBoard().get(0).getProfessorTable().contains(Color.Blue) );
        assertFalse(GB.getSchoolBoard().get(0).getProfessorTable().contains(Color.Red) );
        assertFalse(GB.getSchoolBoard().get(0).getProfessorTable().contains(Color.Pink) );
        assertFalse(GB.getSchoolBoard().get(0).getProfessorTable().contains(Color.Yellow) );
        assertFalse(GB.getSchoolBoard().get(0).getProfessorTable().contains(Color.Green) );
        assertFalse(GB.getSchoolBoard().get(1).getProfessorTable().contains(Color.Red) );
        assertTrue(GB.getSchoolBoard().get(1).getProfessorTable().contains(Color.Blue) );
        assertFalse(GB.getSchoolBoard().get(1).getProfessorTable().contains(Color.Pink) );
        assertFalse(GB.getSchoolBoard().get(1).getProfessorTable().contains(Color.Yellow) );
        assertTrue(GB.getSchoolBoard().get(1).getProfessorTable().contains(Color.Green) );
    }

    @Test
    public void testRightProfessorTable4() {
        Player p1= new Player("A");
        Player p2= new Player("B");
        GB.CreateSchoolBoards(2);
        p1.setMySchoolBoard(GB.getSchoolBoard().get(0));
        p2.setMySchoolBoard(GB.getSchoolBoard().get(1));
        GB.getSchoolBoard().get(0).getDiningRoom().PutStudent(Color.Pink);
        GB.getSchoolBoard().get(1).getDiningRoom().PutStudent(Color.Yellow);
        try{
            GB.getSchoolBoard().get(0).PutProfessor(Color.Pink);
        }catch(IllegalMoveException e){
            fail();
        }
        GB.getSchoolBoard().get(1).getDiningRoom().PutStudent(Color.Pink);
        IPT.RightProfessorTable(GB, 2, p2);
        assertFalse(GB.getSchoolBoard().get(0).getProfessorTable().contains(Color.Blue) );
        assertFalse(GB.getSchoolBoard().get(0).getProfessorTable().contains(Color.Red) );
        assertFalse(GB.getSchoolBoard().get(0).getProfessorTable().contains(Color.Pink) );
        assertFalse(GB.getSchoolBoard().get(0).getProfessorTable().contains(Color.Yellow) );
        assertFalse(GB.getSchoolBoard().get(0).getProfessorTable().contains(Color.Green) );
        assertFalse(GB.getSchoolBoard().get(1).getProfessorTable().contains(Color.Red) );
        assertFalse(GB.getSchoolBoard().get(1).getProfessorTable().contains(Color.Blue) );
        assertTrue(GB.getSchoolBoard().get(1).getProfessorTable().contains(Color.Pink) );
        assertTrue(GB.getSchoolBoard().get(1).getProfessorTable().contains(Color.Yellow) );
        assertFalse(GB.getSchoolBoard().get(1).getProfessorTable().contains(Color.Green) );
    }
}