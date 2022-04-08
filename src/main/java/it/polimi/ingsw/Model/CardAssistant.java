package it.polimi.ingsw.Model;

/*@author Luigia Falasca*/

public enum CardAssistant {
    Uno(1,1), Due(2,1),Tre(3,2) ,Quattro(4,2), Cinque(5,3), Sei(6,3), Sette(7,4), Otto(8,4), Nove(9,5),Dieci(9,5) ;
    private final int CardValue;
    private final int MovementMN;

    CardAssistant(int cardValue, int movementMN ) {
        CardValue = cardValue;
        MovementMN = movementMN;
    }
    public int getCardValue(){
        return CardValue;
    }
    public int getMovementMN(){
        return MovementMN;
    }
}
