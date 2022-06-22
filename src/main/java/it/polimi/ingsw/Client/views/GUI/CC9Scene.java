package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Model.DeckCardAssistant;
import it.polimi.ingsw.messages.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class CC9Scene {
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

    private static Color color;
    private static AnsCC9Msg answerMsg;

    public static void setAnswerMsg(AnsCC9Msg answerMsg) {
        CC9Scene.answerMsg = answerMsg;
    }


    public void initialize() {
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
    }
    public void showGeneralBoardSelected(){
        IslandTilesScene.setOnlyObserv(true);
        IslandTilesScene.setNumberOfSceneToComeBack(10);
        IslandTilesScene.setIslands(answerMsg.GetGB().GetIslands());
        JavaFXMain.getCurrentApplication().switchToIslandTitleScene();
    }

    public void showSchoolBoard1Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(10);
        SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(0));
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();

    }
    public void showSchoolBoard2Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(10);
        SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(1));
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();

    }
    public void showSchoolBoard3Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(10);
        SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(2));
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();
    }

    public void showSchoolBoard4Selected(){
        SchoolBoardScene.setNumberOfSceneToComeBack(10);
        SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(3));
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();
    }
    public void BlueSelected(){
        color=Color.Blue;
        CC9Msg cc9Msg= new CC9Msg(color);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(cc9Msg);
    }
    public void YellowSelected(){
        color=Color.Yellow;
        CC9Msg cc9Msg= new CC9Msg(color);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(cc9Msg);
    }
    public void GreenSelected(){
        color=Color.Green;
        CC9Msg cc9Msg= new CC9Msg(color);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(cc9Msg);
    }
    public void RedSelected(){
        color=Color.Red;
        CC9Msg cc9Msg= new CC9Msg(color);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(cc9Msg);
    }
    public void PinkSelected(){
        color=Color.Pink;
        CC9Msg cc9Msg= new CC9Msg(color);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(cc9Msg);
    }

}
