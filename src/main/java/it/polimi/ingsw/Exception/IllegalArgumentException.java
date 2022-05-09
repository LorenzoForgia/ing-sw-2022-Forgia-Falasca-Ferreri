package it.polimi.ingsw.Exception;

public class IllegalArgumentException extends Exception {
    public IllegalArgumentException() {
        super("Illegal argument");
    }

    public IllegalArgumentException(String s) {
        super(s + "is not a valid argument");
    }
}
