package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.ColorTower;
import it.polimi.ingsw.Model.GeneralBoard;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class WinLoseCheckState {
    public boolean CheckIfWinWithTower(Player p, GeneralBoard g){
        int w=0,b=0,gr=0;
        for(int i=0;i<g.GetIslands().size();i++){
            if(g.GetIslands().get(i).getColTower().equals(ColorTower.Black)){
                b=b+g.GetIslands().get(i).getSize();
            }else if(g.GetIslands().get(i).getColTower().equals(ColorTower.White)){
                w=w+g.GetIslands().get(i).getSize();
            }else if(g.GetIslands().get(i).getColTower().equals(ColorTower.Grey)){
                gr=gr+g.GetIslands().get(i).getSize();
            }
        }
        if(b>w && b>gr && p.getMySchoolBoard().ColorTower().equals(ColorTower.Black)){
            return true;
        }else if(w>b && w>gr && p.getMySchoolBoard().ColorTower().equals(ColorTower.White)){
            return true;
        }else if(gr>w && gr>b && p.getMySchoolBoard().ColorTower().equals(ColorTower.Grey)){
            return true;
        }else {return false;}
    }
    public boolean CheckIfWinWithProfessor(Player p, GeneralBoard g){
        ArrayList<Integer> prof= null;
        int k=1;
        for(int i=0;i<g.getSchoolBoard().size();i++){
            prof.add(g.getSchoolBoard().get(i).getProfessorTable().size());
        }
        for(int i=0;i<prof.size();i++){
            for(int j=0;j<prof.size() && i!=j;j++){
                if(p.getMySchoolBoard().GetId()==i && prof.get(i)>prof.get(j)){
                    k++;
                }
            }
        }
        if(k== prof.size()){return true;}
        else{return false;}
    }
    public boolean CheckIfWin(Player p, GeneralBoard g){
        if(CheckIfWinWithTower(p,g) || CheckIfWinWithProfessor(p,g)){
            return true;
        }else{return false;}
    }
}
