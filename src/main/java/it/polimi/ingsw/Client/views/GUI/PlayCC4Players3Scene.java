package it.polimi.ingsw.Client.views.GUI;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlayCC4Players3Scene {
    public ImageView imageFirstCharacterCard;
    public ImageView imageSecondCharacterCard;
    public ImageView imageThirdCharacterCard;


    public void initialize() {
        Image firstCharacterCard = new Image("CarteTOT_front.jpg");
        imageFirstCharacterCard.setImage(firstCharacterCard);
        Image secondCharacterCard = new Image("CarteTOT_front2.jpg");
        imageSecondCharacterCard.setImage(secondCharacterCard);
        Image thirdCharacterCard = new Image("CarteTOT_front3.jpg");
        imageThirdCharacterCard.setImage(thirdCharacterCard);
    }
    public void noClicked(ActionEvent event){
        JavaFXMain.getCurrentApplication().switchToMoveStudent4Scene();
    }
    public void siClicked(ActionEvent event){
        JavaFXMain.getCurrentApplication().switchToChoiceCharacterCardScene();
    }
}
