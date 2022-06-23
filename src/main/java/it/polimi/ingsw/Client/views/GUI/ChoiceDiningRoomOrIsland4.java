package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.messages.MoveStudent4Msg;
import javafx.event.ActionEvent;

public class ChoiceDiningRoomOrIsland4 {
    public void DiningClicked(ActionEvent event){
        MoveStudent4Msg moveStudent4Msg= new MoveStudent4Msg(MoveStudent4Scene.getColor(), 123);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(moveStudent4Msg);
    }
    public void IslandClicked(ActionEvent event){
        IslandTilesScene.setOnlyObserv(false);
        if(MoveStudent4Scene.getNumberOfMessage()==0) {
            IslandTilesScene.setIslands(MoveStudent4Scene.getAnswerMsg().GetGB().GetIslands());
        }else if(MoveStudent4Scene.getNumberOfMessage()==1){
            IslandTilesScene.setIslands(MoveStudent4Scene.getAnsPlayAfterCCMsg().GetGB().GetIslands());
        }else if(MoveStudent4Scene.getNumberOfMessage()==2){
            IslandTilesScene.setIslands(MoveStudent4Scene.getAnsPlayAfterNotCCMsg().GetGB().GetIslands());
        }
        IslandTilesScene.setNumberOfSceneToComeBack(4);
        JavaFXMain.getCurrentApplication().switchToIslandTitleScene();
    }

}
