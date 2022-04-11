package it.polimi.ingsw.Model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class IslandTilesTest {
    @Test
    public void testPutMN() {
        IslandTiles Island = new IslandTiles(1, false, 1, false, false);
        Island.putMotherNature();
        assertTrue(Island.isMotherNature());
    }

    @Test
    public void testPutNET() {
        IslandTiles Island = new IslandTiles(1, false, 1, false, false);
        try {
            Island.putNET();
            assertTrue(Island.isNoEntryTiles());
        } catch (IllegalMoveException e) {
            fail();
        }
    }

    @Test
    public void testPutNet2() {
        IslandTiles Island = new IslandTiles(1, false, 1, true, false);
        try {
            Island.putNET();
            fail();
        } catch (IllegalMoveException e) {
            assertTrue(Island.isNoEntryTiles());
        }
    }

    @Test
    public void testRemoveMN() {
        IslandTiles Island = new IslandTiles(1, true, 1, false, false);
        Island.removeNM();
        assertFalse(Island.isMotherNature());
    }

    @Test
    public void testRemoveNET() {
        IslandTiles Island = new IslandTiles(1, false, 1, true, false);
        try {
            Island.removeNET();
            assertFalse(Island.isNoEntryTiles());
        } catch (IllegalMoveException e) {
            fail();
        }
    }

    @Test
    public void testRemoveNET2() {
        IslandTiles Island = new IslandTiles(1, false, 1, true, false);
        try {
            Island.removeNET();
            fail();
        } catch (IllegalMoveException e) {
            assertTrue(Island.isNoEntryTiles());
        }
    }


    @Test
    public void testGetSize() {
        IslandTiles Island = new IslandTiles(1, false, 1, false, false);
        assertEquals(1, Island.getSize());
    }


    @Test
    public void tesSetColor() {
        IslandTiles Island = new IslandTiles(1, false, 1, false, true);
        Island.setColTower(ColorTower.Black);
        assertEquals(ColorTower.Black, Island.getColTower());
    }


    @Test
    public void tesSetStudent() {
        IslandTiles Island = new IslandTiles(1, false, 1, false, false);
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

}

