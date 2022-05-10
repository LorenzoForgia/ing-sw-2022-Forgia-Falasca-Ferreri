package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.GameCreatedView;
import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Exception.IllegalArgumentException;
import it.polimi.ingsw.Model.GeneralBoard;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;
import java.util.ArrayList;

public class GameStartedMsg extends CommandMsg{
    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException {
        AnsGameStartedMsg answerMsg;
        GameController game = clientHandler.getGame();
        ArrayList<String> nickname = new ArrayList<String>();
        /*ArrayList<Integer> schoolboards= new ArrayList<Integer>();*/
        /*GeneralBoard gb= game.getGameModel().getGeneralBoard();*/
        synchronized (game) {
            Boolean flag=game.CheckIfAllLogin();
            while(!flag){
                try{
                    System.out.println("mi addormento");
                    game.wait();
                    flag=game.CheckIfAllLogin();
                    System.out.println("mi sveglio");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
            for (int i = 0; i < game.getGameModel().getPlayers().size(); i++) {
                nickname.add(game.getGameModel().getPlayers().get(i).getNickName());
            }
        /*for(int i=0; i<game.getGameModel().getGeneralBoard().getSchoolBoard().size(); i++){
            schoolboards.add(game.getGameModel().getGeneralBoard().getSchoolBoard().get(i).GetId());
        }*/
            game.notifyAll();
            answerMsg = new AnsGameStartedMsg(this, nickname);
            clientHandler.sendAnswerMessage(answerMsg);

        }
    }
}
