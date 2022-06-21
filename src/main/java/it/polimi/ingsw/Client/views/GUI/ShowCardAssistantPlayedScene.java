package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Model.CardAssistant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class ShowCardAssistantPlayedScene {
    @FXML
    private ImageView cardAssistant1;
    @FXML
    private ImageView cardAssistant2;
    @FXML
    private ImageView cardAssistant3;
    @FXML
    private Label Title;
    private static ArrayList<CardAssistant> cards;
    private static int numberOfSceneToComeBack;

    /**number to decide where to come back
     * 0 is for AssistantCardScene
     * 5 is for AssistantCardSceneNewTurn
     * **/
    public static void setNumberOfSceneToComeBack(int numberOfSceneToComeBack) {
        ShowCardAssistantPlayedScene.numberOfSceneToComeBack = numberOfSceneToComeBack;
    }

    public static void setCards(ArrayList<CardAssistant> cards) {
        ShowCardAssistantPlayedScene.cards = cards;
    }

    public void initialize() {

        if (cards.size()==0){
            Title.setText("Non ci sono carte giocate!");
        }else{
            if(cards.size()>0){
                getTheRightCard(cards.get(0), cardAssistant1);
            }
            if(cards.size()>1){
                getTheRightCard(cards.get(1), cardAssistant2);
            }
            if(cards.size()>2){
                getTheRightCard(cards.get(2), cardAssistant3);
            }
        }
    }

    private void getTheRightCard(CardAssistant ca, ImageView imageView){
        if(ca.equals(CardAssistant.Uno)){
            imageView.setImage(new Image("Assistente (1).png"));
        }else if(ca.equals(CardAssistant.Due)) {
            imageView.setImage(new Image("Assistente (2).png"));
        }else if(ca.equals(CardAssistant.Tre)){
            imageView.setImage(new Image("Assistente (3).png"));
        }else if(ca.equals(CardAssistant.Quattro)){
            imageView.setImage(new Image("Assistente (4).png"));
        }else if(ca.equals(CardAssistant.Cinque)){
            imageView.setImage(new Image("Assistente (5).png"));
        }else if(ca.equals(CardAssistant.Sei)){
            imageView.setImage(new Image("Assistente (6).png"));
        }else if(ca.equals(CardAssistant.Sette)){
            imageView.setImage(new Image("Assistente (7).png"));
        }else if(ca.equals(CardAssistant.Otto)){
            imageView.setImage(new Image("Assistente (8).png"));
        }else if(ca.equals(CardAssistant.Nove)){
            imageView.setImage(new Image("Assistente (9).png"));
        }else if(ca.equals(CardAssistant.Dieci)){
            imageView.setImage(new Image("Assistente (10).png"));
        }

    }
    public void backClicked(ActionEvent event) {
        if (numberOfSceneToComeBack == 0) {
            JavaFXMain.getCurrentApplication().switchToCardAssistantScene();
        } else if (numberOfSceneToComeBack == 5) {
            JavaFXMain.getCurrentApplication().switchToAssistantCardSceneNewTurn();
        }
    }

}

