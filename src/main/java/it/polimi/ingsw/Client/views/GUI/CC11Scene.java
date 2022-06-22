package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.messages.CC11Msg;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class CC11Scene {
    @FXML
    private Circle student1;
    @FXML
    private Circle student2;
    @FXML
    private Circle student3;
    @FXML
    private Circle student4;
    private static AnsCC11Msg answerMsg;
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

    public static void setAnswerMsg(AnsCC11Msg answerMsg) {
        CC11Scene.answerMsg = answerMsg;
    }

    public void initialize(){
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
        getTheRightColor(((CharacterCard11)answerMsg.GetCharacterCard()).GetchoosenStudent().get(0), student1);
        getTheRightColor(((CharacterCard11)answerMsg.GetCharacterCard()).GetchoosenStudent().get(1), student2);
        getTheRightColor(((CharacterCard11)answerMsg.GetCharacterCard()).GetchoosenStudent().get(2), student3);
        getTheRightColor(((CharacterCard11)answerMsg.GetCharacterCard()).GetchoosenStudent().get(3), student4);
    }

    public void chosenStudent1(){
        CC11Msg cc11msg= new  CC11Msg(((CharacterCard11)answerMsg.GetCharacterCard()).GetchoosenStudent().get(0));
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(cc11msg);
    }
    public void chosenStudent2(){
        CC11Msg cc11msg= new  CC11Msg(((CharacterCard11)answerMsg.GetCharacterCard()).GetchoosenStudent().get(1));
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(cc11msg);

    }
    public void chosenStudent3(){
        CC11Msg cc11msg= new  CC11Msg(((CharacterCard11)answerMsg.GetCharacterCard()).GetchoosenStudent().get(2));
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(cc11msg);
    }
    public void chosenStudent4(){
        CC11Msg cc11msg= new  CC11Msg(((CharacterCard11)answerMsg.GetCharacterCard()).GetchoosenStudent().get(3));
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(cc11msg);
    }

    private void getTheRightColor(it.polimi.ingsw.Model.Color color, Circle circle){
        if(color.equals(it.polimi.ingsw.Model.Color.Green)){
            circle.setFill(javafx.scene.paint.Color.GREEN);
        }else if(color.equals(it.polimi.ingsw.Model.Color.Red)){
            circle.setFill(javafx.scene.paint.Color.RED);
        }else if(color.equals(it.polimi.ingsw.Model.Color.Yellow)){
            circle.setFill(javafx.scene.paint.Color.YELLOW);
        }else if(color.equals(it.polimi.ingsw.Model.Color.Pink)){
            circle.setFill(javafx.scene.paint.Color.PINK);
        }else if(color.equals(it.polimi.ingsw.Model.Color.Blue)){
            circle.setFill(javafx.scene.paint.Color.BLUE);
        }
    }
    public void showSchoolBoard1Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(15);
        SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(0));
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();

    }
    public void showSchoolBoard2Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(15);
        SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(1));
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();

    }
    public void showSchoolBoard3Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(15);
        SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(2));
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();
    }

    public void showSchoolBoard4Selected(){
        SchoolBoardScene.setNumberOfSceneToComeBack(15);
        SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(3));
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();
    }
}
