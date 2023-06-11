package com.example.montyhall;

public abstract class Kartya {
    protected boolean selected;
    protected boolean nyertes;
    protected boolean nyitott;



    public Kartya(){
        selected = false;
        nyertes = false;
        nyitott = false;

    }




    public void select(){
        selected = true;
    }
    public void nyertes(){nyertes = true;}
    public void nyitott(){nyitott = true;}

    public void deSelect(){selected = false;}
    public void deNyertes(){nyertes = false;}
    public void deNyitott(){nyitott = false;}



    public boolean isSelected() {
        return selected;
    }

    public boolean isNyertes() {
        return nyertes;
    }

    public boolean isNyitott() {
        return nyitott;
    }

    public abstract void Kirajzol();
    public abstract void kecskeNyitas();



}


