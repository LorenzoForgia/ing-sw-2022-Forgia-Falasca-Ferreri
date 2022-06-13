package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.LoginMsg;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class LoginScene extends View {
    public TextField usernameBox;
    private String testo;
    @Override
    public void run() {
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToLoginScene();
        });
    }

    public void loginButtonClicked(ActionEvent event){

        if (usernameBox.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Insert a valid username!", ButtonType.OK);
            alert.showAndWait();
            return;
        }
        JavaFXMain.getCurrentApplication().switchToNumberOfPlayerScene();
        testo=usernameBox.getText();
        LoginMsg login=new LoginMsg(testo);
        System.out.println(testo);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(login);

    }
}
