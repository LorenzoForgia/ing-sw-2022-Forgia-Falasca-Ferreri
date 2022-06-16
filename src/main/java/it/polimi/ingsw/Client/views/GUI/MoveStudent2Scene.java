package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Model.Color;

import it.polimi.ingsw.messages.MoveStudent2Msg;
import javafx.event.ActionEvent;

public class MoveStudent2Scene {
    private static Color color;
    private static int location;

    public void BlueSelected(){
        color=Color.Blue;
        JavaFXMain.getCurrentApplication().switchToMS2DiningOrIslandScene();
    }
    public void YellowSelected(){
        color=Color.Yellow;
        JavaFXMain.getCurrentApplication().switchToMS2DiningOrIslandScene();
    }
    public void GreenSelected(){
        color=Color.Green;
        JavaFXMain.getCurrentApplication().switchToMS2DiningOrIslandScene();
    }
    public void RedSelected(){
        color=Color.Red;
        JavaFXMain.getCurrentApplication().switchToMS2DiningOrIslandScene();
    }
    public void PinkSelected(){
        color=Color.Pink;
        JavaFXMain.getCurrentApplication().switchToMS2DiningOrIslandScene();
    }
    public void DiningClicked(ActionEvent event){
        location=12;
        MoveStudent2Msg moveStudent2Msg= new MoveStudent2Msg(color, location);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(moveStudent2Msg);
    }
    public void IslandClicked(ActionEvent event){
        JavaFXMain.getCurrentApplication().switchToIslandTitleScene();
    }

}
