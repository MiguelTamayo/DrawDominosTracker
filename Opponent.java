package com.company;

import java.util.ArrayList;

public class Opponent {
    private ArrayList<Domino> dominoArrayList = new ArrayList<Domino>();

    public Opponent(){
        int idCounter=0;
        for(int top = 0; top < 7; top++){
            for(int bottom = 0; bottom < 7; bottom++){
                if (bottom<=top){
                    dominoArrayList.add(new Domino(top,bottom,idCounter));
                    idCounter++;
                }
            }
        }
    }

    public ArrayList<Domino> getDominos(){
        return dominoArrayList;
    }

    public void printDominos(ArrayList<Domino> dominoArrayList){
        int counter =0;
        //cycle through all 7 rows
        for (int i =0;i<7;i++){
            //cycle through each column incrementing by 1 for each row
            for (int x = 0; x<i+1;x++){
                if(getDominos().get(counter)!=null){
                    System.out.print(getDominos().get(counter).toString());
                }else{
                    System.out.print("     ");
                }
                counter++;
            }
            System.out.println();
        }
    }

    public void removeDominos(int i){
        for(Domino d: dominoArrayList){
            if(d!=null&&((d.getBottom()==i)||(d.getTop()==i))){
                dominoArrayList.set(dominoArrayList.indexOf(d),null);
            }
        }
    }
    public void removeDominosById(int i){
        for(Domino d: dominoArrayList){
            if(d!=null && d.getID()==i){
                dominoArrayList.set(dominoArrayList.indexOf(d),null);
            }
        }
    }

}
