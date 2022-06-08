package it.polimi.ingsw.Model;

import java.io.Serializable;

/**
 * @author Luigia Falasca and Federico Angelo Luigi Ferreri
 * **/

public abstract class CharacterCard implements Serializable {
    private int Name;
    private int Coins;
    private int CountUse;

    public int getCoins() {
        return Coins;
    }

    public String getDescriptionEffect() {
        return DescriptionEffect;
    }

    private String DescriptionEffect;

    public CharacterCard(int name, int coins, int countUse,String descriptionEffect) {
        Name= name;
        Coins= coins;
        CountUse= countUse;
        DescriptionEffect=descriptionEffect;
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

    public void setCountUse() {     /*card is used so the cost++ */
        CountUse = CountUse +1;
    }
    public abstract void SetCard(Bag b, GeneralBoard GB);
    public abstract void UseEffect(Player p);
}
