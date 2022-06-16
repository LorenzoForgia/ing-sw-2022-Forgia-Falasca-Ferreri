package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Model.Color;

import it.polimi.ingsw.messages.MoveStudent3Msg;
import javafx.event.ActionEvent;

public class MoveStudent3Scene {
    private static Color color;
    private static int location;

    public void BlueSelected(){
        color=Color.Blue;
        JavaFXMain.getCurrentApplication().switchToMS3DiningOrIslandScene();
    }
    public void YellowSelected(){
        color=Color.Yellow;
        JavaFXMain.getCurrentApplication().switchToMS3DiningOrIslandScene();
    }
    public void GreenSelected(){
        color=Color.Green;
        JavaFXMain.getCurrentApplication().switchToMS3DiningOrIslandScene();
    }
    public void RedSelected(){
        color=Color.Red;
        JavaFXMain.getCurrentApplication().switchToMS3DiningOrIslandScene();
    }
    public void PinkSelected(){
        color=Color.Pink;
        JavaFXMain.getCurrentApplication().switchToMS3DiningOrIslandScene();
    }
    public void DiningClicked(ActionEvent event){
        location=12;
        MoveStudent3Msg moveStudent3Msg= new MoveStudent3Msg(color, location);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(moveStudent3Msg);
    }
    public void IslandClicked(ActionEvent event){
        JavaFXMain.getCurrentApplication().switchToIslandTitleScene();
    }

}
