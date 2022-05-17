package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Exception.CloudEmptyException;
import it.polimi.ingsw.Model.CloudTiles;
import it.polimi.ingsw.Model.IslandTiles;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class CloudMsg extends CommandMsg{
    private int cloud;

    public CloudMsg(int cloud) {
        this.cloud=cloud;
    }

    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException
    {
        GameController game = clientHandler.getGame();
        CloudTiles cloudTiles= null;
        synchronized (game) {
            for(int i=0; i<game.getGameModel().getGeneralBoard().getClouds().size();i++){
                if(cloud==game.getGameModel().getGeneralBoard().getClouds().get(i).getNumid()){
                    cloudTiles= game.getGameModel().getGeneralBoard().getClouds().get(i);
                }
            }
            try {
                game.CheckCloud(cloudTiles, game.getChoosenPlayer().GetPlayerTurn());
            }catch (CloudEmptyException e){

            }
            AnsCloudMsg ansCloudMsg=new AnsCloudMsg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName());
            clientHandler.sendAnswerMessage(ansCloudMsg);
        }
    }
}
