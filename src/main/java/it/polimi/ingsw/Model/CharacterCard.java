package it.polimi.ingsw.Model;

import java.io.Serializable;

/**
 * @author Luigia Falasca and Federico Angelo Luigi Ferreri
 * **/

public abstract class CharacterCard implements Serializable {
    private int Name;
    private int Coins;
    private int CountUse;
    private String DescriptionEffect;

    public int getCoins() {
        return Coins;
    }

    public String getDescriptionEffect() {
        return DescriptionEffect;
    }

    public CharacterCard(int name, int coins, int countUse,String descriptionEffect) {
        Name= name;
        Coins= coins;
        CountUse= countUse;
        DescriptionEffect=descriptionEffect;
    }

    public int getName(){      /* return the character's name*/
        return Name;
    }

    /***
     how many times the card has been used
     **/
    public int getCountUse() {
        return CountUse;
    }
    /***
     card's cost
     **/
    public int getCost(){
        return Coins+CountUse;
    }
    /**card is used so the cost++ **/
    public void setCountUse() {
        CountUse = CountUse +1;
    }

    /** abstract methods**/
    public abstract void SetCard(Bag b, GeneralBoard GB);
    public abstract void UseEffect(Player p);
}
