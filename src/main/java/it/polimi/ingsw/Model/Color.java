package it.polimi.ingsw.Model;

import java.io.Serializable;
/**
 * @author Lorenzo Forgia
 */
public enum Color implements Serializable {
    Green(0,"\u001B[32m","Green"), Red(1,"\u001B[31m","Red"), Yellow(2,"\u001B[93m","Yellow"), Pink(3,"\u001B[35m","Pink"), Blue(4,"\u001B[34m","Blue");
    private final int intcolor;
    private String escape;



    private String name;
    public static final String Reset = "\u001B[0m";

    Color(int intcolor,String escape,String name) {
        this.intcolor = intcolor;
        this.escape=escape;
        this.name=name();
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return intcolor;
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