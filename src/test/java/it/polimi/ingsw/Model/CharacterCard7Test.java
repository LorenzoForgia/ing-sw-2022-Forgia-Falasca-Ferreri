package it.polimi.ingsw.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCard7Test {
    CharacterCard7 CC7 =null;
    @BeforeEach
    public void setUp(){
        CC7= new CharacterCard7(7, 1,0);
    }

    @AfterEach
    public void tearDown(){
        CC7 = null;
    }

    @Test
    public void testSetCard(){
        Bag b1= new Bag();
        b1.setStudents(120);
        CC7.SetCard7(b1);
        assertEquals(6, CC7.GetStudents().size());
    }

    @Test
    public void testUseEffect7(){
        SchoolBoard SB= new SchoolBoard(1,7);
        Bag b1= new Bag();
        b1.setStudents(120);
        ArrayList<Color> a1 = new ArrayList<>();
        ArrayList<Color> a2 = new ArrayList<>();
        Color C;
        SB.AddStudent(Color.Blue);
        CC7.SetCard7(b1);
        C = CC7.GetStudents().get(1);
        a1.add(C);
        a2.add(Color.Blue);

        CC7.useEffect7(a1, a2, SB);
        assertEquals(C,SB.getEntrance().get(0));

    }
}