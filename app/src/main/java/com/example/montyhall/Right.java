package com.example.montyhall;

public class Right extends Kartya{
    public Right(String fajta){
        super(fajta);


    }

    @Override
    public void Kirajzol() {
        if(!MainActivity.nyitva){
            if(!selected){
                MainActivity.right.setImageResource(R.mipmap.megforditott);
            }
            else if(selected){
                MainActivity.right.setImageResource(R.mipmap.kijelolt);
            }
        }
    }




    //Kecske nyitas
    @Override
    public void kecskeNyitas(){
        MainActivity.right.setImageResource(R.mipmap.kecske);
    }
}
