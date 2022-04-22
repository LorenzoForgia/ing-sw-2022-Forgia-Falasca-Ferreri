package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.Bag;
import it.polimi.ingsw.Model.GeneralBoard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddStudentsOnCloudsTest {
    GeneralBoard g =null;
    AddStudentsOnClouds a=null;
    @BeforeEach
    public void setUp(){
        g= new GeneralBoard(20);
        a= new AddStudentsOnClouds();
    }

    @AfterEach
    public void tearDown(){
        g = null;
        a= null;
    }

    @Test
    public void testRestartTurn1(){
        g.CreateClouds(2);
        Bag b=new Bag();
        b.setStudents(50);
        a.RestartTurn(g,b,2);
        for(int i=0;i<g.getClouds().size();i++){
            assertEquals(3, g.getClouds().get(i).getStud().size());
        }
    }

    @Test
    public void testRestartTurn2(){
        g.CreateClouds(3);
        Bag b=new Bag();
        b.setStudents(50);
        a.RestartTurn(g,b,3);
        for(int i=0;i<g.getClouds().size();i++){
            assertEquals(4, g.getClouds().get(i).getStud().size());
        }
    }

    @Test
    public void testRestartTurn3(){
        g.CreateClouds(4);
        Bag b=new Bag();
        b.setStudents(50);
        a.RestartTurn(g,b,4);
        for(int i=0;i<g.getClouds().size();i++){
            assertEquals(3, g.getClouds().get(i).getStud().size());
        }
    }
}