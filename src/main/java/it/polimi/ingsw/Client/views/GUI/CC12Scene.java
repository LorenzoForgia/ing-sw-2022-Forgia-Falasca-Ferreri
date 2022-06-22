package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.messages.AnsCC12Msg;
import it.polimi.ingsw.messages.AnsCC9Msg;
import it.polimi.ingsw.messages.CC12Msg;
import it.polimi.ingsw.messages.CC9Msg;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class CC12Scene {
    private static AnsCC12Msg answerMsg;

    public static void setAnswerMsg(AnsCC12Msg answerMsg) {
        CC12Scene.answerMsg = answerMsg;
    }
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
        IslandTilesScene.setNumberOfSceneToComeBack(14);
        IslandTilesScene.setIslands(answerMsg.GetGB().GetIslands());
        JavaFXMain.getCurrentApplication().switchToIslandTitleScene();
    }

    public void showSchoolBoard1Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(14);
        SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(0));
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();

    }
    public void showSchoolBoard2Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(14);
        SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(1));
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();

    }
    public void showSchoolBoard3Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(14);
        SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(2));
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();
    }

    public void showSchoolBoard4Selected(){
        SchoolBoardScene.setNumberOfSceneToComeBack(14);
        SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(3));
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();
    }
    public void BlueSelected(){
        color=Color.Blue;
        CC12Msg cc12Msg= new CC12Msg(color);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(cc12Msg);
    }
    public void YellowSelected(){
        color=Color.Yellow;
        CC12Msg cc12Msg= new CC12Msg(color);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(cc12Msg);
    }
    public void GreenSelected(){
        color=Color.Green;
        CC12Msg cc12Msg= new CC12Msg(color);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(cc12Msg);
    }
    public void RedSelected(){
        color=Color.Red;
        CC12Msg cc12Msg= new CC12Msg(color);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(cc12Msg);
    }
    public void PinkSelected(){
        color=Color.Pink;
        CC12Msg cc12Msg= new CC12Msg(color);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(cc12Msg);
    }
}
