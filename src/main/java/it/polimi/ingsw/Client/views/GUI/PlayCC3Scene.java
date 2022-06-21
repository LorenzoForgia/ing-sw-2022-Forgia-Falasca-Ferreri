package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.messages.AnsMoveStudent2Msg;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class PlayCC3Scene {
    @FXML
    public ImageView imageFirstCharacterCard;
    @FXML
    public ImageView imageSecondCharacterCard;
    @FXML
    public ImageView imageThirdCharacterCard;

    public static AnsMoveStudent2Msg answerMsg;

    public static void setAnsMoveStudent2Msg(AnsMoveStudent2Msg ansMoveStudent2Msg) {
        PlayCC3Scene.answerMsg = ansMoveStudent2Msg;
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
            }else if (answerMsg.GetCharacterCards().get(i).getName() == 11) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front11.jpg"));
            } else if (answerMsg.GetCharacterCards().get(i).getName() == 12) {
                imageCharacterCard.get(i).setImage(new Image("CarteTOT_front12.jpg"));
            }

        }
    }
    public void noClicked(ActionEvent event){
        JavaFXMain.getCurrentApplication().switchToMoveStudent3Scene();
    }
    public void siClicked(ActionEvent event){
        ChoiceCharacterCardScene.setCards(answerMsg.GetCharacterCards());
        JavaFXMain.getCurrentApplication().switchToChoiceCharacterCardScene();
    }
}
