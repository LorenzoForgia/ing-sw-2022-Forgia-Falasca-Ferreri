package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.messages.Login;

import java.util.Scanner;

public class TitleView extends View {


    /**
     * View that welcome the user and prints the Eriantys Logo.
     */


  @Override
  public void run()
  {
    Scanner scanner = new Scanner(System.in);


    System.out.println("Welcome to:");
    Displayer d=new Displayer();
    d.displayLogo();
    System.out.println("Inserisci il tuo nickname:");
    String nickname = (scanner.nextLine());
    Login login=new Login(nickname);
    getOwner().getServerHandler().sendCommandMessage(login);
  }

}
