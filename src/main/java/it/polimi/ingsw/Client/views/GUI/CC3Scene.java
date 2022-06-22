package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.messages.AnsCC3Msg;
import javafx.event.ActionEvent;

public class CC3Scene {
    private static AnsCC3Msg answerMsg;

    public static void setAnswerMsg(AnsCC3Msg answerMsg) {
        CC3Scene.answerMsg = answerMsg;
    }

    public static AnsCC3Msg getAnswerMsg() {
        return answerMsg;
    }

    public void IslandClicked(ActionEvent event){
        IslandTilesScene.setOnlyObserv(false);
        IslandTilesScene.setIslands(CC3Scene.getAnswerMsg().GetGB().GetIslands());
        IslandTilesScene.setNumberOfSceneToComeBack(10);
        JavaFXMain.getCurrentApplication().switchToIslandTitleScene();
    }
}
