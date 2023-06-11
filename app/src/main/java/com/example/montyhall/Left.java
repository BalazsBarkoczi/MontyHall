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
        else {
            if(!selected){
                //kocsi
                if(isNyertes()){
                    MainActivity.left.setImageResource(R.mipmap.kocsi);
                }
                else{
                    MainActivity.left.setImageResource(R.mipmap.kecske);
                }
            }
            else{
                if(isNyertes()){
                    MainActivity.left.setImageResource(R.mipmap.kocsiselected);
                    MainActivity.nyeresekSzama++;
                    MainActivity.eredmeny.setText("Win");
                }
                else {
                    MainActivity.left.setImageResource(R.mipmap.kecskeselected);
                    MainActivity.eredmeny.setText("Lose");
                }
            }
        }
    }




    //Kecske nyitas
    @Override
    public void kecskeNyitas(){
        MainActivity.left.setImageResource(R.mipmap.kecske);
    }
}
