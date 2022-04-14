package it.polimi.ingsw.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiningRoomTest {
    @Test
    public void GetNumberStudentTest(){
        DiningRoom d= new DiningRoom();
        assertEquals(0,d.GetNumberStudent());
        d.PutStudent(Color.Green);
        d.PutStudent(Color.Green);
        d.PutStudent(Color.Red);
        assertEquals(3,d.GetNumberStudent());
        assertEquals(2,d.GetNumberStudent(Color.Green));
        assertEquals(1,d.GetNumberStudent(Color.Red));
    }
    @Test
    public void PutStudentTest(){
        DiningRoom d= new DiningRoom();
        d.PutStudent(Color.Red);
        assertEquals(1,d.GetNumberStudent(Color.Red));
    }
    @Test
    public void PutStudentTest2() {
        DiningRoom d = new DiningRoom();
        d.PutStudent(Color.Red);
        assertEquals(1, d.GetNumberStudent(Color.Red));
    }
    @Test
    public void RemoveStudent(){
        DiningRoom d = new DiningRoom();
        d.PutStudent(Color.Red);
        d.RemoveStudent(Color.Red);
        assertEquals(0, d.GetNumberStudent(Color.Red));
    }
    @Test
    public void RemoveStudent2(){
        DiningRoom d = new DiningRoom();
        int i=0;
        d.PutStudent(Color.Red);
        d.PutStudent(Color.Blue);
        assertEquals(1,d.GetNumberStudent(Color.Red));
        assertEquals(1,d.GetNumberStudent(Color.Blue));
        d.RemoveStudent(Color.Red);
        assertEquals(0, d.GetNumberStudent(Color.Red));
    }

    @Test
    public void GetCoinTest(){
        DiningRoom d = new DiningRoom();
        d.PutStudent(Color.Red);
        d.PutStudent(Color.Red);
        d.PutStudent(Color.Red);
        assertTrue(d.GetCoin(Color.Red));
    }
    @Test
    public void GetCoinTest2(){
        DiningRoom d = new DiningRoom();
        d.PutStudent(Color.Red);
        d.PutStudent(Color.Red);
        d.PutStudent(Color.Red);
        d.PutStudent(Color.Red);
        d.PutStudent(Color.Red);
        d.PutStudent(Color.Red);
        assertTrue(d.GetCoin(Color.Red));
    }
    @Test
    public void GetCoinTest3(){
        DiningRoom d = new DiningRoom();
        d.PutStudent(Color.Red);
        d.PutStudent(Color.Red);
        d.PutStudent(Color.Red);
        d.PutStudent(Color.Red);
        d.PutStudent(Color.Red);
        d.PutStudent(Color.Red);
        d.PutStudent(Color.Red);
        d.PutStudent(Color.Red);
        d.PutStudent(Color.Red);
        assertTrue(d.GetCoin(Color.Red));
    }
    @Test
    public void GetCoinTest4(){
        DiningRoom d = new DiningRoom();
        d.PutStudent(Color.Red);
        d.PutStudent(Color.Red);
        assertFalse(d.GetCoin(Color.Red));
    }

}