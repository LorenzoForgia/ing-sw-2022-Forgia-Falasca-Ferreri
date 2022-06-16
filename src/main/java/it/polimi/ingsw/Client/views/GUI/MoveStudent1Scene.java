package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.messages.MoveStudent1Msg;
import javafx.event.ActionEvent;
import java.awt.*;


public class MoveStudent1Scene {
    private static Color color;
    private static int location;

    public void BlueSelected(){
        color=Color.Blue;
        JavaFXMain.getCurrentApplication().switchToMS1DiningOrIslandScene();
    }
    public void YellowSelected(){
        color=Color.Yellow;
        JavaFXMain.getCurrentApplication().switchToMS1DiningOrIslandScene();
    }
    public void GreenSelected(){
        color=Color.Green;
        JavaFXMain.getCurrentApplication().switchToMS1DiningOrIslandScene();
    }
    public void RedSelected(){
        color=Color.Red;
        JavaFXMain.getCurrentApplication().switchToMS1DiningOrIslandScene();
    }
    public void PinkSelected(){
        color=Color.Pink;
        JavaFXMain.getCurrentApplication().switchToMS1DiningOrIslandScene();
    }
    public void DiningClicked(ActionEvent event){
        location=12;
        MoveStudent1Msg moveStudent1Msg= new MoveStudent1Msg(color, location);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(moveStudent1Msg);
    }
    public void IslandClicked(ActionEvent event){
        JavaFXMain.getCurrentApplication().switchToIslandTitleScene();
    }







}
