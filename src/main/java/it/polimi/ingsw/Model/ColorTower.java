package it.polimi.ingsw.Model;

import java.io.Serializable;

/**
 * @author Lorenzo Forgia
 */
public enum ColorTower implements Serializable {
    Black(0,"\u001B[94m"), White(1,"\u001B[37m"), Grey(2,"\u001B[90m");
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
