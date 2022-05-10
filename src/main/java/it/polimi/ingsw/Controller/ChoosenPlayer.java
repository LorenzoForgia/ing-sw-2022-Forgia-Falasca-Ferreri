package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;
import java.util.List;

public class ChoosenPlayer {
    private List<Player> orderPlayers = new ArrayList<>();
    private Player firstPlayer;

    public void ChooseTurnPlayer(ArrayList<CardAssistant> c, Player p){
        for(int i=0;i<c.size();i++){
            for(int j=0;j<c.size();j++) {
                if (c.get(i).getCardValue() > c.get(j).getCardValue()) {
                    if (p.getMySchoolBoard().GetId() == i) {
                        p.SetNumTurn();
                    }
                }
            }
        }
     }

    public void ChooseTurnPlayer(Player p, int n){
        if(orderPlayers.size()==0){
            orderPlayers.add(p);
        }
    }

    public void ChooseTurnPlayer(List<Player> players){
        for(int i=0;i<players.size();i++) {
            for(int j=0;j<players.size();j++) {
                if (players.get(i).getCA().getCardValue() > players.get(j).getCA().getCardValue() ){
                    players.get(i).SetNumTurn();
                }else if(players.get(i).getCA().getCardValue() == players.get(j).getCA().getCardValue() && i!= j){
                    if(players.get(i).getTurnToPlayCardAssistant()>players.get(j).getTurnToPlayCardAssistant()){
                        players.get(i).SetNumTurn();
                    }
                }
            }
        }
    }


    public void ChooseTurnPlayerForCardAssistant(List<Player> players){
        int k;
        k=firstPlayer.getMySchoolBoard().GetId();
        for(int i=0; i< players.size(); i ++){
            players.get(k).SetNumTurnCardAssistant(i);
            if(k== players.size() -1){
                k=0;
            }else{
                k=k+1;
            }
        }
    }

    public void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public void GetOrderPlayers(List<Player> players){
        for(int i =0; i < players.size(); i ++ ){
            orderPlayers.add(players.get(i).GetNumTurn(), players.get(i));
        }
        firstPlayer = orderPlayers.get(0);
    }

    public Player GetPlayerTurn(){
        Player p;
        p= orderPlayers.get(0);
        p.ResetTurn();
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

