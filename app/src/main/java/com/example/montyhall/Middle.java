package com.example.montyhall;

public class Middle extends Kartya{
    public Middle(String fajta){
        super(fajta);

    }

    @Override
    public void Kirajzol() {
        if(!MainActivity.nyitva){
            if(!selected){
                MainActivity.middle.setImageResource(R.mipmap.megforditott);
            }
            else if(selected){
                MainActivity.middle.setImageResource(R.mipmap.kijelolt);
            }
        }
    }





    //Kecske nyitas
    @Override
    public void kecskeNyitas(){
        MainActivity.middle.setImageResource(R.mipmap.kecske);
    }
}
