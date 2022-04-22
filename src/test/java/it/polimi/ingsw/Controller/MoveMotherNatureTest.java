package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoveMotherNatureTest {
    MoveMotherNature MMN = null;

    @BeforeEach
    public void setUp() {
        MMN = new MoveMotherNature();
    }

    @AfterEach
    public void tearDown() {
        MMN = null;
    }

    @Test
    public void testIfIslandCanGetControlled() {
        boolean flag;
        IslandTiles IT = new IslandTiles(1, true, 1, false, false);
        GeneralBoard GB = new GeneralBoard(0);
        IT.PutStudent(Color.Red);
        IT.PutStudent(Color.Red);
        IT.PutStudent(Color.Green);
        IT.PutStudent(Color.Blue);
        IT.PutStudent(Color.Blue);
        IT.PutStudent(Color.Yellow);
        MMN.SetIslandWithMotherNature(IT);
        GB.CreateSchoolBoards(2);
        GB.getSchoolBoard().get(0).setColorTower(ColorTower.Black);
        GB.getSchoolBoard().get(1).setColorTower(ColorTower.White);
        GB.getSchoolBoard().get(0).PutProfessor(Color.Blue);
        GB.getSchoolBoard().get(0).PutProfessor(Color.Red);
        GB.getSchoolBoard().get(1).PutProfessor(Color.Green);
        GB.getSchoolBoard().get(1).PutProfessor(Color.Yellow);
        flag = MMN.CheckIfIslandGetControlled(2, GB, IT);
        assertTrue(flag);
    }

    @Test
    public void testIfIslandCanGetControlled2() {
        boolean flag;
        IslandTiles IT = new IslandTiles(1, true, 1, false, false);
        GeneralBoard GB = new GeneralBoard(0);
        IT.putTower(ColorTower.Grey);
        IT.PutStudent(Color.Red);
        IT.PutStudent(Color.Red);
        IT.PutStudent(Color.Green);
        IT.PutStudent(Color.Blue);
        IT.PutStudent(Color.Blue);
        IT.PutStudent(Color.Yellow);
        MMN.SetIslandWithMotherNature(IT);
        GB.CreateSchoolBoards(3);
        GB.getSchoolBoard().get(0).setColorTower(ColorTower.Black);
        GB.getSchoolBoard().get(1).setColorTower(ColorTower.White);
        GB.getSchoolBoard().get(2).setColorTower(ColorTower.Grey);
        GB.getSchoolBoard().get(0).PutProfessor(Color.Blue);
        GB.getSchoolBoard().get(0).PutProfessor(Color.Yellow);
        GB.getSchoolBoard().get(1).PutProfessor(Color.Green);
        GB.getSchoolBoard().get(1).PutProfessor(Color.Red);
        flag = MMN.CheckIfIslandGetControlled(3, GB, IT);
        assertFalse(flag);
    }

    @Test
    public void testGetRightTowerOnIsland() {
        boolean flag;
        IslandTiles IT;
        GeneralBoard GB = new GeneralBoard(0);
        GB.CreateTwelveIslands();
        List<SchoolBoard> schoolBoardList = new ArrayList<>();
        IT = GB.GetIslands().get(1);
        IT.PutStudent(Color.Red);
        IT.PutStudent(Color.Red);
        IT.PutStudent(Color.Green);
        IT.PutStudent(Color.Blue);
        IT.PutStudent(Color.Blue);
        IT.PutStudent(Color.Yellow);
        MMN.SetIslandWithMotherNature(IT);
        GB.CreateSchoolBoards(2);
        GB.getSchoolBoard().get(0).setColorTower(ColorTower.Black);
        GB.getSchoolBoard().get(1).setColorTower(ColorTower.White);
        GB.getSchoolBoard().get(0).setNumberOfTower(8);
        GB.getSchoolBoard().get(1).setNumberOfTower(8);
        GB.getSchoolBoard().get(0).PutProfessor(Color.Blue);
        GB.getSchoolBoard().get(0).PutProfessor(Color.Red);
        GB.getSchoolBoard().get(1).PutProfessor(Color.Green);
        GB.getSchoolBoard().get(1).PutProfessor(Color.Yellow);
        schoolBoardList.add(0, GB.getSchoolBoard().get(0));
        schoolBoardList.add(1, GB.getSchoolBoard().get(1));
        flag = MMN.CheckIfIslandGetControlled(2, GB, IT);
        assertTrue(flag);
        MMN.GetRightTowerOnIsland(GB, IT,schoolBoardList);
        assertEquals(ColorTower.Black, IT.getColTower());
        assertEquals(7, GB.getSchoolBoard().get(0).getNumberOfTower());
    }


    @Test
    public void testGetRightTowerOnIsland2() {
        boolean flag;
        IslandTiles IT;
        GeneralBoard GB = new GeneralBoard(0);
        GB.CreateTwelveIslands();
        List<SchoolBoard> schoolBoardList = new ArrayList<>();
        IT = GB.GetIslands().get(1);
        IT.putTower(ColorTower.Black);
        IT.PutStudent(Color.Red);
        IT.PutStudent(Color.Red);
        IT.PutStudent(Color.Green);
        IT.PutStudent(Color.Blue);
        IT.PutStudent(Color.Blue);
        IT.PutStudent(Color.Yellow);
        MMN.SetIslandWithMotherNature(IT);
        GB.CreateSchoolBoards(2);
        GB.getSchoolBoard().get(0).setColorTower(ColorTower.Black);
        GB.getSchoolBoard().get(1).setColorTower(ColorTower.White);
        GB.getSchoolBoard().get(0).setNumberOfTower(8);
        GB.getSchoolBoard().get(1).setNumberOfTower(8);
        GB.getSchoolBoard().get(0).PutProfessor(Color.Blue);
        GB.getSchoolBoard().get(0).PutProfessor(Color.Red);
        GB.getSchoolBoard().get(1).PutProfessor(Color.Green);
        GB.getSchoolBoard().get(1).PutProfessor(Color.Yellow);
        schoolBoardList.add(0, GB.getSchoolBoard().get(0));
        schoolBoardList.add(1, GB.getSchoolBoard().get(1));
        flag = MMN.CheckIfIslandGetControlled(2, GB, IT);
        assertTrue(flag);
        MMN.GetRightTowerOnIsland(GB, IT, schoolBoardList);
        assertEquals(ColorTower.Black, IT.getColTower());
        assertEquals(8, GB.getSchoolBoard().get(0).getNumberOfTower());
    }

    @Test
    public void testGetRightTowerOnIsland3() {
        boolean flag;
        IslandTiles IT;
        GeneralBoard GB = new GeneralBoard(0);
        GB.CreateTwelveIslands();
        List<SchoolBoard> schoolBoardList = new ArrayList<>();
        IT = GB.GetIslands().get(1);
        IT.putTower(ColorTower.White);
        IT.PutStudent(Color.Red);
        IT.PutStudent(Color.Red);
        IT.PutStudent(Color.Green);
        IT.PutStudent(Color.Blue);
        IT.PutStudent(Color.Blue);
        IT.PutStudent(Color.Yellow);
        MMN.SetIslandWithMotherNature(IT);
        GB.CreateSchoolBoards(2);
        GB.getSchoolBoard().get(0).setColorTower(ColorTower.Black);
        GB.getSchoolBoard().get(1).setColorTower(ColorTower.White);
        GB.getSchoolBoard().get(0).setNumberOfTower(8);
        GB.getSchoolBoard().get(1).setNumberOfTower(8);
        GB.getSchoolBoard().get(0).PutProfessor(Color.Blue);
        GB.getSchoolBoard().get(0).PutProfessor(Color.Red);
        GB.getSchoolBoard().get(1).PutProfessor(Color.Green);
        GB.getSchoolBoard().get(1).PutProfessor(Color.Yellow);
        schoolBoardList.add(0, GB.getSchoolBoard().get(0));
        schoolBoardList.add(1, GB.getSchoolBoard().get(1));
        flag = MMN.CheckIfIslandGetControlled(2, GB,  IT);
        assertTrue(flag);
        MMN.GetRightTowerOnIsland(GB, IT, schoolBoardList);
        assertEquals(ColorTower.Black, IT.getColTower());
        assertEquals(7, GB.getSchoolBoard().get(0).getNumberOfTower());
        assertEquals(9, GB.getSchoolBoard().get(1).getNumberOfTower());
    }

    @Test
    public void testGetRightTowerOnIsland4() {
        boolean flag;
        IslandTiles IT;
        GeneralBoard GB = new GeneralBoard(0);
        GB.CreateTwelveIslands();
        List<SchoolBoard> schoolBoardList = new ArrayList<>();
        IT = GB.GetIslands().get(1);
        IT.putTower(ColorTower.White);
        IT.PutStudent(Color.Red);
        IT.PutStudent(Color.Red);
        IT.PutStudent(Color.Green);
        IT.PutStudent(Color.Blue);
        IT.PutStudent(Color.Blue);
        IT.PutStudent(Color.Yellow);
        MMN.SetIslandWithMotherNature(IT);
        GB.CreateSchoolBoards(4);
        GB.getSchoolBoard().get(0).setColorTower(ColorTower.Black);
        GB.getSchoolBoard().get(1).setColorTower(ColorTower.White);
        GB.getSchoolBoard().get(2).setColorTower(ColorTower.Black);
        GB.getSchoolBoard().get(3).setColorTower(ColorTower.White);
        GB.getSchoolBoard().get(0).setNumberOfTower(8);
        GB.getSchoolBoard().get(1).setNumberOfTower(8);
        GB.getSchoolBoard().get(0).PutProfessor(Color.Blue);
        GB.getSchoolBoard().get(2).PutProfessor(Color.Red);
        GB.getSchoolBoard().get(1).PutProfessor(Color.Green);
        GB.getSchoolBoard().get(3).PutProfessor(Color.Yellow);
        schoolBoardList.add(0, GB.getSchoolBoard().get(0));
        schoolBoardList.add(1, GB.getSchoolBoard().get(1));
        flag = MMN.CheckIfIslandGetControlled(4, GB, IT);
        assertTrue(flag);
        MMN.GetRightTowerOnIsland(GB,IT, schoolBoardList);
        assertEquals(ColorTower.Black, IT.getColTower());
        assertEquals(7, GB.getSchoolBoard().get(0).getNumberOfTower());
        assertEquals(9, GB.getSchoolBoard().get(1).getNumberOfTower());
    }

    @Test
    public void testGetRightTowerOnIsland5() {
        boolean flag;
        IslandTiles IT;
        GeneralBoard GB = new GeneralBoard(0);
        GB.CreateTwelveIslands();
        List<SchoolBoard> schoolBoardList = new ArrayList<>();
        IT = GB.GetIslands().get(1);
        IT.putTower(ColorTower.White);
        IT.PutStudent(Color.Red);
        IT.PutStudent(Color.Red);
        IT.PutStudent(Color.Green);
        IT.PutStudent(Color.Blue);
        IT.PutStudent(Color.Blue);
        IT.PutStudent(Color.Yellow);
        MMN.SetIslandWithMotherNature(IT);
        GB.CreateSchoolBoards(4);
        GB.getSchoolBoard().get(0).setColorTower(ColorTower.Black);
        GB.getSchoolBoard().get(2).setColorTower(ColorTower.White);
        GB.getSchoolBoard().get(1).setColorTower(ColorTower.Black);
        GB.getSchoolBoard().get(3).setColorTower(ColorTower.White);
        GB.getSchoolBoard().get(0).setNumberOfTower(8);
        GB.getSchoolBoard().get(2).setNumberOfTower(7);
        GB.getSchoolBoard().get(0).PutProfessor(Color.Blue);
        GB.getSchoolBoard().get(1).PutProfessor(Color.Red);
        GB.getSchoolBoard().get(2).PutProfessor(Color.Green);
        GB.getSchoolBoard().get(3).PutProfessor(Color.Yellow);
        schoolBoardList.add(0, GB.getSchoolBoard().get(0));
        schoolBoardList.add(1, GB.getSchoolBoard().get(2));
        flag = MMN.CheckIfIslandGetControlled(4, GB, IT);
        assertTrue(flag);
        MMN.GetRightTowerOnIsland(GB,IT, schoolBoardList);
        assertEquals(ColorTower.Black, IT.getColTower());
        assertEquals(7, GB.getSchoolBoard().get(0).getNumberOfTower());
        assertEquals(8, GB.getSchoolBoard().get(2).getNumberOfTower());
    }
}