package it.polimi.ingsw.Model;

/**
 * @author Luigia Falasca
 */

import java.io.Serializable;

public class Player implements Serializable {
    private String NickName;
    private int NumberCoins;
    private int Turn=0;
    private int turnToPlayCardAssistant=0;
    private SchoolBoard MySchoolBoard;
    private DeckCardAssistant MyDeck;
    private CardAssistant CA;
    private int nameCharacterCard;
    private boolean usedCharacterCard = false;

    public Player(String nickName) {
        NickName = nickName;
    }

    public void setNumberCoins(int numberCoins) {
        NumberCoins = numberCoins;
    }


    public void setNameCharacterCard(int nameCharacterCard) {
        this.nameCharacterCard = nameCharacterCard;
    }

    public void setUsedCharacterCard(boolean usedCharacterCard) {
        this.usedCharacterCard = usedCharacterCard;
    }

    public int getNameCharacterCard() {
        return nameCharacterCard;
    }

    public boolean isUsedCharacterCard() {
        return usedCharacterCard;
    }

    public void setMySchoolBoard(SchoolBoard mySchoolBoard) {
        MySchoolBoard = mySchoolBoard;
    }

    public void setMyDeck(DeckCardAssistant myDeck) {
        MyDeck = myDeck;
    }

    /* remove used Card from MyDeck*/
    public void usedCard( CardAssistant c){
        getMyDeck().RemoveCard(c);
    }

    public String getNickName() {
        return NickName;
    }

    public int getNumberCoins() {
        return NumberCoins;
    }

    public DeckCardAssistant getMyDeck() {
        return MyDeck;
    }


    public SchoolBoard getMySchoolBoard() {
        return MySchoolBoard;
    }

    public void AddCoin(int n) {
        NumberCoins = NumberCoins + n;
    }

    public int getTurnToPlayCardAssistant() {
        return turnToPlayCardAssistant;
    }

    public void SetNumTurn(){
        Turn=Turn+1;
    }
    public int GetNumTurn(){
        return Turn;
    }
    public void ResetTurn(){Turn=0;
    }

    public void setCA(CardAssistant CA) {
        this.CA = CA;
    }

    public void SetNumTurnCardAssistant(int n){
        turnToPlayCardAssistant = n;
    }

    public CardAssistant getCA() {
        return CA;
    }
}
