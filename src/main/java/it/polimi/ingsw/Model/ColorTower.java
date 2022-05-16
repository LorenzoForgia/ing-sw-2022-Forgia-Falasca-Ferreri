package it.polimi.ingsw.Model;

public enum ColorTower {
    Black(0,"\u001B[30m"), White(1,"\u001B[97m"), Grey(2,"\u001B[90m");
    private final int intTower;
    private String escape;
    public static final String Reset = "\u001B[0m";
    ColorTower(int intTower,String escape) {
        this.intTower = intTower;
        this.escape=escape;
    }

    public int getIndex(){
        return intTower;
    }


    public String getEscape()
    {
        return escape;
    }


    @Override
    public String toString()
    {
        return escape;
    }
}
