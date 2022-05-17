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


   public void displayAllSchoolboard(ArrayList<SchoolBoard> s){
        for(int i=0;i<s.size();i++){
            System.out.println("Schoolboard del giocatore:"+i);
            this.displaySchoolBoard(s.get(i).getEntrance(),s.get(i).getDiningRoom().getDiningRoom(),s.get(i).getProfessorTable(),s.get(i).getNumberOfTower(),s.get(i).ColorTower());
        }

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
        System.out.print(ColorTower.White+""+i.isTower()+" ");
        System.out.print(ColorTower.Grey+""+i.isTower()+" ");
        System.out.print(ColorTower.Black+""+i.isTower()+Color.Reset+"|  ");

    }
    public void showAllIsland(ArrayList<IslandTiles> isl){
        for(int i=0;i<4;i++){
            System.out.print("Isola n°"+i+"            ");
        }
        System.out.println("");
        for(int i=0;i<4;i++){
            this.showIsland(isl.get(i));
            System.out.print(" ");
        }
        System.out.print("\n");
        for(int i=4;i<8;i++){
            System.out.print("Isola n°"+i+"            ");
        }
        System.out.println("");
        for(int i=4;i<8;i++){
            this.showIsland(isl.get(i));
            System.out.print(" ");
        }
        System.out.print("\n");
        for(int i=8;i<12;i++){
            System.out.print("Isola n°"+i+"            ");
        }
        System.out.println("");
        for(int i=8;i<12;i++){
            this.showIsland(isl.get(i));
            System.out.print(" ");
        }
        System.out.print("\n");
    }
    public void displayAssistantCard(CardAssistant c){
        System.out.println("CARTA ASSISTENTE:"+c.getCardValue());
        System.out.println("|"+Color.Blue+"Valore:"+c.getCardValue()+" "+Color.Red+"Mov.MN:"+c.getMovementMN()+Color.Reset+"|");

    }

    public void displayWallet(int coin){
        System.out.print("|");
        System.out.println(Color.Yellow+"Monete spendibili:"+coin+Color.Reset+"|");


    }
}
