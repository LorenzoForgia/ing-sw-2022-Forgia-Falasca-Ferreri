package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.Player;

import java.util.List;

public class GameController {
    private AddStudentsOnClouds addStudentsOnClouds = new AddStudentsOnClouds();
    private ChooseCloudTiles chooseCloudTiles = new ChooseCloudTiles();
    private ChoosenPlayer choosenPlayer = new ChoosenPlayer();
    private ChooseSettingGame chooseSettingGame;
    private GameEndState gameEndState = new GameEndState();
    private Move3Students move3Students = new Move3Students();
    private Setup setup = new Setup();
    private MoveMotherNature moveMotherNature = new MoveMotherNature();
    private WinLoseCheckState winLoseCheckState = new WinLoseCheckState();
    private PlayAssCard playAssCard = new PlayAssCard();
    private List<Player> players;

    /*public static void main(String[] args) {*/
        /* Richiesta modalità gioco
        chooseSettingGame= new ChooseSettingGame();
        Metodi di SetUp
        Creazione giocatori con i rispettivi nickname
        Inizia un ciclo con un flag dato dal Game End State
        AddStudentOnCloud
        Scegli un giocatore random che sceglierà la carta assistente
        prendi tutte le carte assistenti dagli altri giocatori
        chiama play ass card
        inizia il turno del primo giocatore tramite un ciclo for (choosenPlayer)
        Scelta location da parte del player
        Move3student
        MoveMotherNature
        CheckEndGameState
        se true uscire dal loop, altrimenti ricominciare
        se usciti dal loop winlosecheckstate


    }*/
}


