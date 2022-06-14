package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Model.CloudTiles;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class ChooseCloudScene {
    @FXML
    private ImageView cloud1;
    @FXML
    private ImageView cloud2;
    @FXML
    private ImageView cloud3;
    @FXML
    private ImageView cloud4;
    @FXML
    private Circle student11;
    @FXML
    private Circle student12;
    @FXML
    private Circle student13;
    @FXML
    private Circle student14;
    @FXML
    private Circle student21;
    @FXML
    private Circle student22;
    @FXML
    private Circle student23;
    @FXML
    private Circle student24;
    @FXML
    private Circle student31;
    @FXML
    private Circle student32;
    @FXML
    private Circle student33;
    @FXML
    private Circle student34;
    @FXML
    private Circle student41;
    @FXML
    private Circle student42;
    @FXML
    private Circle student43;
    @FXML
    private Circle student44;
    private ArrayList<CloudTiles> clouds;

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

    public void initialize(){
        ArrayList<ImageView> imageClouds= new ArrayList<>();
        imageClouds.add(0,cloud1);
        imageClouds.add(1,cloud2);
        imageClouds.add(2,cloud3);
        imageClouds.add(3,cloud4);
        Image cloudImage = new Image("cloud_card.png");
        for(int i=0; i<clouds.size(); i++){
            imageClouds.get(i).setImage(cloudImage);
        }

        ArrayList<Circle> studentsOnCloud1 = new ArrayList<>();
        studentsOnCloud1.add(student11);
        studentsOnCloud1.add(student12);
        studentsOnCloud1.add(student13);
        studentsOnCloud1.add(student14);

        for(int i=0; i< clouds.get(0).getStud().size(); i++){
            getTheRightColor(clouds.get(0).getStud().get(i), studentsOnCloud1.get(i));
        }

        ArrayList<Circle> studentsOnCloud2 = new ArrayList<>();
        studentsOnCloud2.add(student21);
        studentsOnCloud2.add(student22);
        studentsOnCloud2.add(student23);
        studentsOnCloud2.add(student24);

        for(int i=0; i< clouds.get(1).getStud().size(); i++){
            getTheRightColor(clouds.get(1).getStud().get(i), studentsOnCloud2.get(i));
        }
        ArrayList<Circle> studentsOnCloud3 = new ArrayList<>();
        studentsOnCloud3.add(student31);
        studentsOnCloud3.add(student32);
        studentsOnCloud3.add(student33);
        studentsOnCloud3.add(student34);

        for(int i=0; i< clouds.get(2).getStud().size(); i++){
            getTheRightColor(clouds.get(2).getStud().get(i), studentsOnCloud3.get(i));
        }
        ArrayList<Circle> studentsOnCloud4 = new ArrayList<>();
        studentsOnCloud3.add(student41);
        studentsOnCloud3.add(student42);
        studentsOnCloud3.add(student43);
        studentsOnCloud3.add(student44);

        for(int i=0; i< clouds.get(3).getStud().size(); i++){
            getTheRightColor(clouds.get(3).getStud().get(i), studentsOnCloud4.get(i));
        }
    }

}
