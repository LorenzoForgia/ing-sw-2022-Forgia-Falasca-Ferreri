package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Model.ColorTower;
import it.polimi.ingsw.Model.IslandTiles;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class IslandTilesScene {

    @FXML
    private ImageView Island1;
    @FXML
    private ImageView Island2;
    @FXML
    private ImageView Island3;
    @FXML
    private ImageView Island4;
    @FXML
    private ImageView Island5;
    @FXML
    private ImageView Island6;
    @FXML
    private ImageView Island7;
    @FXML
    private ImageView Island8;
    @FXML
    private ImageView Island9;
    @FXML
    private ImageView Island10;
    @FXML
    private ImageView Island11;
    @FXML
    private ImageView Island12;
    @FXML
    private ImageView studentRed1;
    @FXML
    private ImageView studentRed2;
    @FXML
    private ImageView studentRed3;
    @FXML
    private ImageView studentRed4;
    @FXML
    private ImageView studentRed5;
    @FXML
    private ImageView studentRed6;
    @FXML
    private ImageView studentRed7;
    @FXML
    private ImageView studentRed8;
    @FXML
    private ImageView studentRed9;
    @FXML
    private ImageView studentRed10;
    @FXML
    private ImageView studentRed11;
    @FXML
    private ImageView studentRed12;
    @FXML
    private ImageView studentYellow1;
    @FXML
    private ImageView studentYellow2;
    @FXML
    private ImageView studentYellow3;
    @FXML
    private ImageView studentYellow4;
    @FXML
    private ImageView studentYellow5;
    @FXML
    private ImageView studentYellow6;
    @FXML
    private ImageView studentYellow7;
    @FXML
    private ImageView studentYellow8;
    @FXML
    private ImageView studentYellow9;
    @FXML
    private ImageView studentYellow10;
    @FXML
    private ImageView studentYellow11;
    @FXML
    private ImageView studentYellow12;
    @FXML
    private ImageView studentGreen1;
    @FXML
    private ImageView studentGreen2;
    @FXML
    private ImageView studentGreen3;
    @FXML
    private ImageView studentGreen4;
    @FXML
    private ImageView studentGreen5;
    @FXML
    private ImageView studentGreen6;
    @FXML
    private ImageView studentGreen7;
    @FXML
    private ImageView studentGreen8;
    @FXML
    private ImageView studentGreen9;
    @FXML
    private ImageView studentGreen10;
    @FXML
    private ImageView studentGreen11;
    @FXML
    private ImageView studentGreen12;
    @FXML
    private ImageView studentPink1;
    @FXML
    private ImageView studentPink2;
    @FXML
    private ImageView studentPink3;
    @FXML
    private ImageView studentPink4;
    @FXML
    private ImageView studentPink5;
    @FXML
    private ImageView studentPink6;
    @FXML
    private ImageView studentPink7;
    @FXML
    private ImageView studentPink8;
    @FXML
    private ImageView studentPink9;
    @FXML
    private ImageView studentPink10;
    @FXML
    private ImageView studentPink11;
    @FXML
    private ImageView studentPink12;
    @FXML
    private ImageView studentBlue1;
    @FXML
    private ImageView studentBlue2;
    @FXML
    private ImageView studentBlue3;
    @FXML
    private ImageView studentBlue4;
    @FXML
    private ImageView studentBlue5;
    @FXML
    private ImageView studentBlue6;
    @FXML
    private ImageView studentBlue7;
    @FXML
    private ImageView studentBlue8;
    @FXML
    private ImageView studentBlue9;
    @FXML
    private ImageView studentBlue10;
    @FXML
    private ImageView studentBlue11;
    @FXML
    private ImageView studentBlue12;
    @FXML
    private ImageView Tower1;
    @FXML
    private ImageView Tower2;
    @FXML
    private ImageView Tower3;
    @FXML
    private ImageView Tower4;
    @FXML
    private ImageView Tower5;
    @FXML
    private ImageView Tower6;
    @FXML
    private ImageView Tower7;
    @FXML
    private ImageView Tower8;
    @FXML
    private ImageView Tower9;
    @FXML
    private ImageView Tower10;
    @FXML
    private ImageView Tower11;
    @FXML
    private ImageView Tower12;
    @FXML
    private ImageView motherNature1;
    @FXML
    private ImageView motherNature2;
    @FXML
    private ImageView motherNature3;
    @FXML
    private ImageView motherNature4;
    @FXML
    private ImageView motherNature5;
    @FXML
    private ImageView motherNature6;
    @FXML
    private ImageView motherNature7;
    @FXML
    private ImageView motherNature8;
    @FXML
    private ImageView motherNature9;
    @FXML
    private ImageView motherNature10;
    @FXML
    private ImageView motherNature11;
    @FXML
    private ImageView motherNature12;
    @FXML
    private ImageView noEntryTiles1;
    @FXML
    private ImageView noEntryTiles2;
    @FXML
    private ImageView noEntryTiles3;
    @FXML
    private ImageView noEntryTiles4;
    @FXML
    private ImageView noEntryTiles5;
    @FXML
    private ImageView noEntryTiles6;
    @FXML
    private ImageView noEntryTiles7;
    @FXML
    private ImageView noEntryTiles8;
    @FXML
    private ImageView noEntryTiles9;
    @FXML
    private ImageView noEntryTiles10;
    @FXML
    private ImageView noEntryTiles11;
    @FXML
    private ImageView noEntryTiles12;
    @FXML
    private Label size1;
    @FXML
    private Label size2;
    @FXML
    private Label size3;
    @FXML
    private Label size4;
    @FXML
    private Label size5;
    @FXML
    private Label size6;
    @FXML
    private Label size7;
    @FXML
    private Label size8;
    @FXML
    private Label size9;
    @FXML
    private Label size10;
    @FXML
    private Label size11;
    @FXML
    private Label size12;
    @FXML
    private Label numberStudentGreen1;
    @FXML
    private Label numberStudentGreen2;
    @FXML
    private Label numberStudentGreen3;
    @FXML
    private Label numberStudentGreen4;
    @FXML
    private Label numberStudentGreen5;
    @FXML
    private Label numberStudentGreen6;
    @FXML
    private Label numberStudentGreen7;
    @FXML
    private Label numberStudentGreen8;
    @FXML
    private Label numberStudentGreen9;
    @FXML
    private Label numberStudentGreen10;
    @FXML
    private Label numberStudentGreen11;
    @FXML
    private Label numberStudentGreen12;
    @FXML
    private Label numberStudentRed1;
    @FXML
    private Label numberStudentRed2;
    @FXML
    private Label numberStudentRed3;
    @FXML
    private Label numberStudentRed4;
    @FXML
    private Label numberStudentRed5;
    @FXML
    private Label numberStudentRed6;
    @FXML
    private Label numberStudentRed7;
    @FXML
    private Label numberStudentRed8;
    @FXML
    private Label numberStudentRed9;
    @FXML
    private Label numberStudentRed10;
    @FXML
    private Label numberStudentRed11;
    @FXML
    private Label numberStudentRed12;
    @FXML
    private Label numberStudentBlue1;
    @FXML
    private Label numberStudentBlue2;
    @FXML
    private Label numberStudentBlue3;
    @FXML
    private Label numberStudentBlue4;
    @FXML
    private Label numberStudentBlue5;
    @FXML
    private Label numberStudentBlue6;
    @FXML
    private Label numberStudentBlue7;
    @FXML
    private Label numberStudentBlue8;
    @FXML
    private Label numberStudentBlue9;
    @FXML
    private Label numberStudentBlue10;
    @FXML
    private Label numberStudentBlue11;
    @FXML
    private Label numberStudentBlue12;
    @FXML
    private Label numberStudentYellow1;
    @FXML
    private Label numberStudentYellow2;
    @FXML
    private Label numberStudentYellow3;
    @FXML
    private Label numberStudentYellow4;
    @FXML
    private Label numberStudentYellow5;
    @FXML
    private Label numberStudentYellow6;
    @FXML
    private Label numberStudentYellow7;
    @FXML
    private Label numberStudentYellow8;
    @FXML
    private Label numberStudentYellow9;
    @FXML
    private Label numberStudentYellow10;
    @FXML
    private Label numberStudentYellow11;
    @FXML
    private Label numberStudentYellow12;
    @FXML
    private Label numberStudentPink1;
    @FXML
    private Label numberStudentPink2;
    @FXML
    private Label numberStudentPink3;
    @FXML
    private Label numberStudentPink4;
    @FXML
    private Label numberStudentPink5;
    @FXML
    private Label numberStudentPink6;
    @FXML
    private Label numberStudentPink7;
    @FXML
    private Label numberStudentPink8;
    @FXML
    private Label numberStudentPink9;
    @FXML
    private Label numberStudentPink10;
    @FXML
    private Label numberStudentPink11;
    @FXML
    private Label numberStudentPink12;
    @FXML
    private Label numberTower1;
    @FXML
    private Label numberTower2;
    @FXML
    private Label numberTower3;
    @FXML
    private Label numberTower4;
    @FXML
    private Label numberTower5;
    @FXML
    private Label numberTower6;
    @FXML
    private Label numberTower7;
    @FXML
    private Label numberTower8;
    @FXML
    private Label numberTower9;
    @FXML
    private Label numberTower10;
    @FXML
    private Label numberTower11;
    @FXML
    private Label numberTower12;
    private ArrayList<IslandTiles> islands;
    private static boolean onlyObserv;

    public static void setOnlyObserv(boolean onlyObserv) {
        IslandTilesScene.onlyObserv = onlyObserv;
    }

    public void chosenIsland1(){
        System.out.println("Ho scelto l'isola 1");
    }
    public void chosenIsland2(){
        System.out.println("Ho scelto l'isola 2");
    }
    public void chosenIsland3(){
        System.out.println("Ho scelto l'isola 3");
    }
    public void chosenIsland4(){
        System.out.println("Ho scelto l'isola 4");
    }
    public void chosenIsland5(){
        System.out.println("Ho scelto l'isola 5");
    }
    public void chosenIsland6(){
        System.out.println("Ho scelto l'isola 6");
    }
    public void chosenIsland7(){
        System.out.println("Ho scelto l'isola 7");
    }
    public void chosenIsland8(){
        System.out.println("Ho scelto l'isola 8");
    }
    public void chosenIsland9(){
        System.out.println("Ho scelto l'isola 9");
    }
    public void chosenIsland10(){
        System.out.println("Ho scelto l'isola 10");
    }
    public void chosenIsland11(){
        System.out.println("Ho scelto l'isola 11");
    }
    public void chosenIsland12(){
        System.out.println("Ho scelto l'isola 12");
    }


    private IslandTiles returnIsland(ArrayList<IslandTiles> islandTiles, int n){
        for(int i=0; i< islandTiles.size(); i++){
            if(islandTiles.get(i).getNumberID()==n){
                return islandTiles.get(i);

            }
        }
        return null;
    }
    public void initialize() {
        IslandTiles islandToShow;
        islands = new ArrayList<>();
        IslandTiles i1 = new IslandTiles(1, false, 1, false, 0, false);
        IslandTiles i2 = new IslandTiles(2, true, 1, false, 0, false);
        IslandTiles i3 = new IslandTiles(3, false, 1, true, 0, false);
        IslandTiles i4= new IslandTiles(4, false, 4, true, 0, true);
        i4.putTower(ColorTower.Black);
        i4.PutStudent(Color.Blue);
        islands.add(i1);
        islands.add(i2);
        islands.add(i3);
        islands.add(i4);
        ArrayList<ImageView> islandImage = new ArrayList<>();
        ArrayList<ImageView> studentRedImage = new ArrayList<>();
        ArrayList<ImageView> studentGreenImage = new ArrayList<>();
        ArrayList<ImageView> studentPinkImage = new ArrayList<>();
        ArrayList<ImageView> studentBlueImage = new ArrayList<>();
        ArrayList<ImageView> studentYellowImage = new ArrayList<>();
        ArrayList<ImageView> towerImage = new ArrayList<>();
        ArrayList<ImageView> noEntryTilesImage = new ArrayList<>();
        ArrayList<Label> numberStudentGreen = new ArrayList<>();
        ArrayList<Label> numberStudentYellow = new ArrayList<>();
        ArrayList<Label> numberStudentRed = new ArrayList<>();
        ArrayList<Label> numberStudentBlue = new ArrayList<>();
        ArrayList<Label> numberStudentPink = new ArrayList<>();
        ArrayList<ImageView> motherNature = new ArrayList<>();
        ArrayList<Label> numberTower = new ArrayList<>();
        ArrayList<Label> sizes = new ArrayList<>();

        islandImage.add(0,Island1);
        islandImage.add(1,Island2);
        islandImage.add(2,Island3);
        islandImage.add(3,Island4);
        islandImage.add(4,Island5);
        islandImage.add(5,Island6);
        islandImage.add(6,Island7);
        islandImage.add(7,Island8);
        islandImage.add(8,Island9);
        islandImage.add(9,Island10);
        islandImage.add(10,Island11);
        islandImage.add(11,Island12);

        studentRedImage.add(0, studentRed1);
        studentRedImage.add(1, studentRed2);
        studentRedImage.add(2, studentRed3);
        studentRedImage.add(3, studentRed4);
        studentRedImage.add(4, studentRed5);
        studentRedImage.add(5, studentRed6);
        studentRedImage.add(6, studentRed7);
        studentRedImage.add(7, studentRed8);
        studentRedImage.add(8, studentRed9);
        studentRedImage.add(9, studentRed10);
        studentRedImage.add(10, studentRed11);
        studentRedImage.add(11, studentRed12);

        studentGreenImage.add(0, studentGreen1);
        studentGreenImage.add(1, studentGreen2);
        studentGreenImage.add(2, studentGreen3);
        studentGreenImage.add(3, studentGreen4);
        studentGreenImage.add(4, studentGreen5);
        studentGreenImage.add(5, studentGreen6);
        studentGreenImage.add(6, studentGreen7);
        studentGreenImage.add(7, studentGreen8);
        studentGreenImage.add(8, studentGreen9);
        studentGreenImage.add(9, studentGreen10);
        studentGreenImage.add(10, studentGreen11);
        studentGreenImage.add(11, studentGreen12);

        studentYellowImage.add(0, studentYellow1);
        studentYellowImage.add(1, studentYellow2);
        studentYellowImage.add(2, studentYellow3);
        studentYellowImage.add(3, studentYellow4);
        studentYellowImage.add(4, studentYellow5);
        studentYellowImage.add(5, studentYellow6);
        studentYellowImage.add(6, studentYellow7);
        studentYellowImage.add(7, studentYellow8);
        studentYellowImage.add(8, studentYellow9);
        studentYellowImage.add(9, studentYellow10);
        studentYellowImage.add(10, studentYellow11);
        studentYellowImage.add(11, studentYellow12);

        studentPinkImage.add(0, studentPink1);
        studentPinkImage.add(1, studentPink2);
        studentPinkImage.add(2, studentPink3);
        studentPinkImage.add(3, studentPink4);
        studentPinkImage.add(4, studentPink5);
        studentPinkImage.add(5, studentPink6);
        studentPinkImage.add(6, studentPink7);
        studentPinkImage.add(7, studentPink8);
        studentPinkImage.add(8, studentPink9);
        studentPinkImage.add(9, studentPink10);
        studentPinkImage.add(10, studentPink11);
        studentPinkImage.add(11, studentPink12);

        studentBlueImage.add(0, studentBlue1);
        studentBlueImage.add(1, studentBlue2);
        studentBlueImage.add(2, studentBlue3);
        studentBlueImage.add(3, studentBlue4);
        studentBlueImage.add(4, studentBlue5);
        studentBlueImage.add(5, studentBlue6);
        studentBlueImage.add(6, studentBlue7);
        studentBlueImage.add(7, studentBlue8);
        studentBlueImage.add(8, studentBlue9);
        studentBlueImage.add(9, studentBlue10);
        studentBlueImage.add(10, studentBlue11);
        studentBlueImage.add(11, studentBlue12);

        towerImage.add(0,Tower1);
        towerImage.add(1,Tower2);
        towerImage.add(2,Tower3);
        towerImage.add(3,Tower4);
        towerImage.add(4,Tower5);
        towerImage.add(5,Tower6);
        towerImage.add(6,Tower7);
        towerImage.add(7,Tower8);
        towerImage.add(8,Tower9);
        towerImage.add(9,Tower10);
        towerImage.add(10,Tower11);
        towerImage.add(11,Tower12);

        noEntryTilesImage.add(0,noEntryTiles1);
        noEntryTilesImage.add(1,noEntryTiles2);
        noEntryTilesImage.add(2,noEntryTiles3);
        noEntryTilesImage.add(3,noEntryTiles4);
        noEntryTilesImage.add(4,noEntryTiles5);
        noEntryTilesImage.add(5,noEntryTiles6);
        noEntryTilesImage.add(6,noEntryTiles7);
        noEntryTilesImage.add(7,noEntryTiles8);
        noEntryTilesImage.add(8,noEntryTiles9);
        noEntryTilesImage.add(9,noEntryTiles10);
        noEntryTilesImage.add(10,noEntryTiles11);
        noEntryTilesImage.add(11,noEntryTiles12);

        motherNature.add(0, motherNature1);
        motherNature.add(1, motherNature2);
        motherNature.add(2, motherNature3);
        motherNature.add(3, motherNature4);
        motherNature.add(4, motherNature5);
        motherNature.add(5, motherNature6);
        motherNature.add(6, motherNature7);
        motherNature.add(7, motherNature8);
        motherNature.add(8, motherNature9);
        motherNature.add(9, motherNature10);
        motherNature.add(10, motherNature11);
        motherNature.add(11, motherNature12);

        numberStudentBlue.add(0, numberStudentBlue1);
        numberStudentBlue.add(1, numberStudentBlue2);
        numberStudentBlue.add(2, numberStudentBlue3);
        numberStudentBlue.add(3, numberStudentBlue4);
        numberStudentBlue.add(4, numberStudentBlue5);
        numberStudentBlue.add(5, numberStudentBlue6);
        numberStudentBlue.add(6, numberStudentBlue7);
        numberStudentBlue.add(7, numberStudentBlue8);
        numberStudentBlue.add(8, numberStudentBlue9);
        numberStudentBlue.add(9, numberStudentBlue10);
        numberStudentBlue.add(10, numberStudentBlue11);
        numberStudentBlue.add(11, numberStudentBlue12);

        numberStudentGreen.add(0, numberStudentGreen1);
        numberStudentGreen.add(1, numberStudentGreen2);
        numberStudentGreen.add(2, numberStudentGreen3);
        numberStudentGreen.add(3, numberStudentGreen4);
        numberStudentGreen.add(4, numberStudentGreen5);
        numberStudentGreen.add(5, numberStudentGreen6);
        numberStudentGreen.add(6, numberStudentGreen7);
        numberStudentGreen.add(7, numberStudentGreen8);
        numberStudentGreen.add(8, numberStudentGreen9);
        numberStudentGreen.add(9, numberStudentGreen10);
        numberStudentGreen.add(10, numberStudentGreen11);
        numberStudentGreen.add(11, numberStudentGreen12);

        numberStudentPink.add(0, numberStudentPink1);
        numberStudentPink.add(1, numberStudentPink2);
        numberStudentPink.add(2, numberStudentPink3);
        numberStudentPink.add(3, numberStudentPink4);
        numberStudentPink.add(4, numberStudentPink5);
        numberStudentPink.add(5, numberStudentPink6);
        numberStudentPink.add(6, numberStudentPink7);
        numberStudentPink.add(7, numberStudentPink8);
        numberStudentPink.add(8, numberStudentPink9);
        numberStudentPink.add(9, numberStudentPink10);
        numberStudentPink.add(10, numberStudentPink11);
        numberStudentPink.add(11, numberStudentPink12);

        numberStudentRed.add(0, numberStudentRed1);
        numberStudentRed.add(1, numberStudentRed2);
        numberStudentRed.add(2, numberStudentRed3);
        numberStudentRed.add(3, numberStudentRed4);
        numberStudentRed.add(4, numberStudentRed5);
        numberStudentRed.add(5, numberStudentRed6);
        numberStudentRed.add(6, numberStudentRed7);
        numberStudentRed.add(7, numberStudentRed8);
        numberStudentRed.add(8, numberStudentRed9);
        numberStudentRed.add(9, numberStudentRed10);
        numberStudentRed.add(10, numberStudentRed11);
        numberStudentRed.add(11, numberStudentRed12);

        numberStudentYellow.add(0, numberStudentYellow1);
        numberStudentYellow.add(1, numberStudentYellow2);
        numberStudentYellow.add(2, numberStudentYellow3);
        numberStudentYellow.add(3, numberStudentYellow4);
        numberStudentYellow.add(4, numberStudentYellow5);
        numberStudentYellow.add(5, numberStudentYellow6);
        numberStudentYellow.add(6, numberStudentYellow7);
        numberStudentYellow.add(7, numberStudentYellow8);
        numberStudentYellow.add(8, numberStudentYellow9);
        numberStudentYellow.add(9, numberStudentYellow10);
        numberStudentYellow.add(10, numberStudentYellow11);
        numberStudentYellow.add(11, numberStudentYellow12);

        numberTower.add(0,numberTower1);
        numberTower.add(1,numberTower2);
        numberTower.add(2,numberTower3);
        numberTower.add(3,numberTower4);
        numberTower.add(4,numberTower5);
        numberTower.add(5,numberTower6);
        numberTower.add(6,numberTower7);
        numberTower.add(7,numberTower8);
        numberTower.add(8,numberTower9);
        numberTower.add(9,numberTower10);
        numberTower.add(10,numberTower11);
        numberTower.add(11,numberTower12);

        sizes.add(0, size1);
        sizes.add(1, size2);
        sizes.add(2, size3);
        sizes.add(3, size4);
        sizes.add(4, size5);
        sizes.add(5, size6);
        sizes.add(6, size7);
        sizes.add(7, size8);
        sizes.add(8, size9);
        sizes.add(9, size10);
        sizes.add(10, size11);
        sizes.add(11, size12);



        if (onlyObserv) {
            for (int i = 0; i < 12; i++) {
                islandImage.get(i).setOnMouseClicked(null);
            }
        }
        for (int i = 0; i < 12; i++) {
            islandToShow = returnIsland(islands, i);
            if (islandToShow != null) {
                numberStudentBlue.get(i).setText(Integer.toString(islandToShow.CountInfluence(Color.Blue)) + "x");
                numberStudentRed.get(i).setText(Integer.toString(islandToShow.CountInfluence(Color.Red)) + "x");
                numberStudentYellow.get(i).setText(Integer.toString(islandToShow.CountInfluence(Color.Yellow)) + "x");
                numberStudentPink.get(i).setText(Integer.toString(islandToShow.CountInfluence(Color.Pink)) + "x");
                numberStudentGreen.get(i).setText(Integer.toString(islandToShow.CountInfluence(Color.Green)) + "x");
                if (islandToShow.isMotherNature()) {
                    motherNature.get(i).setImage(new Image("mother_nature.png"));
                }
                if (islandToShow.isNoEntryTiles()) {
                    noEntryTilesImage.get(i).setImage(new Image("deny_island_icon.png"));
                }
                if (islandToShow.isTower()) {
                    if (islandToShow.getColTower().equals(ColorTower.Black)) {
                        towerImage.get(i).setImage(new Image("black_tower.png"));
                    } else if (islandToShow.getColTower().equals(ColorTower.White)) {
                        towerImage.get(i).setImage(new Image("white_tower.png"));
                    } else {
                        towerImage.get(i).setImage(new Image("grey_tower.png"));
                    }
                    numberTower.get(i).setText(Integer.toString(islandToShow.getSize()) + "x");
                }
                sizes.get(i).setText("[" + Integer.toString(islandToShow.getSize()) + "]");
            } else {
                islandImage.get(i).setImage(null);
                islandImage.get(i).setOnMouseClicked(null);
                studentBlueImage.get(i).setImage(null);
                studentGreenImage.get(i).setImage(null);
                studentYellowImage.get(i).setImage(null);
                studentRedImage.get(i).setImage(null);
                studentPinkImage.get(i).setImage(null);
                numberStudentBlue.get(i).setText("");
                numberStudentYellow.get(i).setText("");
                numberStudentGreen.get(i).setText("");
                numberStudentPink.get(i).setText("");
                numberStudentRed.get(i).setText("");
                sizes.get(i).setText("");
            }

        }
    }
}
