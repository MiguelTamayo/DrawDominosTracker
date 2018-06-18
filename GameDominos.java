import java.util.ArrayList;

public class GameDominos {
    private ArrayList<Domino> availableDominos = new ArrayList<Domino>();

    public GameDominos(){
        int idcounter =0;
        for(int top = 0; top < 7; top++){
            for(int bottom = 0; bottom < 7; bottom++){
                if (bottom<=top){
                    availableDominos.add(new Domino(top,bottom,idcounter));
                    idcounter++;
                }
            }
        }


        //test deletes


    }

    public ArrayList<Domino> getAvailableDominos() {
        return availableDominos;
    }

    public void printAvailableDominos(){
        int counter =0;
        //cycle through all 7 rows
        for (int i =0;i<7;i++){
            //cycle through each column incrementing by 1 for each row
            for (int x = 0; x<i+1;x++){
                if(availableDominos.get(counter)!=null){
                    System.out.print(availableDominos.get(counter).toString());
                }else{
                    System.out.print("     ");
                }
                counter++;
            }
            System.out.println();
        }
    }

    public void removeFromPlay(int i) {
        availableDominos.set(i,null);
    }
}