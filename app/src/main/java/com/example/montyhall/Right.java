package com.example.montyhall;

import android.annotation.SuppressLint;

public class Right extends Kartya{
    public Right(){
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void Kirajzol() {
        if(!MainActivity.getNyitva()){
            if(!selected){
                MainActivity.getRight().setImageResource(R.mipmap.megforditott);
            }
            else {
                MainActivity.getRight().setImageResource(R.mipmap.kijelolt);
            }
        }
        else {
            if(!selected){
                //kocsi
                if(isNyertes()){
                    MainActivity.getRight().setImageResource(R.mipmap.kocsi);
                }
                else{
                    MainActivity.getRight().setImageResource(R.mipmap.kecske);
                }
            }

            else{
                if(isNyertes()){
                    MainActivity.getRight().setImageResource(R.mipmap.kocsiselected);
                    MainActivity.nyeresekSzamaNovel();
                    MainActivity.getEredmeny().setText("Win");

                }
                else {
                    MainActivity.getRight().setImageResource(R.mipmap.kecskeselected);
                    MainActivity.getEredmeny().setText("Lose");
                }
            }
        }
    }




    //Kecske nyitas
    @Override
    public void kecskeNyitas(){
        MainActivity.getRight().setImageResource(R.mipmap.kecske);
    }
}
