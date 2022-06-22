package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Model.Color;

import it.polimi.ingsw.messages.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class MoveStudent4Scene {
    private static Color color;

    @FXML
    private Label showSchoolBoard1;
    @FXML
    private Label showSchoolBoard2;
    @FXML
    private Label showSchoolBoard3;
    @FXML
    private Label showSchoolBoard4;
    @FXML
    private ImageView imageThirdSchoolBoard;
    @FXML
    private ImageView imageFourthSchoolBoard;
    private static AnsMoveStudent3Msg answerMsg;
    private static AnsPlayAfterCCMsg ansPlayAfterCCMsg;
    private static AnsPlayAfterNotCCMsg ansPlayAfterNotCCMsg;
    private static int numberOfMessage;

    /** is used to know which answerMessage has to use
     * 0 is for answerMsg
     * 1 is for ansPlayAfterCCMsg
     * 2 is for ansPlayNotAfterCCMsg
     * **/
    public static void setNumberOfMessage(int numberOfMessage) {
        MoveStudent4Scene.numberOfMessage = numberOfMessage;
    }

    public static AnsPlayAfterCCMsg getAnsPlayAfterCCMsg() {
        return ansPlayAfterCCMsg;
    }

    public static AnsPlayAfterNotCCMsg getAnsPlayAfterNotCCMsg() {
        return ansPlayAfterNotCCMsg;
    }

    public static int getNumberOfMessage() {
        return numberOfMessage;
    }

    public static void setAnsPlayAfterCCMsg(AnsPlayAfterCCMsg ansPlayAfterCCMsg) {
        MoveStudent4Scene.ansPlayAfterCCMsg = ansPlayAfterCCMsg;
    }

    public static void setAnsPlayAfterNotCCMsg(AnsPlayAfterNotCCMsg ansPlayAfterNotCCMsg) {
        MoveStudent4Scene.ansPlayAfterNotCCMsg = ansPlayAfterNotCCMsg;
    }

    public static void setAnswerMsg(AnsMoveStudent3Msg answerMsg) {
        MoveStudent4Scene.answerMsg = answerMsg;
    }

    public static AnsMoveStudent3Msg getAnswerMsg() {
        return answerMsg;
    }

    public static Color getColor() {
        return color;
    }

    public void initialize() {
        if(numberOfMessage==0) {
            if (answerMsg.GetPlayers().size() == 2) {
                imageFourthSchoolBoard.setVisible(false);
                imageFourthSchoolBoard.setOnMouseClicked(null);
                imageThirdSchoolBoard.setOnMouseClicked(null);
                imageThirdSchoolBoard.setVisible(false);
                showSchoolBoard4.setText("");
                showSchoolBoard3.setText("");
                showSchoolBoard1.setText("Plancia di " + answerMsg.GetPlayers().get(0).getNickName());
                showSchoolBoard2.setText("Plancia di " + answerMsg.GetPlayers().get(1).getNickName());
            } else if (answerMsg.GetPlayers().size() == 3) {
                imageFourthSchoolBoard.setVisible(false);
                imageFourthSchoolBoard.setOnMouseClicked(null);
                showSchoolBoard4.setText("");
                showSchoolBoard1.setText("Plancia di " + answerMsg.GetPlayers().get(0).getNickName());
                showSchoolBoard2.setText("Plancia di " + answerMsg.GetPlayers().get(1).getNickName());
                showSchoolBoard3.setText("Plancia di " + answerMsg.GetPlayers().get(2).getNickName());
            } else {
                showSchoolBoard1.setText("Plancia di " + answerMsg.GetPlayers().get(0).getNickName());
                showSchoolBoard2.setText("Plancia di " + answerMsg.GetPlayers().get(1).getNickName());
                showSchoolBoard3.setText("Plancia di " + answerMsg.GetPlayers().get(2).getNickName());
                showSchoolBoard4.setText("Plancia di " + answerMsg.GetPlayers().get(3).getNickName());
            }
        }else if(numberOfMessage==1){
            if (ansPlayAfterCCMsg.GetPlayers().size() == 2) {
                imageFourthSchoolBoard.setVisible(false);
                imageFourthSchoolBoard.setOnMouseClicked(null);
                imageThirdSchoolBoard.setOnMouseClicked(null);
                imageThirdSchoolBoard.setVisible(false);
                showSchoolBoard4.setText("");
                showSchoolBoard3.setText("");
                showSchoolBoard1.setText("Plancia di " + ansPlayAfterCCMsg.GetPlayers().get(0).getNickName());
                showSchoolBoard2.setText("Plancia di " + ansPlayAfterCCMsg.GetPlayers().get(1).getNickName());
            } else if (ansPlayAfterCCMsg.GetPlayers().size() == 3) {
                imageFourthSchoolBoard.setVisible(false);
                imageFourthSchoolBoard.setOnMouseClicked(null);
                showSchoolBoard4.setText("");
                showSchoolBoard1.setText("Plancia di " + ansPlayAfterCCMsg.GetPlayers().get(0).getNickName());
                showSchoolBoard2.setText("Plancia di " + ansPlayAfterCCMsg.GetPlayers().get(1).getNickName());
                showSchoolBoard3.setText("Plancia di " + ansPlayAfterCCMsg.GetPlayers().get(2).getNickName());
            } else {
                showSchoolBoard1.setText("Plancia di " + ansPlayAfterCCMsg.GetPlayers().get(0).getNickName());
                showSchoolBoard2.setText("Plancia di " + ansPlayAfterCCMsg.GetPlayers().get(1).getNickName());
                showSchoolBoard3.setText("Plancia di " + ansPlayAfterCCMsg.GetPlayers().get(2).getNickName());
                showSchoolBoard4.setText("Plancia di " + ansPlayAfterCCMsg.GetPlayers().get(3).getNickName());
            }

        }else if(numberOfMessage==2){
            if (ansPlayAfterNotCCMsg.GetPlayers().size() == 2) {
                imageFourthSchoolBoard.setVisible(false);
                imageFourthSchoolBoard.setOnMouseClicked(null);
                imageThirdSchoolBoard.setOnMouseClicked(null);
                imageThirdSchoolBoard.setVisible(false);
                showSchoolBoard4.setText("");
                showSchoolBoard3.setText("");
                showSchoolBoard1.setText("Plancia di " + ansPlayAfterNotCCMsg.GetPlayers().get(0).getNickName());
                showSchoolBoard2.setText("Plancia di " + ansPlayAfterNotCCMsg.GetPlayers().get(1).getNickName());
            } else if (ansPlayAfterNotCCMsg.GetPlayers().size() == 3) {
                imageFourthSchoolBoard.setVisible(false);
                imageFourthSchoolBoard.setOnMouseClicked(null);
                showSchoolBoard4.setText("");
                showSchoolBoard1.setText("Plancia di " + ansPlayAfterNotCCMsg.GetPlayers().get(0).getNickName());
                showSchoolBoard2.setText("Plancia di " + ansPlayAfterNotCCMsg.GetPlayers().get(1).getNickName());
                showSchoolBoard3.setText("Plancia di " + ansPlayAfterNotCCMsg.GetPlayers().get(2).getNickName());
            } else {
                showSchoolBoard1.setText("Plancia di " + ansPlayAfterNotCCMsg.GetPlayers().get(0).getNickName());
                showSchoolBoard2.setText("Plancia di " + ansPlayAfterNotCCMsg.GetPlayers().get(1).getNickName());
                showSchoolBoard3.setText("Plancia di " + ansPlayAfterNotCCMsg.GetPlayers().get(2).getNickName());
                showSchoolBoard4.setText("Plancia di " + ansPlayAfterNotCCMsg.GetPlayers().get(3).getNickName());
            }
        }
    }


    public void BlueSelected(){
        color=Color.Blue;
        JavaFXMain.getCurrentApplication().switchToMS4DiningOrIslandScene();
    }
    public void YellowSelected(){
        color=Color.Yellow;
        JavaFXMain.getCurrentApplication().switchToMS4DiningOrIslandScene();
    }
    public void GreenSelected(){
        color=Color.Green;
        JavaFXMain.getCurrentApplication().switchToMS4DiningOrIslandScene();
    }
    public void RedSelected(){
        color=Color.Red;
        JavaFXMain.getCurrentApplication().switchToMS4DiningOrIslandScene();
    }
    public void PinkSelected(){
        color=Color.Pink;
        JavaFXMain.getCurrentApplication().switchToMS4DiningOrIslandScene();
    }

    public void showGeneralBoardSelected(){
        IslandTilesScene.setOnlyObserv(true);
        IslandTilesScene.setNumberOfSceneToComeBack(4);
        if(numberOfMessage==0) {
            IslandTilesScene.setIslands(answerMsg.GetGB().GetIslands());
        }else if(numberOfMessage==1){
            IslandTilesScene.setIslands(ansPlayAfterCCMsg.GetGB().GetIslands());
        }else if(numberOfMessage==2){
            IslandTilesScene.setIslands(ansPlayAfterNotCCMsg.GetGB().GetIslands());
        }
        JavaFXMain.getCurrentApplication().switchToIslandTitleScene();
    }

    public void showSchoolBoard1Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(4);
        if(numberOfMessage==0) {
            SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(0));
        }else if(numberOfMessage==1){
            IslandTilesScene.setIslands(ansPlayAfterCCMsg.GetGB().GetIslands());
        }else if(numberOfMessage==2){
            IslandTilesScene.setIslands(ansPlayAfterNotCCMsg.GetGB().GetIslands());
        }
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();

    }
    public void showSchoolBoard2Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(4);
        if(numberOfMessage==0) {
            SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(1));
        }else if(numberOfMessage==1){
            IslandTilesScene.setIslands(ansPlayAfterCCMsg.GetGB().GetIslands());
        }else if(numberOfMessage==2){
            IslandTilesScene.setIslands(ansPlayAfterNotCCMsg.GetGB().GetIslands());
        }
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();

    }
    public void showSchoolBoard3Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(4);
        if(numberOfMessage==0) {
            SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(2));
        }else if(numberOfMessage==1){
            IslandTilesScene.setIslands(ansPlayAfterCCMsg.GetGB().GetIslands());
        }else if(numberOfMessage==2){
            IslandTilesScene.setIslands(ansPlayAfterNotCCMsg.GetGB().GetIslands());
        }
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();
    }

    public void showSchoolBoard4Selected(){
        SchoolBoardScene.setNumberOfSceneToComeBack(4);
        if(numberOfMessage==0) {
            SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(3));
        }else if(numberOfMessage==1){
            IslandTilesScene.setIslands(ansPlayAfterCCMsg.GetGB().GetIslands());
        }else if(numberOfMessage==2){
            IslandTilesScene.setIslands(ansPlayAfterNotCCMsg.GetGB().GetIslands());
        }
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();
    }

}
