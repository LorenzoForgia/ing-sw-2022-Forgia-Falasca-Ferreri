package it.polimi.ingsw.Client.views;

import java.util.ArrayList;
import java.util.List;

public class Displayer {
    /*  DA MODIFICARE
    public void ingresso(ArrayList<ArrayList<ColorCLI>> DiningRoom, int nr){
        List<ColorCLI> c=new ArrayList<>();
        c.add(ColorCLI.ANSI_GREEN);
        c.add(ColorCLI.ANSI_RED);
        c.add(Color.ANSI_YELLOWCHIARO);
        c.add(Color.ANSI_PURPLE);
        c.add(Color.ANSI_BLUE);
        List<Color> p=new ArrayList<>();
        p.add(Color.ANSI_GREEN);
        p.add(Color.ANSI_YELLOWCHIARO);
        p.add(Color.ANSI_PURPLE);
        for(int i=0,k=0;i<5;i++) {
            if(k<DiningRoom.get(i).size()) {
                System.out.print("|" + DiningRoom.get(i).get(k)+ "● ");
            }else{
                System.out.print("|  ");
            }if(k+1<DiningRoom.get(i).size()) {
                System.out.print(DiningRoom.get(i).get(k+1) + "●" + Color.RESET + "|");
                for(int j=0;j<10;j++){
                    if(j<nr){
                        System.out.print(c.get(i) + "● ");
                    }else if(j==9 && nr==10){
                        System.out.print(c.get(i) + "●" + Color.RESET + "|");
                    }else if(j<9){
                        System.out.print("  ");
                    }else{
                        System.out.print(c.get(i) + " " + Color.RESET + "|");
                    }
                }

                if(p.contains(c.get(i))){
                    System.out.print(c.get(i) + "●" + Color.RESET + "|\n");
                }else{
                    System.out.print(" " + Color.RESET + "|\n");
                }

            }else{
                System.out.print(Color.RESET+" |");
            }
            k=k+2;
        }
    }
    public void dining(ArrayList<Color> colors){
        for(int i=0,k=0;i<5;i++) {
            if(k<colors.size()) {
                System.out.print("|" + colors.get(k) + "● ");
            }else{
                System.out.print("|  ");
            }if(k+1<colors.size()) {
                System.out.print(colors.get(k+1) + "●" + Color.RESET + "|\n");
            }else{
                System.out.print(Color.RESET+" |\n");
            }
            k=k+2;
        }
    }
    public void structureSchoolBoard(){


        System.out.print("|"+Color.ANSI_RED+"●  "+Color.RESET+"|"+Color.ANSI_GREEN+"● ● ● ● ●"+Color.ANSI_BLACK+"      "+Color.RESET+"|"+Color.ANSI_GREEN+"⬛"+Color.RESET+"|"+Color.ANSI_BLACK+"   "+Color.RESET+"|\n");
        System.out.print("|"+Color.ANSI_RED+"● ●"+Color.RESET+"|"+Color.ANSI_RED+"● ● ● ● ● ● ● ●"+Color.RESET+"|"+Color.ANSI_RED+"⬜"+Color.RESET+"|"+Color.ANSI_CYAN+"● ●"+Color.RESET+"|\n");
        System.out.println("|"+Color.ANSI_RED+"● ●"+Color.RESET+"|"+Color.ANSI_YELLOWCHIARO+"● ● ● ● ● ● ● ●"+Color.RESET+"|"+Color.ANSI_YELLOWCHIARO+"⬛"+Color.RESET+"|"+Color.ANSI_GRAY+"● ●"+Color.RESET+"|\n");
        System.out.println("|"+Color.ANSI_RED+"● ●"+Color.RESET+"|"+Color.ANSI_PURPLE+"● ● ● ● ● ● ● ●"+Color.RESET+"|"+Color.ANSI_PURPLE+"⬜"+Color.RESET+"|"+Color.ANSI_YELLOW+"● ●"+Color.RESET+"|\n");
        System.out.println("|"+Color.ANSI_RED+"● ●"+Color.RESET+"|"+Color.ANSI_BLUE+"● ● ● ● ● ● ● ●"+Color.RESET+"|"+Color.ANSI_BLUE+"⬛"+Color.RESET+"|"+Color.ANSI_WHITEPURO+"● ●"+Color.RESET+"|");
    }

    public void displaySchoolBoard(){


        System.out.print("|"+Color.ANSI_RED+"●  "+Color.RESET+"|"+Color.ANSI_GREEN+"● ● ● ● ●"+Color.ANSI_BLACK+"      "+Color.RESET+"|"+Color.ANSI_GREEN+"⬛"+Color.RESET+"|"+Color.ANSI_BLACK+"   "+Color.RESET+"|\n");
        System.out.print("|"+Color.ANSI_RED+"● ●"+Color.RESET+"|"+Color.ANSI_RED+"● ● ● ● ● ● ● ●"+Color.RESET+"|"+Color.ANSI_RED+"⬜"+Color.RESET+"|"+Color.ANSI_CYAN+"● ●"+Color.RESET+"|\n");
        System.out.print("|"+Color.ANSI_RED+"● ●"+Color.RESET+"|"+Color.ANSI_YELLOWCHIARO+"● ● ● ● ● ● ● ●"+Color.RESET+"|"+Color.ANSI_YELLOWCHIARO+"⬛"+Color.RESET+"|"+Color.ANSI_GRAY+"● ●"+Color.RESET+"|\n");
        System.out.print("|"+Color.ANSI_RED+"● ●"+Color.RESET+"|"+Color.ANSI_PURPLE+"● ● ● ● ● ● ● ●"+Color.RESET+"|"+Color.ANSI_PURPLE+"⬜"+Color.RESET+"|"+Color.ANSI_YELLOW+"● ●"+Color.RESET+"|\n");
        System.out.print("|"+Color.ANSI_RED+"● ●"+Color.RESET+"|"+Color.ANSI_BLUE+"● ● ● ● ● ● ● ●"+Color.RESET+"|"+Color.ANSI_BLUE+"⬛"+Color.RESET+"|"+Color.ANSI_WHITEPURO+"● ●"+Color.RESET+"|\n");
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
