package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;
import java.util.List;

public class ChoosenPlayer {
    private List<Player> orderPlayers = new ArrayList<>();
    private Player firstPlayer;
    private int numPlayerTurn = 0;


    /**
     * Set the turn after the players played the cardAssistant
     **/
    public void ChooseTurnPlayer(List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < players.size(); j++) {
                if (players.get(i).getCA().getCardValue() > players.get(j).getCA().getCardValue()) {
                    players.get(i).SetNumTurn();
                } else if (players.get(i).getCA().getCardValue() == players.get(j).getCA().getCardValue() && i != j) {
                    if (players.get(i).getTurnToPlayCardAssistant() > players.get(j).getTurnToPlayCardAssistant()) {
                        players.get(i).SetNumTurn();
                    }
                }
            }
        }
        GetOrderPlayers(players);


    }

    public int getNumPlayerTurn() {
        return numPlayerTurn;
    }

    /**
     * Set the turn before the players play the cardAssistant
     **/
    public void ChooseTurnPlayerForCardAssistant(List<Player> players) {
        int k;
        k = firstPlayer.getMySchoolBoard().GetId();
        for (int i = 0; i < players.size(); i++) {
            players.get(k).SetNumTurnCardAssistant(i);
            if (k == players.size() - 1) {
                k = 0;
            } else {
                k = k + 1;
            }
        }
        GetOrderOfPlayersForCardAssistant(players);
    }


    /**
     * Saves the first player at the beginning of the game
     **/
    public void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    /**
     * Get the order of the players after the turn is set
     **/
    private void GetOrderPlayers(List<Player> players) {
       if(orderPlayers.size()==0){
           for (int i = 0; i < players.size(); i++) {
               orderPlayers.add(players.get(i));
           }
       }

        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.size());
            System.out.println("Sto shutdownando:"+players.get(i).GetNumTurn()+"  "+players.get(i));
            orderPlayers.set(players.get(i).GetNumTurn(), players.get(i));
        }
        firstPlayer = orderPlayers.get(0);
        numPlayerTurn =0;
    }

    private void GetOrderOfPlayersForCardAssistant(List<Player> players) {
        numPlayerTurn =0;
        if(orderPlayers.size()==0) {
            for (int i = 0; i < players.size(); i++) {
                orderPlayers.add(players.get(i));
            }
        }

        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.size());
            System.out.println("Sto shutdownando:"+players.get(i).GetNumTurn()+"  "+players.get(i));
            orderPlayers.set(players.get(i).getTurnToPlayCardAssistant(), players.get(i));
        }

        System.out.println(numPlayerTurn);
    }

    public void incrementTurn() {

        numPlayerTurn++;
        System.out.println(numPlayerTurn);
    }

    /**
     * Show the player who has to play
     **/
    public Player GetPlayerTurn() {
        Player p;
        p = orderPlayers.get(numPlayerTurn);
        p.ResetTurn();
        return p;
    }

    /**
     * Check if all players played their own turn
     **/
    public boolean EndOfAllTurn() {
        if (numPlayerTurn == orderPlayers.size()) {
            return true;
        } else {
            return false;
        }
    }
    public List<Player> getOrderPlayers(){return orderPlayers;}
}

