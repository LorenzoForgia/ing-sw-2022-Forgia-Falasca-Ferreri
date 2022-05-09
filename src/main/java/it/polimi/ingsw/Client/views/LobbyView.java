package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.messages.*;

import java.util.Scanner;

public class LobbyView extends View{
    /** The view of the lobby */

    private AnsGameCreatedMsg answerMsg;


    public LobbyView(AnsGameCreatedMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }


    @Override
    public void run()
    {

        System.out.println("LOBBY");
        Scanner scanner = new Scanner(System.in);
        AnsGameCreatedMsg.Status moveStatus = answerMsg.getMoveStatus();
        if(moveStatus==AnsGameCreatedMsg.Status.VALID) {
            System.out.println("Creazone Partita");
            System.out.println("Inserire numero di giocatori:");
            int numplayers = Integer.parseInt(scanner.nextLine());
            System.out.println("Modalità esperta?");
            boolean modexp = Boolean.parseBoolean(scanner.nextLine());
            NewGameMsg newgame = new NewGameMsg(numplayers, modexp);
            getOwner().getServerHandler().sendCommandMessage(newgame);
        }else{
            System.out.println("Ti stai unendo a una partita:");



        }

    }
}
