package it.polimi.ingsw.Controller;

public class ChooseSettingGame {
    private int NumPlayers;
    private boolean ModExpert;
    public ChooseSettingGame(int numplayers,boolean modexpert){
        this.NumPlayers=numplayers;
        this.ModExpert=modexpert;
    }
    public int getNumPlayers() {
        return NumPlayers;
    }
    public boolean isModExpert() {
        return ModExpert;
    }
}
