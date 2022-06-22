package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.messages.MoveStudent2Msg;
import javafx.event.ActionEvent;

public class ChoiceDiningRoomOrIsland2 {
    public void DiningClicked(ActionEvent event){
        MoveStudent2Msg moveStudent2Msg= new MoveStudent2Msg(MoveStudent2Scene.getColor(), 12);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(moveStudent2Msg);
    }
    public void IslandClicked(ActionEvent event){
        IslandTilesScene.setOnlyObserv(false);
        if(MoveStudent2Scene.getNumberOfMessage()==0) {
            IslandTilesScene.setIslands(MoveStudent2Scene.getAnswerMsg().GetGB().GetIslands());
        }else if(MoveStudent2Scene.getNumberOfMessage()==1){
            IslandTilesScene.setIslands(MoveStudent2Scene.getAnsPlayAfterCCMsg().GetGB().GetIslands());
        }else if(MoveStudent2Scene.getNumberOfMessage()==2){
            IslandTilesScene.setIslands(MoveStudent2Scene.getAnsPlayAfterNotCCMsg().GetGB().GetIslands());
        }
        IslandTilesScene.setNumberOfSceneToComeBack(2);
        JavaFXMain.getCurrentApplication().switchToIslandTitleScene();
    }
}
