package it.polimi.ingsw.Model;

import java.io.Serializable;
import java.util.List;


/** @author Lorenzo Forgia and Luigia Falasca **/
public class CharacterCard12 extends CharacterCard implements Serializable {
    private List<Player> players;
    private Bag bag;
    private Color chosenColor;

    public CharacterCard12(int name, int coins, int countUse, String descriptionEffect) {
        super(name, coins, countUse, descriptionEffect);
    }

    /** everyone (including the player who has used the effect)
     * return three students in the bag from their Dining Room
     **/
    @Override
    public void UseEffect(Player p) {
        p.setNameCharacterCard(12);
        p.setUsedCharacterCard(true);
        for(int i=0,limit=3;i<players.size();i++,limit=3){
            if(players.get(i).getMySchoolBoard().getDiningRoom().GetNumberStudent(chosenColor)<3){
                limit=players.get(i).getMySchoolBoard().getDiningRoom().GetNumberStudent(chosenColor);
            }
            for(int j=0; j<limit;j++){
                players.get(i).getMySchoolBoard().getDiningRoom().RemoveStudent(chosenColor);
                bag.PutStudent(chosenColor);
            }
        }
    }

    @Override
    public void SetCard(Bag b, GeneralBoard gb) {
        bag = b;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    /** Set the chosen color of student
     * **/
    public void setChosenColor(Color chosenColor) {

        this.chosenColor = chosenColor;
    }
}
