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
    Player p4= null;
    SchoolBoard SB1 = null;
    SchoolBoard SB2 = null;
    SchoolBoard SB3 = null;
    SchoolBoard SB4= null;
    DeckCardAssistant DCA1 = null;
    DeckCardAssistant DCA2 = null;
    DeckCardAssistant DCA3 = null;
    DeckCardAssistant DCA4 = null;

    @BeforeEach
    public void setUp(){
        w= new WinLoseCheckState();
        g= new GeneralBoard(20);
        SB1 = new SchoolBoard(0, 9);
        SB2 = new SchoolBoard(1, 9);
        SB3 = new SchoolBoard(2, 9);
        SB4 = new SchoolBoard(3, 9);
        DCA1 = new DeckCardAssistant();
        DCA2 = new DeckCardAssistant();
        DCA3 = new DeckCardAssistant();
        DCA4 = new DeckCardAssistant();
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
        p4= new Player("D");
        p4.setMySchoolBoard(SB4);
        p4.setNumberCoins(1);
        p4.setMyDeck(DCA4);
    }

    @AfterEach
    public void tearDown(){
        w= null;
        g= null;
        p1= null;
        p2= null;
        p3= null;
        p4= null;
        SB1 = null;
        SB2 = null;
        SB3 = null;
        SB4= null;
        DCA1 = null;
        DCA2 = null;
        DCA3 = null;
        DCA4 = null;
    }

    @Test
    public void testCheckWinnerWithoutCheckingProfessor(){
      SB1.setColorTower(ColorTower.Black);
      SB2.setColorTower(ColorTower.White);
      SB3.setColorTower(ColorTower.Grey);
      SB1.setNumberOfTower(6);
      SB2.setNumberOfTower(6);
      SB3.setNumberOfTower(6);
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
    public void testCheckWinnerCheckingProfessor4players(){
        SB1.setColorTower(ColorTower.Black);
        SB2.setColorTower(ColorTower.White);
        SB3.setColorTower(ColorTower.Black);
        SB4.setColorTower(ColorTower.White);
        SB1.setNumberOfTower(8);
        SB2.setNumberOfTower(8);
        p1.getMySchoolBoard().RemoveTower();
        p2.getMySchoolBoard().RemoveTower();
        ArrayList<SchoolBoard> schoolBoards= new ArrayList<>();
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Boolean> winners;
        schoolBoards.add(0,SB1);
        schoolBoards.add(1,SB2);
        players.add(0,p1);
        players.add(1,p2);
        players.add(2,p3);
        players.add(3,p4);
        try {
            players.get(2).getMySchoolBoard().PutProfessor(Color.Red);
            players.get(1).getMySchoolBoard().PutProfessor(Color.Green);
            players.get(0).getMySchoolBoard().PutProfessor(Color.Pink);
            players.get(3).getMySchoolBoard().PutProfessor(Color.Blue);
        }catch (IllegalMoveException e){
            fail();
        }
        winners= w.CheckWinner(players,schoolBoards);
        assertTrue(winners.get(0));
        assertTrue(winners.get(1));
        assertTrue(winners.get(2));
        assertTrue(winners.get(3));
    }

    @Test
    public void testCheckWinnerCheckingProfessor3players(){
        SB1.setColorTower(ColorTower.Black);
        SB2.setColorTower(ColorTower.White);
        SB3.setColorTower(ColorTower.Grey);
        SB1.setNumberOfTower(6);
        SB2.setNumberOfTower(6);
        SB3.setNumberOfTower(6);
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
            schoolBoards.get(2).PutProfessor(Color.Red);
            schoolBoards.get(2).PutProfessor(Color.Green);
            schoolBoards.get(0).PutProfessor(Color.Pink);
            schoolBoards.get(0).PutProfessor(Color.Blue);
            schoolBoards.get(0).PutProfessor(Color.Yellow);
        }catch (IllegalMoveException e){
            fail();
        }
        winners= w.CheckWinner(players,schoolBoards);

        assertFalse(winners.get(0));
        assertFalse(winners.get(1));
        assertTrue(winners.get(2));
    }

    @Test
    public void testCheckWinnerCheckingProfessor2players(){
        SB1.setColorTower(ColorTower.Black);
        SB2.setColorTower(ColorTower.White);
        SB1.setNumberOfTower(8);
        SB2.setNumberOfTower(8);
        p1.getMySchoolBoard().RemoveTower();
        p2.getMySchoolBoard().RemoveTower();
        ArrayList<SchoolBoard> schoolBoards= new ArrayList<>();
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Boolean> winners;
        schoolBoards.add(0,SB1);
        schoolBoards.add(1,SB2);
        players.add(0,p1);
        players.add(1,p2);
        try {
            schoolBoards.get(1).PutProfessor(Color.Red);
            schoolBoards.get(1).PutProfessor(Color.Green);
            schoolBoards.get(0).PutProfessor(Color.Pink);
            schoolBoards.get(0).PutProfessor(Color.Blue);
            schoolBoards.get(0).PutProfessor(Color.Yellow);
        }catch (IllegalMoveException e){
            fail();
        }
        winners= w.CheckWinner(players,schoolBoards);

        assertTrue(winners.get(0));
        assertFalse(winners.get(1));
    }
    @Test
    public void testCheckWinnerCheckingProfessor4players2(){
        SB1.setColorTower(ColorTower.Black);
        SB2.setColorTower(ColorTower.White);
        SB3.setColorTower(ColorTower.Black);
        SB4.setColorTower(ColorTower.White);
        SB1.setNumberOfTower(8);
        SB2.setNumberOfTower(8);
        p1.getMySchoolBoard().RemoveTower();
        p2.getMySchoolBoard().RemoveTower();
        ArrayList<SchoolBoard> schoolBoards= new ArrayList<>();
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Boolean> winners;
        schoolBoards.add(0,SB1);
        schoolBoards.add(1,SB2);
        players.add(0,p1);
        players.add(1,p2);
        players.add(2,p3);
        players.add(3,p4);
        try {
            players.get(2).getMySchoolBoard().PutProfessor(Color.Red);
            players.get(1).getMySchoolBoard().PutProfessor(Color.Green);
            players.get(0).getMySchoolBoard().PutProfessor(Color.Pink);
            players.get(3).getMySchoolBoard().PutProfessor(Color.Blue);
            players.get(3).getMySchoolBoard().PutProfessor(Color.Yellow);
        }catch (IllegalMoveException e){
            fail();
        }
        winners= w.CheckWinner(players,schoolBoards);
        assertFalse(winners.get(0));
        assertTrue(winners.get(1));
        assertFalse(winners.get(2));
        assertTrue(winners.get(3));
    }

}