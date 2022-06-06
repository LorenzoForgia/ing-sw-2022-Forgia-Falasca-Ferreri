package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.IslandTiles;
import it.polimi.ingsw.Model.SchoolBoard;
import it.polimi.ingsw.messages.AnsMoveStudent2Msg;
import it.polimi.ingsw.messages.AnsMoveStudent3Msg;
import it.polimi.ingsw.messages.CCMsg;
import it.polimi.ingsw.messages.NumStepMNMsg;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayCC4View extends View{
    AnsMoveStudent3Msg answerMsg;
    public PlayCC4View(AnsMoveStudent3Msg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Displayer displayer = new Displayer();
        displayer.displayAllSchoolboard(answerMsg.GetGB().getSchoolBoard(),answerMsg.GetPlayers());
        displayer.showAllIsland(answerMsg.GetGB().GetIslands());
        /**stampa charactercards**/
        for(int i=0;i<answerMsg.GetPlayers().size();i++){
            if(answerMsg.GetPlayers().get(i).getNickName().equals(answerMsg.GetPlayer())) {
                displayer.displayWallet(answerMsg.GetPlayers().get(i).getNumberCoins());
            }
        }
        displayer.displayAllcharactercard(answerMsg.GetCharacterCards());
        System.out.println("Vuoi giocare una carta personaggio? si/no");
        String card = scanner.nextLine();
        if (card.equals("si")) {
            System.out.println("Qual'è il numero della carta personaggio che vuoi giocare?");
            int numcard = Integer.parseInt(scanner.nextLine());
            CCMsg ccMsg = new CCMsg(numcard);
            getOwner().getServerHandler().sendCommandMessage(ccMsg);
        } else {
            int step;
            System.out.println("Quanti passi di madre natura vuoi fare?");
            step = Integer.parseInt(scanner.nextLine());
            NumStepMNMsg numStepMNMsg= new NumStepMNMsg(step);
            getOwner().getServerHandler().sendCommandMessage(numStepMNMsg);
        }
    }
}
