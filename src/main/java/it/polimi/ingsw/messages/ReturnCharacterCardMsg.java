package it.polimi.ingsw.messages;

import it.polimi.ingsw.Model.CharacterCard;

/*public class ReturnCharacterCardMsg extends CommandMsg{
    CharacterCard c;

    public ReturnCharacterCardMsg(CharacterCard c){
        this.c = c;
    }*/

    /*@Override
    public void processMessage(ClientHandler clientHandler) throws IOException {
        GameController g = ClientHandler.GetGame();
        CheckCorrectOrNotMsg AnswerMsg;
        if (g.CheckCharacterCard()) {
            AnswerMsg = new CheckCorrectOrNotMsg(this, CheckCorrectOrNotMsg.Status.CORRECT);
        } else {
            AnswerMsg = new CheckCorrectOrNotMsg(this, CheckCorrectOrNotMsg.Status.INCORRECT);
        }
        clientHandler.sendAnswerMessage(AnswerMsg);
    }

}*/
