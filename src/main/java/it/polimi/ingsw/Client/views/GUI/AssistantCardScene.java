package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Exception.CardAssistantNotAvailableException;
import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.Model.DeckCardAssistant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

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
    private DeckCardAssistant deckCardAssistant;


    public void initialize()
    {
        deckCardAssistant = new DeckCardAssistant();
        deckCardAssistant.RemoveCard(CardAssistant.Cinque);
        deckCardAssistant.RemoveCard(CardAssistant.Uno);
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
