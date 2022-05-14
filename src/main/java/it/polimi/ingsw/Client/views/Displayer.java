package it.polimi.ingsw.Client.views;

import java.util.ArrayList;
import java.util.List;

public class Displayer {
    /*       DA IMPLEMENTARE CONVERSIONE COLOR TO COLORCLI
     public void ingresso(ArrayList<Color> e, ArrayList<ArrayList<Color>> diningroom,ArrayList<Color> prof,int ntorri,Color ct){
        ArrayList<Color> p=new ArrayList<>();
        p.add(Color.ANSI_GREEN);
        p.add(Color.ANSI_RED);
        p.add(Color.ANSI_YELLOWCHIARO);
        p.add(Color.ANSI_PURPLE);
        p.add(Color.ANSI_BLUE);
        for(int i=0,k=0,t=0;i<5;i++) {
             if(k<e.size()) {
                 System.out.print("|" + e.get(k)+ "● ");
             }else{
                 System.out.print("|  ");
             }if(k+1<e.size()) {
                System.out.print(e.get(k+1) + "●" + Color.RESET + "|");
                for(int j=0;j<10;j++){
                    if(j<diningroom.get(i).size() && j<=8){
                        System.out.print(diningroom.get(i).get(j) + "● ");
                    }else if(j==9 && diningroom.get(i).size()==10){
                        System.out.print(diningroom.get(i).get(j) + "●" + Color.RESET + "|");
                        if(prof.contains(p.get(i))){
                            System.out.print(p.get(i) + "⬛" + Color.RESET + "|");
                            if(t<ntorri){
                                System.out.print(ct + "● ");
                            }else{
                                System.out.print("  ");
                            }
                            if(t+1<ntorri){
                                System.out.print(ct+ "●" + Color.RESET + "|\n");
                            }else{
                                System.out.print(" " + Color.RESET + "|\n");
                            }
                            t=t+2;
                        }else{
                            System.out.print(p.get(i)+"⬜" + Color.RESET + "|");
                            if(t<ntorri){
                                System.out.print(ct + "● ");
                            }else{
                                System.out.print("  ");
                            }
                            if(t+1<ntorri){
                                System.out.print(ct+ "●" + Color.RESET + "|\n");
                            }else{
                                System.out.print(" " + Color.RESET + "|\n");
                            }
                            t=t+2;
                        }
                    }else if(j<9 && j>=diningroom.get(i).size()){
                        System.out.print("  ");
                    }else{
                        System.out.print( " " + Color.RESET + "|");
                        if(prof.contains(p.get(i))){
                            System.out.print(p.get(i) + "⬛" + Color.RESET + "|");
                            if(t<ntorri){
                                System.out.print(ct + "● ");
                            }else{
                                System.out.print("  ");
                            }
                            if(t+1<ntorri){
                                System.out.print(ct+ "●" + Color.RESET + "|\n");
                            }else{
                                System.out.print(" " + Color.RESET + "|\n");
                            }
                            t=t+2;
                        }else{
                            System.out.print(p.get(i)+"⬜" + Color.RESET + "|");
                            if(t<ntorri){
                                System.out.print(ct + "● ");
                            }else{
                                System.out.print("  ");
                            }
                            if(t+1<ntorri){
                                System.out.print(ct+ "●" + Color.RESET + "|\n");
                            }else{
                                System.out.print(" " + Color.RESET + "|\n");
                            }
                            t=t+2;
                        }
                    }
                }



             }else{
                System.out.print(Color.RESET+" |");
                for(int j=0;j<10;j++){
                    if(j<diningroom.get(i).size() && j<=8){
                        System.out.print(diningroom.get(i).get(j) + "● ");
                    }else if(j==9 && diningroom.get(i).size()==10){
                        System.out.print(diningroom.get(i).get(j) + "●" + Color.RESET + "|");
                        if(prof.contains(p.get(i))){
                            System.out.print(p.get(i) + "⬛" + Color.RESET + "|");
                            if(t<ntorri){
                                System.out.print(ct + "● ");
                            }else{
                                System.out.print("  ");
                            }
                            if(t+1<ntorri){
                                System.out.print(ct+ "●" + Color.RESET + "|\n");
                            }else{
                                System.out.print(" " + Color.RESET + "|\n");
                            }
                            t=t+2;
                        }else{
                            System.out.print(p.get(i)+"⬜" + Color.RESET + "|");
                            if(t<ntorri){
                                System.out.print(ct + "● ");
                            }else{
                                System.out.print("  ");
                            }
                            if(t+1<ntorri){
                                System.out.print(ct+ "●" + Color.RESET + "|\n");
                            }else{
                                System.out.print(" " + Color.RESET + "|\n");
                            }
                            t=t+2;
                        }
                    }else if(j<9 && j>=diningroom.get(i).size()){
                        System.out.print("  ");
                    }else{
                        System.out.print( " " + Color.RESET + "|");
                        if(prof.contains(p.get(i))){
                            System.out.print(p.get(i) + "⬛" + Color.RESET + "|");
                            if(t<ntorri){
                                System.out.print(ct + "● ");
                            }else{
                                System.out.print("  ");
                            }
                            if(t+1<ntorri){
                                System.out.print(ct+ "●" + Color.RESET + "|\n");
                            }else{
                                System.out.print(" " + Color.RESET + "|\n");
                            }
                            t=t+2;
                        }else{
                            System.out.print(p.get(i)+"⬜" + Color.RESET + "|");
                            if(t<ntorri){
                                System.out.print(ct + "● ");
                            }else{
                                System.out.print("  ");
                            }
                            if(t+1<ntorri){
                                System.out.print(ct+ "●" + Color.RESET + "|\n");
                            }else{
                                System.out.print(" " + Color.RESET + "|\n");
                            }
                            t=t+2;
                        }
                    }
                }
             }
             k=k+2;
     }
    }







    public void displaySchoolBoard(){


        System.out.print("|"+Color.ANSI_RED+"●  "+Color.RESET+"|"+Color.ANSI_GREEN+"● ● ● ● ● ● ● ● ● ●"+Color.RESET+"|"+Color.ANSI_GREEN+"⬛"+Color.RESET+"|"+Color.ANSI_BLACK+"   "+Color.RESET+"|\n");
        System.out.print("|"+Color.ANSI_RED+"● ●"+Color.RESET+"|"+Color.ANSI_RED+"● ● ● ● ● ● ● ● ● ●"+Color.RESET+"|"+Color.ANSI_RED+"⬜"+Color.RESET+"|"+Color.ANSI_CYAN+"● ●"+Color.RESET+"|\n");
        System.out.print("|"+Color.ANSI_RED+"● ●"+Color.RESET+"|"+Color.ANSI_YELLOWCHIARO+"● ● ● ● ● ● ● ● ● ●"+Color.RESET+"|"+Color.ANSI_YELLOWCHIARO+"⬛"+Color.RESET+"|"+Color.ANSI_GRAY+"● ●"+Color.RESET+"|\n");
        System.out.print("|"+Color.ANSI_RED+"● ●"+Color.RESET+"|"+Color.ANSI_PURPLE+"● ● ● ● ● ● ● ● ● ●"+Color.RESET+"|"+Color.ANSI_PURPLE+"⬜"+Color.RESET+"|"+Color.ANSI_YELLOW+"● ●"+Color.RESET+"|\n");
        System.out.print("|"+Color.ANSI_RED+"● ●"+Color.RESET+"|"+Color.ANSI_BLUE+"● ● ● ● ● ● ● ● ● ●"+Color.RESET+"|"+Color.ANSI_BLUE+"⬛"+Color.RESET+"|"+Color.ANSI_WHITEPURO+"● ●"+Color.RESET+"|\n");
    }
    public void displayAllSchoolboard(){
        int numPlayers=3;
        prova p=new prova();
        for(int i=0;i<numPlayers;i++) {
            System.out.println("\nSchoolboard del giocatore :"+i);
            p.displaySchoolBoard();
        }
        System.out.println("FINE");
    }
    */

}
