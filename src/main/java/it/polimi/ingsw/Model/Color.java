package it.polimi.ingsw.Model;

public enum Color {
    Green(0,"\u001B[32m"), Red(1,"\u001B[31m"), Yellow(2,"\u001B[93m"), Pink(3,"\u001B[35m"), Blue(4,"\u001B[34m"),Black(5,"\u001B[30m"),White(6,"\u001B[97m"),Gray(7,"\u001B[90m"),Reset(8,"\u001B[0m");
    private final int intcolor;
    private String escape;

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