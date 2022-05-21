package it.polimi.ingsw.Exception;

public class IslandNotInListException extends Exception{
    public IslandNotInListException() {
        super("Illegal number of Island");
    }

    public IslandNotInListException(int n) {
        super("There is no Island with number of ID" + n);
    }
}

