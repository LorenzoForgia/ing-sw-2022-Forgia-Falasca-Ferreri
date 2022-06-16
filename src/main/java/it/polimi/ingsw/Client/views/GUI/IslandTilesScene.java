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
    private ImageView island10;
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
        islands.add(new IslandTiles(1, false, 1, false, 0, false));
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
