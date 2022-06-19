package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.messages.MoveStudent3Msg;
import javafx.event.ActionEvent;

public class ChoiceDiningRoomOrIsland3 {
    public void DiningClicked(ActionEvent event){

        MoveStudent3Msg moveStudent3Msg= new MoveStudent3Msg(MoveStudent1Scene.getColor(), 12);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(moveStudent3Msg);
    }
    public void IslandClicked(ActionEvent event){
        IslandTilesScene.setOnlyObserv(false);
        IslandTilesScene.setIslands(MoveStudent1Scene.getAnswerMsg().GetGB().GetIslands());
        IslandTilesScene.setNumberOfSceneToComeBack(3);
        JavaFXMain.getCurrentApplication().switchToIslandTitleScene();
    }
}
