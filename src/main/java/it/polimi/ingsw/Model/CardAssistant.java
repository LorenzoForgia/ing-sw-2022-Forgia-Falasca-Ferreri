package it.polimi.ingsw.Model;

/*@author Luigia Falasca*/

import java.io.Serializable;

public enum CardAssistant implements Serializable {
    Uno(1,1,"Uno"), Due(2,1,"Due"),Tre(3,2,"Tre") ,Quattro(4,2,"Quattro"), Cinque(5,3,"Cinque"), Sei(6,3,"Sei"), Sette(7,4,"Sette"), Otto(8,4,"Otto"), Nove(9,5,"Nove"),Dieci(10,5,"Dieci"),Invalid(404,0,"Invalid") ;
    private final int CardValue;
    private final int MovementMN;
    private final String name;

    CardAssistant(int cardValue, int movementMN,String name ) {
        CardValue = cardValue;
        MovementMN = movementMN;
        this.name=name;
    }
    public int getCardValue(){
        return CardValue;
    }
    public int getMovementMN(){
        return MovementMN;
    }
    public String getName(){ return name;}
}
