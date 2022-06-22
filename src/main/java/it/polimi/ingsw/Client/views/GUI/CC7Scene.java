package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.messages.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class CC7Scene {
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
    @FXML
    private Label Title;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Circle Blue;
    @FXML
    private Circle Red;
    @FXML
    private Circle Yellow;
    @FXML
    private Circle Green;
    @FXML
    private Circle Pink;
    @FXML
    private Circle student1;
    @FXML
    private Circle student2;
    @FXML
    private Circle student3;
    @FXML
    private Circle student4;
    @FXML
    private Circle student5;
    @FXML
    private Circle student6;

    private static ArrayList<Color> studentsCard= new ArrayList<>();
    private static ArrayList<Color> studentsEntrance= new ArrayList<>();
    private static AnsCC7Msg answerMsg;
    private static boolean choseNumber;
    private static int numberOfCard;
    private static int numberOfEntrance;

    public static void setAnswerMsg(AnsCC7Msg answerMsg) {
        CC7Scene.answerMsg = answerMsg;
    }

    public static void setChoseNumber(boolean choseNumber) {
        CC7Scene.choseNumber = choseNumber;
    }

    public void initialize() {
        getTheRightColor(((CharacterCard7)answerMsg.GetCharacterCard()).getStudentOnCard().get(0), student1);
        getTheRightColor(((CharacterCard7)answerMsg.GetCharacterCard()).getStudentOnCard().get(1), student2);
        getTheRightColor(((CharacterCard7)answerMsg.GetCharacterCard()).getStudentOnCard().get(2), student3);
        getTheRightColor(((CharacterCard7)answerMsg.GetCharacterCard()).getStudentOnCard().get(3), student4);
        getTheRightColor(((CharacterCard7)answerMsg.GetCharacterCard()).getStudentOnCard().get(4), student5);
        getTheRightColor(((CharacterCard7)answerMsg.GetCharacterCard()).getStudentOnCard().get(5), student6);
        if(choseNumber){
            button1.setVisible(false);
            button2.setVisible(false);
            button3.setVisible(false);
            if(numberOfCard!=0){
                Title.setText("Scegli lo studente dalla carta!");
            }else{
                Title.setText("Scegli lo studente dal tuo ingresso!");
            }
        }else{
            Blue.setVisible(false);
            Red.setVisible(false);
            Yellow.setVisible(false);
            Pink.setVisible(false);
            Green.setVisible(false);
        }
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

    public void button1Clicked(ActionEvent event){
        numberOfCard=1;
        numberOfEntrance=1;
        choseNumber=true;
        JavaFXMain.getCurrentApplication().switchToCC7Scene();
    }
    public void button2Clicked(ActionEvent event){
        numberOfCard=2;
        numberOfEntrance=2;
        choseNumber=true;
        JavaFXMain.getCurrentApplication().switchToCC7Scene();
    }
    public void button3Clicked(ActionEvent event){
        numberOfCard=3;
        numberOfEntrance=3;
        choseNumber=true;
        JavaFXMain.getCurrentApplication().switchToCC7Scene();
    }

    public void showSchoolBoard1Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(17);
        SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(0));
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();

    }
    public void showSchoolBoard2Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(17);
        SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(1));
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();

    }
    public void showSchoolBoard3Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(17);
        SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(2));
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();
    }

    public void showSchoolBoard4Selected(){
        SchoolBoardScene.setNumberOfSceneToComeBack(17);
        SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(3));
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();
    }
    public void BlueSelected(){
        if(numberOfCard!=0){
            studentsCard.add(Color.Blue);
            numberOfCard= numberOfCard-1;
            JavaFXMain.getCurrentApplication().switchToCC7Scene();
        }else{
            if(numberOfEntrance!=1){
                studentsEntrance.add(Color.Blue);
                numberOfEntrance= numberOfEntrance-1;
                JavaFXMain.getCurrentApplication().switchToCC7Scene();
            }else{
                studentsEntrance.add(Color.Blue);
                CC7Msg cc7Msg= new CC7Msg(studentsCard, studentsEntrance);
                JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(cc7Msg);
            }
        }

    }
    public void YellowSelected(){
        if(numberOfCard!=0){
            studentsCard.add(Color.Yellow);
            numberOfCard= numberOfCard-1;
            JavaFXMain.getCurrentApplication().switchToCC7Scene();
        }else{
            if(numberOfEntrance!=1){
                studentsEntrance.add(Color.Yellow);
                numberOfEntrance= numberOfEntrance-1;
                JavaFXMain.getCurrentApplication().switchToCC7Scene();
            }else{
                studentsEntrance.add(Color.Yellow);
                CC7Msg cc7Msg= new CC7Msg(studentsCard, studentsEntrance);
                JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(cc7Msg);
            }
        }
    }
    public void GreenSelected(){
        if(numberOfCard!=0){
            studentsCard.add(Color.Green);
            numberOfCard= numberOfCard-1;
            JavaFXMain.getCurrentApplication().switchToCC7Scene();
        }else{
            if(numberOfEntrance!=1){
                studentsEntrance.add(Color.Green);
                numberOfEntrance= numberOfEntrance-1;
                JavaFXMain.getCurrentApplication().switchToCC7Scene();
            }else{
                studentsEntrance.add(Color.Green);
                CC7Msg cc7Msg= new CC7Msg(studentsCard, studentsEntrance);
                JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(cc7Msg);
            }
        }

    }
    public void RedSelected(){
        if(numberOfCard!=0){
            studentsCard.add(Color.Red);
            numberOfCard= numberOfCard-1;
            JavaFXMain.getCurrentApplication().switchToCC7Scene();
        }else{
            if(numberOfEntrance!=1){
                studentsEntrance.add(Color.Red);
                numberOfEntrance= numberOfEntrance-1;
                JavaFXMain.getCurrentApplication().switchToCC7Scene();
            }else{
                studentsEntrance.add(Color.Red);
                CC7Msg cc7Msg= new CC7Msg(studentsCard, studentsEntrance);
                JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(cc7Msg);
            }
        }
    }
    public void PinkSelected(){
        if(numberOfCard!=0){
            studentsCard.add(Color.Pink);
            numberOfCard= numberOfCard-1;
            JavaFXMain.getCurrentApplication().switchToCC7Scene();
        }else{
            if(numberOfEntrance!=1){
                studentsEntrance.add(Color.Pink);
                numberOfEntrance= numberOfEntrance-1;
                JavaFXMain.getCurrentApplication().switchToCC7Scene();
            }else{
                studentsEntrance.add(Color.Pink);
                CC7Msg cc7Msg= new CC7Msg(studentsCard, studentsEntrance);
                JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(cc7Msg);
            }
        }
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
}
