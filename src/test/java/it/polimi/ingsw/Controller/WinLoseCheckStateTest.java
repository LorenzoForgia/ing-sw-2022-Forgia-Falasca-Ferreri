package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WinLoseCheckStateTest {
    WinLoseCheckState w= null;
    GeneralBoard g= null;
    Player p1= null;
    Player p2= null;
    Player p3= null;
    SchoolBoard SB1 = null;
    SchoolBoard SB2 = null;
    SchoolBoard SB3 = null;
    DeckCardAssistant DCA1 = null;
    DeckCardAssistant DCA2 = null;
    DeckCardAssistant DCA3 = null;

    @BeforeEach
    public void setUp(){
        w= new WinLoseCheckState();
        g= new GeneralBoard(20);
        SB1 = new SchoolBoard(0, 9);
        SB2 = new SchoolBoard(1, 9);
        SB3 = new SchoolBoard(2, 9);
        DCA1 = new DeckCardAssistant();
        DCA2 = new DeckCardAssistant();
        DCA3 = new DeckCardAssistant();
        SB1.setColorTower(ColorTower.Black);
        SB2.setColorTower(ColorTower.White);
        SB3.setColorTower(ColorTower.Grey);
        p1=new Player("A");
        p1.setMySchoolBoard(SB1);
        p1.setNumberCoins(1);
        p1.setMyDeck(DCA1);
        p2=new Player("B");
        p2.setMySchoolBoard(SB2);
        p2.setNumberCoins(1);
        p2.setMyDeck(DCA2);
        p3=new Player("C");
        p3.setMySchoolBoard(SB3);
        p3.setNumberCoins(1);
        p3.setMyDeck(DCA3);
        SB1.setNumberOfTower(6);
        SB2.setNumberOfTower(6);
        SB3.setNumberOfTower(6);
        g.CreateSchoolBoards(3);
    }

    @AfterEach
    public void tearDown(){
        w= null;
        g= null;
        p1= null;
        p2= null;
        p3= null;
        SB1 = null;
        SB2 = null;
        SB3 = null;
        DCA1 = null;
        DCA2 = null;
        DCA3 = null;
    }
    @Test
    public void testCheckWinTowerBlack(){
        g.CreateTwelveIslands();
        g.GetIslands().get(0).putTower(ColorTower.Black);
        g.GetIslands().get(2).putTower(ColorTower.Black);
        g.GetIslands().get(3).putTower(ColorTower.Black);
        g.GetIslands().get(6).putTower(ColorTower.White);
        g.GetIslands().get(8).putTower(ColorTower.White);
        g.GetIslands().get(10).putTower(ColorTower.Grey);
        assertTrue(w.CheckIfWinWithTower(p1, g));
        assertFalse(w.CheckIfWinWithTower(p2,g));
        assertFalse(w.CheckIfWinWithTower(p3, g));
        assertTrue(w.CheckIfWin(p1, g));
        assertFalse(w.CheckIfWin(p2, g));
        assertFalse(w.CheckIfWin(p3, g));
    }
    @Test
    public void testCheckWinTowerWhite(){
        g.CreateTwelveIslands();
        g.GetIslands().get(0).putTower(ColorTower.White);
        g.GetIslands().get(2).putTower(ColorTower.Black);
        g.GetIslands().get(3).putTower(ColorTower.Black);
        g.GetIslands().get(6).putTower(ColorTower.White);
        g.GetIslands().get(8).putTower(ColorTower.White);
        g.GetIslands().get(10).putTower(ColorTower.Grey);
        assertTrue(w.CheckIfWinWithTower(p2, g));
        assertFalse(w.CheckIfWinWithTower(p1,g));
        assertFalse(w.CheckIfWinWithTower(p3, g));
        assertTrue(w.CheckIfWin(p2, g));
        assertFalse(w.CheckIfWin(p1, g));
        assertFalse(w.CheckIfWin(p3, g));
    }
    @Test
    public void testCheckWinTowerGrey(){
        g.CreateTwelveIslands();
        g.GetIslands().get(0).putTower(ColorTower.Grey);
        g.GetIslands().get(2).putTower(ColorTower.Black);
        g.GetIslands().get(3).putTower(ColorTower.Grey);
        g.GetIslands().get(6).putTower(ColorTower.White);
        g.GetIslands().get(8).putTower(ColorTower.White);
        g.GetIslands().get(10).putTower(ColorTower.Grey);
        assertTrue(w.CheckIfWinWithTower(p3, g));
        assertFalse(w.CheckIfWinWithTower(p2,g));
        assertFalse(w.CheckIfWinWithTower(p1, g));
        assertTrue(w.CheckIfWin(p3, g));
        assertFalse(w.CheckIfWin(p2, g));
        assertFalse(w.CheckIfWin(p1, g));
    }
    @Test
    public void testCheckWinProf(){
      try {
          g.getSchoolBoard().get(0).PutProfessor(Color.Red);
          g.getSchoolBoard().get(0).PutProfessor(Color.Green);
          g.getSchoolBoard().get(0).PutProfessor(Color.Pink);
          g.getSchoolBoard().get(1).PutProfessor(Color.Blue);
          g.getSchoolBoard().get(0).PutProfessor(Color.Yellow);
      }catch (IllegalMoveException e){
          fail();
      }
       
       assertTrue(w.CheckIfWinWithProfessor(p1, g));
       assertFalse(w.CheckIfWinWithProfessor(p2, g));
       assertFalse(w.CheckIfWinWithProfessor(p3, g));
       assertTrue(w.CheckIfWin(p1, g));
       assertFalse(w.CheckIfWin(p2, g));
       assertFalse(w.CheckIfWin(p3, g));
    }

    @Test
    public void testCheckWinner(){
      p1.getMySchoolBoard().RemoveTower();
      p2.getMySchoolBoard().RemoveTower();
      p2.getMySchoolBoard().RemoveTower();
      ArrayList<SchoolBoard> schoolBoards= new ArrayList<>();
      ArrayList<Player> players = new ArrayList<>();
      ArrayList<Boolean> winners;
      schoolBoards.add(0,SB1);
      schoolBoards.add(1,SB2);
      schoolBoards.add(2,SB3);
      players.add(0,p1);
      players.add(1,p2);
      players.add(2,p3);
      winners= w.CheckWinner(players,schoolBoards);
      assertFalse(winners.get(0));
      assertFalse(winners.get(2));
      assertTrue(winners.get(1));
    }


    @Test
    public void testCheckWinner2(){
        p1.getMySchoolBoard().RemoveTower();
        p2.getMySchoolBoard().RemoveTower();
        p2.getMySchoolBoard().RemoveTower();
        p3.getMySchoolBoard().RemoveTower();
        p3.getMySchoolBoard().RemoveTower();
        ArrayList<SchoolBoard> schoolBoards= new ArrayList<>();
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Boolean> winners;
        schoolBoards.add(0,SB1);
        schoolBoards.add(1,SB2);
        schoolBoards.add(2,SB3);
        players.add(0,p1);
        players.add(1,p2);
        players.add(2,p3);
        try {
            g.getSchoolBoard().get(2).PutProfessor(Color.Red);
            g.getSchoolBoard().get(2).PutProfessor(Color.Green);
            g.getSchoolBoard().get(0).PutProfessor(Color.Pink);
            g.getSchoolBoard().get(0).PutProfessor(Color.Blue);
            g.getSchoolBoard().get(0).PutProfessor(Color.Yellow);
        }catch (IllegalMoveException e){
            fail();
        }
        winners= w.CheckWinner(players,schoolBoards);

        assertFalse(winners.get(0));
        assertFalse(winners.get(1));
        assertTrue(winners.get(2));
    }

}