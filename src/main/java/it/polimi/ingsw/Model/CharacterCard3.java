package it.polimi.ingsw.Model;

import it.polimi.ingsw.Controller.*;

import java.util.List;


/** Resolve the island such as Mother Nature ended her movement there
 * The player has to choose the island **/
public class CharacterCard3 extends CharacterCard{
    private IslandTiles I1;
    private MoveMotherNature moveMotherNature = new MoveMotherNature();
    private GeneralBoard generalBoard;
    private int numOfPlayer;
    private List<SchoolBoard> schoolBoardList;

    public CharacterCard3(int name, int coins, int countUse) {
        super(name, coins, countUse);
    }

    @Override
    public void SetCard(Bag b, GeneralBoard gb) {
        generalBoard = gb;
    }

    @Override
    public void UseEffect(Player player) {
        if(moveMotherNature.CheckIfIslandGetControlled(numOfPlayer,generalBoard, I1)){
            moveMotherNature.GetRightTowerOnIsland(generalBoard, I1, schoolBoardList);
        }
    }

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
