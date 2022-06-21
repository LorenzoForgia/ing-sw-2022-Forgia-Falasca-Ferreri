package it.polimi.ingsw.Client.views.GUI;


import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.messages.AnsAskCAMsg;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.util.ArrayList;



public class SchoolBoardScene {

    @FXML
    private Circle Entrance1;
    @FXML
    private Circle Entrance2;
    @FXML
    private Circle Entrance3;
    @FXML
    private Circle Entrance4;
    @FXML
    private Circle Entrance5;
    @FXML
    private Circle Entrance6;
    @FXML
    private Circle Entrance7;
    @FXML
    private Circle Entrance8;
    @FXML
    private Circle Entrance9;
    @FXML
    private Circle DiningRoom11;
    @FXML
    private Circle DiningRoom12;
    @FXML
    private Circle DiningRoom13;
    @FXML
    private Circle DiningRoom14;
    @FXML
    private Circle DiningRoom15;
    @FXML
    private Circle DiningRoom16;
    @FXML
    private Circle DiningRoom17;
    @FXML
    private Circle DiningRoom18;
    @FXML
    private Circle DiningRoom19;
    @FXML
    private Circle DiningRoom110;
    @FXML
    private Circle DiningRoom21;
    @FXML
    private Circle DiningRoom22;
    @FXML
    private Circle DiningRoom23;
    @FXML
    private Circle DiningRoom24;
    @FXML
    private Circle DiningRoom25;
    @FXML
    private Circle DiningRoom26;
    @FXML
    private Circle DiningRoom27;
    @FXML
    private Circle DiningRoom28;
    @FXML
    private Circle DiningRoom29;
    @FXML
    private Circle DiningRoom210;
    @FXML
    private Circle DiningRoom31;
    @FXML
    private Circle DiningRoom32;
    @FXML
    private Circle DiningRoom33;
    @FXML
    private Circle DiningRoom34;
    @FXML
    private Circle DiningRoom35;
    @FXML
    private Circle DiningRoom36;
    @FXML
    private Circle DiningRoom37;
    @FXML
    private Circle DiningRoom38;
    @FXML
    private Circle DiningRoom39;
    @FXML
    private Circle DiningRoom310;
    @FXML
    private Circle DiningRoom41;
    @FXML
    private Circle DiningRoom42;
    @FXML
    private Circle DiningRoom43;
    @FXML
    private Circle DiningRoom44;
    @FXML
    private Circle DiningRoom45;
    @FXML
    private Circle DiningRoom46;
    @FXML
    private Circle DiningRoom47;
    @FXML
    private Circle DiningRoom48;
    @FXML
    private Circle DiningRoom49;
    @FXML
    private Circle DiningRoom410;
    @FXML
    private Circle DiningRoom51;
    @FXML
    private Circle DiningRoom52;
    @FXML
    private Circle DiningRoom53;
    @FXML
    private Circle DiningRoom54;
    @FXML
    private Circle DiningRoom55;
    @FXML
    private Circle DiningRoom56;
    @FXML
    private Circle DiningRoom57;
    @FXML
    private Circle DiningRoom58;
    @FXML
    private Circle DiningRoom59;
    @FXML
    private Circle DiningRoom510;
    @FXML
    private Circle Tower1;
    @FXML
    private Circle Tower2;
    @FXML
    private Circle Tower3;
    @FXML
    private Circle Tower4;
    @FXML
    private Circle Tower5;
    @FXML
    private Circle Tower6;
    @FXML
    private Circle Tower7;
    @FXML
    private Circle Tower8;
    @FXML
    private ImageView teacher1;
    @FXML
    private ImageView teacher2;
    @FXML
    private ImageView teacher3;
    @FXML
    private ImageView teacher4;
    @FXML
    private ImageView teacher5;
    @FXML
    private Label playerSchoolBoardWritten;

    private static int numberOfSceneToComeBack;
    private SchoolBoard schoolBoardToShow;
    private static Player player;


    /** number to decide where to come back
     * 0 is for AssistantCardScene
     * 1 is for MoveStudentScene1
     * 2 is for MoveStudentScene2
     * 3 is for MoveStudentScene3
     * 4 is for MoveStudentScene4
     * 5 is for AssistantCardSceneNewTurn
     * 6 is for AskForMotherNatureScene
     * 7 is for AskForMN3PlayersScene
     * **/
    public static void setNumberOfSceneToComeBack(int numberOfSceneToComeBack) {
        SchoolBoardScene.numberOfSceneToComeBack = numberOfSceneToComeBack;
    }

    public static void setPlayer(Player player) {
        SchoolBoardScene.player = player;
    }


    public void backToSceneButtonClicked(ActionEvent event){
        if(numberOfSceneToComeBack==0){
            JavaFXMain.getCurrentApplication().switchToCardAssistantScene();
        }else if(numberOfSceneToComeBack==1){
            JavaFXMain.getCurrentApplication().switchToMoveStudent1Scene();
        } else if(numberOfSceneToComeBack==2){
        JavaFXMain.getCurrentApplication().switchToMoveStudent2Scene();
        }else if(numberOfSceneToComeBack==3) {
        JavaFXMain.getCurrentApplication().switchToMoveStudent3Scene();
        }else if(numberOfSceneToComeBack==4) {
        JavaFXMain.getCurrentApplication().switchToMoveStudent4Scene();
        }else if(numberOfSceneToComeBack==5) {
            JavaFXMain.getCurrentApplication().switchToAssistantCardSceneNewTurn();
        }else if(numberOfSceneToComeBack==6){
            JavaFXMain.getCurrentApplication().switchToAskForMotherNatureScene();
        }else if(numberOfSceneToComeBack==7){
            JavaFXMain.getCurrentApplication().switchToAskForMN3PlayersScene();
        }
    }


    private void getTheRightColor(it.polimi.ingsw.Model.Color color, Circle circle){
        if(color.equals(it.polimi.ingsw.Model.Color.Green)){
            circle.setFill(Color.GREEN);
        }else if(color.equals(it.polimi.ingsw.Model.Color.Red)){
            circle.setFill(Color.RED);
        }else if(color.equals(it.polimi.ingsw.Model.Color.Yellow)){
            circle.setFill(Color.YELLOW);
        }else if(color.equals(it.polimi.ingsw.Model.Color.Pink)){
            circle.setFill(Color.PINK);
        }else if(color.equals(it.polimi.ingsw.Model.Color.Blue)){
            circle.setFill(Color.BLUE);
        }
    }

    public void initialize() {

        schoolBoardToShow= player.getMySchoolBoard();
        playerSchoolBoardWritten.setText("Plancia di " + player.getNickName());

        ArrayList<Circle> entranceStudent = new ArrayList<>();
        entranceStudent.add(0, Entrance1);
        entranceStudent.add(1, Entrance2);
        entranceStudent.add(2, Entrance3);
        entranceStudent.add(3, Entrance4);
        entranceStudent.add(4, Entrance5);
        entranceStudent.add(5, Entrance6);
        entranceStudent.add(6, Entrance7);
        entranceStudent.add(7, Entrance8);
        entranceStudent.add(8, Entrance9);

        for (int i = 0; i < schoolBoardToShow.getEntrance().size(); i++) {
            getTheRightColor(schoolBoardToShow.getEntrance().get(i), entranceStudent.get(i));
        }

        ArrayList<Circle> diningRoomStudentGreen = new ArrayList<>();
        diningRoomStudentGreen.add(0, DiningRoom11);
        diningRoomStudentGreen.add(1, DiningRoom12);
        diningRoomStudentGreen.add(2, DiningRoom13);
        diningRoomStudentGreen.add(3, DiningRoom14);
        diningRoomStudentGreen.add(4, DiningRoom15);
        diningRoomStudentGreen.add(5, DiningRoom16);
        diningRoomStudentGreen.add(6, DiningRoom17);
        diningRoomStudentGreen.add(7, DiningRoom18);
        diningRoomStudentGreen.add(8, DiningRoom19);
        diningRoomStudentGreen.add(9, DiningRoom110);

        for (int i = 0; i < schoolBoardToShow.getDiningRoom().GetNumberStudent(0); i++) {
            diningRoomStudentGreen.get(i).setFill(Color.GREEN);
        }

        ArrayList<Circle> diningRoomStudentRed = new ArrayList<>();
        diningRoomStudentRed.add(0, DiningRoom21);
        diningRoomStudentRed.add(1, DiningRoom22);
        diningRoomStudentRed.add(2, DiningRoom23);
        diningRoomStudentRed.add(3, DiningRoom24);
        diningRoomStudentRed.add(4, DiningRoom25);
        diningRoomStudentRed.add(5, DiningRoom26);
        diningRoomStudentRed.add(6, DiningRoom27);
        diningRoomStudentRed.add(7, DiningRoom28);
        diningRoomStudentRed.add(8, DiningRoom29);
        diningRoomStudentRed.add(9, DiningRoom210);

        for (int i = 0; i < schoolBoardToShow.getDiningRoom().GetNumberStudent(1); i++) {
            diningRoomStudentRed.get(i).setFill(Color.RED);
        }

        ArrayList<Circle> diningRoomStudentYellow = new ArrayList<>();
        diningRoomStudentYellow.add(0, DiningRoom31);
        diningRoomStudentYellow.add(1, DiningRoom32);
        diningRoomStudentYellow.add(2, DiningRoom33);
        diningRoomStudentYellow.add(3, DiningRoom34);
        diningRoomStudentYellow.add(4, DiningRoom35);
        diningRoomStudentYellow.add(5, DiningRoom36);
        diningRoomStudentYellow.add(6, DiningRoom37);
        diningRoomStudentYellow.add(7, DiningRoom38);
        diningRoomStudentYellow.add(8, DiningRoom39);
        diningRoomStudentYellow.add(9, DiningRoom310);

        for (int i = 0; i < schoolBoardToShow.getDiningRoom().GetNumberStudent(2); i++) {
            diningRoomStudentYellow.get(i).setFill(Color.YELLOW);
        }

        ArrayList<Circle> diningRoomStudentPink = new ArrayList<>();
        diningRoomStudentPink.add(0, DiningRoom41);
        diningRoomStudentPink.add(1, DiningRoom42);
        diningRoomStudentPink.add(2, DiningRoom43);
        diningRoomStudentPink.add(3, DiningRoom44);
        diningRoomStudentPink.add(4, DiningRoom45);
        diningRoomStudentPink.add(5, DiningRoom46);
        diningRoomStudentPink.add(6, DiningRoom47);
        diningRoomStudentPink.add(7, DiningRoom48);
        diningRoomStudentPink.add(8, DiningRoom49);
        diningRoomStudentPink.add(9, DiningRoom410);

        for (int i = 0; i < schoolBoardToShow.getDiningRoom().GetNumberStudent(3); i++) {
            diningRoomStudentPink.get(i).setFill(Color.PINK);
        }

        ArrayList<Circle> diningRoomStudentBlue = new ArrayList<>();
        diningRoomStudentBlue.add(0, DiningRoom51);
        diningRoomStudentBlue.add(1, DiningRoom52);
        diningRoomStudentBlue.add(2, DiningRoom53);
        diningRoomStudentBlue.add(3, DiningRoom54);
        diningRoomStudentBlue.add(4, DiningRoom55);
        diningRoomStudentBlue.add(5, DiningRoom56);
        diningRoomStudentBlue.add(6, DiningRoom57);
        diningRoomStudentBlue.add(7, DiningRoom58);
        diningRoomStudentBlue.add(8, DiningRoom59);
        diningRoomStudentBlue.add(9, DiningRoom510);

        for (int i = 0; i < schoolBoardToShow.getDiningRoom().GetNumberStudent(4); i++) {
            diningRoomStudentBlue.get(i).setFill(Color.BLUE);
        }

        ArrayList<Circle> towerRoom = new ArrayList<>();
        towerRoom.add(0, Tower1);
        towerRoom.add(1, Tower2);
        towerRoom.add(2, Tower3);
        towerRoom.add(3, Tower4);
        towerRoom.add(4, Tower5);
        towerRoom.add(5, Tower6);
        towerRoom.add(6, Tower7);
        towerRoom.add(7, Tower8);
        ColorTower ct = schoolBoardToShow.ColorTower();
        Color color;
        if (ct.equals(ColorTower.Black)) {
            color = Color.BLACK;
        } else if (ct.equals(ColorTower.White)) {
            color = Color.WHITE;
        } else {
            color = Color.GREY;
        }
        for (int i = 0; i < schoolBoardToShow.getNumberOfTower(); i++) {
            towerRoom.get(i).setFill(color);
            towerRoom.get(i).setStrokeWidth(1);
        }

        if (schoolBoardToShow.getProfessorTable().contains(it.polimi.ingsw.Model.Color.Green)) {
            Image imageTeacher1 = new Image("teacher_green.png");
            teacher1.setImage(imageTeacher1);
        }
        if (schoolBoardToShow.getProfessorTable().contains(it.polimi.ingsw.Model.Color.Red)) {
            Image imageTeacher2 = new Image("teacher_red.png");
            teacher2.setImage(imageTeacher2);
        }
        if (schoolBoardToShow.getProfessorTable().contains(it.polimi.ingsw.Model.Color.Yellow)) {
            Image imageTeacher3 = new Image("teacher_yellow.png");
            teacher3.setImage(imageTeacher3);
        }
        if (schoolBoardToShow.getProfessorTable().contains(it.polimi.ingsw.Model.Color.Pink)) {
            Image imageTeacher4 = new Image("teacher_pink.png");
            teacher4.setImage(imageTeacher4);
        }
        if (schoolBoardToShow.getProfessorTable().contains(it.polimi.ingsw.Model.Color.Blue)) {
            Image imageTeacher5 = new Image("teacher_blue.png");
            teacher5.setImage(imageTeacher5);
        }

    }
}
