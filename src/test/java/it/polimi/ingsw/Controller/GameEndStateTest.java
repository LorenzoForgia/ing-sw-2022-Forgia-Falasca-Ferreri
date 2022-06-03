package it.polimi.ingsw.Controller;
import it.polimi.ingsw.Model.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameEndStateTest {
  @Test
  public void testCheckEndGameImmediately1(){ /** case  numTowers=0 for 1st player **/
      Setup s=new Setup();
      GeneralBoard gb=s.CreateGeneralboard(false,2);
      Player p1=new Player("A");
      p1.setMyDeck(new DeckCardAssistant());
      p1.setMySchoolBoard(gb.getSchoolBoard().get(0));
      p1.setNumberCoins(1);
      Player p2=new Player("B");
      p2.setMyDeck(new DeckCardAssistant());
      p2.setMySchoolBoard(gb.getSchoolBoard().get(1));
      p2.setNumberCoins(1);
      List<SchoolBoard> sb=new ArrayList<>();
      sb.add(gb.getSchoolBoard().get(0));
      sb.add(gb.getSchoolBoard().get(1));
      s.SetTowers(2,sb);
      for(int i=0;i<8;i++){
          gb.getSchoolBoard().get(0).RemoveTower();
      }
      GameEndState GE=new GameEndState();
      GE.CheckEndGameImmediately(p1,gb, sb, 2);
      assertTrue(GE.isFlagImmediately());
  }
    @Test
    public void testCheckEndGameImmediately4(){ /** case  numTowers=0 for 1st player,player 3 is in the same squad of playe 1and 4 players **/
        Setup s=new Setup();
        GeneralBoard gb=s.CreateGeneralboard(false,4);
        Player p1=new Player("A");
        p1.setMyDeck(new DeckCardAssistant());
        p1.setMySchoolBoard(gb.getSchoolBoard().get(0));
        p1.setNumberCoins(1);
        Player p2=new Player("B");
        p2.setMyDeck(new DeckCardAssistant());
        p2.setMySchoolBoard(gb.getSchoolBoard().get(1));
        p2.setNumberCoins(1);
        Player p3=new Player("A");
        p3.setMyDeck(new DeckCardAssistant());
        p3.setMySchoolBoard(gb.getSchoolBoard().get(0));
        p3.setNumberCoins(1);
        Player p4=new Player("B");
        p4.setMyDeck(new DeckCardAssistant());
        p4.setMySchoolBoard(gb.getSchoolBoard().get(1));
        p4.setNumberCoins(1);
        List<SchoolBoard> sb=new ArrayList<>();
        sb.add(gb.getSchoolBoard().get(0));
        sb.add(gb.getSchoolBoard().get(1));

        s.SetTowers(4,sb);
        for(int i=0;i<8;i++){
            gb.getSchoolBoard().get(0).RemoveTower();
        }
        GameEndState GE=new GameEndState();
        GE.CheckEndGameImmediately(p3,gb, sb, 4);
        assertTrue(GE.isFlagImmediately());
    }

    @Test
    public void testCheckEndGameImmediately5(){ /** case no winner 4 players **/
        Setup s=new Setup();
        GeneralBoard gb=s.CreateGeneralboard(false,4);
        Player p1=new Player("A");
        p1.setMyDeck(new DeckCardAssistant());
        p1.setMySchoolBoard(gb.getSchoolBoard().get(0));
        p1.setNumberCoins(1);
        Player p2=new Player("B");
        p2.setMyDeck(new DeckCardAssistant());
        p2.setMySchoolBoard(gb.getSchoolBoard().get(1));
        p2.setNumberCoins(1);
        Player p3=new Player("A");
        p3.setMyDeck(new DeckCardAssistant());
        p3.setMySchoolBoard(gb.getSchoolBoard().get(0));
        p3.setNumberCoins(1);
        Player p4=new Player("B");
        p4.setMyDeck(new DeckCardAssistant());
        p4.setMySchoolBoard(gb.getSchoolBoard().get(1));
        p4.setNumberCoins(1);
        List<SchoolBoard> sb=new ArrayList<>();
        sb.add(gb.getSchoolBoard().get(0));
        sb.add(gb.getSchoolBoard().get(1));

        s.SetTowers(4,sb);

        GameEndState GE=new GameEndState();
        GE.CheckEndGameImmediately(p3,gb, sb, 4);
        assertFalse(GE.isFlagImmediately());
    }

    @Test
    public void testCheckEndGameImmediately2(){ /** case  numIslands<=3  **/
        Setup s=new Setup();
        GeneralBoard gb=s.CreateGeneralboard(false,2);
        Player p1=new Player("A");
        p1.setMyDeck(new DeckCardAssistant());
        p1.setMySchoolBoard(gb.getSchoolBoard().get(0));
        p1.setNumberCoins(1);
        Player p2=new Player("B");
        p2.setMyDeck(new DeckCardAssistant());
        p2.setMySchoolBoard(gb.getSchoolBoard().get(1));
        p2.setNumberCoins(1);
        List<SchoolBoard> sb=new ArrayList<>();
        sb.add(gb.getSchoolBoard().get(0));
        sb.add(gb.getSchoolBoard().get(1));
        s.SetTowers(2,sb);
        for(int i=0;i<10;i++){
            gb.GetIslands().remove(0);
        }
        GameEndState GE=new GameEndState();
        GE.CheckEndGameImmediately(p1,gb,sb, 2);
        assertTrue(GE.isFlagImmediately());
    }
    @Test
    public void testCheckEndGameImmediately3(){ /** case  numIslands>3  **/
        Setup s=new Setup();
        GeneralBoard gb=s.CreateGeneralboard(false,2);
        Player p1=new Player("A");
        p1.setMyDeck(new DeckCardAssistant());
        p1.setMySchoolBoard(gb.getSchoolBoard().get(0));
        p1.setNumberCoins(1);
        Player p2=new Player("B");
        p2.setMyDeck(new DeckCardAssistant());
        p2.setMySchoolBoard(gb.getSchoolBoard().get(1));
        p2.setNumberCoins(1);
        List<SchoolBoard> sb=new ArrayList<>();
        sb.add(gb.getSchoolBoard().get(0));
        sb.add(gb.getSchoolBoard().get(1));
        s.SetTowers(2,sb);
        GameEndState GE=new GameEndState();
        GE.CheckEndGameImmediately(p1,gb, sb, 2);
        assertFalse(GE.isFlagImmediately());
    }

    @Test
    public void testCheckEndGameRoundEnded1(){ /** Bag is empty  **/
        Setup s=new Setup();
        Bag b=new Bag();
        GeneralBoard gb=s.CreateGeneralboard(false,2);
        Player p1=new Player("A");
        p1.setMyDeck(new DeckCardAssistant());
        p1.setMySchoolBoard(gb.getSchoolBoard().get(0));
        p1.setNumberCoins(1);
        Player p2=new Player("B");
        p2.setMyDeck(new DeckCardAssistant());
        p2.setMySchoolBoard(gb.getSchoolBoard().get(1));
        p2.setNumberCoins(1);
        List<SchoolBoard> sb=new ArrayList<>();
        sb.add(gb.getSchoolBoard().get(0));
        sb.add(gb.getSchoolBoard().get(1));
        GameEndState GE=new GameEndState();
        GE.CheckEndGameRoundEndedForBag(b);
        assertTrue(GE.isFlagNotImmediately());

    }
    @Test
    public void testCheckEndGameRoundEnded2(){ /** deck size=0  **/
        Setup s=new Setup();
        Bag b=new Bag();
        GeneralBoard gb=s.CreateGeneralboard(false,2);
        Player p1=new Player("A");
        p1.setMyDeck(new DeckCardAssistant());
        p1.setMySchoolBoard(gb.getSchoolBoard().get(0));
        p1.setNumberCoins(1);
        Player p2=new Player("B");
        p2.setMyDeck(new DeckCardAssistant());
        p2.setMySchoolBoard(gb.getSchoolBoard().get(1));
        p2.setNumberCoins(1);
        List<SchoolBoard> sb=new ArrayList<>();
        sb.add(gb.getSchoolBoard().get(0));
        sb.add(gb.getSchoolBoard().get(1));
        b.setStudents(10);
        for(int i=0;i<10;i++){
            p1.getMyDeck().GetDeck().remove(0);
        }
        GameEndState GE=new GameEndState();
        GE.CheckEndGameRoundEndedForCardAssistant(p1);
        assertTrue(GE.isFlagNotImmediately());
    }
    @Test
    public void testCheckEndGameRoundEnded3(){ /** Bag is not empty **/
        Setup s=new Setup();
        Bag b=new Bag();
        GeneralBoard gb=s.CreateGeneralboard(false,2);
        Player p1=new Player("A");
        p1.setMyDeck(new DeckCardAssistant());
        p1.setMySchoolBoard(gb.getSchoolBoard().get(0));
        p1.setNumberCoins(1);
        Player p2=new Player("B");
        p2.setMyDeck(new DeckCardAssistant());
        p2.setMySchoolBoard(gb.getSchoolBoard().get(1));
        p2.setNumberCoins(1);
        List<SchoolBoard> sb=new ArrayList<>();
        sb.add(gb.getSchoolBoard().get(0));
        sb.add(gb.getSchoolBoard().get(1));
        b.setStudents(10);
        GameEndState GE=new GameEndState();
        GE.CheckEndGameRoundEndedForBag(b);
        assertFalse(GE.isFlagNotImmediately());
    }
    @Test
    public void testCheckEndGameRoundEnded4(){ /** myDeck size>0 **/
        Setup s=new Setup();
        Bag b=new Bag();
        GeneralBoard gb=s.CreateGeneralboard(false,2);
        Player p1=new Player("A");
        p1.setMyDeck(new DeckCardAssistant());
        p1.setMySchoolBoard(gb.getSchoolBoard().get(0));
        p1.setNumberCoins(1);
        Player p2=new Player("B");
        p2.setMyDeck(new DeckCardAssistant());
        p2.setMySchoolBoard(gb.getSchoolBoard().get(1));
        p2.setNumberCoins(1);
        List<SchoolBoard> sb=new ArrayList<>();
        b.setStudents(10);
        sb.add(gb.getSchoolBoard().get(0));
        sb.add(gb.getSchoolBoard().get(1));
        GameEndState GE=new GameEndState();
        assertEquals(10,p1.getMyDeck().GetDeck().size());
        GE.CheckEndGameRoundEndedForCardAssistant(p1);
        assertFalse(GE.isFlagNotImmediately());
    }
}