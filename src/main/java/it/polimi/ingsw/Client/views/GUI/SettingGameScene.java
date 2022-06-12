package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.messages.NewGameMsg;
import javafx.event.ActionEvent;

public class SettingGameScene {

    private int n;
    private boolean expMode;

    public void number2OfPlayerButtonClicked(ActionEvent event){
        n=2;
        JavaFXMain.getCurrentApplication().switchToExpertModeScene();
    }

    public void number3OfPlayerButtonClicked(ActionEvent event){
        n=3;
        JavaFXMain.getCurrentApplication().switchToExpertModeScene();
    }

    public void number4OfPlayerButtonClicked(ActionEvent event){
        n=4;
        JavaFXMain.getCurrentApplication().switchToExpertModeScene();
    }

    public void expModeButtonClicked(ActionEvent event){
        expMode= true;
       /* NewGameMsg newgame = new NewGameMsg(n, expMode);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(newgame);*/
    }

    public void noExpModeButtonClicked(ActionEvent event){
       expMode= false;
      /* NewGameMsg newgame = new NewGameMsg(n, expMode);
       JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(newgame);*/
    }


}
