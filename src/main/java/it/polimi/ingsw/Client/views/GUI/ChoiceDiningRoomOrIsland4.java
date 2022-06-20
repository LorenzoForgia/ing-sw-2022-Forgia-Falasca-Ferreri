package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.messages.MoveStudent4Msg;
import javafx.event.ActionEvent;

public class ChoiceDiningRoomOrIsland4 {
    public void DiningClicked(ActionEvent event){
        MoveStudent4Msg moveStudent4Msg= new MoveStudent4Msg(MoveStudent4Scene.getColor(), 12);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(moveStudent4Msg);
    }
    public void IslandClicked(ActionEvent event){
        IslandTilesScene.setOnlyObserv(false);
        IslandTilesScene.setIslands(MoveStudent4Scene.getAnswerMsg().GetGB().GetIslands());
        IslandTilesScene.setNumberOfSceneToComeBack(4);
        JavaFXMain.getCurrentApplication().switchToIslandTitleScene();
    }

}
