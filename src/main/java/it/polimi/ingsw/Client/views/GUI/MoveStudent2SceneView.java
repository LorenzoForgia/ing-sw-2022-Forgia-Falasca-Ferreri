package it.polimi.ingsw.Client.views.GUI;
import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsMoveStudent1Msg;
import javafx.application.Platform;

public class MoveStudent2SceneView extends View{
    private AnsMoveStudent1Msg answerMsg;
    public MoveStudent2SceneView(AnsMoveStudent1Msg answerMsg){
        this.answerMsg=answerMsg;
    }
    @Override
    public void run() {
        MoveStudent2Scene.setAnswerMsg(this.answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToMoveStudent2Scene();
        });
    }
}
