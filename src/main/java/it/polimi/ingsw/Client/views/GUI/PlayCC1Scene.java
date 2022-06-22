package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.messages.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class PlayCC1Scene {
    @FXML
    private ImageView imageFirstCharacterCard;
    @FXML
    private ImageView imageSecondCharacterCard;
    @FXML
    private ImageView imageThirdCharacterCard;
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
    private Circle color1;
    @FXML
    private Circle color2;
    @FXML
    private Circle color3;
    @FXML
    private Circle color4;
    @FXML
    private Circle color5;
    @FXML
    private Circle color6;
    @FXML
    private Circle color11;
    @FXML
    private Circle color21;
    @FXML
    private Circle color31;
    @FXML
    private Circle color41;
    @FXML
    private Circle color51;
    @FXML
    private Circle color61;
    @FXML
    private Circle color12;
    @FXML
    private Circle color22;
    @FXML
    private Circle color32;
    @FXML
    private Circle color42;
    @FXML
    private Circle color52;
    @FXML
    private Circle color62;

    private static ArrayList<CharacterCard> cards;
    private static ArrayList<Player> players;
    private static ArrayList<IslandTiles> islands;

    private static AnsAskCAMsg answerMsg;
    private static AnsMoveStudent1Msg ansMoveStudent1Msg;
    private static AnsMoveStudent2Msg ansMoveStudent2Msg;
    private static AnsMoveStudent3Msg ansMoveStudent3Msg;
    private static AnsMoveStudent4Msg ansMoveStudent4Msg;
    private static int numberOfMessage;


    public void setImageFirstCharacterCard(ImageView imageFirstCharacterCard) {
        this.imageFirstCharacterCard = imageFirstCharacterCard;
    }

    public static void setCards(ArrayList<CharacterCard> cards) {
        PlayCC1Scene.cards = cards;
    }

    public static void setPlayers(ArrayList<Player> players) {
        PlayCC1Scene.players = players;
    }

    public static void setIslands(ArrayList<IslandTiles> islands) {
        PlayCC1Scene.islands = islands;
    }

    /** is used to know which answerMessage has to use
     * 0 is for answerMsg
     * 1 is for ansMoveStudent1Msg
     * 2 is for ansMoveStudent2Msg
     *  3 is for ansMoveStudent3Msg
     *  4 is for ansMoveStudent4Msg
     * **/
    public static void setNumberOfMessage(int numberOfMessage) {
        PlayCC1Scene.numberOfMessage = numberOfMessage;
    }

    public static void setAnsAskCAMsg(AnsAskCAMsg ansAskCAMsg) {
        PlayCC1Scene.answerMsg = ansAskCAMsg;
    }

    public static void setAnsMoveStudent1Msg(AnsMoveStudent1Msg ansMoveStudent1Msg) {
        PlayCC1Scene.ansMoveStudent1Msg = ansMoveStudent1Msg;
    }

    public static void setAnsMoveStudent2Msg(AnsMoveStudent2Msg ansMoveStudent2Msg) {
        PlayCC1Scene.ansMoveStudent2Msg = ansMoveStudent2Msg;
    }

    public static void setAnsMoveStudent3Msg(AnsMoveStudent3Msg ansMoveStudent3Msg) {
        PlayCC1Scene.ansMoveStudent3Msg = ansMoveStudent3Msg;
    }

    public static void setAnsMoveStudent4Msg(AnsMoveStudent4Msg ansMoveStudent4Msg) {
        PlayCC1Scene.ansMoveStudent4Msg = ansMoveStudent4Msg;
    }

    public void initialize() {
        ArrayList<ImageView> imageCharacterCard = new ArrayList<>();
        ArrayList<ArrayList<Circle>> students = new ArrayList<>(3);
        ArrayList<Circle> student1 = new ArrayList<>();
        student1.add(0,color1);
        student1.add(1,color2);
        student1.add(2,color3);
        student1.add(3,color4);
        student1.add(4,color5);
        student1.add(5,color6);
        ArrayList<Circle> student2 = new ArrayList<>();
        student2.add(0,color11);
        student2.add(1,color21);
        student2.add(2,color31);
        student2.add(3,color41);
        student2.add(4,color51);
        student2.add(5,color61);
        ArrayList<Circle> student3 = new ArrayList<>();
        student3.add(0,color12);
        student3.add(1,color22);
        student3.add(2,color32);
        student3.add(3,color42);
        student3.add(4,color52);
        student3.add(5,color62);
        students.add(0,student1);
        students.add(1, student2);
        students.add(2,student3);
        for(int i=0; i< 3; i++){
            for(int j=0; j<6; j++){
                students.get(i).get(j).setVisible(false);
            }
        }
        imageCharacterCard.add(0, imageFirstCharacterCard);
        imageCharacterCard.add(1, imageSecondCharacterCard);
        imageCharacterCard.add(2, imageThirdCharacterCard);

        for (int i = 0; i < 3; i++) {
            if (cards.get(i).getName() == 1) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front.jpg"));
                for(int j=0; j < 4; j++){
                    students.get(i).get(j).setVisible(true);
                    getTheRightColor(((CharacterCard1)cards.get(i)).GetchoosenStudent().get(j), students.get(i).get(j));
                }
            } else if (cards.get(i).getName() == 2) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front2.jpg"));
            } else if (cards.get(i).getName() == 3) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front3.jpg"));
            } else if (cards.get(i).getName() == 4) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front4.jpg"));
            } else if (cards.get(i).getName() == 5) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front5.jpg"));
            } else if (cards.get(i).getName() == 6) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front6.jpg"));
            } else if (cards.get(i).getName() == 7) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front7.jpg"));
                for(int j=0; j < 6; j++){
                    students.get(i).get(j).setVisible(true);
                    getTheRightColor(((CharacterCard7)cards.get(i)).getStudentOnCard().get(j), students.get(i).get(j));
                }
            } else if (cards.get(i).getName() == 8) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front8.jpg"));
            } else if (cards.get(i).getName() == 9) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front9.jpg"));
            } else if (cards.get(i).getName() == 10) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front10.jpg"));
            } else if (cards.get(i).getName() == 11) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front11.jpg"));
                for(int j=0; j < 4; j++){
                    students.get(i).get(j).setVisible(true);
                    getTheRightColor(((CharacterCard11)cards.get(i)).GetchoosenStudent().get(j), students.get(i).get(j));
                }
            } else if (cards.get(i).getName() == 12) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front12.jpg"));
            }
        }
        if (players.size() == 2) {
            imageFourthSchoolBoard.setVisible(false);
            imageFourthSchoolBoard.setOnMouseClicked(null);
            imageThirdSchoolBoard.setOnMouseClicked(null);
            imageThirdSchoolBoard.setVisible(false);
            showSchoolBoard4.setText("");
            showSchoolBoard3.setText("");
            showSchoolBoard1.setText("Plancia di " + players.get(0).getNickName());
            showSchoolBoard2.setText("Plancia di " + players.get(1).getNickName());
        } else if (players.size() == 3) {
            imageFourthSchoolBoard.setVisible(false);
            imageFourthSchoolBoard.setOnMouseClicked(null);
            showSchoolBoard4.setText("");
            showSchoolBoard1.setText("Plancia di " + players.get(0).getNickName());
            showSchoolBoard2.setText("Plancia di " + players.get(1).getNickName());
            showSchoolBoard3.setText("Plancia di " + players.get(2).getNickName());
        } else {
            showSchoolBoard1.setText("Plancia di " + players.get(0).getNickName());
            showSchoolBoard2.setText("Plancia di " + players.get(1).getNickName());
            showSchoolBoard3.setText("Plancia di " + players.get(2).getNickName());
            showSchoolBoard4.setText("Plancia di " + players.get(3).getNickName());
        }
    }

    public void noClicked(ActionEvent event){
        if(numberOfMessage==0) {
            MoveStudent1SceneView m = new MoveStudent1SceneView(answerMsg);
            m.run();
        }else if(numberOfMessage==1){
            MoveStudent2SceneView m=new MoveStudent2SceneView(ansMoveStudent1Msg);
            m.run();
        }else if(numberOfMessage==2){
            MoveStudent3SceneView m=new MoveStudent3SceneView(ansMoveStudent2Msg);
            m.run();
        }else if(numberOfMessage==3){
            if(ansMoveStudent3Msg.GetPlayers().size()==3) {
                MoveStudent4SceneView m = new MoveStudent4SceneView(ansMoveStudent3Msg);
                m.run();
            }else {
                AskForMotherNatureSceneView a= new AskForMotherNatureSceneView(ansMoveStudent3Msg);
                a.run();
            }
        }else if(numberOfMessage==4){
            AskForMN3PlayersSceneView a= new AskForMN3PlayersSceneView(ansMoveStudent4Msg);
            a.run();
        }
    }
    public void siClicked(ActionEvent event){
        ChoiceCharacterCardScene.setCards(cards);
        ChoiceCharacterCardScene.setPlayers(players);
        ChoiceCharacterCardScene.setIslands(islands);
        if(numberOfMessage==0) {
            ChoiceCharacterCardScene.setNumberOfMessage(0);
        }else if(numberOfMessage==1){
            ChoiceCharacterCardScene.setNumberOfMessage(1);
        }else if(numberOfMessage==2){
            ChoiceCharacterCardScene.setNumberOfMessage(2);
        }else if (numberOfMessage==3){
            ChoiceCharacterCardScene.setNumberOfMessage(3);
        }else if(numberOfMessage==4){
            ChoiceCharacterCardScene.setNumberOfMessage(4);
        }
        JavaFXMain.getCurrentApplication().switchToChoiceCharacterCardScene();
    }

    public void showGeneralBoardSelected(){
        IslandTilesScene.setOnlyObserv(true);
        IslandTilesScene.setNumberOfSceneToComeBack(9);
        IslandTilesScene.setIslands(islands);
        JavaFXMain.getCurrentApplication().switchToIslandTitleScene();
    }

    public void showSchoolBoard1Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(9);
        SchoolBoardScene.setPlayer(players.get(0));
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();

    }
    public void showSchoolBoard2Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(9);
        SchoolBoardScene.setPlayer(players.get(1));
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();

    }
    public void showSchoolBoard3Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(9);
        SchoolBoardScene.setPlayer(players.get(2));
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();
    }

    public void showSchoolBoard4Selected(){
        SchoolBoardScene.setNumberOfSceneToComeBack(9);
        SchoolBoardScene.setPlayer(players.get(3));
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();
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
