package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.*;

import java.util.*;

public class WinLoseCheckState {
    public boolean CheckIfWinWithTower(Player p, GeneralBoard g){
        int w=0,b=0,gr=0;
        for(int i=0;i<g.GetIslands().size();i++){
            if( g.GetIslands().get(i).isTower() && g.GetIslands().get(i).getColTower().equals(ColorTower.Black)){
                b=b+g.GetIslands().get(i).getSize();
            }else if(g.GetIslands().get(i).isTower() && g.GetIslands().get(i).getColTower().equals(ColorTower.White)){
                w=w+g.GetIslands().get(i).getSize();
            }else if(g.GetIslands().get(i).isTower() && g.GetIslands().get(i).getColTower().equals(ColorTower.Grey)){
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

    public ArrayList<Boolean> CheckWinner(ArrayList<Player> players, List<SchoolBoard> SbWithSchoolBoard){
        int min=9;
        ArrayList<ColorTower> colorWinning= new ArrayList<>();
        ArrayList<Boolean> playersVictory= new ArrayList<>();

        for(int i=0; i< players.size(); i++){
            playersVictory.add(false);
        }

        for(int i=0; i< SbWithSchoolBoard.size(); i++){
            if(SbWithSchoolBoard.get(i).getNumberOfTower()< min){
                colorWinning= new ArrayList<>();
                colorWinning.add(SbWithSchoolBoard.get(i).ColorTower());
                min = SbWithSchoolBoard.get(i).getNumberOfTower();
            }else if(SbWithSchoolBoard.get(i).getNumberOfTower()== min){
                colorWinning.add(SbWithSchoolBoard.get(i).ColorTower());
            }
        }

        if(colorWinning.size()>1){
            colorWinning= CheckProfessor(colorWinning, players);
        }

        for(int i=0; i< players.size(); i++ ){
            for(int j=0; j < colorWinning.size(); j++){
                if(players.get(i).getMySchoolBoard().ColorTower().equals(colorWinning.get(j))){
                    playersVictory.set(i,true);
                }
            }
        }
        return playersVictory;
    }

    private ArrayList<ColorTower> CheckProfessor(ArrayList<ColorTower> colorWinning, ArrayList<Player> players){
        int max=0;
        ArrayList<Color> ProfessorTableBlack= new ArrayList<>();
        ArrayList<Color> ProfessorTableWhite= new ArrayList<>();
        ArrayList<ColorTower> colorTowers= new ArrayList<>();
        if(players.size()==3) {
            for (int i = 0; i < colorWinning.size(); i++) {
                for (int j = 0; j < players.size(); j++) {
                    if (players.get(j).getMySchoolBoard().ColorTower().equals(colorWinning.get(i))){
                        if(players.get(j).getMySchoolBoard().getProfessorTable().size()>max){
                            colorTowers = new ArrayList<>();
                            colorTowers.add(colorWinning.get(i));
                            max= players.get(j).getMySchoolBoard().getProfessorTable().size();
                        }else if(players.get(j).getMySchoolBoard().getProfessorTable().size()==max){
                            colorTowers.add(colorWinning.get(i));
                        }
                    }
                }
            }
        }else{
            for (int j = 0; j < players.size(); j++) {
                if(players.get(j).getMySchoolBoard().ColorTower().equals(ColorTower.Black)){
                    ProfessorTableBlack.addAll(players.get(j).getMySchoolBoard().getProfessorTable());
                }
                if(players.get(j).getMySchoolBoard().ColorTower().equals(ColorTower.White)){
                    ProfessorTableWhite.addAll(players.get(j).getMySchoolBoard().getProfessorTable());
                }
            }

            if(ProfessorTableBlack.size()>ProfessorTableWhite.size()){
                colorTowers.add(ColorTower.Black);
            }else if(ProfessorTableBlack.size()<ProfessorTableWhite.size()){
                colorTowers.add(ColorTower.White);
            }else{
                colorTowers= colorWinning;
            }
        }

        return colorTowers;
    }

    public boolean CheckIfWinWithProfessor(Player p, GeneralBoard g){
        ArrayList<Integer> prof= new ArrayList<Integer>();
        int k=1;
        for(int i=0;i<g.getSchoolBoard().size();i++){
            prof.add(g.getSchoolBoard().get(i).getProfessorTable().size());
        }
        for(int i=0;i<prof.size();i++){
            for(int j=0;p.getMySchoolBoard().GetId()==i && j<prof.size();j++){
                if(prof.get(i)>prof.get(j)){
                    k++;
                }
            }
        }
        if(prof.size()==k){return true;}
        else{return false;}
    }
    public boolean CheckIfWin(Player p, GeneralBoard g){
        if(CheckIfWinWithTower(p,g) || CheckIfWinWithProfessor(p,g)){
            return true;
        }else{return false;}}
}
