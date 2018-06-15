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
       gameDominos.printAvailableDominos();
        System.out.println("\n");

        opponent.printDominos(gameDominos.getAvailableDominos());



    }



}
