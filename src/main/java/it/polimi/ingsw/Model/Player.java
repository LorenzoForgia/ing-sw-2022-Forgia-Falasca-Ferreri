package it.polimi.ingsw.Model;

/*@author Luigia Falasca*/

public class Player {
    private String NickName;
    private int NumberCoins;
    private int Turn=0;
    private int turnToPlayCardAssistant=0;
    private SchoolBoard MySchoolBoard;
    private DeckCardAssistant MyDeck;
    private CardAssistant CA;
    private CharacterCard CC;
    private int nameCharacterCard;
    private boolean usedCharacterCard;

    public Player(String nickName) {
        NickName = nickName;
    }

    public void setNumberCoins(int numberCoins) {
        NumberCoins = numberCoins;
    }

    public CharacterCard getCC() {
        return CC;
    }

    public void setCC(CharacterCard CC) {
        this.CC = CC;
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

    public void removeCoin(int n) throws IllegalMoveException {
        if (NumberCoins >= n) {
            NumberCoins = NumberCoins - n;
        } else {
            throw new IllegalMoveException();
        }
    }

    public int getTurnToPlayCardAssistant() {
        return turnToPlayCardAssistant;
    }

    public ColorTower GetSquad(){
        return MySchoolBoard.ColorTower();
    }

    public void ChooseSquad( ColorTower t){
        MySchoolBoard.setColorTower(t);
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
