package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Exception.CharacterCardNotInTableException;
import it.polimi.ingsw.Exception.NotEnoughCoinException;
import it.polimi.ingsw.Exception.PlayerAlreadyUsedCharacterCard;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class CCMsg extends CommandMsg{
    private int numcard;
    public CCMsg(int numcard){
        this.numcard= numcard;
    }

    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException {
        GameController game = clientHandler.getGame();
        synchronized (game) {
            try{
                game.CharacterCardInTable(numcard);
                try{
                    game.CheckIfPlayerCanPlayCharacterCard(game.getChoosenPlayer().GetPlayerTurn());
                    try{
                        game.CheckIfEnoughMoney(game.getChoosenPlayer().GetPlayerTurn(), game.getCharacterCardChosen());
                        if(numcard==1){
                            AnsCC1Msg ansCC1Msg=new AnsCC1Msg(this);
                            clientHandler.sendAnswerMessage(ansCC1Msg);
                        }else if(numcard==2){

                        }else if(numcard==3){
                            AnsCC3Msg ansCC3Msg= new AnsCC3Msg(this);
                            clientHandler.sendAnswerMessage(ansCC3Msg);
                        }else if(numcard==4){

                        }else if(numcard==5){
                            AnsCC5Msg ansCC5Msg= new AnsCC5Msg(this);
                            clientHandler.sendAnswerMessage(ansCC5Msg);
                        }else if(numcard==6){

                        }else if(numcard==7){

                        }else if(numcard==8){

                        }else if(numcard==9){

                        }else if(numcard==10){

                        }else if(numcard==11){

                        }else if(numcard==12){

                        }
                    }catch (NotEnoughCoinException e){
                        AnsNotEnoughCoinsExcMsg ansNotEnoughCoinsExcMsg= new AnsNotEnoughCoinsExcMsg(this);
                        clientHandler.sendAnswerMessage(ansNotEnoughCoinsExcMsg);
                    }
                }catch (PlayerAlreadyUsedCharacterCard e){
                    AnsPlayerAlrUsedCCExcMsg ansPlayerAlrUsedCCExcMsg= new AnsPlayerAlrUsedCCExcMsg(this);
                    clientHandler.sendAnswerMessage(ansPlayerAlrUsedCCExcMsg);
                }
            }catch (CharacterCardNotInTableException e){
                AnsCCNotInTableExcMsg answerMsg= new AnsCCNotInTableExcMsg(this);
                clientHandler.sendAnswerMessage(answerMsg);
            }







        }
    }
}
