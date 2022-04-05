package it.polimi.ingsw.Model;

public enum ColorTower {
    Black(0), White(1), Grey(2);
    private final int intTower;
    ColorTower(int intTower) {
        this.intTower = intTower;
    }
    public int getIndex(){
        return intTower;
    }

}
