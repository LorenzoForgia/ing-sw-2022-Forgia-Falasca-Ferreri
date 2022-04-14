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
        GB.CreateTwelveIslands();

        assertEquals(12, GB.GetIslands().size());
    }

    @Test
    public void testCreateClouds(){
        GB.CreateClouds(2);
        assertEquals(2, GB.getClouds().size());

    }

    @Test
    public void testCreateSchoolBoard(){

        GB.CreateSchoolBoards(2);
        assertEquals(2, GB.getSchoolBoard().size());
    }

    @Test
    public void testCreateSchoolBoard2(){

        GB.CreateSchoolBoards(3);
        assertEquals(3, GB.getSchoolBoard().size());
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
        IslandTiles Island2;
        Island2=GB.moveMotherNature(GB.GetIslands().get(1),2);
        assertFalse(GB.GetIslands().get(1).isMotherNature());
        assertEquals(3, Island2.getNumberID());
       assertTrue( Island2.isMotherNature());
    }

    @Test
    public void testMoveMotherNature2() {
        GB.CreateTwelveIslands();
        GB.GetIslands().get(11).putMotherNature();
        IslandTiles Island2;
        Island2=GB.moveMotherNature(GB.GetIslands().get(11),2);
        assertFalse(GB.GetIslands().get(11).isMotherNature());
        assertEquals(1, Island2.getNumberID());
        assertTrue( Island2.isMotherNature());
    }
 /*   @Test
    public void testSetNewGroup(){
        IslandTiles i1=new IslandTiles(1,false,1,false,false);
        IslandTiles i2=new IslandTiles(2,true,1,false,false);
        i1.PutStudent(Color.Red);
        i1.PutStudent(Color.Blue);
        i1.PutStudent(Color.Red);
        i2.PutStudent(Color.Blue);
        GB.SetNewGroup(i1, i2);
        assertEquals(2, i1.getSize());
        assertEquals(4,i1.getStudentsInIsland().size());
        assertTrue(i1.isMotherNature());
        assertFalse(i1.isNoEntryTiles());
    }
    @Test
    public void testSetNewGroup2(){
        int i;
        GB.CreateTwelveIslands();
        GB.GetIslands().get(0).PutStudent(Color.Green);
        GB.GetIslands().get(0).PutStudent(Color.Green);
        GB.GetIslands().get(0).PutStudent(Color.Blue);
        GB.GetIslands().get(1).PutStudent(Color.Blue);
        i=GB.GetIslands().size();
        GB.SetNewGroup(GB.GetIslands().get(0), GB.GetIslands().get(1));
        assertEquals(4,GB.GetIslands().get(0).getStudentsInIsland().size());
        assertEquals(11, GB.GetIslands().size());
    }

  */

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
        GB.GetIslands().get(0).PutStudent(Color.Green);
        GB.GetIslands().get(0).PutStudent(Color.Green);
        GB.GetIslands().get(0).PutStudent(Color.Blue);
        GB.GetIslands().get(11).PutStudent(Color.Blue);
        GB.GetIslands().get(10).putMotherNature();
        GB.GetIslands().get(0).putTower(ColorTower.Black);
        GB.GetIslands().get(10).putTower(ColorTower.Black);
        GB.GetIslands().get(11).putTower(ColorTower.Black);
        GB.CheckNearTower(GB.GetIslands().get(11));
        assertEquals(10, GB.CheckNumberOfGroup());
    }

    @Test
    public void testCheckNearTower3(){
        GB.CreateTwelveIslands();
        try{
            GB.GetIslands().get(1).putNET();
        }catch(IllegalMoveException e){
            fail();
        }
        GB.GetIslands().get(0).putTower(ColorTower.Black);
        GB.GetIslands().get(1).putTower(ColorTower.Black);
        GB.GetIslands().get(11).putTower(ColorTower.Black);
        GB.CheckNearTower(GB.GetIslands().get(0));
        assertEquals(10, GB.CheckNumberOfGroup());
    }

    @Test
    public void testCheckNearTower4(){
        GB.CreateTwelveIslands();
        try{
            GB.GetIslands().get(1).putNET();
        }catch(IllegalMoveException e){
            fail();
        }
        try{
            GB.GetIslands().get(11).putNET();
        }catch(IllegalMoveException e){
            fail();
        }

        GB.GetIslands().get(0).putTower(ColorTower.Black);
        GB.GetIslands().get(1).putTower(ColorTower.White);
        GB.GetIslands().get(11).putTower(ColorTower.Black);
        GB.CheckNearTower(GB.GetIslands().get(0));
        assertEquals(11, GB.CheckNumberOfGroup());
    }

    @Test
    public void testCheckNearTower5(){
        GB.CreateTwelveIslands();
        GB.GetIslands().get(0).putTower(ColorTower.White);
        GB.GetIslands().get(1).putTower(ColorTower.Black);
        GB.GetIslands().get(11).putTower(ColorTower.Grey);
        GB.CheckNearTower(GB.GetIslands().get(0));
        assertEquals(12, GB.CheckNumberOfGroup());
    }

    @Test
    public void testCheckNearTower6(){
        GB.CreateTwelveIslands();
        GB.GetIslands().get(0).putTower(ColorTower.White);
        GB.CheckNearTower(GB.GetIslands().get(0));
        assertEquals(12, GB.CheckNumberOfGroup());
    }

}
