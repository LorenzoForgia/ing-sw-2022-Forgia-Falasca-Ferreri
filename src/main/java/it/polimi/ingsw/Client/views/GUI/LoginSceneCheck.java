package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnswIfAllowedMsg;
import it.polimi.ingsw.messages.AskIfGameCreatedMsg;
import it.polimi.ingsw.messages.LoginMsg;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.util.Scanner;

public class LoginSceneCheck extends View {
    public TextField usernameBox;
    private String testo;
    private AnswIfAllowedMsg answerMsg;

    public LoginSceneCheck(AnswIfAllowedMsg answIfAllowedMsg){
        this.answerMsg=answIfAllowedMsg;
    }
    public void run() {


        AnswIfAllowedMsg.Status moveStatus = answerMsg.getMoveStatus();
        if (moveStatus == AnswIfAllowedMsg.Status.INVALID) {
            Platform.runLater(() -> {
                JavaFXMain.getCurrentApplication().switchToLoginScene();
                Alert alert = new Alert(Alert.AlertType.ERROR, "Esiste già questo nickname!", ButtonType.OK);
                alert.showAndWait();
            });
        } else {
            System.out.println("loggato correttamente");
            /* answer if a game is already created*/
            Platform.runLater(() -> {
                JavaFXMain.getCurrentApplication().switchToWaitingScene();
            });
            JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(new AskIfGameCreatedMsg());

        /*getOwner().terminate();
        nextView = null;*/

        }
    }

    public void loginButtonClicked(ActionEvent event){

        if (usernameBox.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Insert a valid username!", ButtonType.OK);
            alert.showAndWait();
            return;
        }
        //JavaFXMain.getCurrentApplication().switchToNumberOfPlayerScene();
        testo=usernameBox.getText();
        LoginMsg login=new LoginMsg(testo);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(login);

    }
}

