package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.messages.AnsAskCAMsg;
import it.polimi.ingsw.messages.AnsFirstPlayerTurnMsg;
import it.polimi.ingsw.messages.MoveStudent1Msg;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.*;


public class MoveStudent1Scene {
    private static Color color;
    private static int location;
    @FXML
    private ImageView imageIsland;
    @FXML
    private ImageView imageFirstSchoolBoard;
    @FXML
    private ImageView imageSecondSchoolBoard;
    @FXML
    private ImageView imageThirdSchoolBoard;
    @FXML
    private ImageView imageFourthSchoolBoard;
    @FXML
    private Label showSchoolBoard1;
    @FXML
    private Label showSchoolBoard2;
    @FXML
    private Label showSchoolBoard3;
    @FXML
    private Label showSchoolBoard4;

    private static AnsAskCAMsg answerMsg;

    public static void setAnswerMsg(AnsAskCAMsg answerMsg) {
        MoveStudent1Scene.answerMsg = answerMsg;
    }

    public void initialize() {
        if(answerMsg.GetPlayers().size()==2){
            imageFourthSchoolBoard.setImage(null);
            imageThirdSchoolBoard.setImage(null);
        }else if(answerMsg.GetPlayers().size()==3){

        }else{

        }
    }


    public void BlueSelected(){
        color=Color.Blue;
        JavaFXMain.getCurrentApplication().switchToMS1DiningOrIslandScene();
    }
    public void YellowSelected(){
        color=Color.Yellow;
        JavaFXMain.getCurrentApplication().switchToMS1DiningOrIslandScene();
    }
    public void GreenSelected(){
        color=Color.Green;
        JavaFXMain.getCurrentApplication().switchToMS1DiningOrIslandScene();
    }
    public void RedSelected(){
        color=Color.Red;
        JavaFXMain.getCurrentApplication().switchToMS1DiningOrIslandScene();
    }
    public void PinkSelected(){
        color=Color.Pink;
        JavaFXMain.getCurrentApplication().switchToMS1DiningOrIslandScene();
    }
    public void DiningClicked(ActionEvent event){
        location=12;
        MoveStudent1Msg moveStudent1Msg= new MoveStudent1Msg(color, location);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(moveStudent1Msg);
    }
    public void IslandClicked(ActionEvent event){
        JavaFXMain.getCurrentApplication().switchToIslandTitleScene();
    }

    public void showGeneralBoardSelected(){

    }

    public void showShowSchoolBoard1Selected(){

    }
    public void showShowSchoolBoard2Selected(){

    }
    public void showShowSchoolBoard3Selected(){

    }

    public void showShowSchoolBoard4Selected(){

    }


}
