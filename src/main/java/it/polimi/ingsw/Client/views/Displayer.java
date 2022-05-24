package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.*;

import java.util.ArrayList;
import java.util.List;

public class Displayer {
    public void displayLogo(){
        System.out.println("\n" +
                "███████╗██████╗░██╗░█████╗░███╗░░██╗████████╗██╗░░░██╗░██████╗\n" +
                "██╔════╝██╔══██╗██║██╔══██╗████╗░██║╚══██╔══╝╚██╗░██╔╝██╔════╝\n" +
                "█████╗░░██████╔╝██║███████║██╔██╗██║░░░██║░░░░╚████╔╝░╚█████╗░\n" +
                "██╔══╝░░██╔══██╗██║██╔══██║██║╚████║░░░██║░░░░░╚██╔╝░░░╚═══██╗\n" +
                "███████╗██║░░██║██║██║░░██║██║░╚███║░░░██║░░░░░░██║░░░██████╔╝\n" +
                "╚══════╝╚═╝░░╚═╝╚═╝╚═╝░░╚═╝╚═╝░░╚══╝░░░╚═╝░░░░░░╚═╝░░░╚═════╝░"
        );
    }

     public void displaySchoolBoard(ArrayList<Color> e, ArrayList<ArrayList<Color>> diningroom, ArrayList<Color> prof, int ntorri, ColorTower ct){
        ArrayList<Color> p=new ArrayList<>();
        p.add(Color.Green);
        p.add(Color.Red);
        p.add(Color.Yellow);
        p.add(Color.Pink);
        p.add(Color.Blue);
        for(int i=0,k=0,t=0;i<5;i++) {
             if(k<e.size()) {
                 System.out.print("|" + e.get(k)+ "● ");
             }else{
                 System.out.print("|  ");
             }if(k+1<e.size()) {
                System.out.print(e.get(k+1) + "●" + Color.Reset + "|");
                for(int j=0;j<10;j++){
                    if(j<diningroom.get(i).size() && j<=8){
                        System.out.print(diningroom.get(i).get(j) + "● ");
                    }else if(j==9 && diningroom.get(i).size()==10){
                        System.out.print(diningroom.get(i).get(j) + "●" + Color.Reset + "|");
                        if(prof.contains(p.get(i))){
                            System.out.print(p.get(i) + "⬛" + Color.Reset + "|");
                            if(t<ntorri){
                                System.out.print(ct + "● ");
                            }else{
                                System.out.print("  ");
                            }
                            if(t+1<ntorri){
                                System.out.print(ct+ "●" + Color.Reset + "|\n");
                            }else{
                                System.out.print(" " + Color.Reset + "|\n");
                            }
                            t=t+2;
                        }else{
                            System.out.print(p.get(i)+"⬜" + Color.Reset + "|");
                            if(t<ntorri){
                                System.out.print(ct + "● ");
                            }else{
                                System.out.print("  ");
                            }
                            if(t+1<ntorri){
                                System.out.print(ct+ "●" + Color.Reset + "|\n");
                            }else{
                                System.out.print(" " + Color.Reset + "|\n");
                            }
                            t=t+2;
                        }
                    }else if(j<9 && j>=diningroom.get(i).size()){
                        System.out.print("  ");
                    }else{
                        System.out.print( " " + Color.Reset + "|");
                        if(prof.contains(p.get(i))){
                            System.out.print(p.get(i) + "⬛" + Color.Reset + "|");
                            if(t<ntorri){
                                System.out.print(ct + "● ");
                            }else{
                                System.out.print("  ");
                            }
                            if(t+1<ntorri){
                                System.out.print(ct+ "●" + Color.Reset + "|\n");
                            }else{
                                System.out.print(" " + Color.Reset + "|\n");
                            }
                            t=t+2;
                        }else{
                            System.out.print(p.get(i)+"⬜" + Color.Reset + "|");
                            if(t<ntorri){
                                System.out.print(ct + "● ");
                            }else{
                                System.out.print("  ");
                            }
                            if(t+1<ntorri){
                                System.out.print(ct+ "●" + Color.Reset + "|\n");
                            }else{
                                System.out.print(" " + Color.Reset + "|\n");
                            }
                            t=t+2;
                        }
                    }
                }



             }else{
                System.out.print(Color.Reset+" |");
                for(int j=0;j<10;j++){
                    if(j<diningroom.get(i).size() && j<=8){
                        System.out.print(diningroom.get(i).get(j) + "● ");
                    }else if(j==9 && diningroom.get(i).size()==10){
                        System.out.print(diningroom.get(i).get(j) + "●" + Color.Reset + "|");
                        if(prof.contains(p.get(i))){
                            System.out.print(p.get(i) + "⬛" + Color.Reset + "|");
                            if(t<ntorri){
                                System.out.print(ct + "● ");
                            }else{
                                System.out.print("  ");
                            }
                            if(t+1<ntorri){
                                System.out.print(ct+ "●" + Color.Reset + "|\n");
                            }else{
                                System.out.print(" " + Color.Reset + "|\n");
                            }
                            t=t+2;
                        }else{
                            System.out.print(p.get(i)+"⬜" + Color.Reset + "|");
                            if(t<ntorri){
                                System.out.print(ct + "● ");
                            }else{
                                System.out.print("  ");
                            }
                            if(t+1<ntorri){
                                System.out.print(ct+ "●" + Color.Reset + "|\n");
                            }else{
                                System.out.print(" " + Color.Reset + "|\n");
                            }
                            t=t+2;
                        }
                    }else if(j<9 && j>=diningroom.get(i).size()){
                        System.out.print("  ");
                    }else{
                        System.out.print( " " + Color.Reset + "|");
                        if(prof.contains(p.get(i))){
                            System.out.print(p.get(i) + "⬛" + Color.Reset + "|");
                            if(t<ntorri){
                                System.out.print(ct + "● ");
                            }else{
                                System.out.print("  ");
                            }
                            if(t+1<ntorri){
                                System.out.print(ct+ "●" + Color.Reset + "|\n");
                            }else{
                                System.out.print(" " + Color.Reset + "|\n");
                            }
                            t=t+2;
                        }else{
                            System.out.print(p.get(i)+"⬜" + Color.Reset + "|");
                            if(t<ntorri){
                                System.out.print(ct + "● ");
                            }else{
                                System.out.print("  ");
                            }
                            if(t+1<ntorri){
                                System.out.print(ct+ "●" + Color.Reset + "|\n");
                            }else{
                                System.out.print(" " + Color.Reset + "|\n");
                            }
                            t=t+2;
                        }
                    }
                }
             }
             k=k+2;
     }
    }


   public void displayAllSchoolboard(ArrayList<SchoolBoard> s,ArrayList<Player> pl){
        for(int i=0;i<s.size();i++){
            System.out.println("Schoolboard del giocatore:"+pl.get(i).getNickName());
            this.displaySchoolBoard(s.get(i).getEntrance(),s.get(i).getDiningRoom().getDiningRoom(),s.get(i).getProfessorTable(),s.get(i).getNumberOfTower(),s.get(i).ColorTower());
        }
       System.out.println();
    }

    public void showCloudTiles(CloudTiles c){
        System.out.println("Nuvola n°"+c.getNumid());
        System.out.print("|");
        int counter=0;
        for(int i=0;i<c.getStud().size();i++){
            if(c.getStud().get(i).equals(Color.Green)){
                counter++;
            }
        }
        System.out.print(Color.Green+""+counter+" ");
        counter=0;
        for(int i=0;i<c.getStud().size();i++){
            if(c.getStud().get(i).equals(Color.Red)){
                counter++;
            }
        }
        System.out.print(Color.Red+""+counter+" ");
        counter=0;
        for(int i=0;i<c.getStud().size();i++){
            if(c.getStud().get(i).equals(Color.Yellow)){
                counter++;
            }
        }
        System.out.print(Color.Yellow+""+counter+" ");
        counter=0;
        for(int i=0;i<c.getStud().size();i++){
            if(c.getStud().get(i).equals(Color.Pink)){
                counter++;
            }
        }
        System.out.print(Color.Pink+""+counter+" ");
        counter=0;
        for(int i=0;i<c.getStud().size();i++){
            if(c.getStud().get(i).equals(Color.Blue)){
                counter++;
            }
        }
        System.out.println(Color.Blue+""+counter+Color.Reset+"|");

    }

    public void showAllCloudTiles(ArrayList<CloudTiles> ct){
        for(int i=0;i<ct.size();i++){
            this.showCloudTiles(ct.get(i));
        }
        System.out.println();
    }

    public void showIsland(IslandTiles i){

        System.out.print("|");
        if(i.isMotherNature()){
            System.out.print(Color.Yellow+"M"+" ");
        }
        System.out.print(Color.Green+""+i.getNumberStudentsbyColor(Color.Green)+" ");
        System.out.print(Color.Red+""+i.getNumberStudentsbyColor(Color.Red)+" ");
        System.out.print(Color.Yellow+""+i.getNumberStudentsbyColor(Color.Yellow)+" ");
        System.out.print(Color.Pink+""+i.getNumberStudentsbyColor(Color.Pink)+" ");
        System.out.print(Color.Blue+""+i.getNumberStudentsbyColor(Color.Blue)+Color.Reset+"|");
        if(ColorTower.White.equals(i.getColTower())) {
            System.out.print(ColorTower.White + "" + i.getSize() + " ");
        }else{
            System.out.print(ColorTower.White + "" + "0" + " ");
        }

        if(ColorTower.Grey.equals(i.getColTower())) {
            System.out.print(ColorTower.Grey + "" + i.getSize() + " ");
        }else{
            System.out.print(ColorTower.Grey + "" + "0" + " ");
        }
        if(ColorTower.Black.equals(i.getColTower())) {
            System.out.print(ColorTower.Black + "" + i.getSize() + Color.Reset+"|  ");
        }else{
            System.out.print(ColorTower.Black + "" + "0" + Color.Reset+"|  ");
        }
        System.out.println("Isola n°"+i.getNumberID());
    }

    public void showAllIsland(ArrayList<IslandTiles> isl){

        for(int i=0;i<isl.size();i++){
            this.showIsland(isl.get(i));
        }
        System.out.println();

    }
    public void displayAssistantCard(CardAssistant c){
        System.out.print("|"+Color.Blue+"Valore:"+c.getCardValue()+" "+Color.Red+"Mov.MN:"+c.getMovementMN()+Color.Reset+"|  ");
        System.out.println("CARTA ASSISTENTE:"+c.getName());
    }
    public void showAllAssistantCard(ArrayList<CardAssistant> ac){
        for(int i=0;i<ac.size();i++){
            this.displayAssistantCard(ac.get(i));
        }
        System.out.println();
    }

    public void displayWallet(int coin){
        System.out.print("|");
        System.out.println(Color.Yellow+"Monete spendibili:"+coin+Color.Reset+"|");
        System.out.println();
    }
    public void displayCharactercard(CharacterCard c){
        System.out.println("|"+Color.Blue+"CARTA PERSONAGGIO:"+c.getName()+Color.Yellow+"  Costo:"+c.getCost()+Color.Green+"  Effetto:"+c.getDescriptionEffect()+Color.Reset+"|  ");
        if(c.getName()==1){
            for(int i=0;i<((CharacterCard1)c).GetchoosenStudent().size();i++){
                System.out.print(((CharacterCard1)c).GetchoosenStudent().get(i).getEscape() + "● ");
            }
            System.out.println();
        }
        if(c.getName()==7){
            for(int i=0;i<((CharacterCard7)c).getStudentOnCard().size();i++){
                System.out.print(((CharacterCard7)c).getStudentOnCard().get(i).getEscape() + "● ");
            }
            System.out.println();
        }
        if(c.getName()==11){
            for(int i=0;i<((CharacterCard11)c).GetchoosenStudent().size();i++){
                System.out.print(((CharacterCard11)c).GetchoosenStudent().get(i).getEscape() + "● ");
            }
            System.out.println();
        }
    }
    public void displayAllcharactercard(ArrayList<CharacterCard> characterCards){
        for(int i=0;i<characterCards.size();i++){
            displayCharactercard(characterCards.get(i));
        }
    }
}
