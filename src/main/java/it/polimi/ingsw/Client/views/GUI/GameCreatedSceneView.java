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

    /**    BooleanCheckMsg.Status moveStatus = answerMsg.getMoveStatus();
        System.out.println("aoooo");
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToWaitingScene();
        });
        GameStartedMsg gameStartedMsg= new GameStartedMsg();
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(gameStartedMsg);
    **/

        BooleanCheckMsg.Status moveStatus = answerMsg.getMoveStatus();

        System.out.println("Game created");
        Platform.runLater(() -> {
            GameStartedMsg gameStartedMsg= new GameStartedMsg();
            JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(gameStartedMsg);
            System.out.println("aoooo");
        });




    }
}
