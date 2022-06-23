package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.messages.MoveStudent3Msg;
import javafx.event.ActionEvent;

public class ChoiceDiningRoomOrIsland3 {
    public void DiningClicked(ActionEvent event){

        MoveStudent3Msg moveStudent3Msg= new MoveStudent3Msg(MoveStudent3Scene.getColor(), 123);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(moveStudent3Msg);
    }
    public void IslandClicked(ActionEvent event){
        IslandTilesScene.setOnlyObserv(false);
        if(MoveStudent3Scene.getNumberOfMessage()==0) {
            IslandTilesScene.setIslands(MoveStudent3Scene.getAnswerMsg().GetGB().GetIslands());
        }else if(MoveStudent3Scene.getNumberOfMessage()==1){
            IslandTilesScene.setIslands(MoveStudent3Scene.getAnsPlayAfterCCMsg().GetGB().GetIslands());
        }else if(MoveStudent3Scene.getNumberOfMessage()==2){
            IslandTilesScene.setIslands(MoveStudent3Scene.getAnsPlayAfterNotCCMsg().GetGB().GetIslands());
        }
        IslandTilesScene.setNumberOfSceneToComeBack(3);
        JavaFXMain.getCurrentApplication().switchToIslandTitleScene();
    }
}
