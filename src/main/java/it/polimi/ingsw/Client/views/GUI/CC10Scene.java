package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.messages.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

import javafx.event.ActionEvent;
import java.util.ArrayList;

public class CC10Scene {
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
    private Circle Blue;
    @FXML
    private Circle Red;
    @FXML
    private Circle Yellow;
    @FXML
    private Circle Green;
    @FXML
    private Circle Pink;

    private static ArrayList<Color> studentsDining= new ArrayList<>();
    private static ArrayList<Color> studentsEntrance= new ArrayList<>();
    private static AnsCC10Msg answerMsg;
    private static boolean choseNumber;
    private static int numberOfDiningRoom;
    private static int numberOfEntrance;

    public static void setAnswerMsg(AnsCC10Msg answerMsg) {
        CC10Scene.answerMsg = answerMsg;
    }

    public static void setChosenNumber(boolean chosenNumber) {
        CC10Scene.choseNumber = chosenNumber;
    }

    public void initialize() {
        if(choseNumber){
            button1.setVisible(false);
            button2.setVisible(false);
            if(numberOfDiningRoom!=0){
                Title.setText("Scegli lo studente dalla tua sala!");
            }else{
                Title.setText("Scegli lo studente dal tuo ingresso!");
            }
        }else{
            Blue.setVisible(false);
            Red.setVisible(false);
            Yellow.setVisible(false);
            Pink.setVisible(false);
            Green.setVisible(false);
            studentsDining= new ArrayList<>();
            studentsEntrance= new ArrayList<>();
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
        numberOfDiningRoom=1;
        numberOfEntrance=1;
        choseNumber=true;
        JavaFXMain.getCurrentApplication().switchToCC10Scene();
    }
    public void button2Clicked(ActionEvent event){
        numberOfDiningRoom=2;
        numberOfEntrance=2;
        choseNumber=true;
        JavaFXMain.getCurrentApplication().switchToCC10Scene();
    }

    public void showSchoolBoard1Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(16);
        SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(0));
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();

    }
    public void showSchoolBoard2Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(16);
        SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(1));
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();

    }
    public void showSchoolBoard3Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(16);
        SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(2));
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();
    }

    public void showSchoolBoard4Selected(){
        SchoolBoardScene.setNumberOfSceneToComeBack(16);
        SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(3));
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();
    }
    public void BlueSelected(){
        if(numberOfDiningRoom!=0){
            studentsDining.add(Color.Blue);
            numberOfDiningRoom= numberOfDiningRoom-1;
            JavaFXMain.getCurrentApplication().switchToCC10Scene();
        }else{
            if(numberOfEntrance!=1){
                studentsEntrance.add(Color.Blue);
                numberOfEntrance= numberOfEntrance-1;
                JavaFXMain.getCurrentApplication().switchToCC10Scene();
            }else{
                studentsEntrance.add(Color.Blue);
                CC10Msg cc10Msg= new CC10Msg(studentsEntrance, studentsDining);
                JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(cc10Msg);
            }
        }

    }
    public void YellowSelected(){
        if(numberOfDiningRoom!=0){
            studentsDining.add(Color.Yellow);
            numberOfDiningRoom= numberOfDiningRoom-1;
            JavaFXMain.getCurrentApplication().switchToCC10Scene();
        }else{
            if(numberOfEntrance!=1){
                studentsEntrance.add(Color.Yellow);
                numberOfEntrance= numberOfEntrance-1;
                JavaFXMain.getCurrentApplication().switchToCC10Scene();
            }else{
                studentsEntrance.add(Color.Yellow);
                CC10Msg cc10Msg= new CC10Msg(studentsEntrance, studentsDining);
                JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(cc10Msg);
            }
        }
    }
    public void GreenSelected(){
        if(numberOfDiningRoom!=0){
            studentsDining.add(Color.Green);
            numberOfDiningRoom= numberOfDiningRoom-1;
            JavaFXMain.getCurrentApplication().switchToCC10Scene();
        }else{
            if(numberOfEntrance!=1){
                studentsEntrance.add(Color.Green);
                numberOfEntrance= numberOfEntrance-1;
                JavaFXMain.getCurrentApplication().switchToCC10Scene();
            }else{
                studentsEntrance.add(Color.Green);
                CC10Msg cc10Msg= new CC10Msg(studentsEntrance, studentsDining);
                JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(cc10Msg);
            }
        }

    }
    public void RedSelected(){
        if(numberOfDiningRoom!=0){
            studentsDining.add(Color.Red);
            numberOfDiningRoom= numberOfDiningRoom-1;
            JavaFXMain.getCurrentApplication().switchToCC10Scene();
        }else{
            if(numberOfEntrance!=1){
                studentsEntrance.add(Color.Red);
                numberOfEntrance= numberOfEntrance-1;
                JavaFXMain.getCurrentApplication().switchToCC10Scene();
            }else{
                studentsEntrance.add(Color.Red);
                CC10Msg cc10Msg= new CC10Msg(studentsEntrance, studentsDining);
                JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(cc10Msg);
            }
        }
    }
    public void PinkSelected(){
        if(numberOfDiningRoom!=0){
            studentsDining.add(Color.Pink);
            numberOfDiningRoom= numberOfDiningRoom-1;
            JavaFXMain.getCurrentApplication().switchToCC10Scene();
        }else{
            if(numberOfEntrance!=1){
                studentsEntrance.add(Color.Pink);
                numberOfEntrance= numberOfEntrance-1;
                JavaFXMain.getCurrentApplication().switchToCC10Scene();
            }else{
                studentsEntrance.add(Color.Pink);
                CC10Msg cc10Msg= new CC10Msg(studentsEntrance, studentsDining);
                JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(cc10Msg);
            }
        }
    }

}
