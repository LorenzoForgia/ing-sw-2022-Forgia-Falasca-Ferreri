package it.polimi.ingsw.Client.views.GUI;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AssistantCardScene {

    public ImageView assistantCard1;
    public ImageView assistantCard2;
    public ImageView assistantCard3;
    public ImageView assistantCard4;
    public ImageView assistantCard5;
    public ImageView assistantCard6;
    public ImageView assistantCard7;
    public ImageView assistantCard8;
    public ImageView assistantCard9;
    public ImageView assistantCard10;


    public void initialize()
    {
        Image imageAssCard1 = new Image("Assistente (1).png");
        assistantCard1.setImage(imageAssCard1);
        Image imageAssCard2 = new Image("Assistente (2).png");
        assistantCard2.setImage(imageAssCard2);
        Image imageAssCard3 = new Image("Assistente (3).png");
        assistantCard3.setImage(imageAssCard3);
        Image imageAssCard4 = new Image("Assistente (4).png");
        assistantCard4.setImage(imageAssCard4);
        Image imageAssCard5 = new Image("Assistente (5).png");
        assistantCard5.setImage(imageAssCard5);
        Image imageAssCard6 = new Image("Assistente (6).png");
        assistantCard6.setImage(imageAssCard6);
        Image imageAssCard7 = new Image("Assistente (7).png");
        assistantCard7.setImage(imageAssCard7);
        Image imageAssCard8 = new Image("Assistente (8).png");
        assistantCard8.setImage(imageAssCard8);
        Image imageAssCard9 = new Image("Assistente (9).png");
        assistantCard9.setImage(imageAssCard9);
        Image imageAssCard10 = new Image("Assistente (10).png");
        assistantCard10.setImage(imageAssCard10);

    }

    public void chosenCard1(){
        System.out.println("Ho giocato la carta Uno");
    }
    public void chosenCard2(){
        System.out.println("Ho giocato la carta Due");
    }
    public void chosenCard3(){
        System.out.println("Ho giocato la carta Tre");
    }
    public void chosenCard4(){
        System.out.println("Ho giocato la carta Quattro");
    }
    public void chosenCard5(){
        System.out.println("Ho giocato la carta 5");
    }
    public void chosenCard6(){
        System.out.println("Ho giocato la carta 6");
    }
    public void chosenCard7(){
        System.out.println("Ho giocato la carta 7");
    }
    public void chosenCard8(){
        System.out.println("Ho giocato la carta 8");
    }
    public void chosenCard9(){
        System.out.println("Ho giocato la carta 9");
    }
    public void chosenCard10(){
        System.out.println("Ho giocato la carta 10");
    }


}
