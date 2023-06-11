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
        else {
            if(!selected){
                //kocsi
                if(isNyertes()){
                    MainActivity.middle.setImageResource(R.mipmap.kocsi);
                }
                else{
                    MainActivity.middle.setImageResource(R.mipmap.kecske);
                }
            }

            else{
                if(isNyertes()){
                    MainActivity.middle.setImageResource(R.mipmap.kocsiselected);
                    MainActivity.nyeresekSzama++;
                    MainActivity.eredmeny.setText("Win");
                }
                else {
                    MainActivity.middle.setImageResource(R.mipmap.kecskeselected);
                    MainActivity.eredmeny.setText("Lose");
                }
            }
        }
    }





    //Kecske nyitas
    @Override
    public void kecskeNyitas(){
        MainActivity.middle.setImageResource(R.mipmap.kecske);
    }
}
