package com.example.montyhall;

import android.annotation.SuppressLint;

public class Right extends Kartya{
    public Right(){
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void Kirajzol() {
        if(!MainActivity.nyitva){
            if(!selected){
                MainActivity.right.setImageResource(R.mipmap.megforditott);
            }
            else {
                MainActivity.right.setImageResource(R.mipmap.kijelolt);
            }
        }
        else {
            if(!selected){
                //kocsi
                if(isNyertes()){
                    MainActivity.right.setImageResource(R.mipmap.kocsi);
                }
                else{
                    MainActivity.right.setImageResource(R.mipmap.kecske);
                }
            }

            else{
                if(isNyertes()){
                    MainActivity.right.setImageResource(R.mipmap.kocsiselected);
                    MainActivity.nyeresekSzama++;
                    MainActivity.eredmeny.setText("Win");

                }
                else {
                    MainActivity.right.setImageResource(R.mipmap.kecskeselected);
                    MainActivity.eredmeny.setText("Lose");
                }
            }
        }
    }




    //Kecske nyitas
    @Override
    public void kecskeNyitas(){
        MainActivity.right.setImageResource(R.mipmap.kecske);
    }
}
