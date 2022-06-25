package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.messages.AnsEndGameMsg;
import it.polimi.ingsw.messages.AnsGameStartedMsg;
import it.polimi.ingsw.messages.FirstPlayerTurnMsg;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class EndGameScene {
    @FXML
    private Label player1;
    @FXML
    private Label player2;

    private static AnsEndGameMsg answerMsg;

    public static void setAnswerMsg(AnsEndGameMsg answerMsg) {
        EndGameScene.answerMsg = answerMsg;
    }

    public void initialize(){
        for(int i=0; i<answerMsg.getWinner().size(); i++){
            if(i==0){
                player1.setText(answerMsg.getWinner().get(i));
            }else if(i==1){
                player2.setText(answerMsg.getWinner().get(i));
            }
        }
    }
}
