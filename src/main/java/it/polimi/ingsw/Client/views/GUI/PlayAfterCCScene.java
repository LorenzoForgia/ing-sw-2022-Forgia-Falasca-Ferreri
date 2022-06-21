package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.messages.AnsPlayAfterCCMsg;
import javafx.event.ActionEvent;

public class PlayAfterCCScene {
    private static AnsPlayAfterCCMsg ansPlayAfterCCMsg;

    public static void setAnsPlayAfterCCMsg(AnsPlayAfterCCMsg ansPlayAfterCCMsg) {
        PlayAfterCCScene.ansPlayAfterCCMsg = ansPlayAfterCCMsg;
    }
    public void okClicked(ActionEvent event){
        if(ansPlayAfterCCMsg.getCountmodexpview()==1){
            MS1CCSceneView m= new MS1CCSceneView(ansPlayAfterCCMsg);
            m.run();
        }else if(ansPlayAfterCCMsg.getCountmodexpview()==2){
            MS2CCSceneView m= new MS2CCSceneView(ansPlayAfterCCMsg);
            m.run();
        }else if(ansPlayAfterCCMsg.getCountmodexpview()==3){
            MS3CCSceneView m= new MS3CCSceneView(ansPlayAfterCCMsg);
            m.run();
        }else if(ansPlayAfterCCMsg.GetPlayers().size()!=3 && ansPlayAfterCCMsg.getCountmodexpview()==4){
            AskForMNCCSceneView a= new AskForMNCCSceneView(ansPlayAfterCCMsg);
            a.run();
        }else if(ansPlayAfterCCMsg.GetPlayers().size()==3 && ansPlayAfterCCMsg.getCountmodexpview()==4){
            MS4CCSceneView m= new MS4CCSceneView(ansPlayAfterCCMsg);
            m.run();
        }else if(ansPlayAfterCCMsg.getCountmodexpview()==5){
            AskForMNCCSceneView a= new AskForMNCCSceneView(ansPlayAfterCCMsg);
            a.run();
        }
    }
}
