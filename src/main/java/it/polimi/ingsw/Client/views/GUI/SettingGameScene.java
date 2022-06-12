package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.messages.NewGameMsg;

public class SettingGameScene {

    private int n;
    private boolean expMode;

    public void number2OfPlayerButtonClicked(){
        n=2;
        JavaFXMain.getCurrentApplication().switchToExpertModeScene();
    }

    public void number3OfPlayerButtonClicked(){
        n=3;
        JavaFXMain.getCurrentApplication().switchToExpertModeScene();
    }

    public void number4OfPlayerButtonClicked(){
        n=4;
        JavaFXMain.getCurrentApplication().switchToExpertModeScene();
    }

    public void expModeButtonClicked(){
        expMode= true;
        NewGameMsg newgame = new NewGameMsg(n, expMode);
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(newgame);
    }

    public void noExpModeButtonClicked(){
       expMode= false;
       NewGameMsg newgame = new NewGameMsg(n, expMode);
       JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(newgame);
    }


}
