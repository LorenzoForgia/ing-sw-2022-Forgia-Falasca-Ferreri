package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.messages.LoginMsg;

import java.util.Scanner;

public class TitleView extends View {


    /**
     * View that welcome the user and prints the Eriantys Logo.
     */


  @Override
  public void run()
  {
    Scanner scanner = new Scanner(System.in);


    System.out.println("Benvenuto in:");
    Displayer d=new Displayer();
    d.displayLogo();
    System.out.println("Inserisci il tuo nickname:");
    String nickname = (scanner.nextLine());
    LoginMsg login=new LoginMsg(nickname);
    getOwner().getServerHandler().sendCommandMessage(login);
  }

}
