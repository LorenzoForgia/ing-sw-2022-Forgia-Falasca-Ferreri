package it.polimi.ingsw.Model;

public enum Color {
    Green(0), Red(1), Yellow(2), Pink(3), Blue(4);
    private final int intcolor;

    Color(int intcolor) {
        this.intcolor = intcolor;
    }

    public int getIndex() {
        return intcolor;
    }

}