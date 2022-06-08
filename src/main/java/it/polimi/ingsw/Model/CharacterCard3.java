package it.polimi.ingsw.Model;

import it.polimi.ingsw.Controller.*;

import java.io.Serializable;
import java.util.List;


 /**
  * @author Luigia Falasca and Federico Angelo Luigi Ferreri
 * **/
public class CharacterCard3 extends CharacterCard implements Serializable {
    private IslandTiles I1;
    private MoveMotherNature moveMotherNature = new MoveMotherNature();
    private GeneralBoard generalBoard;
    private int numOfPlayer;
    private List<SchoolBoard> schoolBoardList;

    public CharacterCard3(int name, int coins, int countUse, String descriptionEffect) {
        super(name, coins, countUse, descriptionEffect);
    }

    @Override
    public void SetCard(Bag b, GeneralBoard gb) {
        generalBoard = gb;
    }

/** Resolve the island such as Mother Nature ended her movement there
 * **/
    @Override
    public void UseEffect(Player player) {
        player.setNameCharacterCard(3);
        player.setUsedCharacterCard(true);
        if(moveMotherNature.CheckIfIslandGetControlled(numOfPlayer,generalBoard, I1)){
            moveMotherNature.GetRightTowerOnIsland(generalBoard, I1, schoolBoardList);
        }
    }
/** Set the chosen Island
 * **/
    public void setI1(IslandTiles i1) {
        I1 = i1;
    }

    public void setNumOfPlayer(int numOfPlayer) {
        this.numOfPlayer = numOfPlayer;
    }

    public void setSchoolBoardList(List<SchoolBoard> schoolBoardList) {
        this.schoolBoardList = schoolBoardList;
    }
}
