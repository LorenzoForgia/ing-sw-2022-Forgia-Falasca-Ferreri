package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Model.CharacterCard;
import it.polimi.ingsw.messages.AnsAskCAMsg;
import it.polimi.ingsw.messages.CCMsg;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class ChoiceCharacterCardScene {

    @FXML
    private ImageView imageFirstCharacterCard;
    @FXML
    private ImageView imageSecondCharacterCard;
    @FXML
    private ImageView imageThirdCharacterCard;
    private static AnsAskCAMsg answerMsg;

    public static void setAnswerMsg(AnsAskCAMsg answerMsg) {
        ChoiceCharacterCardScene.answerMsg = answerMsg;
    }
    private static ArrayList<CharacterCard> cards;


    public static void setCards(ArrayList<CharacterCard> cards) {
        ChoiceCharacterCardScene.cards = cards;
    }


    public void initialize() {
        ArrayList<ImageView> imageCharacterCard = new ArrayList<>();
        imageCharacterCard.add(0, imageFirstCharacterCard);
        imageCharacterCard.add(1, imageSecondCharacterCard);
        imageCharacterCard.add(2, imageThirdCharacterCard);

        for (int i = 0; i < 3; i++) {
            if (cards.get(i).getName() == 1) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front.jpg"));
            } else if (cards.get(i).getName() == 2) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front4.jpg"));
            } else if (cards.get(i).getName() == 3) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front4.jpg"));
            } else if (cards.get(i).getName() == 4) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front5.jpg"));
            } else if (cards.get(i).getName() == 5) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front6.jpg"));
            } else if (cards.get(i).getName() == 6) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front7.jpg"));
            } else if (cards.get(i).getName() == 7) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front8.jpg"));
            } else if (cards.get(i).getName() == 8) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front9.jpg"));
            } else if (cards.get(i).getName() == 9) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front10.jpg"));
            } else if (cards.get(i).getName() == 10) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front11.jpg"));
            } else if (cards.get(i).getName() == 11) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front12.jpg"));
            } else if (cards.get(i).getName() == 12) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front2.jpg"));
            }
        }
    }
    public void image1Clicked(ActionEvent event){
        CCMsg ccMsg= new CCMsg(cards.get(0).getName());
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(ccMsg);
    }
    public void image2Clicked(ActionEvent event){
        CCMsg ccMsg= new CCMsg(cards.get(1).getName());
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(ccMsg);
    }
    public void image3Clicked(ActionEvent event){
        CCMsg ccMsg= new CCMsg(cards.get(2).getName());
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(ccMsg);
    }
}
