package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.messages.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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

    private static AnsAskCAMsg answerMsg;
    private static AnsMoveStudent1Msg ansMoveStudent1Msg;
    private static AnsMoveStudent2Msg ansMoveStudent2Msg;
    private static AnsMoveStudent3Msg ansMoveStudent3Msg;
    private static AnsMoveStudent4Msg ansMoveStudent4Msg;
    private static int numberOfMessage;


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
        imageCharacterCard.add(0, imageFirstCharacterCard);
        imageCharacterCard.add(1, imageSecondCharacterCard);
        imageCharacterCard.add(2, imageThirdCharacterCard);
        for (int i = 0; i < 3; i++) {
            if (answerMsg.GetCharacterCards().get(i).getName() == 1) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front.jpg"));
            } else if (answerMsg.GetCharacterCards().get(i).getName() == 2) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front2.jpg"));
            } else if (answerMsg.GetCharacterCards().get(i).getName() == 3) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front3.jpg"));
            } else if (answerMsg.GetCharacterCards().get(i).getName() == 4) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front4.jpg"));
            } else if (answerMsg.GetCharacterCards().get(i).getName() == 5) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front5.jpg"));
            } else if (answerMsg.GetCharacterCards().get(i).getName() == 6) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front6.jpg"));
            } else if (answerMsg.GetCharacterCards().get(i).getName() == 7) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front7.jpg"));
            } else if (answerMsg.GetCharacterCards().get(i).getName() == 8) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front8.jpg"));
            } else if (answerMsg.GetCharacterCards().get(i).getName() == 9) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front9.jpg"));
            } else if (answerMsg.GetCharacterCards().get(i).getName() == 10) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front10.jpg"));
            } else if (answerMsg.GetCharacterCards().get(i).getName() == 11) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front11.jpg"));
            } else if (answerMsg.GetCharacterCards().get(i).getName() == 12) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front12.jpg"));
            }
        }
        if (numberOfMessage == 0) {
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
        }else if(numberOfMessage==1) {
            if (ansMoveStudent1Msg.GetPlayers().size() == 2) {
                imageFourthSchoolBoard.setVisible(false);
                imageFourthSchoolBoard.setOnMouseClicked(null);
                imageThirdSchoolBoard.setOnMouseClicked(null);
                imageThirdSchoolBoard.setVisible(false);
                showSchoolBoard4.setText("");
                showSchoolBoard3.setText("");
                showSchoolBoard1.setText("Plancia di " + ansMoveStudent1Msg.GetPlayers().get(0).getNickName());
                showSchoolBoard2.setText("Plancia di " + ansMoveStudent1Msg.GetPlayers().get(1).getNickName());
            } else if (ansMoveStudent1Msg.GetPlayers().size() == 3) {
                imageFourthSchoolBoard.setVisible(false);
                imageFourthSchoolBoard.setOnMouseClicked(null);
                showSchoolBoard4.setText("");
                showSchoolBoard1.setText("Plancia di " + ansMoveStudent1Msg.GetPlayers().get(0).getNickName());
                showSchoolBoard2.setText("Plancia di " + ansMoveStudent1Msg.GetPlayers().get(1).getNickName());
                showSchoolBoard3.setText("Plancia di " + ansMoveStudent1Msg.GetPlayers().get(2).getNickName());
            } else {
                showSchoolBoard1.setText("Plancia di " + ansMoveStudent1Msg.GetPlayers().get(0).getNickName());
                showSchoolBoard2.setText("Plancia di " + ansMoveStudent1Msg.GetPlayers().get(1).getNickName());
                showSchoolBoard3.setText("Plancia di " + ansMoveStudent1Msg.GetPlayers().get(2).getNickName());
                showSchoolBoard4.setText("Plancia di " + ansMoveStudent1Msg.GetPlayers().get(3).getNickName());
            }
        }else if(numberOfMessage==2){
                if (ansMoveStudent2Msg.GetPlayers().size() == 2) {
                    imageFourthSchoolBoard.setVisible(false);
                    imageFourthSchoolBoard.setOnMouseClicked(null);
                    imageThirdSchoolBoard.setOnMouseClicked(null);
                    imageThirdSchoolBoard.setVisible(false);
                    showSchoolBoard4.setText("");
                    showSchoolBoard3.setText("");
                    showSchoolBoard1.setText("Plancia di " + ansMoveStudent2Msg.GetPlayers().get(0).getNickName());
                    showSchoolBoard2.setText("Plancia di " + ansMoveStudent2Msg.GetPlayers().get(1).getNickName());
                } else if (ansMoveStudent2Msg.GetPlayers().size() == 3) {
                    imageFourthSchoolBoard.setVisible(false);
                    imageFourthSchoolBoard.setOnMouseClicked(null);
                    showSchoolBoard4.setText("");
                    showSchoolBoard1.setText("Plancia di " + ansMoveStudent2Msg.GetPlayers().get(0).getNickName());
                    showSchoolBoard2.setText("Plancia di " + ansMoveStudent2Msg.GetPlayers().get(1).getNickName());
                    showSchoolBoard3.setText("Plancia di " + ansMoveStudent2Msg.GetPlayers().get(2).getNickName());
                } else {
                    showSchoolBoard1.setText("Plancia di " + ansMoveStudent2Msg.GetPlayers().get(0).getNickName());
                    showSchoolBoard2.setText("Plancia di " + ansMoveStudent2Msg.GetPlayers().get(1).getNickName());
                    showSchoolBoard3.setText("Plancia di " + ansMoveStudent2Msg.GetPlayers().get(2).getNickName());
                    showSchoolBoard4.setText("Plancia di " + ansMoveStudent2Msg.GetPlayers().get(3).getNickName());
                }
        }else if(numberOfMessage==3) {
            if (ansMoveStudent3Msg.GetPlayers().size() == 2) {
                imageFourthSchoolBoard.setVisible(false);
                imageFourthSchoolBoard.setOnMouseClicked(null);
                imageThirdSchoolBoard.setOnMouseClicked(null);
                imageThirdSchoolBoard.setVisible(false);
                showSchoolBoard4.setText("");
                showSchoolBoard3.setText("");
                showSchoolBoard1.setText("Plancia di " + ansMoveStudent3Msg.GetPlayers().get(0).getNickName());
                showSchoolBoard2.setText("Plancia di " + ansMoveStudent3Msg.GetPlayers().get(1).getNickName());
            } else if (ansMoveStudent3Msg.GetPlayers().size() == 3) {
                imageFourthSchoolBoard.setVisible(false);
                imageFourthSchoolBoard.setOnMouseClicked(null);
                showSchoolBoard4.setText("");
                showSchoolBoard1.setText("Plancia di " + ansMoveStudent3Msg.GetPlayers().get(0).getNickName());
                showSchoolBoard2.setText("Plancia di " + ansMoveStudent3Msg.GetPlayers().get(1).getNickName());
                showSchoolBoard3.setText("Plancia di " + ansMoveStudent3Msg.GetPlayers().get(2).getNickName());
            } else {
                showSchoolBoard1.setText("Plancia di " + ansMoveStudent3Msg.GetPlayers().get(0).getNickName());
                showSchoolBoard2.setText("Plancia di " + ansMoveStudent3Msg.GetPlayers().get(1).getNickName());
                showSchoolBoard3.setText("Plancia di " + ansMoveStudent3Msg.GetPlayers().get(2).getNickName());
                showSchoolBoard4.setText("Plancia di " + ansMoveStudent3Msg.GetPlayers().get(3).getNickName());
            }
        }else if(numberOfMessage==4) {
            if (ansMoveStudent4Msg.GetPlayers().size() == 2) {
                imageFourthSchoolBoard.setVisible(false);
                imageFourthSchoolBoard.setOnMouseClicked(null);
                imageThirdSchoolBoard.setOnMouseClicked(null);
                imageThirdSchoolBoard.setVisible(false);
                showSchoolBoard4.setText("");
                showSchoolBoard3.setText("");
                showSchoolBoard1.setText("Plancia di " + ansMoveStudent4Msg.GetPlayers().get(0).getNickName());
                showSchoolBoard2.setText("Plancia di " + ansMoveStudent4Msg.GetPlayers().get(1).getNickName());
            } else if (ansMoveStudent4Msg.GetPlayers().size() == 3) {
                imageFourthSchoolBoard.setVisible(false);
                imageFourthSchoolBoard.setOnMouseClicked(null);
                showSchoolBoard4.setText("");
                showSchoolBoard1.setText("Plancia di " + ansMoveStudent4Msg.GetPlayers().get(0).getNickName());
                showSchoolBoard2.setText("Plancia di " + ansMoveStudent4Msg.GetPlayers().get(1).getNickName());
                showSchoolBoard3.setText("Plancia di " + ansMoveStudent4Msg.GetPlayers().get(2).getNickName());
            } else {
                showSchoolBoard1.setText("Plancia di " + ansMoveStudent4Msg.GetPlayers().get(0).getNickName());
                showSchoolBoard2.setText("Plancia di " + ansMoveStudent4Msg.GetPlayers().get(1).getNickName());
                showSchoolBoard3.setText("Plancia di " + ansMoveStudent4Msg.GetPlayers().get(2).getNickName());
                showSchoolBoard4.setText("Plancia di " + ansMoveStudent4Msg.GetPlayers().get(3).getNickName());
            }
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
        if(numberOfMessage==0) {
            ChoiceCharacterCardScene.setNumberOfMessage(0);
            ChoiceCharacterCardScene.setAnswerMsg(answerMsg);
        }else if(numberOfMessage==1){
            ChoiceCharacterCardScene.setNumberOfMessage(1);
            ChoiceCharacterCardScene.setAnsMoveStudent1Msg(ansMoveStudent1Msg);
        }else if(numberOfMessage==2){
            ChoiceCharacterCardScene.setNumberOfMessage(2);
            ChoiceCharacterCardScene.setAnsMoveStudent2Msg(ansMoveStudent2Msg);
        }else if (numberOfMessage==3){
            ChoiceCharacterCardScene.setNumberOfMessage(3);
            ChoiceCharacterCardScene.setAnsMoveStudent3Msg(ansMoveStudent3Msg);
        }else if(numberOfMessage==4){
            ChoiceCharacterCardScene.setNumberOfMessage(4);
            ChoiceCharacterCardScene.setAnsMoveStudent4Msg(ansMoveStudent4Msg);
        }
        JavaFXMain.getCurrentApplication().switchToChoiceCharacterCardScene();
    }

    public void showGeneralBoardSelected(){
        IslandTilesScene.setOnlyObserv(true);
        IslandTilesScene.setNumberOfSceneToComeBack(8);
        if(numberOfMessage==0) {
            IslandTilesScene.setIslands(answerMsg.GetGB().GetIslands());
        }else if(numberOfMessage==1){
            IslandTilesScene.setIslands(ansMoveStudent1Msg.GetGB().GetIslands());
        }else if(numberOfMessage==2){
            IslandTilesScene.setIslands(ansMoveStudent2Msg.GetGB().GetIslands());
        }else if (numberOfMessage==3){
            IslandTilesScene.setIslands(ansMoveStudent3Msg.GetGB().GetIslands());
        }else if(numberOfMessage==4){
            IslandTilesScene.setIslands(ansMoveStudent4Msg.GetGB().GetIslands());
        }
        JavaFXMain.getCurrentApplication().switchToIslandTitleScene();
    }

    public void showSchoolBoard1Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(8);
        if(numberOfMessage==0) {
            SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(0));
        }else if(numberOfMessage==1){
            SchoolBoardScene.setPlayer(ansMoveStudent1Msg.GetPlayers().get(0));
        }else if(numberOfMessage==2){
            SchoolBoardScene.setPlayer(ansMoveStudent2Msg.GetPlayers().get(0));
        }else if (numberOfMessage==3){
            SchoolBoardScene.setPlayer(ansMoveStudent3Msg.GetPlayers().get(0));
        }else if(numberOfMessage==4){
            SchoolBoardScene.setPlayer(ansMoveStudent4Msg.GetPlayers().get(0));
        }
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();

    }
    public void showSchoolBoard2Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(8);
        if(numberOfMessage==0) {
            SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(1));
        }else if(numberOfMessage==1){
            SchoolBoardScene.setPlayer(ansMoveStudent1Msg.GetPlayers().get(1));
        }else if(numberOfMessage==2){
            SchoolBoardScene.setPlayer(ansMoveStudent2Msg.GetPlayers().get(1));
        }else if (numberOfMessage==3){
            SchoolBoardScene.setPlayer(ansMoveStudent3Msg.GetPlayers().get(1));
        }else if(numberOfMessage==4){
            SchoolBoardScene.setPlayer(ansMoveStudent4Msg.GetPlayers().get(1));
        }
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();

    }
    public void showSchoolBoard3Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(8);
        if(numberOfMessage==0){
            SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(2));
        }else if(numberOfMessage==1){
            SchoolBoardScene.setPlayer(ansMoveStudent1Msg.GetPlayers().get(2));
        }else if(numberOfMessage==2){
            SchoolBoardScene.setPlayer(ansMoveStudent2Msg.GetPlayers().get(2));
        }else if (numberOfMessage==3){
            SchoolBoardScene.setPlayer(ansMoveStudent3Msg.GetPlayers().get(2));
        }else if(numberOfMessage==4){
            SchoolBoardScene.setPlayer(ansMoveStudent4Msg.GetPlayers().get(2));
        }

        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();
    }

    public void showSchoolBoard4Selected(){
        SchoolBoardScene.setNumberOfSceneToComeBack(0);
        if(numberOfMessage==0) {
            SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(3));
        }else if(numberOfMessage==1){
                SchoolBoardScene.setPlayer(ansMoveStudent1Msg.GetPlayers().get(3));
            }else if(numberOfMessage==2){
                SchoolBoardScene.setPlayer(ansMoveStudent2Msg.GetPlayers().get(3));
            }else if (numberOfMessage==3){
                SchoolBoardScene.setPlayer(ansMoveStudent3Msg.GetPlayers().get(3));
            }else if(numberOfMessage==4){
                SchoolBoardScene.setPlayer(ansMoveStudent4Msg.GetPlayers().get(3));
            }
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();
    }
}
