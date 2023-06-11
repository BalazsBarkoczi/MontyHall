package com.example.montyhall;

public class Left extends Kartya{

    public Left(String fajta){
        super(fajta);

    }

    @Override
    public void Kirajzol() {
        if(!MainActivity.nyitva){
            if(!selected){
                MainActivity.left.setImageResource(R.mipmap.megforditott);
            }
            else if(selected) {
                MainActivity.left.setImageResource(R.mipmap.kijelolt);
            }
        }
    }




    //Kecske nyitas
    @Override
    public void kecskeNyitas(){
        MainActivity.left.setImageResource(R.mipmap.kecske);
    }
}
