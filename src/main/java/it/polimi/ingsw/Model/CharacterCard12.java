package it.polimi.ingsw.Model;

public class CharacterCard12 extends CharacterCard{
    public CharacterCard12(int name, int coins, int countUse) {
        super(name, coins, countUse);
    }
    public void useEffect12(Color c,Player[] players){
        for(int i=0;i<players.length;i++){
            for(int j=0; j<players[i].getMySchoolBoard().getDiningRoom().GetNumberStudent(c);j++){
                players[i].getMySchoolBoard().getDiningRoom().RemoveStudent(c);
            }
        }
    }
}
