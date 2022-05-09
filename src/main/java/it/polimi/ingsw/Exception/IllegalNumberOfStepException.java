package it.polimi.ingsw.Exception;

public class IllegalNumberOfStepException extends Exception{
    public IllegalNumberOfStepException() {
        super("Illegal number of step");
    }

    public IllegalNumberOfStepException(int n) {
        super(" Mother Nature can't do" + n + "steps");
    }
}
