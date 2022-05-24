package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.IslandTiles;
import it.polimi.ingsw.messages.AnsCC5ExcMsg;
import it.polimi.ingsw.messages.AnsCC5Msg;
import it.polimi.ingsw.messages.CC5Msg;

import java.util.ArrayList;
import java.util.Scanner;

public class CC5ExcView extends View{
    AnsCC5ExcMsg answerMsg;
    public CC5ExcView(AnsCC5ExcMsg answerMsg)
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
        System.out.println("sceltanon valida! Riprova");
        System.out.println("Scegli il numero dell'isola su cui vuoi mettere la tessera divieto");
        int isl = Integer.parseInt(scanner.nextLine());
        CC5Msg cc5Msg = new CC5Msg(isl);
        getOwner().getServerHandler().sendCommandMessage(cc5Msg);
    }
}
