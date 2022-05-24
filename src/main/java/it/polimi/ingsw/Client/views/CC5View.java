package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.IslandTiles;
import it.polimi.ingsw.Model.SchoolBoard;
import it.polimi.ingsw.messages.AnsCC3Msg;
import it.polimi.ingsw.messages.AnsCC5Msg;
import it.polimi.ingsw.messages.CC3Msg;
import it.polimi.ingsw.messages.CC5Msg;

import java.util.ArrayList;
import java.util.Scanner;

public class CC5View extends View{
    AnsCC5Msg answerMsg;
    public CC5View(AnsCC5Msg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Displayer displayer= new Displayer();
        ArrayList<IslandTiles> islandTiles=new ArrayList<>();
        for(int i=0; i<answerMsg.GetGB().GetIslands().size();i++){
            islandTiles.add(answerMsg.GetGB().GetIslands().get(i));
        }
        displayer.showAllIsland(islandTiles);
        System.out.println("Scegli il numero dell'isola su cui vuoi mettere la tessera divieto");
        int isl = Integer.parseInt(scanner.nextLine());
        CC5Msg cc5Msg = new CC5Msg(isl);
        getOwner().getServerHandler().sendCommandMessage(cc5Msg);
    }
}
