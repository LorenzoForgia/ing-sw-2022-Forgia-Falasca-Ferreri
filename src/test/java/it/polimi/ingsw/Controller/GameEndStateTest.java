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
      Player p1=new Player("A",1, gb.getSchoolBoard().get(0), new DeckCardAssistant());
      Player p2=new Player("B",1, gb.getSchoolBoard().get(1), new DeckCardAssistant());
      List<SchoolBoard> sb=new ArrayList<>();
      sb.add(gb.getSchoolBoard().get(0));
      sb.add(gb.getSchoolBoard().get(1));
      s.SetTowers(2,sb);
      for(int i=0;i<8;i++){
          gb.getSchoolBoard().get(0).RemoveTower();
      }
      GameEndState GE=new GameEndState();
      assertTrue(GE.CheckEndGameImmediately(p1,gb));
      assertFalse(GE.CheckEndGameImmediately(p2,gb));
  }
    @Test
    public void testCheckEndGameImmediately2(){ /** case  numIslands<=3  **/
        Setup s=new Setup();
        GeneralBoard gb=s.CreateGeneralboard(false,2);
        Player p1=new Player("A",1, gb.getSchoolBoard().get(0), new DeckCardAssistant());
        Player p2=new Player("B",1, gb.getSchoolBoard().get(1), new DeckCardAssistant());
        List<SchoolBoard> sb=new ArrayList<>();
        sb.add(gb.getSchoolBoard().get(0));
        sb.add(gb.getSchoolBoard().get(1));
        s.SetTowers(2,sb);
        for(int i=0;i<10;i++){
            gb.GetIslands().remove(0);
        }
        GameEndState GE=new GameEndState();
        assertTrue(GE.CheckEndGameImmediately(p1,gb));
    }
    @Test
    public void testCheckEndGameRoundEnded1(){ /** Bag is empty  **/
        Setup s=new Setup();
        Bag b=new Bag();
        GeneralBoard gb=s.CreateGeneralboard(false,2);
        Player p1=new Player("A",1, gb.getSchoolBoard().get(0), new DeckCardAssistant());
        Player p2=new Player("B",1, gb.getSchoolBoard().get(1), new DeckCardAssistant());
        List<SchoolBoard> sb=new ArrayList<>();
        sb.add(gb.getSchoolBoard().get(0));
        sb.add(gb.getSchoolBoard().get(1));
        GameEndState GE=new GameEndState();
        assertTrue(GE.CheckEndGameRoundEnded(p1,gb,b));
    }
    @Test
    public void testCheckEndGameRoundEnded2(){ /** deck size=0  **/
        Setup s=new Setup();
        Bag b=new Bag();
        GeneralBoard gb=s.CreateGeneralboard(false,2);
        Player p1=new Player("A",1, gb.getSchoolBoard().get(0), new DeckCardAssistant());
        Player p2=new Player("B",1, gb.getSchoolBoard().get(1), new DeckCardAssistant());
        List<SchoolBoard> sb=new ArrayList<>();
        sb.add(gb.getSchoolBoard().get(0));
        sb.add(gb.getSchoolBoard().get(1));
        b.setStudents(10);
        for(int i=0;i<10;i++){
            p1.getMyDeck().GetDeck().remove(0);
        }
        GameEndState GE=new GameEndState();
        assertTrue(GE.CheckEndGameRoundEnded(p1,gb,b));
    }
    @Test
    public void testCheckEndGameRoundEnded3(){ /** Bag is not empty **/
        Setup s=new Setup();
        Bag b=new Bag();
        GeneralBoard gb=s.CreateGeneralboard(false,2);
        Player p1=new Player("A",1, gb.getSchoolBoard().get(0), new DeckCardAssistant());
        Player p2=new Player("B",1, gb.getSchoolBoard().get(1), new DeckCardAssistant());
        List<SchoolBoard> sb=new ArrayList<>();
        sb.add(gb.getSchoolBoard().get(0));
        sb.add(gb.getSchoolBoard().get(1));
        b.setStudents(10);
        GameEndState GE=new GameEndState();
        assertFalse(GE.CheckEndGameRoundEnded(p1,gb,b));
    }
    @Test
    public void testCheckEndGameRoundEnded4(){ /** myDeck size>0 **/
        Setup s=new Setup();
        Bag b=new Bag();
        GeneralBoard gb=s.CreateGeneralboard(false,2);
        Player p1=new Player("A",1, gb.getSchoolBoard().get(0), new DeckCardAssistant());
        Player p2=new Player("B",1, gb.getSchoolBoard().get(1), new DeckCardAssistant());
        List<SchoolBoard> sb=new ArrayList<>();
        b.setStudents(10);
        sb.add(gb.getSchoolBoard().get(0));
        sb.add(gb.getSchoolBoard().get(1));
        GameEndState GE=new GameEndState();
        assertEquals(10,p1.getMyDeck().GetDeck().size());
        assertFalse(GE.CheckEndGameRoundEnded(p1,gb,b));
    }
}