package com.example.montyhall;

public class Left extends Kartya{

    public Left(){


    }

    @Override
    public void Kirajzol() {
        if(!MainActivity.nyitva){
            if(!selected){
                MainActivity.getLeft().setImageResource(R.mipmap.megforditott);
            }
            else  {
                MainActivity.getLeft().setImageResource(R.mipmap.kijelolt);
            }
        }
        else {


            if(!selected){
                //kocsi
                if(isNyertes()){
                    MainActivity.getLeft().setImageResource(R.mipmap.kocsi);
                }
                else{
                    MainActivity.getLeft().setImageResource(R.mipmap.kecske);
                }
            }
            else{
                if(isNyertes()){
                    MainActivity.getLeft().setImageResource(R.mipmap.kocsiselected);
                    MainActivity.nyeresekSzama++;
                    MainActivity.getEredmeny().setText("Win");
                }
                else {
                    MainActivity.getLeft().setImageResource(R.mipmap.kecskeselected);
                    MainActivity.getEredmeny().setText("Lose");
                }
            }
        }
    }




    //Kecske nyitas
    @Override
    public void kecskeNyitas(){
        MainActivity.getLeft().setImageResource(R.mipmap.kecske);
    }
}
