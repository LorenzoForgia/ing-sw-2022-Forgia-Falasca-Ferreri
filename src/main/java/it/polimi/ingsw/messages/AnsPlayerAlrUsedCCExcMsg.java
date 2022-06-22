package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.Client;
import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.CCNotInTableExcView;
import it.polimi.ingsw.Client.views.GUI.PlayerAlrUsedCCExcScene;
import it.polimi.ingsw.Client.views.PlayerAlrUsedCCExcView;

public class AnsPlayerAlrUsedCCExcMsg extends AnswerMsg{
    public AnsPlayerAlrUsedCCExcMsg(CommandMsg parent){
        super(parent);
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        if(Client.GUI){
            PlayerAlrUsedCCExcScene p= new PlayerAlrUsedCCExcScene(this);
            p.run();
        }else{
           serverHandler.getClient().transitionToView(new PlayerAlrUsedCCExcView(this));
        }


    }
}
