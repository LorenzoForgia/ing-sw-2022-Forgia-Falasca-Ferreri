package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.*;
import it.polimi.ingsw.Client.views.TitleView;
import it.polimi.ingsw.messages.LoginMsg;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.Socket;

public class ConnectionScene {

    public TextField ipServerBox;
    public TextField portBox;
    public Button connectBtn;



    public void connectButtonClicked(ActionEvent event) {

        String ip = ipServerBox.getText();
        int port;
        try {
            port = Integer.parseInt(portBox.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "The port number is not valid!", ButtonType.OK);
            alert.showAndWait();
            return;
        }
        Socket server;
        try {
            server = new Socket(ip, port);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Server is unreachble!", ButtonType.OK);
            alert.showAndWait();
            return;
        }

        ServerHandler serverHandler = new ServerHandler(server,JavaFXMain.getCurrentApplication().getClient() );
        JavaFXMain.getCurrentApplication().getClient().setServerHandler(serverHandler);
        Thread serverHandlerThread = new Thread(serverHandler, "server_" + server.getInetAddress().getHostAddress());
        serverHandlerThread.start();
        JavaFXMain.getCurrentApplication().switchToLoginScene();

    }
}
