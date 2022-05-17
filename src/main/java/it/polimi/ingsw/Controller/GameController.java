package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Exception.*;
import it.polimi.ingsw.Exception.IllegalArgumentException;
import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.messages.AnswIfAllowed;

import java.util.List;
import java.util.Random;

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
    private GameModel gameModel=new GameModel();
    private InfluenceProfessorTable influenceProfessorTable = new InfluenceProfessorTable();
    private boolean SetFirstTurn = false;

    public boolean getSetFirstTurn(){return SetFirstTurn;}
    public void setSetFirstTurn(boolean setFirstTurn){this.SetFirstTurn=setFirstTurn;}
    public GameModel getGameModel() {
        return gameModel;
    }

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

    /** this method is called at the begging of the game; it checks if the name is available: if it
     * is not, then will throw an Exception, else will add the new player
     * **/

    public void NickNameAvailable(String name)throws IllegalNickNameException{
        boolean flag= true;
        if(name== null){
            throw new IllegalNickNameException();
        }else {
            for (int i = 0; i < gameModel.getPlayers().size() && flag; i++) {
                if (name.equals(gameModel.getPlayers().get(i).getNickName())) {
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

    /** Check if the number of player is correct
     * **/

    public void CheckNumOfPlayer(int n) throws IllegalArgumentException {
        if(n<2 || n> 4){
            throw new IllegalArgumentException();
        }
    }
  /** this method is called at the begging of the game; it creates the bag with 10 students,
   * the schoolBoards with the right color of Tower, if the players are four decide which schoolBoards
   * will contain the towers,it creates the clouds and the islands
   * **/
    public void newGame(int numofPlayers,boolean modexpert){
        gameModel.setGeneralBoard(setup.CreateGeneralboard(modexpert,numofPlayers));
        gameModel.setBag(setup.CreateBag());
        gameModel.setNumplayers(numofPlayers);
        gameModel.setModExpert(modexpert);
        setup.ChooseSchoolBoardWithTowers(gameModel.getGeneralBoard(),numofPlayers);
        setup.SetTowers(numofPlayers,setup.getSBWithTowers());
        setup.SetBag(gameModel.getBag(),1);
        moveMotherNature.SetIslandWithMotherNature(gameModel.getGeneralBoard());
        SetMotherNatureFirstTurn(moveMotherNature.getI1());
    }

    /** if everyone is login, this method will create for each player the AssistantCard's Deck, it will
     * assign for each player the SchoolBoard and 1 coin if exp mode is on
     * **/
    public boolean CheckIfAllLogin(){
        if(gameModel.getPlayers().size()== gameModel.getNumplayers()){
            for(int i=0; i<gameModel.getNumplayers(); i ++ ){
                gameModel.getPlayers().get(i).setMyDeck(new DeckCardAssistant());
                gameModel.getPlayers().get(i).setMySchoolBoard(gameModel.getGeneralBoard().getSchoolBoard().get(i));
                if(gameModel.getModExpert()){
                    gameModel.getPlayers().get(i).setNumberCoins(1);
                    gameModel.getGeneralBoard().removeCoin(1);
                }else{
                    gameModel.getPlayers().get(i).setNumberCoins(0);
                }
            }
            return true;
        }else{
            return false;
        }
    }
 /** this method decides who starts the game at the beginning of the game and the rest of
  * player's order
     * **/

    public void SetFirstPlayerTurn(){
        Random random = new Random();
        int draftedindex = random.nextInt(this.getGameModel().getPlayers().size());
        Player p = this.getGameModel().getPlayers().get(draftedindex);
        this.getChoosenPlayer().setFirstPlayer(p);
        choosenPlayer.ChooseTurnPlayerForCardAssistant(gameModel.getPlayers());
    }

    /** Randomly the methods put MotherNature in island; this method sets motherNature, sets 120 students in the bag
     * put students in the Clouds, put the students in the Entrance of the schoolBoard
     * **/

    private void SetMotherNatureFirstTurn(IslandTiles I){
        moveMotherNature.SetIslandWithMotherNature(I);
        setup.SetMNto1Island(I.getNumberID(),gameModel.getGeneralBoard());
        setup.SetupStudentsInIslands(gameModel.getBag(),I.getNumberID(),gameModel.getGeneralBoard().GetIslands());
        setup.SetBag(gameModel.getBag(),0);
        addStudentsOnClouds.RestartTurn(gameModel.getGeneralBoard(), gameModel.getBag(),gameModel.getNumplayers());
        for(int i=0; i <gameModel.getNumplayers(); i++ ){
            gameModel.getGeneralBoard().getSchoolBoard().get(i).PutStudent(gameModel.getNumplayers(),gameModel.getBag());
        }
    }

    /**  Check if the player can play the card assistant
     * */
    public void CardAssistantInDeck(CardAssistant cardAssistant, Player p) throws CardAssistantNotAvailableException{
        boolean flag = true;

        for(int i =0; i < p.getMyDeck().GetDeck().size() && flag; i ++){
            if(p.getMyDeck().GetDeck().get(i).equals(cardAssistant)){
                flag = false;
            }
        }

        for(int i=0; i < playAssCard.GetAssCardPlayed().size() && !flag; i++){
            if(cardAssistant.equals(playAssCard.GetAssCardPlayed().get(i))){
                if(!playAssCard.CheckIfLast(p)){
                    flag = true;
                }
            }
        }

        if (flag) {
            throw new CardAssistantNotAvailableException(cardAssistant);
        }else{
            playAssCard.GetAssCard(p,cardAssistant);
            choosenPlayer.incrementTurn();
            gameEndState.CheckEndGameRoundEndedForCardAssistant(p);

        }

    }

    /** Check if all players had played the card assistant
     * **/
    public boolean CheckIfAllPlayedCardAssistant(){
        boolean flag= false;

            if(playAssCard.GetAssCardPlayed().size()==gameModel.getNumplayers()){
                flag= true;
            }
            if(flag && choosenPlayer.getNumPlayerTurn()==gameModel.getNumplayers()){
                setOrder();
            }
        return flag;
    }
    private void setOrder(){
        choosenPlayer.ChooseTurnPlayer(gameModel.getPlayers());
    }

    /** Check if the student that the player wants to move is in his Entrance or not; if it's not it will
     * throw an Exception
     * **/

    public void CheckColor(Color c, Player p) throws ColorNoInEntranceException {
        boolean flag = true;
        if (c == null) {
            throw new ColorNoInEntranceException(c);
        }
        for (int i = 0; i < p.getMySchoolBoard().getEntrance().size() && flag; i++) {
            if (c.equals(p.getMySchoolBoard().getEntrance().get(i))) {
                flag = false;
            }
        }

        if (flag) {
            throw new ColorNoInEntranceException(c);
        }
    }

    /** Put the student in the location and remove it from the entrance
     * **/

    public void PutStudentInLocation(Color c, Location location, Player player  ){
        move3Students.ChooseLocation(c,location,player);
    }

    /** If the location is the DiningRoom, if the mod is exp, this method will check if the player has to get
     * a coin or not, check if a character card is been used (character card 2) and calculates the influence of the professors
     * **/

    public void DiningRoomChosen(Player p, Color c){
        if(gameModel.getModExpert()){
            if(p.getMySchoolBoard().getDiningRoom().GetCoin(c)){
                p.AddCoin(1);
                gameModel.getGeneralBoard().removeCoin(1);
            }
        }
        if(p.getCC()!= null){
            if(p.getCC().getName()==3){
                influenceProfessorTable.RightProfessorTable(gameModel.getGeneralBoard(),gameModel.getNumplayers(),p.getCC(),p);
            }else{
                influenceProfessorTable.RightProfessorTable(gameModel.getGeneralBoard(),gameModel.getNumplayers());
            }
        }else{
            influenceProfessorTable.RightProfessorTable(gameModel.getGeneralBoard(),gameModel.getNumplayers());
        }
    }

    /** Check if the steps are allowed or not. If they are, it changes the position of MotherNature
     * **/
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
            if(moveMotherNature.CheckIfIslandGetControlled(gameModel.getNumplayers(), gameModel.getGeneralBoard(), moveMotherNature.getI1())){
                moveMotherNature.GetRightTowerOnIsland(gameModel.getGeneralBoard(), moveMotherNature.getI1(), setup.getSBWithTowers());
                gameEndState.CheckEndGameImmediately(p, gameModel.getGeneralBoard());
            }
        }
    }

    public void CheckNumberOfStepsMN(int n, Player p, CardAssistant a) throws IllegalNumberOfStepException {
        int move=0;
        if(a != null){
            move = p.getCA().getMovementMN();
        }
        if( n > move|| n<=0 ){
            throw  new IllegalNumberOfStepException(n);
        }else{
            moveMotherNature.MoveMN(gameModel.getGeneralBoard(), n);
            if(moveMotherNature.CheckIfIslandGetControlled(gameModel.getNumplayers(), gameModel.getGeneralBoard(), moveMotherNature.getI1())){
                moveMotherNature.GetRightTowerOnIsland(gameModel.getGeneralBoard(), moveMotherNature.getI1(), setup.getSBWithTowers());
                gameEndState.CheckEndGameImmediately(p, gameModel.getGeneralBoard());
            }
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
            choosenPlayer.incrementTurn();
        }
    }



    /**Check if all played their turn and put students in cloud and reset the CharacterCard if the game is not ended
     * **/
    public boolean ResetTheTurnForNewRoundWhenAllPlayed(){
        if(choosenPlayer.EndOfAllTurn()) {
            gameEndState.CheckEndGameRoundEndedForBag(gameModel.getBag());
            if (!gameEndState.isFlagImmediately() && !gameEndState.isFlagNotImmediately()) {
                addStudentsOnClouds.RestartTurn(gameModel.getGeneralBoard(), gameModel.getBag(), gameModel.getNumplayers());
                gameEndState.CheckEndGameRoundEndedForBag(gameModel.getBag());
                if (gameModel.getModExpert()) {
                    for (int i = 0; i < gameModel.getNumplayers(); i++) {
                        gameModel.getPlayers().get(i).setCC(null);
                    }
                }
            }
        }
        return  choosenPlayer.EndOfAllTurn();
    }

    /** Check if the CharacterCard is in GeneralBoard
     * **/

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



    /** Check if the player has already used a Character Card in the same turn
     * */
    public void CheckIfPlayerCanPlayCharacterCard(Player p) throws  PlayerAlreadyUsedCharacterCard{
        if(p.getCC()!= null){
            throw new PlayerAlreadyUsedCharacterCard();
        }
    }

    /** Check if the player has enough money to play the character card. If he has them, then
     * the card is saved in Player, the count use is set and the money are given to the
     * general board
     * */
    public void CheckIfEnoughMoney(Player p, CharacterCard c) throws NotEnoughCoinException{
        if(c.getCost()> p.getNumberCoins()){
            throw new NotEnoughCoinException(p.getNumberCoins(),c);
        }else{
            p.setNumberCoins(p.getNumberCoins()-c.getCost());
            c.getCountUse();
            gameModel.getGeneralBoard().addCoin(c.getCost());
            p.setCC(c);
        }
    }

    public void CheckColorOfTower(ColorTower ct, Player p) throws ColorTowerNotCorrectException{
        boolean flag = true;
        boolean flag1= true;
        int count =0;
        if(gameModel.getPlayers().size()<4 &&  gameModel.getPlayers().size()>1) {
            for (int i = 0; i < gameModel.getPlayers().size() && flag; i++) {
                if (gameModel.getPlayers().get(i).getMySchoolBoard().ColorTower() != null && !(gameModel.getPlayers().get(i).equals(p))) {
                    if (gameModel.getPlayers().get(i).getMySchoolBoard().ColorTower().equals(ct)) {
                        flag = false;
                    }
                }
            }
        }else {

            for (int i = 0; i < gameModel.getPlayers().size(); i++) {
                if (gameModel.getPlayers().get(i).getMySchoolBoard().ColorTower() != null && !(gameModel.getPlayers().get(i).equals(p))) {
                    if (gameModel.getPlayers().get(i).getMySchoolBoard().ColorTower().equals(ct)) {
                        count = count +1;
                    }
                }
            }

            if(count>1){
                flag= false;
            }
        }
        if(!flag){
            throw new ColorTowerNotCorrectException();
        }else{
            for(int i =0; i < gameModel.getPlayers().size() && flag1 ; i ++ ){
                if((gameModel.getPlayers().get(i).equals(p))){
                    gameModel.getPlayers().get(i).getMySchoolBoard().setColorTower(ct);
                    flag1 = false;
                }
            }
        }

    }

    public Player ReturnPlayerTurn(){
        return choosenPlayer.GetPlayerTurn();
    }




}


