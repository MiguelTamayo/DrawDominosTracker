package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String userChoice=null;

        int numOfPlayers=1;
        System.out.print("Enter the number of players: ");
        numOfPlayers = Integer.parseInt(sc.nextLine());
        System.out.print("Enter your tiles id: ");
        String[] ut=sc.nextLine().split(" ");
        System.out.println();
       GameDominos gameDominos = new GameDominos();
       Opponent opponent = new Opponent();
       for(String s: ut ){
           gameDominos.removeFromPlay(Integer.parseInt(s));
           opponent.removeDominosById(Integer.parseInt(s));
       }

       while (userChoice!="X"){
           System.out.println("enter corresponding option");
           System.out.println("1). Print all available dominos");
           System.out.println("2). Print Opponent's dominos");
           System.out.println("3). input domino played");
           System.out.println("4). note player skipped on number:");
           System.out.println("X). exit");

           switch (sc.nextLine()){
               case "1":
                   gameDominos.printAvailableDominos();
                   System.out.println();
                   break;
               case "2":
                   opponent.printDominos();
                   System.out.println();
                   break;
               case "3":
                   System.out.println("enter id of tile");
                   int del = Integer.parseInt(sc.nextLine());
                   gameDominos.removeFromPlay(del);
                   opponent.removeDominosById(del);
                   break;
               case "4":
                   System.out.println("enter number");
                   opponent.removeDominos(Integer.parseInt(sc.nextLine()));
                   break;
               case "X":
                   userChoice="X";
                   break;
           }
       }



    }



}
