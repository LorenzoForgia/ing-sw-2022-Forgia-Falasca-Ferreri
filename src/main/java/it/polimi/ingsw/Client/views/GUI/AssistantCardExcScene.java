package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsTurnDecidedExcMsg;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class AssistantCardExcScene extends View {
    private AnsTurnDecidedExcMsg ansTurnDecidedExcMsg;

    public AssistantCardExcScene(AnsTurnDecidedExcMsg ansTurnDecidedExcMsg) {
        this.ansTurnDecidedExcMsg = ansTurnDecidedExcMsg;
    }
    public void run(){
        if(this.ansTurnDecidedExcMsg.getAsscardgui()==0){
            Platform.runLater(() -> {
                JavaFXMain.getCurrentApplication().switchToCardAssistantScene();
                Alert alert = new Alert(Alert.AlertType.ERROR, "Scelta invalida! Riprova", ButtonType.OK);
                alert.showAndWait();
            });
        }else{
            Platform.runLater(() -> {
                JavaFXMain.getCurrentApplication().switchToAssistantCardSceneNewTurn();
                Alert alert = new Alert(Alert.AlertType.ERROR, "Scelta invalida! Riprova", ButtonType.OK);
                alert.showAndWait();
            });
        }
    }
}
