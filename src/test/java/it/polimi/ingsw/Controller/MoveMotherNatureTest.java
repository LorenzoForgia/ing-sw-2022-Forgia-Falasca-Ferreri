package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Model.ColorTower;
import it.polimi.ingsw.Model.GeneralBoard;
import it.polimi.ingsw.Model.IslandTiles;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveMotherNatureTest {
    MoveMotherNature MMN = null;
    @BeforeEach
    public void setUp(){
       MMN = new MoveMotherNature();
    }

    @AfterEach
    public void tearDown(){
        MMN= null;
    }

    @Test
    public void testIfIslandCanGetControlled(){
        boolean flag = false;
        IslandTiles IT = new IslandTiles(1, true,1,false,false);
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
        flag = MMN.CheckIfIslandGetControlled(2, GB, false, null);
        assertTrue(flag);
    }

}