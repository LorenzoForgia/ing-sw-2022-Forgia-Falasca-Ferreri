package it.polimi.ingsw.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneralBoardTest {

    GeneralBoard GB =null;
    @BeforeEach
    public void setUp(){
        GB= new GeneralBoard(20);
    }

    @AfterEach
    public void tearDown(){
        GB = null;
    }

    @Test
    public void testCreateTwelveIsland(){
        boolean notnull = false;
        GB.CreateTwelveIslands();
        if(GB.GetIslands().get(0) != null && GB.GetIslands().get(1) != null && GB.GetIslands().get(2) != null && GB.GetIslands().get(3) != null && GB.GetIslands().get(4) != null &&GB.GetIslands().get(5) != null && GB.GetIslands().get(6) != null && GB.GetIslands().get(7) != null && GB.GetIslands().get(8) != null && GB.GetIslands().get(9) != null && GB.GetIslands().get(10) != null && GB.GetIslands().get(11) != null ){
            notnull= true;
        }
        assertTrue(notnull);
    }

    @Test
    public void testCreateClouds(){
        boolean notnull = false;
        GB.CreateClouds(2);
        if(GB.getClouds().get(0)!= null && GB.getClouds().get(1)!= null){
            notnull = true;
        }

        assertTrue(notnull);

    }

    @Test
    public void testCreateSchoolBoard(){
        boolean notnull = false;
        GB.CreateSchoolBoards(2);
        if(GB.getSchoolBoard().get(0)!= null && GB.getSchoolBoard().get(1)!= null){
            notnull = true;
        }
        assertTrue(notnull);
    }

    @Test
    public void testAddCoin() {
        GB.addCoin(3);

        assertEquals(23, GB.getCoin());
    }

    @Test
    public void testRemoveCoin() {
        GB.removeCoin(3);

        assertEquals(17, GB.getCoin());
    }


    @Test
    public void testAddNET() {
        GB.setNoEntryTiles(3);
        GB.addNET();
        assertEquals(4, GB.getNET());
    }
    @Test
    public void testRemoveNET() {
        GB.setNoEntryTiles(4);
        GB.removeNET();
        assertEquals(3, GB.getNET());
    }

    @Test
    public void testCheckNumberOfGroup() {
        int number;
        GB.CreateTwelveIslands();
        number = GB.CheckNumberOfGroup();

        assertEquals(12, number);
    }

    @Test
    public void testMoveMotherNature() {
        GB.CreateTwelveIslands();
        GB.GetIslands().get(1).putMotherNature();
        IslandTiles IslandF = new IslandTiles(3,true,1,false,false);
        IslandTiles Island2;
        Island2=GB.moveMotherNature(GB.GetIslands().get(1),2);
        assertFalse(GB.GetIslands().get(1).isMotherNature());
        assertEquals(IslandF, Island2 );

    }

    @Test
    public void testCheckNearTower(){
        GB.CreateTwelveIslands();
        GB.GetIslands().get(0).putTower(ColorTower.Black);
        GB.GetIslands().get(2).putTower(ColorTower.Black);
        GB.GetIslands().get(1).putTower(ColorTower.Black);
        GB.CheckNearTower(GB.GetIslands().get(1));
        assertEquals(10, GB.CheckNumberOfGroup());
    }

    @Test
    public void testCheckNearTower2(){
        GB.CreateTwelveIslands();
        GB.GetIslands().get(0).putTower(ColorTower.Black);
        GB.GetIslands().get(10).putTower(ColorTower.Black);
        GB.GetIslands().get(11).putTower(ColorTower.Black);
        GB.CheckNearTower(GB.GetIslands().get(11));
        assertEquals(10, GB.CheckNumberOfGroup());
    }

    @Test
    public void testCheckNearTower3(){
        GB.CreateTwelveIslands();
        GB.GetIslands().get(0).putTower(ColorTower.Black);
        GB.GetIslands().get(1).putTower(ColorTower.Black);
        GB.GetIslands().get(11).putTower(ColorTower.Black);
        GB.CheckNearTower(GB.GetIslands().get(0));
        assertEquals(10, GB.CheckNumberOfGroup());
    }

    @Test
    public void testCheckNearTower4(){
        GB.CreateTwelveIslands();
        GB.GetIslands().get(0).putTower(ColorTower.White);
        GB.GetIslands().get(1).putTower(ColorTower.Black);
        GB.GetIslands().get(11).putTower(ColorTower.Black);
        GB.CheckNearTower(GB.GetIslands().get(0));
        assertEquals(11, GB.CheckNumberOfGroup());
    }

    @Test
    public void testCheckNearTower5(){
        GB.CreateTwelveIslands();
        GB.GetIslands().get(0).putTower(ColorTower.White);
        GB.GetIslands().get(1).putTower(ColorTower.Black);
        GB.GetIslands().get(11).putTower(ColorTower.White);
        GB.CheckNearTower(GB.GetIslands().get(0));
        assertEquals(12, GB.CheckNumberOfGroup());
    }
}
