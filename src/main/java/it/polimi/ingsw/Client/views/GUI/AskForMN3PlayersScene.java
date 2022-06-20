package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsMoveStudent4Msg;
import it.polimi.ingsw.messages.NumStepMNMsg;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class AskForMN3PlayersScene extends View {
    private AnsMoveStudent4Msg ansMoveStudent4Msg;
    public TextField box;
    private int step=10;

    public AskForMN3PlayersScene(AnsMoveStudent4Msg ansMoveStudent4Msg) {
        this.ansMoveStudent4Msg = ansMoveStudent4Msg;
    }

    @Override
    public void run() {}

    public void okClicked(ActionEvent event){
        for(int i=0; i<6;i++){
            if (box.getText().compareTo(String.valueOf(i))==0) {
                step=i;
            }
        }
        if(step==10){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Inserisci un numero valido!", ButtonType.OK);
            alert.showAndWait();
            return;
        }
        NumStepMNMsg numStepMNMsg= new NumStepMNMsg(step);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(numStepMNMsg);
    }
}
