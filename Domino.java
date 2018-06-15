package com.company;
public class Domino{

    private int top;
    private int bottom;
    private int id;

    public Domino(int top, int bottom, int id){
        this.top=top;
        this.bottom=bottom;
        this.id=id;
    }

    public int getTop() {
        return top;
    }

    public int getBottom() {
        return bottom;
    }

    @Override
    public String toString(){
        return "["+bottom+"|"+top+"]";
    }

    public int getID() {
        return id;
    }
}
