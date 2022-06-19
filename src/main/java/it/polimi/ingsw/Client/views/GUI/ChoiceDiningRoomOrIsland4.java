package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.messages.MoveStudent4Msg;
import javafx.event.ActionEvent;

public class ChoiceDiningRoomOrIsland4 {
    public void DiningClicked(ActionEvent event){
        MoveStudent4Msg moveStudent4Msg= new MoveStudent4Msg(MoveStudent1Scene.getColor(), 12);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(moveStudent4Msg);
    }
    public void IslandClicked(ActionEvent event){
        JavaFXMain.getCurrentApplication().switchToIslandTitleScene();
        IslandTilesScene.setOnlyObserv(false);
        IslandTilesScene.setIslands(MoveStudent1Scene.getAnswerMsg().GetGB().GetIslands());
        IslandTilesScene.setNumberOfSceneToComeBack(4);
        JavaFXMain.getCurrentApplication().switchToIslandTitleScene();
    }

}
