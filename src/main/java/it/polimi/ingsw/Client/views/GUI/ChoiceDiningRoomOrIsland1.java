package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.messages.MoveStudent1Msg;
import javafx.event.ActionEvent;


public class ChoiceDiningRoomOrIsland1 {
    public static int location;

    public void DiningClicked(ActionEvent event){
        location=12;
        MoveStudent1Msg moveStudent1Msg= new MoveStudent1Msg(MoveStudent1Scene.getColor(), location);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(moveStudent1Msg);
    }
    public void IslandClicked(ActionEvent event){
        IslandTilesScene.setOnlyObserv(false);
        if(MoveStudent1Scene.getNumberOfMessage()==0) {
            IslandTilesScene.setIslands(MoveStudent1Scene.getAnswerMsg().GetGB().GetIslands());
        }else if(MoveStudent1Scene.getNumberOfMessage()==1){
            IslandTilesScene.setIslands(MoveStudent1Scene.getAnsPlayAfterCCMsg().GetGB().GetIslands());
        }else if(MoveStudent1Scene.getNumberOfMessage()==2){
            IslandTilesScene.setIslands(MoveStudent1Scene.getAnsPlayAfterNotCCMsg().GetGB().GetIslands());
        }
        IslandTilesScene.setNumberOfSceneToComeBack(1);
        JavaFXMain.getCurrentApplication().switchToIslandTitleScene();
    }
}
