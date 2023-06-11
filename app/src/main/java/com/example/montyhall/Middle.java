package com.example.montyhall;

import android.annotation.SuppressLint;

public class Middle extends Kartya{
    public Middle(){
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void Kirajzol() {
        if(!MainActivity.nyitva){
            if(!selected){
                MainActivity.getMiddle().setImageResource(R.mipmap.megforditott);
            }
            else {
                MainActivity.getMiddle().setImageResource(R.mipmap.kijelolt);
            }
        }
        else {
            if(!selected){
                //kocsi
                if(isNyertes()){
                    MainActivity.getMiddle().setImageResource(R.mipmap.kocsi);
                }
                else{
                    MainActivity.getMiddle().setImageResource(R.mipmap.kecske);
                }
            }

            else{
                if(isNyertes()){
                    MainActivity.getMiddle().setImageResource(R.mipmap.kocsiselected);
                    MainActivity.nyeresekSzama++;
                    MainActivity.getEredmeny().setText("Win");
                }
                else {
                    MainActivity.getMiddle().setImageResource(R.mipmap.kecskeselected);
                    MainActivity.getEredmeny().setText("Lose");
                }
            }
        }
    }





    //Kecske nyitas
    @Override
    public void kecskeNyitas(){
        MainActivity.getMiddle().setImageResource(R.mipmap.kecske);
    }
}
