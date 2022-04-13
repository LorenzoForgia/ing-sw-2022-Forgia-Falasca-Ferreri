package it.polimi.ingsw.Model;
import java.util.*;
public class CharacterCard10 extends CharacterCard{

    public CharacterCard10(int name, int coins, int countUse) {
        super(name, coins, countUse);
    }
    public void EffectchangeStudents(List<Color> entrancestud,List<Color> diningstud,SchoolBoard sb){
      Color temp;
        for(int i=0;i<entrancestud.size();i++){
          sb.RemoveStudent(entrancestud.get(i));
          sb.AddStudent(diningstud.get(i));
          sb.getDiningRoom().RemoveStudent(diningstud.get(i));
          sb.getDiningRoom().PutStudent(entrancestud.get(i));

      }

    }
}