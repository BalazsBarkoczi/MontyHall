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
