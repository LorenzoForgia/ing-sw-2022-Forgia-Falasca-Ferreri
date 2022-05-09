package it.polimi.ingsw.Exception;

import it.polimi.ingsw.Model.CloudTiles;

public class CloudEmptyException extends Exception {
    public CloudEmptyException() {
        super("Cloud empty");
    }

    public CloudEmptyException(CloudTiles c) {
        super(" Cloud number " + c.getNumid() + "is empty");
    }

}
