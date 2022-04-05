package it.polimi.ingsw.Model;

import java.util.*;

public class IslandTiles implements Location {
    private int NumberID;
    private boolean MotherNature;
    private int size;
    private boolean NoEntryTiles;
    ArrayList<Color> StudentsInIsland = new ArrayList<>();

    public IslandTiles(int numberID, boolean motherNature, int size, boolean noEntryTiles) {
        NumberID = numberID;
        MotherNature = motherNature;
        this.size = size;
        NoEntryTiles = noEntryTiles;
    }


    public void putMotherNature() {
        MotherNature = true;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void putNoEntryTiles() {
        NoEntryTiles = true;
    }

    public boolean isMotherNature() {
        return MotherNature;
    }

    public boolean isNoEntryTiles() {
        return NoEntryTiles;
    }

    public int getSize() {
        return size;
    }

    public int getNumberID() {
        return NumberID;
    }

    public void removeNM() throws IllegalMoveException{
        if (MotherNature) {
            MotherNature = false;
        }else {
            throw new IllegalMoveException();
        }

    }
    public void removeNET() throws IllegalMoveException{
        if (NoEntryTiles) {
            NoEntryTiles= false;
        }else {
            throw new IllegalMoveException();
        }
    }

    public void PutStudent(Color c){
        StudentsInIsland.add(c);
    }

}
