package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;
import java.util.List;

public class ChoosenPlayer {
    private List<Player> orderPlayers;
    public void ChooseTurnPlayer(ArrayList<CardAssistant> c, Player p){
        for(int i=0;i<c.size();i++){
            for(int j=0;j<c.size();j++){
                if(c.get(i).getCardValue()>c.get(j).getCardValue()){
                    if(p.getMySchoolBoard().GetId()==i){
                        p.SetNumTurn();
                    }
                }
            }
        }
    }

    public List<Player> GetOrderPlayers(List<Player> players){
        orderPlayers = new ArrayList<Player>();
        for(int i =0; i < players.size(); i ++ ){
            orderPlayers.add(players.get(i).GetNumTurn(), players.get(i));
        }
        return orderPlayers;
    }

    public Player GetPlayerTurn(){
        Player p;
        p= orderPlayers.get(0);
        orderPlayers.remove(0);
        return p;
    }

    public boolean EndOfAllTurn(){
        if(orderPlayers.size()== 0){
            return true;
        }else{
            return false;
        }
    }
}

