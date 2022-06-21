package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Exception.CardAssistantNotAvailableException;
import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.Model.DeckCardAssistant;
import it.polimi.ingsw.messages.AnsFirstPlayerTurnMsg;
import it.polimi.ingsw.messages.TurnDecidedMsg;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class AssistantCardScene {

    @FXML
    private ImageView assistantCard1;
    @FXML
    private ImageView assistantCard2;
    @FXML
    private ImageView assistantCard3;
    @FXML
    private ImageView assistantCard4;
    @FXML
    private ImageView assistantCard5;
    @FXML
    private ImageView assistantCard6;
    @FXML
    private ImageView assistantCard7;
    @FXML
    private ImageView assistantCard8;
    @FXML
    private ImageView assistantCard9;
    @FXML
    private ImageView assistantCard10;
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
    private DeckCardAssistant deckCardAssistant;

    private static AnsFirstPlayerTurnMsg answerMsg;
    public static void setAnswerMsg(AnsFirstPlayerTurnMsg answerMsg) {
        AssistantCardScene.answerMsg = answerMsg;
    }

    public void initialize()
    {
        if(answerMsg.getPl().size()==2){
            imageFourthSchoolBoard.setVisible(false);
            imageFourthSchoolBoard.setOnMouseClicked(null);
            imageThirdSchoolBoard.setOnMouseClicked(null);
            imageThirdSchoolBoard.setVisible(false);
            showSchoolBoard4.setText("");
            showSchoolBoard3.setText("");
            showSchoolBoard1.setText("Plancia di " + answerMsg.getPl().get(0).getNickName());
            showSchoolBoard2.setText("Plancia di " + answerMsg.getPl().get(1).getNickName());
        }else if(answerMsg.getPl().size()==3){
            imageFourthSchoolBoard.setVisible(false);
            imageFourthSchoolBoard.setOnMouseClicked(null);
            showSchoolBoard4.setText("");
            showSchoolBoard1.setText("Plancia di " + answerMsg.getPl().get(0));
            showSchoolBoard2.setText("Plancia di " + answerMsg.getPl().get(1));
            showSchoolBoard3.setText("Plancia di " + answerMsg.getPl().get(2));
        }else{
            showSchoolBoard1.setText("Plancia di " + answerMsg.getPl().get(0));
            showSchoolBoard2.setText("Plancia di " + answerMsg.getPl().get(1));
            showSchoolBoard3.setText("Plancia di " + answerMsg.getPl().get(2));
            showSchoolBoard4.setText("Plancia di " + answerMsg.getPl().get(3));
        }
        deckCardAssistant =answerMsg.getDca();
        if(deckCardAssistant.GetDeck().contains(CardAssistant.Uno)){
            Image imageAssCard1 = new Image("Assistente (1).png");
            assistantCard1.setImage(imageAssCard1);
        }else{
            assistantCard1.setOnMouseClicked(null);
        }
        if(deckCardAssistant.GetDeck().contains(CardAssistant.Due)){
            Image imageAssCard2 = new Image("Assistente (2).png");
            assistantCard2.setImage(imageAssCard2);
        }else{
            assistantCard2.setOnMouseClicked(null);
        }
        if(deckCardAssistant.GetDeck().contains(CardAssistant.Tre)){
            Image imageAssCard3 = new Image("Assistente (3).png");
            assistantCard3.setImage(imageAssCard3);
        }else{
            assistantCard3.setOnMouseClicked(null);
        }
        if(deckCardAssistant.GetDeck().contains(CardAssistant.Quattro)){
            Image imageAssCard4 = new Image("Assistente (4).png");
            assistantCard4.setImage(imageAssCard4);
        }else{
            assistantCard4.setOnMouseClicked(null);
        }
        if(deckCardAssistant.GetDeck().contains(CardAssistant.Cinque)){
            Image imageAssCard5 = new Image("Assistente (5).png");
            assistantCard5.setImage(imageAssCard5);
        }else{
            assistantCard5.setOnMouseClicked(null);
        }
        if(deckCardAssistant.GetDeck().contains(CardAssistant.Sei)){
            Image imageAssCard6 = new Image("Assistente (6).png");
            assistantCard6.setImage(imageAssCard6);
        }else{
            assistantCard6.setOnMouseClicked(null);
        }
        if(deckCardAssistant.GetDeck().contains(CardAssistant.Sette)){
            Image imageAssCard7 = new Image("Assistente (7).png");
            assistantCard7.setImage(imageAssCard7);
        }else{
            assistantCard7.setOnMouseClicked(null);
        }
        if(deckCardAssistant.GetDeck().contains(CardAssistant.Otto)){
            Image imageAssCard8 = new Image("Assistente (8).png");
            assistantCard8.setImage(imageAssCard8);
        }else{
            assistantCard8.setOnMouseClicked(null);
        }
        if(deckCardAssistant.GetDeck().contains(CardAssistant.Nove)){
            Image imageAssCard9 = new Image("Assistente (9).png");
            assistantCard9.setImage(imageAssCard9);
        }else{
            assistantCard9.setOnMouseClicked(null);
        }
        if(deckCardAssistant.GetDeck().contains(CardAssistant.Dieci)){
            Image imageAssCard10 = new Image("Assistente (10).png");
            assistantCard10.setImage(imageAssCard10);
        }else{
            assistantCard10.setOnMouseClicked(null);
        }

    }

    public void chosenCard1(){
        TurnDecidedMsg turnDecidedMsg= new TurnDecidedMsg(CardAssistant.Uno);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(turnDecidedMsg);
        JavaFXMain.getCurrentApplication().switchToWaitingScene();

    }
    public void chosenCard2(){
        TurnDecidedMsg turnDecidedMsg= new TurnDecidedMsg(CardAssistant.Due);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(turnDecidedMsg);
        JavaFXMain.getCurrentApplication().switchToWaitingScene();
    }
    public void chosenCard3(){
        TurnDecidedMsg turnDecidedMsg= new TurnDecidedMsg(CardAssistant.Tre);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(turnDecidedMsg);
        JavaFXMain.getCurrentApplication().switchToWaitingScene();
    }
    public void chosenCard4(){
        TurnDecidedMsg turnDecidedMsg= new TurnDecidedMsg(CardAssistant.Quattro);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(turnDecidedMsg);
        JavaFXMain.getCurrentApplication().switchToWaitingScene();
    }
    public void chosenCard5(){
        TurnDecidedMsg turnDecidedMsg= new TurnDecidedMsg(CardAssistant.Cinque);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(turnDecidedMsg);
        JavaFXMain.getCurrentApplication().switchToWaitingScene();
    }
    public void chosenCard6(){
        TurnDecidedMsg turnDecidedMsg= new TurnDecidedMsg(CardAssistant.Sei);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(turnDecidedMsg);
        JavaFXMain.getCurrentApplication().switchToWaitingScene();
    }
    public void chosenCard7(){
        TurnDecidedMsg turnDecidedMsg= new TurnDecidedMsg(CardAssistant.Sette);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(turnDecidedMsg);
        JavaFXMain.getCurrentApplication().switchToWaitingScene();
    }
    public void chosenCard8(){
        TurnDecidedMsg turnDecidedMsg= new TurnDecidedMsg(CardAssistant.Otto);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(turnDecidedMsg);
        JavaFXMain.getCurrentApplication().switchToWaitingScene();
    }
    public void chosenCard9(){
        TurnDecidedMsg turnDecidedMsg= new TurnDecidedMsg(CardAssistant.Nove);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(turnDecidedMsg);
        JavaFXMain.getCurrentApplication().switchToWaitingScene();
    }
    public void chosenCard10(){
        TurnDecidedMsg turnDecidedMsg= new TurnDecidedMsg(CardAssistant.Uno);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(turnDecidedMsg);
        JavaFXMain.getCurrentApplication().switchToWaitingScene();
    }

    public void showGeneralBoardSelected(){
        IslandTilesScene.setOnlyObserv(true);
        IslandTilesScene.setNumberOfSceneToComeBack(1);
        IslandTilesScene.setIslands(answerMsg.getIs());
        JavaFXMain.getCurrentApplication().switchToIslandTitleScene();
    }

    public void showSchoolBoard1Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(0);
        SchoolBoardScene.setPlayer(answerMsg.getPl().get(0));
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();

    }
    public void showSchoolBoard2Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(0);
        SchoolBoardScene.setPlayer(answerMsg.getPl().get(1));
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();

    }
    public void showSchoolBoard3Selected(){

        SchoolBoardScene.setNumberOfSceneToComeBack(0);
        SchoolBoardScene.setPlayer(answerMsg.getPl().get(2));
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();
    }

    public void showSchoolBoard4Selected(){
        SchoolBoardScene.setNumberOfSceneToComeBack(0);
        SchoolBoardScene.setPlayer(answerMsg.getPl().get(3));
        JavaFXMain.getCurrentApplication().switchToSchoolBoardScene();
    }
    public void showCardAssistantSelected(){
        ShowCardAssistantPlayedScene.setCards(answerMsg.getCAplayed());
        JavaFXMain.getCurrentApplication().switchToShowCardAssistantScene();
    }


}
