package it.polimi.ingsw.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class IslandTilesTest {

    IslandTiles Island = null;
    @BeforeEach
    public void setUp(){
        Island = new IslandTiles(1, false, 1, false, false);
    }

    @AfterEach
    public void tearDown(){
        Island = null;
    }

    @Test
    public void testPutMN() {
        Island.putMotherNature();
        assertTrue(Island.isMotherNature());
    }

    @Test
    public void testPutNET() {

        try {
            Island.putNET();
            assertTrue(Island.isNoEntryTiles());
        } catch (IllegalMoveException e) {
            fail();
        }
    }

    @Test
    public void testPutNET2() {
        try {
            Island.putNET();
        } catch (IllegalMoveException e) {
            fail();
        }

           boolean thrown = false;
           try {
               Island.putNET();
           }catch( IllegalMoveException e){
               thrown= true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testRemoveMN() {
        Island.putMotherNature();
        Island.removeNM();
        assertFalse(Island.isMotherNature());
    }

    @Test
    public void testRemoveNET() {
        try {
            Island.putNET();
        } catch (IllegalMoveException e) {
            fail();
        }

        try {
            Island.removeNET();
            assertFalse(Island.isNoEntryTiles());
        } catch (IllegalMoveException e) {
            fail();
        }
    }

    @Test
    public void testRemoveNET2() {
        boolean thrown = false;
        try {
            Island.removeNET();

        } catch (IllegalMoveException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }




    @Test
    public void tesPutTower() {
        Island.putTower(ColorTower.Black);
        assertTrue(Island.isTower());
        assertEquals(ColorTower.Black, Island.getColTower());
    }


    @Test
    public void tesSetStudent() {
        ArrayList<Color> Students = new ArrayList<>();
        Students.add(Color.Blue);
        Students.add(Color.Pink);
        Students.add(Color.Yellow);
        Students.add(Color.Green);
        Students.add(Color.Blue);
        Students.add(Color.Red);
        Students.add(Color.Yellow);

        Island.setStudentsInIsland(Students);
        assertArrayEquals(Students.toArray(), Island.getStudentsInIsland().toArray());
    }

    @Test
    public void testCountInfluence(){
        int count;
        ArrayList<Color> Students = new ArrayList<>();
        Students.add(Color.Blue);
        Students.add(Color.Pink);
        Students.add(Color.Yellow);
        Students.add(Color.Green);
        Students.add(Color.Blue);
        Students.add(Color.Red);
        Students.add(Color.Yellow);
        Island.setStudentsInIsland(Students);

        count=Island.CountInfluence(Color.Yellow);
        assertEquals(2, count);
    }
    @Test
    public void testPutStudent(){
        Island.PutStudent(Color.Green);
        Island.PutStudent(Color.Yellow);
        assertEquals(2, Island.getStudentsInIsland().size());
        assertEquals(Color.Yellow, Island.GetStudent(1));
    }

}

