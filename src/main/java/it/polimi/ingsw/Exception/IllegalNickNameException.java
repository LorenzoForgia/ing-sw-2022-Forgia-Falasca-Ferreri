package it.polimi.ingsw.Exception;

public class IllegalNickNameException extends Exception{
    public IllegalNickNameException() {
            super("Nickname no available");
        }

    public IllegalNickNameException(String s) {
        super("Nickname no available," + s + "is taken");
    }
}
