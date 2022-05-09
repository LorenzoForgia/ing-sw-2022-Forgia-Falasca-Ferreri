package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Exception.*;
import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.messages.AnswIfAllowed;

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

    public GameModel getGameModel() {
        return gameModel;
    }

    private GameModel gameModel=new GameModel();

    public AddStudentsOnClouds getAddStudentsOnClouds() {
        return addStudentsOnClouds;
    }

    public void setAddStudentsOnClouds(AddStudentsOnClouds addStudentsOnClouds) {
        this.addStudentsOnClouds = addStudentsOnClouds;
    }
    public ChooseCloudTiles getChooseCloudTiles() {
        return chooseCloudTiles;
    }

    public void setChooseCloudTiles(ChooseCloudTiles chooseCloudTiles) {
        this.chooseCloudTiles = chooseCloudTiles;
    }

    public ChoosenPlayer getChoosenPlayer() {
        return choosenPlayer;
    }

    public void setChoosenPlayer(ChoosenPlayer choosenPlayer) {
        this.choosenPlayer = choosenPlayer;
    }

    public ChooseSettingGame getChooseSettingGame() {
        return chooseSettingGame;
    }

    public void setChooseSettingGame(ChooseSettingGame chooseSettingGame) {
        this.chooseSettingGame = chooseSettingGame;
    }

    public GameEndState getGameEndState() {
        return gameEndState;
    }

    public void setGameEndState(GameEndState gameEndState) {
        this.gameEndState = gameEndState;
    }

    public Move3Students getMove3Students() {
        return move3Students;
    }

    public void setMove3Students(Move3Students move3Students) {
        this.move3Students = move3Students;
    }

    public Setup getSetup() {
        return setup;
    }

    public void setSetup(Setup setup) {
        this.setup = setup;
    }

    public MoveMotherNature getMoveMotherNature() {
        return moveMotherNature;
    }

    public void setMoveMotherNature(MoveMotherNature moveMotherNature) {
        this.moveMotherNature = moveMotherNature;
    }

    public WinLoseCheckState getWinLoseCheckState() {
        return winLoseCheckState;
    }

    public void setWinLoseCheckState(WinLoseCheckState winLoseCheckState) {
        this.winLoseCheckState = winLoseCheckState;
    }

    public PlayAssCard getPlayAssCard() {
        return playAssCard;
    }

    public void setPlayAssCard(PlayAssCard playAssCard) {
        this.playAssCard = playAssCard;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    public void newGame(int numofPlayers,boolean modexpert){
        this.gameModel.setGeneralBoard(setup.CreateGeneralboard(modexpert,numofPlayers));
        this.gameModel.setBag(setup.CreateBag());
    }

    public void CheckNumberOfSteps(int n, Player p, CharacterCard c) throws IllegalNumberOfStepException {
        int move=0;
        if(c != null){
            if(c.getName()==4){
                move = ((CharacterCard4)c).AddTwoMvntMN(p.getCA());
            }else{
                move = p.getCA().getMovementMN();
            }
        }else{
            move = p.getCA().getMovementMN();
        }

        if( n > move|| n<=0 ){
            throw  new IllegalNumberOfStepException(n);
        }else{
            moveMotherNature.MoveMN(gameModel.getGeneralBoard(), n);
        }

    }

    public void CheckColor(Color c, Player p) throws ColorNoInEntranceException {
        boolean flag= true;
        if(c == null){
            throw new ColorNoInEntranceException(c);
        }
        for(int i=0; i < p.getMySchoolBoard().getEntrance().size() && flag; i++){
            if(c.equals(p.getMySchoolBoard().getEntrance().get(i))){
                flag = false;
            }
        }

        if(flag){
            throw new ColorNoInEntranceException(c);
        }
    }

    public void NickNameAvailable(String name)throws IllegalNickNameException{
        boolean flag= true;
        if(name== null){
            throw new IllegalNickNameException();
        }else {
                for (int i = 0; i < gameModel.getPlayers().size() && flag; i++) {
                    if (name.equals(getPlayers().get(i).getNickName())) {
                        flag = false;
                    }
                }
            }
            if (!flag) {
                throw new IllegalNickNameException(name);
            } else {
                gameModel.getPlayers().add(new Player(name));
            }
        }


    private boolean CloudInList( CloudTiles c){
        boolean flag = false;
        for(int i =0; i < gameModel.getGeneralBoard().getClouds().size(); i++){
            if(c.equals(gameModel.getGeneralBoard().getClouds().get(i))){
                flag=true;
            }
        }

        return flag;
    }

    public void CheckCloud(CloudTiles c, Player player)throws CloudEmptyException {
        if( !CloudInList(c) || c.getStud().size()==0 || c.getStud() == null ){
            throw new CloudEmptyException(c);
        }else{
            chooseCloudTiles.ChoosenCloud(player, c);
        }
    }


    public void CardAssistantInDeck(CardAssistant cardAssistant, Player p) throws CardAssistantNotInDeckException {
        boolean flag = true;
        if(cardAssistant == null){
            throw new CardAssistantNotInDeckException(cardAssistant);
        }

        for(int i =0; i < p.getMyDeck().GetDeck().size() && flag; i ++){
            if(p.getMyDeck().GetDeck().get(i).equals(cardAssistant)){
                flag = false;
            }
        }

        if (flag) {
            throw new CardAssistantNotInDeckException(cardAssistant);
        }else{
            playAssCard.GetAssCard(p,cardAssistant, gameModel.getPlayers().size());
        }

    }

    public void CharacterCardInTable(CharacterCard characterCard) throws CharacterCardNotInTableException{
        boolean flag = true;
        if(characterCard == null){
            throw new CharacterCardNotInTableException(characterCard);
        }
        for(int i=0; i < gameModel.getGeneralBoard().getChoosenCard().size() && flag; i ++) {
            if(gameModel.getGeneralBoard().getChoosenCard().get(i).equals(characterCard)){
                flag= false;
            }
        }

        if(flag){
            throw new CharacterCardNotInTableException(characterCard);
        }
    }

}


