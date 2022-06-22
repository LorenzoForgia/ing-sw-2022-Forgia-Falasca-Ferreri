package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.messages.AnsCC1Msg;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

public class CC1Scene {
    @FXML
    private Circle student1;
    @FXML
    private Circle student2;
    @FXML
    private Circle student3;
    @FXML
    private Circle student4;
    private static AnsCC1Msg answerMsg;
    private static Color colorChosen;

    public static void setAnswerMsg(AnsCC1Msg answerMsg) {
        CC1Scene.answerMsg = answerMsg;
    }

    public static Color getColorChosen() {
        return colorChosen;
    }

    public void initialize(){
        getTheRightColor(((CharacterCard1)answerMsg.GetCharacterCard()).GetchoosenStudent().get(0), student1);
        getTheRightColor(((CharacterCard1)answerMsg.GetCharacterCard()).GetchoosenStudent().get(1), student2);
        getTheRightColor(((CharacterCard1)answerMsg.GetCharacterCard()).GetchoosenStudent().get(2), student3);
        getTheRightColor(((CharacterCard1)answerMsg.GetCharacterCard()).GetchoosenStudent().get(3), student4);
    }

    public void chosenStudent1(){
        colorChosen= ((CharacterCard1)answerMsg.GetCharacterCard()).GetchoosenStudent().get(0);
        IslandTilesScene.setOnlyObserv(false);
        IslandTilesScene.setNumberOfSceneToComeBack(13);
        IslandTilesScene.setIslands(answerMsg.GetGB().GetIslands());
        JavaFXMain.getCurrentApplication().switchToIslandTitleScene();
    }
    public void chosenStudent2(){
        colorChosen= ((CharacterCard1)answerMsg.GetCharacterCard()).GetchoosenStudent().get(1);
        IslandTilesScene.setOnlyObserv(false);
        IslandTilesScene.setNumberOfSceneToComeBack(13);
        IslandTilesScene.setIslands(answerMsg.GetGB().GetIslands());
        JavaFXMain.getCurrentApplication().switchToIslandTitleScene();
    }
    public void chosenStudent3(){
        colorChosen= ((CharacterCard1)answerMsg.GetCharacterCard()).GetchoosenStudent().get(2);
        IslandTilesScene.setOnlyObserv(false);
        IslandTilesScene.setNumberOfSceneToComeBack(13);
        IslandTilesScene.setIslands(answerMsg.GetGB().GetIslands());
        JavaFXMain.getCurrentApplication().switchToIslandTitleScene();
    }
    public void chosenStudent4(){
        colorChosen= ((CharacterCard1)answerMsg.GetCharacterCard()).GetchoosenStudent().get(3);
        IslandTilesScene.setOnlyObserv(false);
        IslandTilesScene.setNumberOfSceneToComeBack(13);
        IslandTilesScene.setIslands(answerMsg.GetGB().GetIslands());
        JavaFXMain.getCurrentApplication().switchToIslandTitleScene();
    }

    private void getTheRightColor(it.polimi.ingsw.Model.Color color, Circle circle){
        if(color.equals(it.polimi.ingsw.Model.Color.Green)){
            circle.setFill(javafx.scene.paint.Color.GREEN);
        }else if(color.equals(it.polimi.ingsw.Model.Color.Red)){
            circle.setFill(javafx.scene.paint.Color.RED);
        }else if(color.equals(it.polimi.ingsw.Model.Color.Yellow)){
            circle.setFill(javafx.scene.paint.Color.YELLOW);
        }else if(color.equals(it.polimi.ingsw.Model.Color.Pink)){
            circle.setFill(javafx.scene.paint.Color.PINK);
        }else if(color.equals(it.polimi.ingsw.Model.Color.Blue)){
            circle.setFill(javafx.scene.paint.Color.BLUE);
        }
    }
}
