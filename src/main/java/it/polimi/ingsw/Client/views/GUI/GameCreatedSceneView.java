package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.messages.BooleanCheckMsg;
import it.polimi.ingsw.messages.GameStartedMsg;
import it.polimi.ingsw.messages.NewGameMsg;
import javafx.application.Platform;

import java.util.Scanner;

public class GameCreatedSceneView {
    /** The view of the gamecreated */

    private BooleanCheckMsg answerMsg;


    public GameCreatedSceneView(BooleanCheckMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }


    public void run() {



        BooleanCheckMsg.Status moveStatus = answerMsg.getMoveStatus();


        Platform.runLater(() -> {
            GameStartedMsg gameStartedMsg= new GameStartedMsg();
            JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(gameStartedMsg);

        });




    }
}
