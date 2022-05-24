package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DisplayerTest {
    @Test
    public void testDisplayer(){
        Displayer p=new Displayer();
        ArrayList<Color> entrance=new ArrayList<>();

        entrance.add(Color.Pink);
        entrance.add(Color.Green);
        entrance.add(Color.Red);
        entrance.add(Color.Pink);
        entrance.add(Color.Green);

        entrance.add(Color.Red);
        entrance.add(Color.Red);

        ArrayList<ArrayList<Color>> DiningRoom=new ArrayList<ArrayList<Color>>(5);
        for(int i=0;i<5;i++){
            DiningRoom.add(new ArrayList<>());
        }
        for(int i=0;i<10;i++) {
            DiningRoom.get(0).add(Color.Green);
        }
        for(int i=0;i<0;i++) {
            DiningRoom.get(1).add(Color.Red);
        }
        for(int i=0;i<2;i++) {
            DiningRoom.get(2).add(Color.Yellow);
        }
        for(int i=0;i<0;i++) {
            DiningRoom.get(3).add(Color.Pink);
        }
        for(int i=0;i<4;i++) {
            DiningRoom.get(4).add(Color.Blue);
        }

        ArrayList<Color> prof=new ArrayList<>();
        ArrayList<SchoolBoard> sc=new ArrayList<>();
        p.displayLogo();
        p.displaySchoolBoard(entrance,DiningRoom,prof,9, ColorTower.Black);
        SchoolBoard s1=new SchoolBoard(0,2);
        s1.getEntrance().add(Color.Red);
        s1.getEntrance().add(Color.Blue);
        s1.getDiningRoom().PutStudent(Color.Blue);
        s1.getDiningRoom().PutStudent(Color.Red);
        s1.getProfessorTable().add(Color.Green);
        s1.getProfessorTable().add(Color.Yellow);
        s1.setColorTower(ColorTower.White);
        s1.setNumberOfTower(4);
        sc.add(s1);
        SchoolBoard s2=new SchoolBoard(0,2);
        s2.getEntrance().add(Color.Red);
        s2.getEntrance().add(Color.Blue);
        s2.getDiningRoom().PutStudent(Color.Blue);
        s2.getDiningRoom().PutStudent(Color.Red);
        s2.getProfessorTable().add(Color.Green);
        s2.getProfessorTable().add(Color.Pink);
        s2.setColorTower(ColorTower.White);
        s2.setNumberOfTower(8);
        sc.add(s2);

        /*p.displayAllSchoolboard(sc)*/
        IslandTiles i1=new IslandTiles(0,true,3,false,3,true);
        IslandTiles i2=new IslandTiles(1,true,3,false,3,true);
        IslandTiles i3=new IslandTiles(2,true,3,false,3,true);
        i1.putTower(ColorTower.Black);
        i2.putTower(ColorTower.White);
        i3.putTower(ColorTower.Grey);
        ArrayList<IslandTiles> is=new ArrayList<>();
        is.add(i1);
        is.add(i2);
        is.add(i3);
        is.add(i1);
        is.add(i2);

        p.showAllIsland(is);

        ArrayList<CardAssistant> ca=new ArrayList<>();
        ca.add(CardAssistant.Uno);
        ca.add(CardAssistant.Tre);
        ca.add(CardAssistant.Due);
        ca.add(CardAssistant.Sei);
        ca.add(CardAssistant.Dieci);
        p.showAllAssistantCard(ca);
        p.displayWallet(10);
        ArrayList<CloudTiles> cloudTiles=new ArrayList<CloudTiles>();
        CloudTiles c1=new CloudTiles(0);
        CloudTiles c2=new CloudTiles(1);
        CloudTiles c3=new CloudTiles(2);
        CloudTiles c4=new CloudTiles(3);
        cloudTiles.add(c1);
        cloudTiles.add(c2);
        cloudTiles.add(c3);
        cloudTiles.add(c4);
        p.showAllCloudTiles(cloudTiles);
        ArrayList<CharacterCard> characterCards= new ArrayList<CharacterCard>();
        GeneralBoard gb=new GeneralBoard(20);

        Bag b=new Bag();
        b.setStudents(120);
        CharacterCard c7=new CharacterCard7(7,1,0 ,"Puoi prendere fino a 3 studenti da questa carta e scambiarli con altrettanti studenti presenti nel tuo ingresso ");
        c7.SetCard(b,gb);
        CharacterCard c11=new CharacterCard11(11,2,0 ,"Prendi uno studente dalla carta e piazzalo nella tua sala.Poi pesca uno studente dal sacchetto e mettilo su questa carta");
        c11.SetCard(b,gb);
        characterCards.add(c7);
        characterCards.add(new CharacterCard8(8,2,0 ,"in questo turno, durante il calcolo dell'influenza hai 2 punti di influenza addizionali"));
        characterCards.add(new CharacterCard9(9,3,0 ,"Scegli un colore di studente, in questo turno,durante il calcolo dell'influenza quel colore non fornisce influenza"));
        characterCards.add(new CharacterCard10(10,1,0 ,"puoi scambiare tra loro fino a 2 studenti prensenti nella tua sala e nel tuo ingresso"));
        characterCards.add(c11);
        p.displayAllcharactercard(characterCards);
    }

}