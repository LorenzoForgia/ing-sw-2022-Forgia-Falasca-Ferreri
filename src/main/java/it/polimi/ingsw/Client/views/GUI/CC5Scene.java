package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.messages.AnsCC5Msg;
import javafx.event.ActionEvent;

public class CC5Scene {
    public static AnsCC5Msg answerMsg;

    public static void setAnswerMsg(AnsCC5Msg answerMsg) {
        CC5Scene.answerMsg = answerMsg;
    }

    public static AnsCC5Msg getAnswerMsg() {
        return answerMsg;
    }
    public void IslandClicked(){
        IslandTilesScene.setOnlyObserv(false);
        IslandTilesScene.setIslands(CC5Scene.getAnswerMsg().GetGB().GetIslands());
        IslandTilesScene.setNumberOfSceneToComeBack(12);
        JavaFXMain.getCurrentApplication().switchToIslandTitleScene();
    }
}
