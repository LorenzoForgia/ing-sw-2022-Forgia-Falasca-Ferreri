package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.messages.AnsGameStartedMsg;
import it.polimi.ingsw.messages.AnsTurnDecidedMsg;
import it.polimi.ingsw.messages.FirstPlayerTurnMsg;
import it.polimi.ingsw.messages.TurnDecidedMsg;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TurnDecideScene {
    @FXML
    private Label player1;
    @FXML
    private Label player2;
    @FXML
    private Label player3;
    @FXML
    private Label player4;
    private static AnsTurnDecidedMsg answerMsg;
    public static void setAnswerMsg(AnsTurnDecidedMsg answerMsg) {
        TurnDecideScene.answerMsg = answerMsg;
    }
    public void initialize(){

        for(int i=0; i<answerMsg.getNickname().size(); i++){
            if(i==0){
                player1.setText(answerMsg.getNickname().get(i));
            }else if(i==1){
                player2.setText(answerMsg.getNickname().get(i));
            }else if(i==2){
                player3.setText(answerMsg.getNickname().get(i));
            }else{
                player4.setText(answerMsg.getNickname().get(i));
            }
        }
        //FirstPlayerTurnMsg firstPlayerTurnMsg = new FirstPlayerTurnMsg();
        //JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(firstPlayerTurnMsg);*/
    }
}
