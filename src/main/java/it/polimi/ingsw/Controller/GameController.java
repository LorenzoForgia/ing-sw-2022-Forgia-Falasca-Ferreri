package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Exception.*;
import it.polimi.ingsw.Exception.IllegalArgumentException;
import it.polimi.ingsw.Model.*;

import java.util.*;
import java.util.Random;

/**
 * @author Luigia Falasca
 * **/

public class GameController {
    private AddStudentsOnClouds addStudentsOnClouds = new AddStudentsOnClouds();
    private ChooseCloudTiles chooseCloudTiles = new ChooseCloudTiles();
    private ChoosenPlayer choosenPlayer = new ChoosenPlayer();
    private GameEndState gameEndState = new GameEndState();
    private Move3Students move3Students = new Move3Students();
    private Setup setup = new Setup();
    private MoveMotherNature moveMotherNature = new MoveMotherNature();
    private WinLoseCheckState winLoseCheckState = new WinLoseCheckState();
    private PlayAssCard playAssCard = new PlayAssCard();
    private GameModel gameModel=new GameModel();
    private InfluenceProfessorTable influenceProfessorTable = new InfluenceProfessorTable();
    private boolean SetFirstTurn = false;
    private boolean flagturn= false;
    private CharacterCard characterCardChosen=null;
    private int countmodexpview=1;
    private int asscardgui=0;

    public void setAsscardgui(int asscardgui) {
        this.asscardgui = asscardgui;
    }

    public int getAsscardgui() {
        return asscardgui;
    }

    public void incrementview(){
        if(countmodexpview<5){
            countmodexpview=countmodexpview+1;
        }
    }
    public void resetcountmodexpview(){countmodexpview=1;}
    public int getCountmodexpview(){return countmodexpview;}
    public boolean isFlagturn(){return flagturn;}
    public void setFlagturn(boolean flagturn){this.flagturn=flagturn;}
    public boolean getSetFirstTurn(){return SetFirstTurn;}
    public void setSetFirstTurn(boolean setFirstTurn){this.SetFirstTurn=setFirstTurn;}
    public GameModel getGameModel() {
        return gameModel;
    }


    public ChoosenPlayer getChoosenPlayer() {
        return choosenPlayer;
    }

    public void setChoosenPlayer(ChoosenPlayer choosenPlayer) {
        this.choosenPlayer = choosenPlayer;
    }

    public GameEndState getGameEndState() {
        return gameEndState;
    }

    public Setup getSetup() {
        return setup;
    }

    public void setSetup(Setup setup) {
        this.setup = setup;
    }

    public PlayAssCard getPlayAssCard() {
        return playAssCard;
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
        if(modexpert){
            for(int i=0; i < 3; i++){
                gameModel.getGeneralBoard().getChoosenCard().get(i).SetCard(gameModel.getBag(),gameModel.getGeneralBoard());
                if(gameModel.getGeneralBoard().getChoosenCard().get(i).getName()==3){
                    ((CharacterCard3)gameModel.getGeneralBoard().getChoosenCard().get(i)).setNumOfPlayer(numofPlayers);
                    ((CharacterCard3)gameModel.getGeneralBoard().getChoosenCard().get(i)).setSchoolBoardList(setup.getSBWithTowers());
                }
            }
        }
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
            if(gameModel.getModExpert()) {
                for (int i = 0; i < 3; i++) {
                    if (gameModel.getGeneralBoard().getChoosenCard().get(i).getName() == 12) {
                        ((CharacterCard12) gameModel.getGeneralBoard().getChoosenCard().get(i)).setPlayers(gameModel.getPlayers());
                    }
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
        if(cardAssistant.equals(CardAssistant.Invalid)){
            throw new CardAssistantNotAvailableException();
        }
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
        if(p.isUsedCharacterCard() && p.getNameCharacterCard()==2 ){
            influenceProfessorTable.RightProfessorTable(gameModel.getGeneralBoard(),gameModel.getNumplayers(),p);
        }else{
            influenceProfessorTable.RightProfessorTable(gameModel.getGeneralBoard(),gameModel.getNumplayers());
        }
    }


    public void IslandChosen(Player p, int n, Color c) throws IslandNotInListException{
        boolean flag= true;

        for(int i=0; i< gameModel.getGeneralBoard().GetIslands().size() && flag; i++){
            if(n== gameModel.getGeneralBoard().GetIslands().get(i).getNumberID()){
                PutStudentInLocation(c,gameModel.getGeneralBoard().GetIslands().get(i), p);
                flag= false;
            }
        }

        if(flag){
            throw new IslandNotInListException(n);
        }
    }

    /** Check if the steps are allowed or not. If they are, it changes the position of MotherNature
     * **/

    public void CheckNumberOfStepsMN(int n, Player p) throws IllegalNumberOfStepException {
        int move=0;
        if(p.isUsedCharacterCard() && p.getNameCharacterCard()==4){
                for(int i=0; i < 3; i++){
                    if(gameModel.getGeneralBoard().getChoosenCard().get(i).getName()== 4){
                        move = ((CharacterCard4)gameModel.getGeneralBoard().getChoosenCard().get(i)).AddTwoMvntMN(p.getCA());
                    }
                }
            } else{
                move = p.getCA().getMovementMN();
            }
        if( n > move|| n<=0 ){
            throw  new IllegalNumberOfStepException(n);
        }else {
            moveMotherNature.MoveMN(gameModel.getGeneralBoard(), n);
            if (p.isUsedCharacterCard() && (p.getNameCharacterCard() == 6 || p.getNameCharacterCard() ==8)) {
                    if (moveMotherNature.CheckIfIslandGetControlled(gameModel.getNumplayers(), gameModel.getGeneralBoard(), moveMotherNature.getI1(),p.getNameCharacterCard(),p.getMySchoolBoard())){
                        moveMotherNature.GetRightTowerOnIsland(gameModel.getGeneralBoard(), moveMotherNature.getI1(), setup.getSBWithTowers());
                        gameEndState.CheckEndGameImmediately(gameModel.getGeneralBoard(),setup.getSBWithTowers());
                    }
                }else if(p.isUsedCharacterCard() && p.getNameCharacterCard() == 9){
                    boolean flag = true;
                    for(int i=0; i < 3 && flag; i++){
                        if(gameModel.getGeneralBoard().getChoosenCard().get(i).getName()==9){
                            flag = false;
                            if (moveMotherNature.CheckIfIslandGetControlled(gameModel.getNumplayers(), gameModel.getGeneralBoard(), moveMotherNature.getI1(), 9,((CharacterCard9)gameModel.getGeneralBoard().getChoosenCard().get(i)).getChosenColor())){
                                moveMotherNature.GetRightTowerOnIsland(gameModel.getGeneralBoard(), moveMotherNature.getI1(), setup.getSBWithTowers());
                                gameEndState.CheckEndGameImmediately(gameModel.getGeneralBoard(),setup.getSBWithTowers());
                            }
                        }
                    }
                } else {
                if (moveMotherNature.CheckIfIslandGetControlled(gameModel.getNumplayers(), gameModel.getGeneralBoard(), moveMotherNature.getI1())) {
                    moveMotherNature.GetRightTowerOnIsland(gameModel.getGeneralBoard(), moveMotherNature.getI1(), setup.getSBWithTowers());
                    gameEndState.CheckEndGameImmediately(gameModel.getGeneralBoard(),setup.getSBWithTowers());
                }
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
            if(player.isUsedCharacterCard()){
                if(player.getNameCharacterCard()==2){
                    influenceProfessorTable.comeBackAfterUsingCharacterCard2(gameModel.getGeneralBoard(), gameModel.getNumplayers());
                }
                player.setNameCharacterCard(13);
            }
            influenceProfessorTable.RightProfessorTable(gameModel.getGeneralBoard(), gameModel.getNumplayers());
            choosenPlayer.incrementTurn();
        }
    }

   /** Return the name(s) of the player(s) who wins the game **/
    public ArrayList<String> showWinner(){
        ArrayList<Boolean> playerVictory = new ArrayList<>();
        ArrayList<String> namePlayerVictory = new ArrayList<>();
        playerVictory= winLoseCheckState.CheckWinner(gameModel.getPlayers(), setup.getSBWithTowers());
        for(int i=0; i < playerVictory.size(); i++){
            if(playerVictory.get(i)){
                namePlayerVictory.add(gameModel.getPlayers().get(i).getNickName());
            }
        }

        return namePlayerVictory;
    }


    /**Check if all played their turn and put students in cloud, reset the CharacterCard if the game is not ended,
     * reset the turn for the new game, reset the card Assistant played
     * **/
    public boolean ResetTheTurnForNewRoundWhenAllPlayed(){
        if(choosenPlayer.EndOfAllTurn()) {
            if (choosenPlayer.getNumPlayerTurn() == gameModel.getNumplayers()) {
                gameEndState.CheckEndGameRoundEndedForBag(gameModel.getBag());
                if (!gameEndState.isFlagImmediately() && !gameEndState.isFlagNotImmediately()) {
                    addStudentsOnClouds.RestartTurn(gameModel.getGeneralBoard(), gameModel.getBag(), gameModel.getNumplayers());
                    gameEndState.CheckEndGameRoundEndedForBag(gameModel.getBag());
                    playAssCard.ResetCardPlayed();
                    choosenPlayer.ChooseTurnPlayerForCardAssistant(gameModel.getPlayers());
                    if (gameModel.getModExpert()) {
                        influenceProfessorTable.RightProfessorTable(gameModel.getGeneralBoard(), gameModel.getNumplayers());
                        for (int i = 0; i < gameModel.getNumplayers(); i++) {
                            gameModel.getPlayers().get(i).setUsedCharacterCard(false);
                            gameModel.getPlayers().get(i).setNameCharacterCard(13);
                        }
                        characterCardChosen = null;
                    }
                }
            }
        }
        return  choosenPlayer.EndOfAllTurn();
    }

    /** Check if the CharacterCard is in GeneralBoard
     * **/

    public void CharacterCardInTable(int n) throws CharacterCardNotInTableException{
        boolean flag = true;
        for(int i=0; i < gameModel.getGeneralBoard().getChoosenCard().size() && flag; i ++) {
            if(gameModel.getGeneralBoard().getChoosenCard().get(i).getName()==n){
                flag= false;
                characterCardChosen= gameModel.getGeneralBoard().getChoosenCard().get(i);
            }
        }

        if(flag){
            throw new CharacterCardNotInTableException();
        }
    }



    /** Check if the player has already used a Character Card in the same turn
     * */
    public void CheckIfPlayerCanPlayCharacterCard(Player p) throws  PlayerAlreadyUsedCharacterCard{
        if(p.isUsedCharacterCard()){
            throw new PlayerAlreadyUsedCharacterCard();
        }
    }

    /** Check if the player can play a Character Card
     * */
    public boolean CheckIfShouldAskForCharacterCard(Player p){
        boolean flag = true;
        for(int i=0; i< gameModel.getGeneralBoard().getChoosenCard().size() && flag; i++){
            if(p.getNumberCoins()>=gameModel.getGeneralBoard().getChoosenCard().get(i).getCost()){
                flag= false;
            }
        }

        if(flag || p.isUsedCharacterCard()){
            return false;
        }else{
            return true;
        }
    }

    /** Check if the player has enough money to play the character card.
     * */
    public void CheckIfEnoughMoney(Player p, CharacterCard c) throws NotEnoughCoinException{
        if(c.getCost()> p.getNumberCoins()){
            throw new NotEnoughCoinException(p.getNumberCoins(),c);
        }
    }

    public void UseEffectOfCharacterCard(Player p, CharacterCard c){
          c.UseEffect(p);
          if(c.getName()==2){
              influenceProfessorTable.RightProfessorTable(gameModel.getGeneralBoard(), gameModel.getNumplayers(),p);
          }else{
              influenceProfessorTable.RightProfessorTable(gameModel.getGeneralBoard(), gameModel.getNumplayers());
          }
          p.setNumberCoins(p.getNumberCoins()-c.getCost());
          gameModel.getGeneralBoard().addCoin(c.getCost());
          c.setCountUse();
          gameEndState.CheckEndGameImmediately(gameModel.getGeneralBoard(), setup.getSBWithTowers());
          gameEndState.CheckEndGameRoundEndedForBag(gameModel.getBag());
    }

    /** Set and check the choices of the player for CharacterCard1
     * return false if the choices aren't correct, return true if are correct and set the attributes
     * **/
    public boolean SetCharacterCard1(CharacterCard c1, Color color, int n){
        boolean notCorrectIsland= true;
        boolean notCorrectColor= true;
        for(int i=0; notCorrectIsland && i< gameModel.getGeneralBoard().GetIslands().size(); i++){
            if(gameModel.getGeneralBoard().GetIslands().get(i).getNumberID()== n){
                notCorrectIsland= false;
                ((CharacterCard1)c1).setIchosen(gameModel.getGeneralBoard().GetIslands().get(i));
            }
        }
        for(int i=0; notCorrectColor && i< ((CharacterCard1)c1).GetchoosenStudent().size(); i++){
            if(((CharacterCard1)c1).GetchoosenStudent().get(i).equals(color)){
                notCorrectColor= false;
                ((CharacterCard1)c1).setChoosenColor(color);
            }
        }

        if(notCorrectColor || notCorrectIsland){
            return false;
        }else{
            return true;
        }
    }
    /** Set and check the choices of the player for CharacterCard3
     * return false if the choices aren't correct, return true if are correct and set the attributes
     * **/
    public boolean SetCharacterCard3(CharacterCard c3, int n){
        boolean notCorrectIsland= true;
        for(int i=0; notCorrectIsland && i< gameModel.getGeneralBoard().GetIslands().size(); i++){
            if(gameModel.getGeneralBoard().GetIslands().get(i).getNumberID()== n){
                notCorrectIsland= false;
                ((CharacterCard3)c3).setI1(gameModel.getGeneralBoard().GetIslands().get(i));
            }
        }

        if(notCorrectIsland){
            return false;
        }else{
            return true;
        }
    }

    /** Set and check the choices of the player for CharacterCard5
     * return false if the choices aren't correct, return true if are correct and set the attributes
     * **/
    public boolean SetCharacterCard5(CharacterCard c5, int n){
        boolean notCorrectIsland= true;
        for(int i=0; notCorrectIsland && i< gameModel.getGeneralBoard().GetIslands().size(); i++){
            if(gameModel.getGeneralBoard().GetIslands().get(i).getNumberID()== n){
                notCorrectIsland= false;
                ((CharacterCard5)c5).setI1(gameModel.getGeneralBoard().GetIslands().get(i));
            }
        }

        if(notCorrectIsland){
            return false;
        }else{
            return true;
        }
    }
    /** Set and check the choices of the player for CharacterCard7
     * return false if the choices aren't correct, return true if are correct and set the attributes
     * **/
    public boolean SetCharacterCard7(CharacterCard c7, ArrayList<Color> colorEntrance, ArrayList<Color> colorChosen, Player p){
        boolean notCorrectColorInEntrance= true;
        boolean notCorrectColorOnCard= true;
        ArrayList<Color> checkColor = new ArrayList<>();

        checkColor.addAll(((CharacterCard7) c7).getStudentOnCard());
        for(int i=0; notCorrectColorOnCard && i < colorChosen.size(); i++) {

            if(!checkColor.contains(colorChosen.get(i))){
                notCorrectColorOnCard= false;
            }else{
                checkColor.remove(colorChosen.get(i));
            }
        }

        checkColor.clear();
        checkColor.addAll(p.getMySchoolBoard().getEntrance());
        for(int i=0; notCorrectColorInEntrance && i < colorEntrance.size(); i++) {
            if(!checkColor.contains(colorEntrance.get(i))){
                notCorrectColorInEntrance= false;
            }else{
                checkColor.remove(colorEntrance.get(i));
            }
        }

        if(!notCorrectColorInEntrance || !notCorrectColorOnCard){
            return false;
        }else{
            ((CharacterCard7) c7).setStudentChoosen(colorChosen);
            ((CharacterCard7) c7).setStudentOnEntrance(colorEntrance);
            return true;
        }
    }
    /** Set and check the choices of the player for CharacterCard10
     * return false if the choices aren't correct, return true if are correct and set the attributes
     * **/
    public boolean SetCharacterCard10(CharacterCard c10, ArrayList<Color> colorEntrance, ArrayList<Color> colorDiningRoom, Player p){
        boolean notCorrectColorInEntrance= true;
        boolean notCorrectColorInDiningRoom= true;
        ArrayList<Color> checkColor = new ArrayList<>();
        int[] colorInDiningRoom= new int[5];

        for(int i=0; i<5; i++){
            colorInDiningRoom[i]=p.getMySchoolBoard().getDiningRoom().GetNumberStudent(i);
        }

        for(int i=0; notCorrectColorInDiningRoom && i < colorDiningRoom.size(); i++) {
            if(colorInDiningRoom[colorDiningRoom.get(i).getIndex()]==0){
                notCorrectColorInDiningRoom= false;
            }else{
                colorInDiningRoom[colorDiningRoom.get(i).getIndex()]= colorInDiningRoom[colorDiningRoom.get(i).getIndex()]-1;
            }
        }


        checkColor.addAll(p.getMySchoolBoard().getEntrance());
        for(int i=0; notCorrectColorInEntrance && i < colorEntrance.size(); i++) {
            if(!checkColor.contains(colorEntrance.get(i))){
                notCorrectColorInEntrance= false;
            }else{
                checkColor.remove(colorEntrance.get(i));
            }
        }

        if(!notCorrectColorInEntrance || !notCorrectColorInDiningRoom){
            return false;
        }else{
            ((CharacterCard10) c10).setStudentOnDiningRoom(colorDiningRoom);
            ((CharacterCard10) c10).setStudentOnEntrance(colorEntrance);
            return true;
        }
    }
    /** Set and check the choices of the player for CharacterCard9
     * return false if the choices aren't correct, return true if are correct and set the attributes
     * **/
    public boolean SetCharacterCard9(CharacterCard c9, Color color){
        ((CharacterCard9)c9).setChosenColor(color);
        return true;
    }

    /** Set and check the choices of the player for CharacterCard11
     * return false if the choices aren't correct, return true if are correct and set the attributes
     * **/
    public boolean SetCharacterCard11(CharacterCard c11, Color color){
        boolean notCorrectColor= true;

        for(int i=0; notCorrectColor && i< ((CharacterCard11)c11).GetchoosenStudent().size(); i++){
            if(((CharacterCard11)c11).GetchoosenStudent().get(i).equals(color)){
                notCorrectColor= false;
                ((CharacterCard11)c11).setChoosenColor(color);
            }
        }

        if(notCorrectColor){
            return false;
        }else{
            return true;
        }
    }

    /** Set and check the choices of the player for CharacterCard12
     * return false if the choices aren't correct, return true if are correct and set the attributes
     * **/
    public boolean SetCharacterCard12(CharacterCard c12, Color color){
        ((CharacterCard12)c12).setChosenColor(color);
         return true;
    }

    /** Return CharacterCards in table
     * **/
    public CharacterCard getCharacterCardChosen() {
        return characterCardChosen;
    }
}


