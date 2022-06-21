package it.polimi.ingsw.Client.views.GUI;


import it.polimi.ingsw.messages.AnsPlayAfterNotCCMsg;
import javafx.event.ActionEvent;

public class PlayAfterNotCCScene {
    private static AnsPlayAfterNotCCMsg ansPlayAfterNotCCMsg;

    public static void setAnsPlayAfterNotCCMsg(AnsPlayAfterNotCCMsg ansPlayAfterNotCCMsg) {
        PlayAfterNotCCScene.ansPlayAfterNotCCMsg = ansPlayAfterNotCCMsg;
    }


    public void okClicked(ActionEvent event) {
        if (ansPlayAfterNotCCMsg.getCountmoexpview() == 1) {
            MS1NotCCSceneView m = new MS1NotCCSceneView(ansPlayAfterNotCCMsg);
            m.run();
        } else if (ansPlayAfterNotCCMsg.getCountmoexpview() == 2) {
            MS2NotCCSceneView m = new MS2NotCCSceneView(ansPlayAfterNotCCMsg);
            m.run();
        } else if (ansPlayAfterNotCCMsg.getCountmoexpview() == 3) {
            MS3NotCCSceneView m = new MS3NotCCSceneView(ansPlayAfterNotCCMsg);
            m.run();
        } else if (ansPlayAfterNotCCMsg.GetPlayers().size() != 3 && ansPlayAfterNotCCMsg.getCountmoexpview() == 4) {
            AskForMNotCCSceneView a = new AskForMNotCCSceneView(ansPlayAfterNotCCMsg);
            a.run();
        } else if (ansPlayAfterNotCCMsg.GetPlayers().size() == 3 && ansPlayAfterNotCCMsg.getCountmoexpview() == 4) {
            MS4NotCCSceneView m = new MS4NotCCSceneView(ansPlayAfterNotCCMsg);
            m.run();
        } else if (ansPlayAfterNotCCMsg.getCountmoexpview() == 5) {
            AskForMNotCCSceneView a = new AskForMNotCCSceneView(ansPlayAfterNotCCMsg);
            a.run();
        }
    }
}
