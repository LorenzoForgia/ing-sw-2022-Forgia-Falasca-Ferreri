package it.polimi.ingsw.Controller;
import it.polimi.ingsw.Model.*;
import java.util.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SetupTest {
    @Test
    public void testSetTowers1(){  /**case of 2 or 4 Players**/
        SchoolBoard s1=new SchoolBoard(1,1);
        SchoolBoard s2=new SchoolBoard(2,2);
        List<SchoolBoard> ls=new ArrayList<>();
        ls.add(s1);
        ls.add(s2);
        Setup su=new Setup();
        su.SetTowers(4,ls);
        assertEquals(8,s1.getNumberOfTower());
        assertEquals(8,s2.getNumberOfTower());
    }
    @Test
    public void testSetTowers2(){  /**case of 3 Players**/
        SchoolBoard s1=new SchoolBoard(1,1);
        SchoolBoard s2=new SchoolBoard(2,2);
        SchoolBoard s3=new SchoolBoard(3,3);
        List<SchoolBoard> ls=new ArrayList<>();
        ls.add(s1);
        ls.add(s2);
        ls.add(s3);
        Setup su=new Setup();
        su.SetTowers(3,ls);
        assertEquals(6,s1.getNumberOfTower());
        assertEquals(6,s2.getNumberOfTower());
        assertEquals(6,s3.getNumberOfTower());
    }

   @Test
    public void testCreateGeneralBoard(){
       Setup s=new Setup();
       GeneralBoard gb=s.CreateGeneralboard(true,4);
       assertEquals(12,gb.GetIslands().size());
       assertEquals(4,gb.getClouds().size());
       assertEquals(4,gb.getSchoolBoard().size());
   }

    @Test
    public void testSetPutstudentsInIslands1(){ /**corner case MN in last position**/
        Setup s=new Setup();
        Bag b=s.CreateBag();
        s.SetBag(b,1);
        assertEquals(10,b.getStudents().size());
        GeneralBoard gb=s.CreateGeneralboard(true,4);
        s.SetMNto1Island(11,gb);
        s.SetupStudentsInIslands(b,11,gb.GetIslands());
        s.SetBag(b,2);
        assertEquals(120,b.getStudents().size());
    }
    @Test
    public void testSetPutstudentsInIslands2(){ /**corner case MN in last position**/
        Setup s=new Setup();
        Bag b=s.CreateBag();
        s.SetBag(b,1);
        assertEquals(10,b.getStudents().size());
        GeneralBoard gb=s.CreateGeneralboard(false,4);
        s.SetMNto1Island(2,gb);
        s.SetupStudentsInIslands(b,2,gb.GetIslands());
        s.SetBag(b,2);
        assertEquals(120,b.getStudents().size());
    }

    @Test
    public void testChooseSchoolBoardWithTowers(){
        Setup s=new Setup();

        GeneralBoard gb=s.CreateGeneralboard(false,4);
        gb.getSchoolBoard().get(0).setColorTower(ColorTower.Black);
        gb.getSchoolBoard().get(1).setColorTower(ColorTower.White);
        gb.getSchoolBoard().get(2).setColorTower(ColorTower.Black);
        gb.getSchoolBoard().get(3).setColorTower(ColorTower.White);
        s.ChooseSchoolBoardWithTowers(gb,4);
       assertTrue(s.getSBWithTowers().contains( gb.getSchoolBoard().get(1)));
        assertTrue(s.getSBWithTowers().contains( gb.getSchoolBoard().get(0)));
        assertFalse(s.getSBWithTowers().contains( gb.getSchoolBoard().get(2)));
        assertFalse(s.getSBWithTowers().contains( gb.getSchoolBoard().get(3)));

    }

    @Test
    public void testChooseSchoolBoardWithTowers2(){
        Setup s=new Setup();

        GeneralBoard gb=s.CreateGeneralboard(false,3);
        gb.getSchoolBoard().get(0).setColorTower(ColorTower.Black);
        gb.getSchoolBoard().get(1).setColorTower(ColorTower.White);
        gb.getSchoolBoard().get(2).setColorTower(ColorTower.Grey);
        s.ChooseSchoolBoardWithTowers(gb,3);
        assertTrue(s.getSBWithTowers().contains( gb.getSchoolBoard().get(1)));
        assertTrue(s.getSBWithTowers().contains( gb.getSchoolBoard().get(0)));
        assertTrue(s.getSBWithTowers().contains( gb.getSchoolBoard().get(2)));


    }

}