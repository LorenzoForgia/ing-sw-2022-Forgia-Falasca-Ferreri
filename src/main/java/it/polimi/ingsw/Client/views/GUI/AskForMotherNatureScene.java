package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.messages.AnsMoveStudent3Msg;
import it.polimi.ingsw.messages.AnsPlayAfterCCMsg;
import it.polimi.ingsw.messages.AnsPlayAfterNotCCMsg;
import it.polimi.ingsw.messages.NumStepMNMsg;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class AskForMotherNatureScene {
    private static AnsMoveStudent3Msg answerMsg;
    private static AnsPlayAfterCCMsg ansPlayAfterCCMsg;
    private static AnsPlayAfterNotCCMsg ansPlayAfterNotCCMsg;
    @FXML
    private TextField box;
    private int step;
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
    private ImageView playedCardAssistant;
    private static int numberOfMessage;

    /** is used to know which answerMessage has to use
     * 0 is for answerMsg
     * 1 is for ansPlayAfterCCMsg
     * 2 is for ansPlayNotAfterCCMsg
     * **/
    public static void setNumberOfMessage(int numberOfMessage) {
        AskForMotherNatureScene.numberOfMessage = numberOfMessage;
    }

    public static void setAnsMoveStudent3Msg(AnsMoveStudent3Msg ansMoveStudent3Msg) {
        AskForMotherNatureScene.answerMsg= ansMoveStudent3Msg;
    }

    public static void setAnsPlayAfterNotCCMsg(AnsPlayAfterNotCCMsg ansPlayAfterNotCCMsg) {
        AskForMotherNatureScene.ansPlayAfterNotCCMsg = ansPlayAfterNotCCMsg;
    }

    private CardAssistant getPlayedCard(String nickNamePlayer, ArrayList<Player> players){
        for(int i=0; i< players.size(); i++){
            if(nickNamePlayer.equals(players.get(i).getNickName())){
                return players.get(i).getCA();
            }
        }
        return null;
    }

    private Image shoWImageCA(String nickNamePlayer, ArrayList<Player> players){
        CardAssistant ca=getPlayedCard(nickNamePlayer,players);
        if(ca!=null){
            if(ca.equals(CardAssistant.Uno)){
                return new Image("Assistente (1).png");
            }else if(ca.equals(CardAssistant.Due)){
                return new Image("Assistente (2).png");
            }else if(ca.equals(CardAssistant.Tre)){
                return new Image("Assistente (3).png");
            }else if(ca.equals(CardAssistant.Quattro)){
                return new Image("Assistente (4).png");
            }else if(ca.equals(CardAssistant.Cinque)){
                return new Image("Assistente (5).png");
            }else if(ca.equals(CardAssistant.Sei)){
                return new Image("Assistente (6).png");
            }else if(ca.equals(CardAssistant.Sette)){
                return new Image("Assistente (7).png");
            }else if(ca.equals(CardAssistant.Otto)){
                return new Image("Assistente (8).png");
            }else if(ca.equals(CardAssistant.Nove)){
                return new Image("Assistente (9).png");
            }else {
                return new Image("Assistente 10).png");
            }
        }else{
            return null;
        }
    }
    public void initialize() {
        if(numberOfMessage==0) {
            playedCardAssistant.setImage(shoWImageCA(answerMsg.GetPlayer(), answerMsg.GetPlayers()));
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
            playedCardAssistant.setImage(shoWImageCA(ansPlayAfterCCMsg.GetPlayer(), ansPlayAfterCCMsg.GetPlayers()));
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
        }else if(numberOfMessage==2) {
            playedCardAssistant.setImage(shoWImageCA(ansPlayAfterNotCCMsg.GetPlayer(), ansPlayAfterNotCCMsg.GetPlayers()));
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

    public static void setAnsPlayAfterCCMsg(AnsPlayAfterCCMsg ansPlayAfterCCMsg) {
        AskForMotherNatureScene.ansPlayAfterCCMsg = ansPlayAfterCCMsg;
    }

    public void okClicked(ActionEvent event){
        try{
            step=Integer.parseInt(box.getText());
        }catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Inserisci solo numeri!", ButtonType.OK);
            alert.showAndWait();
            return;
        }
        NumStepMNMsg numStepMNMsg= new NumStepMNMsg(step);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(numStepMNMsg);
    }

    public void showGeneralBoardSelected(){
        IslandTilesScene.setOnlyObserv(true);
        IslandTilesScene.setNumberOfSceneToComeBack(6);
        if(numberOfMessage==0){
            IslandTilesScene.setIslands(answerMsg.GetGB().GetIslands());
        }else if(numberOfMessage==1){
            IslandTilesScene.setIslands(ansPlayAfterCCMsg.GetGB().GetIslands());
        }else if(numberOfMessage==2){
            IslandTilesScene.setIslands(ansPlayAfterNotCCMsg.GetGB().GetIslands());
        }

        JavaFXMain.getCurrentApplication().switchToIslandTitleScene();
    }

    public void showSchoolBoard1Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(6);
        if(numberOfMessage==0){
            SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(0));
        }else if(numberOfMessage==1){
            SchoolBoardScene.setPlayer(ansPlayAfterCCMsg.GetPlayers().get(0));
        }else if(numberOfMessage==2){
            SchoolBoardScene.setPlayer(ansPlayAfterNotCCMsg.GetPlayers().get(0));
        }

        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();

    }
    public void showSchoolBoard2Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(6);
        if(numberOfMessage==0){
            SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(1));
        }else if(numberOfMessage==1){
            SchoolBoardScene.setPlayer(ansPlayAfterCCMsg.GetPlayers().get(1));
        }else if(numberOfMessage==2){
            SchoolBoardScene.setPlayer(ansPlayAfterNotCCMsg.GetPlayers().get(1));
        }
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();

    }
    public void showSchoolBoard3Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(6);
        if(numberOfMessage==0){
            SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(2));
        }else if(numberOfMessage==1){
            SchoolBoardScene.setPlayer(ansPlayAfterCCMsg.GetPlayers().get(2));
        }else if(numberOfMessage==2){
            SchoolBoardScene.setPlayer(ansPlayAfterNotCCMsg.GetPlayers().get(2));
        }
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();
    }

    public void showSchoolBoard4Selected(){
        SchoolBoardScene.setNumberOfSceneToComeBack(6);
        if(numberOfMessage==0){
            SchoolBoardScene.setPlayer(answerMsg.GetPlayers().get(3));
        }else if(numberOfMessage==1){
            SchoolBoardScene.setPlayer(ansPlayAfterCCMsg.GetPlayers().get(3));
        }else if(numberOfMessage==2){
            SchoolBoardScene.setPlayer(ansPlayAfterNotCCMsg.GetPlayers().get(3));
        }
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();
    }

}
