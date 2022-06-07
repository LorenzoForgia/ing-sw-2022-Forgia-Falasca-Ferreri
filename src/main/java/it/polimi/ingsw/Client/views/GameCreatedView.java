package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.messages.AnsGameCreatedMsg;
import it.polimi.ingsw.messages.BooleanCheckMsg;
import it.polimi.ingsw.messages.GameStartedMsg;
import it.polimi.ingsw.messages.NewGameMsg;

import java.util.Scanner;

public class GameCreatedView extends View{
    /** The view of the gamecreated */

    private BooleanCheckMsg answerMsg;


    public GameCreatedView(BooleanCheckMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }


    @Override
    public void run() {

        Scanner scanner = new Scanner(System.in);
        BooleanCheckMsg.Status moveStatus = answerMsg.getMoveStatus();
        if(moveStatus==BooleanCheckMsg.Status.OK){
           System.out.println("Game created");
            GameStartedMsg gameStartedMsg= new GameStartedMsg();
            getOwner().getServerHandler().sendCommandMessage(gameStartedMsg);

        }else{
            System.out.println("Errore inserimento! Riprova");
            System.out.println("Inserire numero di giocatori: da 2 a 4 giocatori");
            boolean ex=false;
            int numplayers=0;
            while(!ex) {
                try {
                    numplayers = Integer.parseInt(scanner.nextLine());
                    ex=true;
                } catch (NumberFormatException e) {
                    System.out.println("Errore: Inserire numero di giocatori: da 2 a 4 giocatori");
                    ex=false;
                }
            }
            System.out.println("Modalità esperta? true o false");
            String modexpert=scanner.nextLine();
            boolean flagfine=true;
            while(flagfine){
                if(modexpert.equals("true") || modexpert.equals("false")){
                    flagfine=false;
                }
                if(flagfine){
                    System.out.println("Errore: Inserire modalità esperta consetita: true/false");
                    modexpert = scanner.nextLine();
                }
            }
            boolean modexp ;
            if(modexpert.equals("true")){
                modexp=true;
            }else{
                modexp=false;
            }
            NewGameMsg newgame = new NewGameMsg(numplayers, modexp);
            getOwner().getServerHandler().sendCommandMessage(newgame);
        }

        }
}
