package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.messages.LoginMsg;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class LoginScene {
    public TextField usernameBox;

    public void loginButtonClicked(ActionEvent event){

        if (usernameBox.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Insert a valid username!", ButtonType.OK);
            alert.showAndWait();
            return;
        }
        JavaFXMain.getCurrentApplication().switchToNumberOfPlayerScene();
        /*LoginMsg login=new LoginMsg(usernameBox.getText());
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(login);*/

    }
}
