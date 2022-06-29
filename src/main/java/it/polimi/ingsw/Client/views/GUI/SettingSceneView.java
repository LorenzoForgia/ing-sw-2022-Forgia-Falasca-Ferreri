package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsGameCreatedMsg;
import it.polimi.ingsw.messages.GameStartedMsg;
import javafx.application.Platform;

public class SettingSceneView extends View {
    private AnsGameCreatedMsg answerMsg;
    public SettingSceneView(AnsGameCreatedMsg answerMsg){
        this.answerMsg=answerMsg;
    }
    public void run(){

        AnsGameCreatedMsg.Status moveStatus = answerMsg.getMoveStatus();
        if(moveStatus==AnsGameCreatedMsg.Status.VALID) {
            Platform.runLater(() -> {
                JavaFXMain.getCurrentApplication().switchToNumberOfPlayerScene();
            });

        }else{

            GameStartedMsg gameStartedMsg= new GameStartedMsg();
            JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(gameStartedMsg);
        }
    }
}
