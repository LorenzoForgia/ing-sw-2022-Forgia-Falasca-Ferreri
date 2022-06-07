package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.*;

import java.util.*;

/**
 * @author Luigia Falasca and Federico Angelo Luigi Ferreri
 * **/
public class WinLoseCheckState {

    /** Check the winner(s)
     * **/
    public ArrayList<Boolean> CheckWinner(ArrayList<Player> players, List<SchoolBoard> SbWithSchoolBoard) {
        int min = 9;
        ArrayList<ColorTower> colorWinning = new ArrayList<>();
        ArrayList<Boolean> playersVictory = new ArrayList<>();

        for (int i = 0; i < players.size(); i++) {
            playersVictory.add(false);
        }

        for (int i = 0; i < SbWithSchoolBoard.size(); i++) {
            if (SbWithSchoolBoard.get(i).getNumberOfTower() < min) {
                colorWinning = new ArrayList<>();
                colorWinning.add(SbWithSchoolBoard.get(i).ColorTower());
                min = SbWithSchoolBoard.get(i).getNumberOfTower();
            } else if (SbWithSchoolBoard.get(i).getNumberOfTower() == min) {
                colorWinning.add(SbWithSchoolBoard.get(i).ColorTower());
            }
        }

        if (colorWinning.size() > 1) {
            colorWinning = CheckProfessor(colorWinning, players);
        }

        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < colorWinning.size(); j++) {
                if (players.get(i).getMySchoolBoard().ColorTower().equals(colorWinning.get(j))) {
                    playersVictory.set(i, true);
                }
            }
        }
        return playersVictory;
    }


    /** Check the number of professors in case the towers left on the schoolBoards are equals
     * **/
    private ArrayList<ColorTower> CheckProfessor(ArrayList<ColorTower> colorWinning, ArrayList<Player> players) {
        int max = 0;
        ArrayList<Color> ProfessorTableBlack = new ArrayList<>();
        ArrayList<Color> ProfessorTableWhite = new ArrayList<>();
        ArrayList<ColorTower> colorTowers = new ArrayList<>();
        if (players.size() == 3) {
            for (int i = 0; i < colorWinning.size(); i++) {
                for (int j = 0; j < players.size(); j++) {
                    if (players.get(j).getMySchoolBoard().ColorTower().equals(colorWinning.get(i))) {
                        if (players.get(j).getMySchoolBoard().getProfessorTable().size() > max) {
                            colorTowers = new ArrayList<>();
                            colorTowers.add(colorWinning.get(i));
                            max = players.get(j).getMySchoolBoard().getProfessorTable().size();
                        } else if (players.get(j).getMySchoolBoard().getProfessorTable().size() == max) {
                            colorTowers.add(colorWinning.get(i));
                        }
                    }
                }
            }
        } else {
            for (int j = 0; j < players.size(); j++) {
                if (players.get(j).getMySchoolBoard().ColorTower().equals(ColorTower.Black)) {
                    ProfessorTableBlack.addAll(players.get(j).getMySchoolBoard().getProfessorTable());
                }
                if (players.get(j).getMySchoolBoard().ColorTower().equals(ColorTower.White)) {
                    ProfessorTableWhite.addAll(players.get(j).getMySchoolBoard().getProfessorTable());
                }
            }

            if (ProfessorTableBlack.size() > ProfessorTableWhite.size()) {
                colorTowers.add(ColorTower.Black);
            } else if (ProfessorTableBlack.size() < ProfessorTableWhite.size()) {
                colorTowers.add(ColorTower.White);
            } else {
                colorTowers = colorWinning;
            }
        }

        return colorTowers;
    }
}

