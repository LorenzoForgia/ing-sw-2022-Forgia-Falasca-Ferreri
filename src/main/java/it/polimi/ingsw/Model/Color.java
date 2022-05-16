package it.polimi.ingsw.Model;

public enum Color {
    Green(0,"\u001B[32m"), Red(1,"\u001B[31m"), Yellow(2,"\u001B[93m"), Pink(3,"\u001B[35m"), Blue(4,"\u001B[34m");
    private final int intcolor;
    private String escape;
    public static final String Reset = "\u001B[0m";

    Color(int intcolor,String escape) {
        this.intcolor = intcolor;
        this.escape=escape;
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