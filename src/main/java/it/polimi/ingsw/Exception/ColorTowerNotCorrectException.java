package it.polimi.ingsw.Exception;

import it.polimi.ingsw.Model.Color;

public class ColorTowerNotCorrectException extends Exception {
    public ColorTowerNotCorrectException() {
        super("Color is not available");
    }

    public ColorTowerNotCorrectException(Color c) {
        super(" The color " + c.name() + "is not available");
    }
}
