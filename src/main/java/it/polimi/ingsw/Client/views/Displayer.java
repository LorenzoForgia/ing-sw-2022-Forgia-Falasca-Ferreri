package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Model.SchoolBoard;

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

     public void displaySchoolBoard(ArrayList<Color> e, ArrayList<ArrayList<Color>> diningroom, ArrayList<Color> prof, int ntorri, Color ct){
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







/*
    public void displayAllSchoolboard(ArrayList<SchoolBoard> s){
        for(int i=0;i<s.size();i++){
            this.displaySchoolBoard(s.get(i).getEntrance(),s.get(i).getDiningRoom(),s.get(i).getProfessorTable(),s.get(i).getNumberOfTower(),s.get(i).ColorTower());
        }

    }*/


}
