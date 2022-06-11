package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.*;
import it.polimi.ingsw.Client.views.TitleView;
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
        Thread serverHandlerThread = new Thread(serverHandler, "server_" + server.getInetAddress().getHostAddress());
        serverHandlerThread.start();
        JavaFXMain.getCurrentApplication().switchToLoginScene();
/*
        JavaFXMain.getCurrentApplication().setServerHandler(new ServerHandler(server, JavaFXMain.getCurrentApplication().getClient()));
        Thread serverHandlerThread = new Thread(JavaFXMain.getCurrentApplication().getServerHandler(), "server_" + server.getInetAddress().getHostAddress());


/*
        JavaFXMain app = JavaFXMain.getCurrentApplication();
        ServerHandler sh = app.getServerHandler();
        connectBtn.setDisable(true);
        sh.setConnectionCompleteObserver((ok) -> {
            Platform.runLater(() -> {
                if (!ok) {

                    Alert alert = new Alert(Alert.AlertType.ERROR, "Connection not successful...", ButtonType.OK);
                    alert.showAndWait();
                    connectBtn.setDisable(false);
                } else {
                    sh.sendMessage(new LoginMessage(usernameBox.getText()));
                    sh.setConnectionCompleteObserver(null);
                    app.switchToLoginScene();
                }
            });
        });
        app.getServerHandler().attemptConnection(ip, port);
*/
    }
}
