package it.polimi.ingsw.Model;

public class CharacterCard  {
    private int Name;
    private int Coins;
    private int CountUse;

    public CharacterCard(int name, int coins, int countUse) {
        Name= name;
        Coins= coins;
        CountUse= countUse;
    }

    public int getName(){      /* return the character's name*/
        return Name;
    }
    public int getCountUse() {    /*how much the card is used*/
        return CountUse;
    }
    public int getCost(){       /*card's cost*/
        return Coins+CountUse;
    }
}
