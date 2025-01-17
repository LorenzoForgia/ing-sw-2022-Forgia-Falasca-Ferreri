package it.polimi.ingsw.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchoolBoardTest {
    @Test
    public void PutProfessorTest(){
        SchoolBoard s= new SchoolBoard(1, 7);
        try {
            s.PutProfessor(Color.Red);
        }catch (IllegalMoveException e){
            fail();
        }
        assertEquals(Color.Red, s.getProfessorTable().get(0));
    }

    @Test
    public void PutProfessorTes2t(){
        SchoolBoard s= new SchoolBoard(1, 7);
        boolean thrown= false;
        try {
            s.PutProfessor(Color.Red);
        }catch (IllegalMoveException e){
            fail();
        }
        try {
            s.PutProfessor(Color.Red);
        }catch (IllegalMoveException e){
            thrown= true;
        }
        assertEquals(Color.Red, s.getProfessorTable().get(0));
        assertTrue(thrown);
    }

    @Test
    public void RemoveProfessorTest(){
        SchoolBoard s= new SchoolBoard(1, 7);
        try {
            s.PutProfessor(Color.Red);
        }catch(IllegalMoveException e){
            fail();
        }
        s.RemoveProfessor(Color.Red);
        assertEquals(0,s.getProfessorTable().size());
    }

    @Test
    public void RemoveProfessorTest2() {
        SchoolBoard s = new SchoolBoard(1, 7);
        int i=0;
        try {
            s.PutProfessor(Color.Red);
            s.PutProfessor(Color.Blue);
        }catch(IllegalMoveException e){
            fail();
        }

        i=s.getProfessorTable().size();
        s.RemoveProfessor(Color.Red);
        assertEquals(i-1, s.getProfessorTable().size());
    }
    @Test
    public void RemoveProfessorTest3() {
        SchoolBoard s = new SchoolBoard(1, 7);
        try {
            s.PutProfessor(Color.Red);
            s.PutProfessor(Color.Blue);
        }catch(IllegalMoveException e){
            fail();
        }
        s.RemoveProfessor(Color.Red);
        assertEquals(Color.Blue, s.getProfessorTable().get(0));
    }
    @Test
    public void PutTowerTest() {
        SchoolBoard s = new SchoolBoard(1, 7);
        int i = 0;
        i = s.getNumberOfTower();
        s.PutTower();
        assertEquals(i + 1, s.getNumberOfTower());
    }
    @Test
    public void ColorTowerTest(){
        SchoolBoard s = new SchoolBoard(1, 7);
        s.setColorTower(ColorTower.Black);
        assertEquals(ColorTower.Black, s.ColorTower());
    }
    @Test
    public void PutStudentTest(){
        SchoolBoard s = new SchoolBoard(1, 7);
        Bag b= new Bag();
        b.setStudents(10);
        s.PutStudent(2,b);
        assertEquals(7, s.GetNumberStudent());
    }
    @Test
    public void PutStudentTest2() {
        SchoolBoard s = new SchoolBoard(1, 7);
        Bag b = new Bag();
        b.setStudents(10);
        s.PutStudent(3, b);
        assertEquals(9, s.GetNumberStudent());
    }
    @Test
    public void PutStudentTest3() {
        SchoolBoard s = new SchoolBoard(1, 7);
        Bag b = new Bag();
        b.setStudents(10);
        s.PutStudent(4, b);
        assertEquals(7, s.GetNumberStudent());
    }
    @Test
    public void RemoveStudentTest() {
        SchoolBoard s = new SchoolBoard(1, 7);
        s.AddStudent(Color.Red);
        s.RemoveStudent(Color.Red);
        assertEquals(0, s.GetNumberStudent());
    }
    @Test
    public void RemoveStudentTest2() {
        SchoolBoard s = new SchoolBoard(1, 7);
        int i=0;
        s.AddStudent(Color.Red);
        s.AddStudent(Color.Blue);
        i=s.GetNumberStudent();
        s.RemoveStudent(Color.Red);
        assertEquals(i-1, s.GetNumberStudent());
    }
    @Test
    public void AddStudentTest(){
        SchoolBoard s = new SchoolBoard(1, 7);
        int i=0;
        i= s.GetNumberStudent();
        s.AddStudent(Color.Red);
        assertEquals(i+1, s.GetNumberStudent());
    } 


}