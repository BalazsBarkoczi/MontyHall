package com.example.montyhall;

public abstract class Kartya {
    protected boolean selected;
    protected boolean nyertes;
    protected boolean nyitott;

    private String fajta;

    public Kartya(String fajta){
        selected = false;
        nyertes = false;
        nyitott = false;
        this.fajta = fajta;


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


