package it.polimi.ingsw.Model;

/*@author Luigia Falasca*/

public class Player {
    private String NickName;
    private int NumberCoins;
    private SchoolBoard MySchoolBoard;

    public Player(String nickName, int numberCoins, SchoolBoard mySchoolBoard) {
        NickName = nickName;
        NumberCoins = numberCoins;
        MySchoolBoard = mySchoolBoard;
    }

    public String getNickName() {
        return NickName;
    }

    public int getNumberCoins() {
        return NumberCoins;
    }

    public SchoolBoard getMySchoolBoard() {
        return MySchoolBoard;
    }

    public void AddCoin(int n) {
        NumberCoins = NumberCoins + n;
    }

    public void removeCoin(int n) throws IllegalMoveException {
        if (NumberCoins >= n) {
            NumberCoins = NumberCoins - n;
        } else {
            throw new IllegalMoveException();
        }
    }

    public ColorTower GetSquad(){
        return MySchoolBoard.ColorTower();
    }

    public void ChooseSquad( ColorTower t){
        MySchoolBoard.setColorTower(t);
    }
}
