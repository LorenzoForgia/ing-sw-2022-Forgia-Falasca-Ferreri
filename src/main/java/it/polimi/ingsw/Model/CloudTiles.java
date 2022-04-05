package it.polimi.ingsw.Model;
import java.util.*;
public class CloudTiles implements Location{
    private int Numid;
    private List<Color> stud=new ArrayList<>();

    public CloudTiles(int numid) {
        this.Numid = numid;
    }

    public int getNumid() {
        return this.Numid;
    }

    public List<Color> CatchStudent() {
        return this.stud;
    }

    @Override /*insert student into CloudTiles*/
    public void PutStudent(Color c) {
        this.stud.add(c);
    }
}
