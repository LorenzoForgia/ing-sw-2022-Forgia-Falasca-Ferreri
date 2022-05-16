package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.Color;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DisplayerTest {
    @Test
    public void testDisplayer(){
        Displayer p=new Displayer();
        ArrayList<Color> entrance=new ArrayList<>();
        entrance.add(Color.Blue);
        entrance.add(Color.Pink);
        entrance.add(Color.Green);
        entrance.add(Color.Red);
        entrance.add(Color.Pink);
        entrance.add(Color.Green);
        entrance.add(Color.Blue);
        entrance.add(Color.Red);
        entrance.add(Color.Red);

        ArrayList<ArrayList<Color>> DiningRoom=new ArrayList<ArrayList<Color>>(5);
        for(int i=0;i<5;i++){
            DiningRoom.add(new ArrayList<>());
        }
        for(int i=0;i<10;i++) {
            DiningRoom.get(0).add(Color.Green);
        }
        for(int i=0;i<0;i++) {
            DiningRoom.get(1).add(Color.Red);
        }
        for(int i=0;i<2;i++) {
            DiningRoom.get(2).add(Color.Yellow);
        }
        for(int i=0;i<0;i++) {
            DiningRoom.get(3).add(Color.Pink);
        }
        for(int i=0;i<4;i++) {
            DiningRoom.get(4).add(Color.Blue);
        }

        ArrayList<Color> prof=new ArrayList<>();
        p.displayLogo();
        p.displaySchoolBoard(entrance,DiningRoom,prof,9,Color.Gray);
    }

}