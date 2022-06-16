package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Model.Color;

import it.polimi.ingsw.messages.MoveStudent4Msg;
import javafx.event.ActionEvent;

public class MoveStudent4Scene {
    private static Color color;
    private static int location;

    public void BlueSelected(){
        color=Color.Blue;
        JavaFXMain.getCurrentApplication().switchToMS4DiningOrIslandScene();
    }
    public void YellowSelected(){
        color=Color.Yellow;
        JavaFXMain.getCurrentApplication().switchToMS4DiningOrIslandScene();
    }
    public void GreenSelected(){
        color=Color.Green;
        JavaFXMain.getCurrentApplication().switchToMS4DiningOrIslandScene();
    }
    public void RedSelected(){
        color=Color.Red;
        JavaFXMain.getCurrentApplication().switchToMS4DiningOrIslandScene();
    }
    public void PinkSelected(){
        color=Color.Pink;
        JavaFXMain.getCurrentApplication().switchToMS4DiningOrIslandScene();
    }
    public void DiningClicked(ActionEvent event){
        location=12;
        MoveStudent4Msg moveStudent4Msg= new MoveStudent4Msg(color, location);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(moveStudent4Msg);
    }
    public void IslandClicked(ActionEvent event){
        JavaFXMain.getCurrentApplication().switchToIslandTitleScene();
    }

}