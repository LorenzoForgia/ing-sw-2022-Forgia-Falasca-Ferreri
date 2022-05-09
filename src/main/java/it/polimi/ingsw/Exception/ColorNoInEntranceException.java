package it.polimi.ingsw.Exception;


import it.polimi.ingsw.Model.Color;

public class ColorNoInEntranceException extends Exception {
    public ColorNoInEntranceException() {
        super("Color not in Entrance");
    }

    public ColorNoInEntranceException(Color c) {
        super(" The color " + c.name() + "is not in your Entrance");
    }
}
