package it.polimi.ingsw.Client.views.GUI;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChoiceCharacterCardScene {

    public ImageView imageFirstCharacterCard;
    public ImageView imageSecondCharacterCard;
    public ImageView imageThirdCharacterCard;


    public void initialize()
    {

        Image firstCharacterCard = new Image("CarteTOT_front.jpg");
        imageFirstCharacterCard.setImage(firstCharacterCard);
        Image secondCharacterCard = new Image("CarteTOT_front2.jpg");
        imageSecondCharacterCard.setImage(secondCharacterCard);
        Image thirdCharacterCard = new Image("CarteTOT_front3.jpg");
        imageThirdCharacterCard.setImage(thirdCharacterCard);
    }

}
