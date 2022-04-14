package it.polimi.ingsw.Model;

public class CharacterCard12 extends CharacterCard{
    public CharacterCard12(int name, int coins, int countUse) {
        super(name, coins, countUse);
    }
    public void useEffect12(Color c,Player[] players,Bag b){
        for(int i=0,limit=3;i<players.length;i++,limit=3){
            if(players[i].getMySchoolBoard().getDiningRoom().GetNumberStudent(c)<3){
                limit=players[i].getMySchoolBoard().getDiningRoom().GetNumberStudent(c);
            }
            for(int j=0; j<limit;j++){
                players[i].getMySchoolBoard().getDiningRoom().RemoveStudent(c);
                b.PutStudent(c);
            }
        }
    }
}
