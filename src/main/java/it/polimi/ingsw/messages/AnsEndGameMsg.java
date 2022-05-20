package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.EndGameView;
import it.polimi.ingsw.Client.views.MoveStudent2View;
import it.polimi.ingsw.Model.GeneralBoard;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class AnsEndGameMsg extends AnswerMsg{
    private ArrayList<String> winner= new ArrayList<String>();
    public AnsEndGameMsg(CommandMsg parent, ArrayList<String> winner ) {
        super(parent);
        this.winner= winner;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new EndGameView(this));
    }
    public ArrayList<String> getWinner(){return winner;}
}
